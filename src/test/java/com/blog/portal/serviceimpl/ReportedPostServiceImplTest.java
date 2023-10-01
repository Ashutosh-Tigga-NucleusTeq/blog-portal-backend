package com.blog.portal.serviceimpl;

import com.blog.portal.entities.Post;
import com.blog.portal.entities.ReportedPost;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.AdminAction;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ReportedPostMapper;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.repository.CommentPostRepo;
import com.blog.portal.repository.LikeOrDislikePostRepo;
import com.blog.portal.repository.ReportedPostRepo;
import com.blog.portal.requestPayload.ReportedPostInDto;
import com.blog.portal.requestPayload.ActionOnReportedPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.ReportedPostMessageOutDto;
import com.blog.portal.responsePayload.ReportedPostOutDto;
import com.blog.portal.services.ReportedPostService;
import com.blog.portal.util.ResponseMessage;
import com.blog.portal.serviceimpl.ReportedPostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReportedPostServiceImplTest {

    @InjectMocks
    private ReportedPostService reportedPostService = new ReportedPostServiceImpl();

    @Mock
    private ReportedPostRepo reportedPostRepo;

    @Mock
    private BlogPostRepo blogPostRepo;

    @Mock
    private BlogUserRepo blogUserRepo;

    @Mock
    private LikeOrDislikePostRepo likeOrDislikePostRepo;

    @Mock
    private CommentPostRepo commentPostRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReportPost_Success() {
        ReportedPostInDto inDto = new ReportedPostInDto("userId", "postId");

        User user = new User();
        user.setId("userId");

        Post post = new Post();
        post.setId("postId");
        post.setReportedBy(new HashSet<>());

        ReportedPost reportedPost = new ReportedPost();
        reportedPost.setId("reportedPostId");

        when(blogUserRepo.findById("userId")).thenReturn(Optional.of(user));
        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(reportedPostRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(null);
        when(blogPostRepo.save(post)).thenReturn(post);
        when(reportedPostRepo.save(any(ReportedPost.class))).thenReturn(reportedPost);

        ApiResponse response = reportedPostService.reportPost(inDto);

        verify(blogUserRepo, times(1)).findById("userId");
        verify(blogPostRepo, times(1)).findById("postId");
        verify(reportedPostRepo, times(1)).findByUserIdAndPostId("userId", "postId");
        verify(blogPostRepo, times(1)).save(post);
        verify(reportedPostRepo, times(1)).save(any(ReportedPost.class));

        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.BLOG_REPORT_SUCCESS, response.getMessage());
    }
    @Test
    public void testReportPost_AlreadyReported() {
        ReportedPostInDto inDto = new ReportedPostInDto("userId", "postId");

        User user = new User();
        user.setId("userId");

        Post post = new Post();
        post.setId("postId");
        post.setReportedBy(new HashSet<>());

        when(blogUserRepo.findById("userId")).thenReturn(Optional.of(user));
        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(reportedPostRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(new ReportedPost());

        ApiResponse response = reportedPostService.reportPost(inDto);


    }


    @Test
    public void testGetAllReportedPost() {
        ReportedPost reportedPost1 = new ReportedPost();
        reportedPost1.setId("reportedPostId1");
        reportedPost1.setPost(new Post("postId1"));

        ReportedPost reportedPost2 = new ReportedPost();
        reportedPost2.setId("reportedPostId2");
        reportedPost2.setPost(new Post("postId2"));

        List<ReportedPost> reportedPosts = Arrays.asList(reportedPost1, reportedPost2);

        when(reportedPostRepo.findAll()).thenReturn(reportedPosts);

        List<ReportedPostOutDto> response = reportedPostService.getAllReportedPost();

        verify(reportedPostRepo, times(1)).findAll();

        assertEquals(2, response.size());
        assertEquals("reportedPostId1", response.get(0).getId());
        assertEquals("reportedPostId2", response.get(1).getId());
    }

    @Test
    public void testActOnReportedBlog_Ignore_Success() {
        ActionOnReportedPostInDto inDto = new ActionOnReportedPostInDto();
        inDto.setAdminAction(AdminAction.IGNORE);
        inDto.setPostId("postId");

        List<ReportedPost> fetchedReportedPosts = new ArrayList<>();
        fetchedReportedPosts.add(new ReportedPost());
        
        Post fetchedPost = new Post();
        fetchedPost.setId("postId");
        fetchedPost.setReportedBy(new HashSet<>(Collections.singletonList("reportingUserId")));

        when(reportedPostRepo.findByPostId("postId")).thenReturn(fetchedReportedPosts);
        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(fetchedPost));

        ApiResponse response = reportedPostService.actOnReportedBlog(inDto);

        verify(reportedPostRepo, times(1)).findByPostId("postId");
        verify(blogPostRepo, times(1)).findById("postId");

        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.REPORTED_BLOG_ACT_IGNORED, response.getMessage());

        assertTrue(fetchedPost.getReportedBy().isEmpty());
        verify(reportedPostRepo, times(1)).deleteByPostId("postId");
    }

    @Test
    public void testActOnReportedBlog_Delete_Success() {
        ActionOnReportedPostInDto inDto = new ActionOnReportedPostInDto();
        inDto.setAdminAction(AdminAction.DELETE);
        inDto.setPostId("postId");

        List<ReportedPost> fetchedReportedPosts = new ArrayList<>();
        fetchedReportedPosts.add(new ReportedPost());

        Post fetchedPost = new Post();
        fetchedPost.setId("postId");

        when(reportedPostRepo.findByPostId("postId")).thenReturn(fetchedReportedPosts);
        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(fetchedPost));

        ApiResponse response = reportedPostService.actOnReportedBlog(inDto);

        verify(reportedPostRepo, times(1)).findByPostId("postId");
        verify(blogPostRepo, times(1)).findById("postId");
        verify(reportedPostRepo, times(1)).deleteByPostId("postId");
        verify(blogPostRepo, times(1)).deleteById("postId");
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.REPORTED_BLOG_ACT_DELETED, response.getMessage());
    }

    @Test
    public void testActOnReportedBlog_NoReportsFound() {
        ActionOnReportedPostInDto inDto = new ActionOnReportedPostInDto();
        inDto.setAdminAction(AdminAction.IGNORE);
        inDto.setPostId("postId");

        when(reportedPostRepo.findByPostId("postId")).thenReturn(new ArrayList<>());

        ApiResponse response = reportedPostService.actOnReportedBlog(inDto);

        verify(reportedPostRepo, times(1)).findByPostId("postId");
        verify(blogPostRepo, never()).findById(anyString());
        verify(reportedPostRepo, never()).deleteByPostId(anyString());
        verify(blogPostRepo, never()).deleteById(anyString());

        assertFalse(response.isSuccess());
    }
    
    @Test
    public void testGetMessage_Success() {
        String postId = "postId";

        List<ReportedPost> reportedPosts = new ArrayList<>();
        ReportedPost reportedPost1 = new ReportedPost();
        reportedPost1.setReportReason("Reason 1");
        ReportedPost reportedPost2 = new ReportedPost();
        reportedPost2.setReportReason("Reason 2");
        reportedPosts.add(reportedPost1);
        reportedPosts.add(reportedPost2);
        when(reportedPostRepo.findByPostId(postId)).thenReturn(reportedPosts);

        ReportedPostMessageOutDto response = reportedPostService.getMessage(postId);

        verify(reportedPostRepo, times(1)).findByPostId(postId);

        assertNotNull(response);
        List<String> reasons = response.getReasons();
        assertEquals(2, reasons.size());
        assertTrue(reasons.contains("Reason 1"));
        assertTrue(reasons.contains("Reason 2"));
    }

    @Test
    public void testGetMessage_NoReportedPosts() {
        String postId = "postId";

        when(reportedPostRepo.findByPostId(postId)).thenReturn(new ArrayList<>());

        ReportedPostMessageOutDto response = reportedPostService.getMessage(postId);

        verify(reportedPostRepo, times(1)).findByPostId(postId);

        assertNotNull(response);
        List<String> reasons = response.getReasons();
        assertTrue(reasons.isEmpty());
    }

}
