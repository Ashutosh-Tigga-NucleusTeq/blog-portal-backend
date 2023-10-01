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

import com.blog.portal.entities.Post;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.*;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.requestPayload.*;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.*;
import com.blog.portal.util.ResponseMessage;

public class BlogPostServiceImplTest {

    @InjectMocks
    private BlogPostServiceImpl blogPostService;

    @Mock
    private BlogPostRepo blogPostRepo;

    @Mock
    private BlogUserRepo blogUserRepo;

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

        when(blogUserRepo.findById("userId")).thenReturn(Optional.of(user));
        when(blogPostRepo.save(any(Post.class))).thenReturn(new Post());

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

        when(blogUserRepo.findById(postBlogInDto.getUserId())).thenReturn(java.util.Optional.of(user));
        when(blogPostRepo.save(any(Post.class))).thenThrow(new RuntimeException("Test exception"));

        ApiResponse response = blogPostService.createPost(postBlogInDto);

        assertNotNull(response);
        assertFalse(response.isSuccess());
        assertEquals(ResponseMessage.BLOG_POST_FAILED, response.getMessage());
    }


    @Test
    public void testGetAllPostFilter_NoFilters() {
        FilterDashboardPostInDto inDto = new FilterDashboardPostInDto(null, null);
        List<Post> mockedPosts = new ArrayList<>();
        Post post = new Post();
        post.setId("id");
        post.setContent("content");
        post.setStatus(PostStatus.APPROVED);
        post.setTitle("title");
        post.setUser(new User());
        post.setUserId("userid");
        post.setTechCategory(TechnologyCategory.JAVA);
        post.setCreatedAt(new Date(12));
        post.setDisLikedBy(null);
        post.setCommentBy(null);
        mockedPosts.add(post);

        when(blogPostRepo.findByStatus(PostStatus.APPROVED)).thenReturn(mockedPosts);

        List<FilterDashboardOutDto> result = blogPostService.getAllPostFilter(inDto);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(mockedPosts.size(), result.size());
    }

    @Test
    public void testGetAllPostOfUserFilter_NoFilters() {
        FilterMyBlogPostInDto inDto = new FilterMyBlogPostInDto();
        inDto.setStatus(null);
        inDto.setTitle(null);
        inDto.setTechCategory(null);
        inDto.setUserId("userId");
        List<Post> mockedPosts = new ArrayList<>();
        Post post = new Post();
        post.setId("id");
        post.setContent("content");
        post.setStatus(PostStatus.APPROVED);
        post.setTitle("title");
        post.setUser(new User());
        post.setUserId("userid");
        post.setTechCategory(TechnologyCategory.JAVA);
        post.setCreatedAt(new Date(12));
        post.setDisLikedBy(null);
        post.setCommentBy(null);
        mockedPosts.add(post);
        
        when(blogPostRepo.findByUserId("userId")).thenReturn(mockedPosts);

        List<FilterMyBlogPostOutDto> result = blogPostService.getAllPostOfUserFilter(inDto);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(mockedPosts.size(), result.size());
    }

    @Test
    public void testEditBlog_Success() {
        UpdatePostInDto inDto = new UpdatePostInDto("postId", "Updated Title", "Updated Content");
        Post post = new Post();
        post.setId("postId");

        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(blogPostRepo.save(any(Post.class))).thenReturn(new Post());

        ApiResponse response = blogPostService.editBlog(inDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.BLOG_UPDATE_SUCCESS, response.getMessage());
    }

    @Test
    public void testEditBlog_PostNotFound() {
        UpdatePostInDto inDto = new UpdatePostInDto("postId", "Updated Title", "Updated Content");

        when(blogPostRepo.findById("postId")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            blogPostService.editBlog(inDto);
        });
    }

    @Test
    public void testGetPost_Success() {
        String postId = "postId";
        Post post = new Post();
        post.setId(postId);

        when(blogPostRepo.findById(postId)).thenReturn(Optional.of(post));

        GetPostOutDto result = blogPostService.getPost(postId);

        assertNotNull(result);
        assertEquals(postId, result.getId());
    }

    @Test
    public void testGetPost_PostNotFound() {
        String postId = "postId";

        when(blogPostRepo.findById(postId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            blogPostService.getPost(postId);
        });
    }

    @Test
    public void testGetUnreviewedPosts_NoFilters() {
        UnReviewedPostInDto inDto = new UnReviewedPostInDto();
        inDto.setTitle(null);
        inDto.setTechnologyCategory(null);
        List<Post> mockedPosts = new ArrayList<>();
        Post post = new Post();
        post.setId("id");
        post.setStatus(PostStatus.PENDING);
        post.setContent("content");
        post.setTitle("title");
        post.setEditedAt(new Date(12));
        post.setCreatedAt(new Date(11));
        post.setUser(new User());
        post.setUserId("userid");
        post.setDisLikedBy(null);
        post.setLikedBy(null);
        mockedPosts.add(post);

        when(blogPostRepo.findByStatus(PostStatus.PENDING)).thenReturn(mockedPosts);

        List<UnReviewedPostOutDto> result = blogPostService.getUnreviewedPosts(inDto);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(mockedPosts.size(), result.size());
    }

    @Test
    public void testResponseUnreviewedPost_ApproveSuccess() {
        ApproveOrRejectPostInDto inDto = new ApproveOrRejectPostInDto("postId", PostStatus.APPROVED);
        Post post = new Post();
        post.setId("postId");
        post.setStatus(PostStatus.PENDING);

        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(blogPostRepo.save(any(Post.class))).thenReturn(new Post());

        ApiResponse response = blogPostService.responseUnreviewedPost(inDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.UNREVIEW_BLOG_APPROVED, response.getMessage());
    }

    @Test
    public void testResponseUnreviewedPost_RejectSuccess() {
        ApproveOrRejectPostInDto inDto = new ApproveOrRejectPostInDto("postId", PostStatus.REJECTED);
        Post post = new Post();
        post.setId("postId");
        post.setStatus(PostStatus.PENDING);

        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(blogPostRepo.save(any(Post.class))).thenReturn(new Post());

        ApiResponse response = blogPostService.responseUnreviewedPost(inDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.UNREVIEW_BLOG_REJECTED, response.getMessage());
    }

    @Test
    public void testResponseUnreviewedPost_PostNotFound() {
        ApproveOrRejectPostInDto inDto = new ApproveOrRejectPostInDto("postId", PostStatus.APPROVED);

        when(blogPostRepo.findById("postId")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            blogPostService.responseUnreviewedPost(inDto);
        });
    }

    @Test
    public void testResponseUnreviewedPost_PostNotPending() {
        ApproveOrRejectPostInDto inDto = new ApproveOrRejectPostInDto("postId", PostStatus.APPROVED);
        Post post = new Post();
        post.setId("postId");
        post.setStatus(PostStatus.APPROVED);

        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));

        ApiResponse response = blogPostService.responseUnreviewedPost(inDto);

        assertNotNull(response);
        assertFalse(response.isSuccess());
        assertEquals(ResponseMessage.UNREVIEW_BLOG_FAILED, response.getMessage());
    }

}
