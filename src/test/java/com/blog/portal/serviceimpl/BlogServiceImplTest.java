package com.blog.portal.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.blog.portal.entities.Blog;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.*;
import com.blog.portal.repository.BlogRepository;
import com.blog.portal.repository.UserRepository;
import com.blog.portal.requestPayload.*;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.*;
import com.blog.portal.util.ResponseMessage;

public class BlogServiceImplTest {

    @InjectMocks
    private BlogServiceImpl blogPostService;

    @Mock
    private BlogRepository blogRepository;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePost_Success() {
        PostBlogInDto postDto = new PostBlogInDto("Test Title", "Test Content", new Date(), "userId", TechnologyCategory.JAVA);
        User user = new User();
        user.setId("userId");
        user.setPassword("password");

        when(userRepository.findById("userId")).thenReturn(Optional.of(user));
        when(blogRepository.save(any(Blog.class))).thenReturn(new Blog());

        ApiResponse response = blogPostService.createPost(postDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.BLOG_POST_SUCCESS, response.getMessage());
    }

    @Test
    public void testCreatePostWithRuntimeException() {
        PostBlogInDto postBlogInDto = new PostBlogInDto();
        postBlogInDto.setUserID("userId");
        postBlogInDto.setContent("content");
        postBlogInDto.setTechCategory(TechnologyCategory.JAVA);
        postBlogInDto.setTitle("title");
        postBlogInDto.setCreatedAt(new Date(12));
        User user = new User();
        user.setId("userId");

        when(userRepository.findById(postBlogInDto.getUserId())).thenReturn(java.util.Optional.of(user));
        when(blogRepository.save(any(Blog.class))).thenThrow(new RuntimeException("Test exception"));

    }


    @Test
    public void testGetAllPostFilter_NoFilters() {
        ApprovedBlogsInDto inDto = new ApprovedBlogsInDto(null, null);
        List<Blog> mockedPosts = new ArrayList<>();
        Blog blog = new Blog();
        blog.setId("id");
        blog.setContent("content");
        blog.setStatus(BlogStatus.APPROVED);
        blog.setTitle("title");
        blog.setUser(new User());
        blog.setUserId("userid");
        blog.setTechCategory(TechnologyCategory.JAVA);
        blog.setCreatedAt(new Date(12));
        blog.setDisLikedBy(null);
        blog.setCommentBy(null);
        mockedPosts.add(blog);

        when(blogRepository.findByStatus(BlogStatus.APPROVED)).thenReturn(mockedPosts);

        List<ApprovedBlogsOutDto> result = blogPostService.getApprovedBlog(inDto);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(mockedPosts.size(), result.size());
    }

    @Test
    public void testGetAllPostOfUserFilter_NoFilters() {
        UserBlogsInDto inDto = new UserBlogsInDto();
        inDto.setStatus(null);
        inDto.setTitle(null);
        inDto.setTechCategory(null);
        inDto.setUserId("userId");
        List<Blog> mockedPosts = new ArrayList<>();
        Blog blog = new Blog();
        blog.setId("id");
        blog.setContent("content");
        blog.setStatus(BlogStatus.APPROVED);
        blog.setTitle("title");
        blog.setUser(new User());
        blog.setUserId("userid");
        blog.setTechCategory(TechnologyCategory.JAVA);
        blog.setCreatedAt(new Date(12));
        blog.setDisLikedBy(null);
        blog.setCommentBy(null);
        mockedPosts.add(blog);
        
        when(blogRepository.findByUserId("userId")).thenReturn(mockedPosts);

        List<UserBlogsOutDto> result = blogPostService.getUserBlogs(inDto);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(mockedPosts.size(), result.size());
    }

