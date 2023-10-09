package com.blog.portal.serviceimpl;

import com.blog.portal.entities.Blog;
import com.blog.portal.entities.ReportedBlog;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.ReportedBlogAction;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ReportBlogMapper;
import com.blog.portal.repository.BlogRepository;
import com.blog.portal.repository.UserRepository;
import com.blog.portal.repository.CommentRepository;
import com.blog.portal.repository.ReactionRepository;
import com.blog.portal.repository.ReportRepository;
import com.blog.portal.requestPayload.ReportBlogInDto;
import com.blog.portal.requestPayload.ActOnReportedBlogInDto;
import com.blog.portal.responsePayload.ReportedBlogReasonsOutDto;
import com.blog.portal.responsePayload.ReportedBlogsOutDto;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.services.ReportService;
import com.blog.portal.util.ResponseMessageConstants;
import com.blog.portal.serviceimpl.ReportServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReportServiceImplTest {

    @InjectMocks
    private ReportService reportService = new ReportServiceImpl();

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private BlogRepository blogRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ReactionRepository reactionRepository;

    @Mock
    private CommentRepository commentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReportPost_Success() {
        ReportBlogInDto inDto = new ReportBlogInDto("userId", "postId");

        User user = new User();
        user.setId("userId");

        Blog blog = new Blog();
        blog.setId("postId");
        blog.setReportedBy(new HashSet<>());

        ReportedBlog reportedBlog = new ReportedBlog();
        reportedBlog.setId("reportedPostId");

        when(userRepository.findById("userId")).thenReturn(Optional.of(user));
        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));
        when(reportRepository.findByUserIdAndPostId("userId", "postId")).thenReturn(null);
        when(blogRepository.save(blog)).thenReturn(blog);
        when(reportRepository.save(any(ReportedBlog.class))).thenReturn(reportedBlog);

        ResponseOutDTO response = reportService.reportOnBlog(inDto);

        verify(userRepository, times(1)).findById("userId");
        verify(blogRepository, times(1)).findById("postId");
        verify(reportRepository, times(1)).findByUserIdAndPostId("userId", "postId");
        verify(blogRepository, times(1)).save(blog);
        verify(reportRepository, times(1)).save(any(ReportedBlog.class));

        assertTrue(response.isSuccess());
        assertEquals(ResponseMessageConstants.BLOG_REPORT_SUCCESS, response.getMessage());
    }
    @Test
    public void testReportPost_AlreadyReported() {
        ReportBlogInDto inDto = new ReportBlogInDto("userId", "postId");

        User user = new User();
        user.setId("userId");

        Blog blog = new Blog();
        blog.setId("postId");
        blog.setReportedBy(new HashSet<>());

        when(userRepository.findById("userId")).thenReturn(Optional.of(user));
        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));
        when(reportRepository.findByUserIdAndPostId("userId", "postId")).thenReturn(new ReportedBlog());

        ResponseOutDTO response = reportService.reportOnBlog(inDto);


    }


    @Test
    public void testGetAllReportedPost() {
        ReportedBlog reportedPost1 = new ReportedBlog();
        reportedPost1.setId("reportedPostId1");
        reportedPost1.setPost(new Blog("postId1"));

        ReportedBlog reportedPost2 = new ReportedBlog();
        reportedPost2.setId("reportedPostId2");
        reportedPost2.setPost(new Blog("postId2"));

        List<ReportedBlog> reportedBlogs = Arrays.asList(reportedPost1, reportedPost2);

        when(reportRepository.findAll()).thenReturn(reportedBlogs);

        List<ReportedBlogsOutDto> response = reportService.getReportedBlogs();

        verify(reportRepository, times(1)).findAll();

        assertEquals(2, response.size());
        assertEquals("reportedPostId1", response.get(0).getId());
        assertEquals("reportedPostId2", response.get(1).getId());
    }

    @Test
    public void testActOnReportedBlog_Ignore_Success() {
        ActOnReportedBlogInDto inDto = new ActOnReportedBlogInDto();
        inDto.setAdminAction(ReportedBlogAction.IGNORE);
        inDto.setPostId("postId");

        List<ReportedBlog> fetchedReportedPosts = new ArrayList<>();
        fetchedReportedPosts.add(new ReportedBlog());
        
        Blog fetchedPost = new Blog();
        fetchedPost.setId("postId");
        fetchedPost.setReportedBy(new HashSet<>(Collections.singletonList("reportingUserId")));

        when(reportRepository.findByPostId("postId")).thenReturn(fetchedReportedPosts);
        when(blogRepository.findById("postId")).thenReturn(Optional.of(fetchedPost));

        ResponseOutDTO response = reportService.actOnReportedBlog(inDto);

        verify(reportRepository, times(1)).findByPostId("postId");
        verify(blogRepository, times(1)).findById("postId");

        assertTrue(response.isSuccess());
        assertEquals(ResponseMessageConstants.REPORTED_BLOG_ACT_IGNORED, response.getMessage());

        assertTrue(fetchedPost.getReportedBy().isEmpty());
        verify(reportRepository, times(1)).deleteByPostId("postId");
    }

    @Test
    public void testActOnReportedBlog_Delete_Success() {
        ActOnReportedBlogInDto inDto = new ActOnReportedBlogInDto();
        inDto.setAdminAction(ReportedBlogAction.DELETE);
        inDto.setPostId("postId");

        List<ReportedBlog> fetchedReportedPosts = new ArrayList<>();
        fetchedReportedPosts.add(new ReportedBlog());

        Blog fetchedPost = new Blog();
        fetchedPost.setId("postId");

        when(reportRepository.findByPostId("postId")).thenReturn(fetchedReportedPosts);
        when(blogRepository.findById("postId")).thenReturn(Optional.of(fetchedPost));

        ResponseOutDTO response = reportService.actOnReportedBlog(inDto);

        verify(reportRepository, times(1)).findByPostId("postId");
        verify(blogRepository, times(1)).findById("postId");
        verify(reportRepository, times(1)).deleteByPostId("postId");
        verify(blogRepository, times(1)).deleteById("postId");
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessageConstants.REPORTED_BLOG_ACT_DELETED, response.getMessage());
    }

    @Test
    public void testActOnReportedBlog_NoReportsFound() {
        ActOnReportedBlogInDto inDto = new ActOnReportedBlogInDto();
        inDto.setAdminAction(ReportedBlogAction.IGNORE);
        inDto.setPostId("postId");

        when(reportRepository.findByPostId("postId")).thenReturn(new ArrayList<>());

        ResponseOutDTO response = reportService.actOnReportedBlog(inDto);

        verify(reportRepository, times(1)).findByPostId("postId");
        verify(blogRepository, never()).findById(anyString());
        verify(reportRepository, never()).deleteByPostId(anyString());
        verify(blogRepository, never()).deleteById(anyString());

        assertFalse(response.isSuccess());
    }
    
    @Test
    public void testGetMessage_Success() {
        String postId = "postId";

        List<ReportedBlog> reportedBlogs = new ArrayList<>();
        ReportedBlog reportedPost1 = new ReportedBlog();
        reportedPost1.setReportReason("Reason 1");
        ReportedBlog reportedPost2 = new ReportedBlog();
        reportedPost2.setReportReason("Reason 2");
        reportedBlogs.add(reportedPost1);
        reportedBlogs.add(reportedPost2);
        when(reportRepository.findByPostId(postId)).thenReturn(reportedBlogs);

        ReportedBlogReasonsOutDto response = reportService.getReportedBlogReason(postId);

        verify(reportRepository, times(1)).findByPostId(postId);

        assertNotNull(response);
        List<String> reasons = response.getReasons();
        assertEquals(2, reasons.size());
        assertTrue(reasons.contains("Reason 1"));
        assertTrue(reasons.contains("Reason 2"));
    }

    @Test
    public void testGetMessage_NoReportedPosts() {
        String postId = "postId";

        when(reportRepository.findByPostId(postId)).thenReturn(new ArrayList<>());

        ReportedBlogReasonsOutDto response = reportService.getReportedBlogReason(postId);

        verify(reportRepository, times(1)).findByPostId(postId);

        assertNotNull(response);
        List<String> reasons = response.getReasons();
        assertTrue(reasons.isEmpty());
    }

}
