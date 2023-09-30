package com.blog.portal.controller;

import com.blog.portal.requestPayload.ReportedPostInDto;
import com.blog.portal.enumResource.AdminAction;
import com.blog.portal.requestPayload.ActionOnReportedPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.ReportedPostMessageOutDto;
import com.blog.portal.responsePayload.ReportedPostOutDto;
import com.blog.portal.services.ReportedPostService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

public class ReportedPostControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ReportedPostController reportedPostController;

    @Mock
    private ReportedPostService reportedPostService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reportedPostController).build();
    }

    @Test
    public void testReportedPost() throws Exception {
        ReportedPostInDto reportedPostInDto = new ReportedPostInDto();
        reportedPostInDto.setUserId("userId");
        reportedPostInDto.setPostId("postId");
        reportedPostInDto.setReportReason("reportReason");
        ApiResponse apiResponse = new ApiResponse("Reported successfully", true);

        when(reportedPostService.reportPost(reportedPostInDto)).thenReturn(apiResponse);

        mockMvc.perform(post("/report/blog")
                .contentType("application/json")
                .content("{\"userId\":\"userId\",\"postId\":\"postId\",\"reportReason\":\"reportReason\"}")
                .accept("application/json"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Reported successfully"))
                .andExpect(jsonPath("$.success").value(true));

        verify(reportedPostService, times(1)).reportPost(reportedPostInDto);
        verifyNoMoreInteractions(reportedPostService);
    }
    @Test
    public void testGetReportedPosts() throws Exception {
        List<ReportedPostOutDto> reportedPostList = new ArrayList<>();
        ReportedPostOutDto reportedPostOutDto = new ReportedPostOutDto();
        reportedPostOutDto.setId("1");
        reportedPostOutDto.setUserId("userId");
        reportedPostOutDto.setPostId("postId");
        reportedPostOutDto.setReportReason(new ArrayList<>(Arrays.asList("report reason")));
        reportedPostList.add(reportedPostOutDto);

        when(reportedPostService.getAllReportedPost()).thenReturn(reportedPostList);

        mockMvc.perform(get("/report/blog-read")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].userId").value("userId"))
                .andExpect(jsonPath("$[0].postId").value("postId"))
                .andExpect(jsonPath("$[0].reportReason[0]").value("report reason"));

        verify(reportedPostService, times(1)).getAllReportedPost();
        verifyNoMoreInteractions(reportedPostService);
    }


    @Test
    public void testActOnReportedBlog() throws Exception {
        ActionOnReportedPostInDto actionOnReportedPostInDto = new ActionOnReportedPostInDto();
        actionOnReportedPostInDto.setPostId("postId");
        actionOnReportedPostInDto.setAdminAction(AdminAction.IGNORE);
        ApiResponse apiResponse = new ApiResponse("Action taken successfully", true);

        when(reportedPostService.actOnReportedBlog(actionOnReportedPostInDto)).thenReturn(apiResponse);

        mockMvc.perform(post("/report/blog-action")
                .contentType("application/json")
                .content("{\"postId\":\"postId\",\"adminAction\":\"IGNORE\"}")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Action taken successfully"))
                .andExpect(jsonPath("$.success").value(true));

        verify(reportedPostService, times(1)).actOnReportedBlog(actionOnReportedPostInDto);
        verifyNoMoreInteractions(reportedPostService);
    }

    @Test
    public void testGetMessage() throws Exception {
        String postId = "samplePostId";

        List<String> reasons = new ArrayList<>();
        reasons.add("Reason 1");
        reasons.add("Reason 2");

        ReportedPostMessageOutDto mockResponse = new ReportedPostMessageOutDto(reasons);

        when(reportedPostService.getMessage(postId)).thenReturn(mockResponse);

        mockMvc.perform(get("/report/message/{postId}", postId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.reasons[0]").value("Reason 1"))
                .andExpect(jsonPath("$.reasons[1]").value("Reason 2"));

        verify(reportedPostService, times(1)).getMessage(postId);
        verifyNoMoreInteractions(reportedPostService);
    }

}