    @Test
    public void testEditBlog_Success() {
        UpdateBlogInDto inDto = new UpdateBlogInDto("postId", "Updated Title", "Updated Content");
        Blog blog = new Blog();
        blog.setId("postId");

        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));
        when(blogRepository.save(any(Blog.class))).thenReturn(new Blog());

        ApiResponse response = blogPostService.editBlog(inDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.BLOG_UPDATE_SUCCESS, response.getMessage());
    }

    @Test
    public void testEditBlog_PostNotFound() {
        UpdateBlogInDto inDto = new UpdateBlogInDto("postId", "Updated Title", "Updated Content");

        when(blogRepository.findById("postId")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            blogPostService.editBlog(inDto);
        });
    }

    @Test
    public void testGetPost_Success() {
        String postId = "postId";
        Blog blog = new Blog();
        blog.setId(postId);

        when(blogRepository.findById(postId)).thenReturn(Optional.of(blog));

        BlogOutDto result = blogPostService.getBlogById(postId);

        assertNotNull(result);
        assertEquals(postId, result.getId());
    }

    @Test
    public void testGetPost_PostNotFound() {
        String postId = "postId";

        when(blogRepository.findById(postId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            blogPostService.getBlogById(postId);
        });
    }

    @Test
    public void testGetUnreviewedPosts_NoFilters() {
        UnReviewedBlogsInDto inDto = new UnReviewedBlogsInDto();
        inDto.setTitle(null);
        inDto.setTechnologyCategory(null);
        List<Blog> mockedPosts = new ArrayList<>();
        Blog blog = new Blog();
        blog.setId("id");
        blog.setStatus(BlogStatus.PENDING);
        blog.setContent("content");
        blog.setTitle("title");
        blog.setEditedAt(new Date(12));
        blog.setCreatedAt(new Date(11));
        blog.setUser(new User());
        blog.setUserId("userid");
        blog.setDisLikedBy(null);
        blog.setLikedBy(null);
        mockedPosts.add(blog);

        when(blogRepository.findByStatus(BlogStatus.PENDING)).thenReturn(mockedPosts);

        List<UnReviewedBlogsOutDto> result = blogPostService.getUnreviewedBlogs(inDto);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(mockedPosts.size(), result.size());
    }

    @Test
    public void testResponseUnreviewedPost_ApproveSuccess() {
        ActOnUnReviewedBlogInDto inDto = new ActOnUnReviewedBlogInDto("postId", BlogStatus.APPROVED);
        Blog blog = new Blog();
        blog.setId("postId");
        blog.setStatus(BlogStatus.PENDING);

        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));
        when(blogRepository.save(any(Blog.class))).thenReturn(new Blog());

        ApiResponse response = blogPostService.actOnUnreviewedBlog(inDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.UNREVIEW_BLOG_APPROVED, response.getMessage());
    }

    @Test
    public void testResponseUnreviewedPost_RejectSuccess() {
        ActOnUnReviewedBlogInDto inDto = new ActOnUnReviewedBlogInDto("postId", BlogStatus.REJECTED);
        Blog blog = new Blog();
        blog.setId("postId");
        blog.setStatus(BlogStatus.PENDING);

        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));
        when(blogRepository.save(any(Blog.class))).thenReturn(new Blog());

        ApiResponse response = blogPostService.actOnUnreviewedBlog(inDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.UNREVIEW_BLOG_REJECTED, response.getMessage());
    }

    @Test
    public void testResponseUnreviewedPost_PostNotFound() {
        ActOnUnReviewedBlogInDto inDto = new ActOnUnReviewedBlogInDto("postId", BlogStatus.APPROVED);

        when(blogRepository.findById("postId")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            blogPostService.actOnUnreviewedBlog(inDto);
        });
    }

    @Test
    public void testResponseUnreviewedPost_PostNotPending() {
        ActOnUnReviewedBlogInDto inDto = new ActOnUnReviewedBlogInDto("postId", BlogStatus.APPROVED);
        Blog blog = new Blog();
        blog.setId("postId");
        blog.setStatus(BlogStatus.APPROVED);

        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));

        ApiResponse response = blogPostService.actOnUnreviewedBlog(inDto);

        assertNotNull(response);
        assertFalse(response.isSuccess());
        assertEquals(ResponseMessage.UNREVIEW_BLOG_FAILED, response.getMessage());
    }

}
