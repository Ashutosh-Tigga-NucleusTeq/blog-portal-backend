package com.blog.portal.controller;

import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.requestPayload.*;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.*;
import com.blog.portal.services.BlogPostService;
import com.blog.portal.util.RequestMappingConst;
import com.blog.portal.util.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BlogPostControllerTest {

	private MockMvc mockMvc;

	@Mock
	private BlogPostService blogPostService;

	@InjectMocks
	private BlogPostController blogPostController;

	private static final String POST_ID = "1";

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(blogPostController).build();
	}

	@Test
	public void testCreateBlogPost() throws Exception {
		PostBlogInDto postBlogInDto = new PostBlogInDto();
		postBlogInDto.setTitle("Test Title");
		postBlogInDto.setContent("Test Content");
		postBlogInDto.setCreatedAt(new Date());
		postBlogInDto.setUserID("userid");
		ApiResponse response = new ApiResponse(ResponseMessage.BLOG_POST_SUCCESS, true);
		when(blogPostService.createPost(postBlogInDto)).thenReturn(response);
		mockMvc.perform(post("/blog/write").contentType(MediaType.APPLICATION_JSON).content(asJsonString(postBlogInDto)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.message").value(ResponseMessage.BLOG_POST_SUCCESS))
				.andExpect(jsonPath("$.success").value(true));

		verify(blogPostService, times(1)).createPost(postBlogInDto);
	}

	@Test
	public void testGetPostById() throws Exception {
		GetPostOutDto response = new GetPostOutDto();
		response.setId(POST_ID);
		response.setTitle("Test Title");
		response.setContent("Test Content");
		response.setTechCategory(TechnologyCategory.JAVA);

		when(blogPostService.getPost(POST_ID)).thenReturn(response);
		mockMvc.perform(get("/blog/read/{post_id}", POST_ID)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(POST_ID)).andExpect(jsonPath("$.title").value("Test Title"))
				.andExpect(jsonPath("$.content").value("Test Content")).andExpect(jsonPath("$.techCategory").value("JAVA"));

		verify(blogPostService, times(1)).getPost(POST_ID);
	}

	@Test
	public void testUpdateBlogPost() throws Exception {
		UpdatePostInDto updatePostInDto = new UpdatePostInDto();
		updatePostInDto.setId(POST_ID);
		updatePostInDto.setTitle("Updated Title");
		updatePostInDto.setContent("Updated Content");

		ApiResponse response = new ApiResponse(ResponseMessage.BLOG_UPDATE_SUCCESS, true);
		when(blogPostService.editBlog(updatePostInDto)).thenReturn(response);

		mockMvc.perform(put("/blog/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(updatePostInDto)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.message").value(ResponseMessage.BLOG_UPDATE_SUCCESS))
				.andExpect(jsonPath("$.success").value(true));

		verify(blogPostService, times(1)).editBlog(updatePostInDto);
	}

	@Test
	public void testGetApprovedPosts() throws Exception {
		FilterDashboardPostInDto filterDto = new FilterDashboardPostInDto();
		filterDto.setTitle("Test Title");
		filterDto.setTechCategory(TechnologyCategory.JAVA);

		List<FilterDashboardOutDto> responseList = new ArrayList<>();
		FilterDashboardOutDto dashboardOutDto = new FilterDashboardOutDto();
		dashboardOutDto.setId(POST_ID);
		dashboardOutDto.setTitle("Test Title");
		dashboardOutDto.setStatus(PostStatus.APPROVED);
		dashboardOutDto.setTechnology(TechnologyCategory.JAVA);
		responseList.add(dashboardOutDto);

		when(blogPostService.getAllPostFilter(filterDto)).thenReturn(responseList);

		/*
		 * mockMvc .perform(post(RequestMappingConst.POST_URL+"read-approved")
		 * .contentType(MediaType.APPLICATION_JSON) .content(asJsonString(filterDto)))
		 * .andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(POST_ID))
		 * .andExpect(jsonPath("$[0].title").value("Test Title")).andExpect(jsonPath(
		 * "$[0].status").value("APPROVED"))
		 * .andExpect(jsonPath("$[0].technology").value("JAVA"));
		 * 
		 * verify(blogPostService, times(1)).getAllPostFilter(filterDto);
		 */
	}

	@Test
	public void testGetUserPosts() throws Exception {
		FilterMyBlogPostInDto filterDto = new FilterMyBlogPostInDto();
		filterDto.setUserId("Test User id");
		filterDto.setTechCategory(TechnologyCategory.JAVA);

		List<FilterMyBlogPostOutDto> responseList = new ArrayList<>();
		FilterMyBlogPostOutDto myBlogPostOutDto = new FilterMyBlogPostOutDto();
		myBlogPostOutDto.setId(POST_ID);
		myBlogPostOutDto.setTitle("Test Title");
		myBlogPostOutDto.setTechnology(TechnologyCategory.JAVA);
		responseList.add(myBlogPostOutDto);

		when(blogPostService.getAllPostOfUserFilter(filterDto)).thenReturn(responseList);

		mockMvc.perform(post("/blog/user").contentType(MediaType.APPLICATION_JSON).content(asJsonString(filterDto)))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(POST_ID))
				.andExpect(jsonPath("$[0].title").value("Test Title")).andExpect(jsonPath("$[0].technology").value("JAVA"));

		verify(blogPostService, times(1)).getAllPostOfUserFilter(filterDto);
	}

	@Test
	public void testGetUnreviewedPost() throws Exception {
		UnReviewedPostInDto unReviewedPostInDto = new UnReviewedPostInDto();
		unReviewedPostInDto.setTechnologyCategory(TechnologyCategory.JAVA);

		List<UnReviewedPostOutDto> responseList = new ArrayList<>();
		UnReviewedPostOutDto unReviewedPostOutDto = new UnReviewedPostOutDto();
		unReviewedPostOutDto.setId(POST_ID);
		unReviewedPostOutDto.setTitle("Test Title");
		unReviewedPostOutDto.setTechCategory(TechnologyCategory.JAVA);
		responseList.add(unReviewedPostOutDto);

		when(blogPostService.getUnreviewedPosts(unReviewedPostInDto)).thenReturn(responseList);

		/*
		 * mockMvc .perform(
		 * post("/blog/unreviewed").contentType(MediaType.APPLICATION_JSON).content(
		 * asJsonString(unReviewedPostInDto)))
		 * .andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(POST_ID))
		 * .andExpect(jsonPath("$[0].title").value("Test Title")).andExpect(jsonPath(
		 * "$[0].techCategory").value("JAVA"));
		 * 
		 * verify(blogPostService, times(1)).getUnreviewedPosts(unReviewedPostInDto);
		 */
	}

	@Test
	public void testResponseUnreviewedPost() throws Exception {
		ApproveOrRejectPostInDto approveOrRejectPostInDto = new ApproveOrRejectPostInDto();
		approveOrRejectPostInDto.setPostId(POST_ID);
		approveOrRejectPostInDto.setPostStatus(PostStatus.APPROVED);
		ApiResponse response = new ApiResponse(ResponseMessage.UNREVIEW_BLOG_APPROVED, true);
		when(blogPostService.responseUnreviewedPost(approveOrRejectPostInDto)).thenReturn(response);

		/*
		 * mockMvc
		 * .perform(put("/blog/action-unreview").contentType(MediaType.APPLICATION_JSON)
		 * .content(asJsonString(approveOrRejectPostInDto)))
		 * .andExpect(status().isOk()).andExpect(jsonPath("$.message").value(
		 * ResponseMessage.UNREVIEW_BLOG_APPROVED))
		 * .andExpect(jsonPath("$.success").value(true));
		 * 
		 * verify(blogPostService,
		 * times(1)).responseUnreviewedPost(approveOrRejectPostInDto);
		 */	}

	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
