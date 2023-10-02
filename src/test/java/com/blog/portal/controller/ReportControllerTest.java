package com.blog.portal.controller;

import com.blog.portal.requestPayload.ReportBlogInDto;
import com.blog.portal.enumResource.ReportedBlogAction;
import com.blog.portal.requestPayload.ActOnReportedBlogInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.ReportedBlogReasonsOutDto;
import com.blog.portal.responsePayload.ReportedBlogsOutDto;
import com.blog.portal.services.ReportService;
import com.blog.portal.util.RequestMappingConst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReportControllerTest {
		
    private MockMvc mockMvc;

    @InjectMocks
    private ReportController reportController;

    @Mock
    private ReportService reportService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reportController).build();
    }

    @Test
    public void testReportedPost() throws Exception {
        ReportBlogInDto reportBlogInDto = new ReportBlogInDto();
        reportBlogInDto.setUserId("userId");
        reportBlogInDto.setPostId("postId");
        reportBlogInDto.setReportReason("reportReason");
        ApiResponse apiResponse = new ApiResponse("Reported successfully", true);

        when(reportService.reportOnBlog(reportBlogInDto)).thenReturn(apiResponse);

        mockMvc.perform(post(RequestMappingConst.REPORT_URL +"/")
                .contentType("application/json")
                .content("{\"userId\":\"userId\",\"postId\":\"postId\",\"reportReason\":\"reportReason\"}")
                .accept("application/json"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Reported successfully"))
                .andExpect(jsonPath("$.success").value(true));

        verify(reportService, times(1)).reportOnBlog(reportBlogInDto);
        verifyNoMoreInteractions(reportService);
    }
    @Test
    public void testGetReportedPosts() throws Exception {
        List<ReportedBlogsOutDto> reportedPostList = new ArrayList<>();
        ReportedBlogsOutDto reportedBlogsOutDto = new ReportedBlogsOutDto();
        reportedBlogsOutDto.setId("1");
        reportedBlogsOutDto.setUserId("userId");
        reportedBlogsOutDto.setPostId("postId");
        reportedBlogsOutDto.setReportReason(new ArrayList<>(Arrays.asList("report reason")));
        reportedPostList.add(reportedBlogsOutDto);

        when(reportService.getReportedBlogs()).thenReturn(reportedPostList);

        mockMvc.perform(get(RequestMappingConst.REPORT_URL +"/all/reported/blogs")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].userId").value("userId"))
                .andExpect(jsonPath("$[0].postId").value("postId"))
                .andExpect(jsonPath("$[0].reportReason[0]").value("report reason"));

        verify(reportService, times(1)).getReportedBlogs();
        verifyNoMoreInteractions(reportService);
    }


    @Test
    public void testActOnReportedBlog() throws Exception {
        ActOnReportedBlogInDto actOnReportedBlogInDto = new ActOnReportedBlogInDto();
        actOnReportedBlogInDto.setPostId("postId");
        actOnReportedBlogInDto.setAdminAction(ReportedBlogAction.IGNORE);
        ApiResponse apiResponse = new ApiResponse("Action taken successfully", true);

        when(reportService.actOnReportedBlog(actOnReportedBlogInDto)).thenReturn(apiResponse);

        mockMvc.perform(post(RequestMappingConst.REPORT_URL +"/blog/action")
                .contentType("application/json")
                .content("{\"postId\":\"postId\",\"adminAction\":\"IGNORE\"}")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Action taken successfully"))
                .andExpect(jsonPath("$.success").value(true));

        verify(reportService, times(1)).actOnReportedBlog(actOnReportedBlogInDto);
        verifyNoMoreInteractions(reportService);
    }

    @Test
    public void testGetMessage() throws Exception {
        String postId = "samplePostId";

        List<String> reasons = new ArrayList<>();
        reasons.add("Reason 1");
        reasons.add("Reason 2");

        ReportedBlogReasonsOutDto mockResponse = new ReportedBlogReasonsOutDto(reasons);

        when(reportService.getReportedBlogReason(postId)).thenReturn(mockResponse);

        mockMvc.perform(get(RequestMappingConst.REPORT_URL +"/{postId}", postId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.reasons[0]").value("Reason 1"))
                .andExpect(jsonPath("$.reasons[1]").value("Reason 2"));

        verify(reportService, times(1)).getReportedBlogReason(postId);
        verifyNoMoreInteractions(reportService);
    }

}
