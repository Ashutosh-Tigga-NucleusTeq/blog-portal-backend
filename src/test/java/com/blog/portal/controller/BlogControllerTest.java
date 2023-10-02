package com.blog.portal.controller;

import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.requestPayload.*;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.*;
import com.blog.portal.services.BlogService;
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

public class BlogControllerTest {

	private MockMvc mockMvc;

	@Mock
	private BlogService blogService;

	@InjectMocks
	private BlogController blogController;

	private static final String POST_ID = "1";

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
	}

	@Test
	public void testCreateBlogPost() throws Exception {
		PostBlogInDto postBlogInDto = new PostBlogInDto();
		postBlogInDto.setTitle("Test Title");
		postBlogInDto.setContent("Test Content");
		postBlogInDto.setCreatedAt(new Date(12));
		postBlogInDto.setUserID("userid");
		postBlogInDto.setTechCategory(TechnologyCategory.JAVA);
		ApiResponse response = new ApiResponse(ResponseMessage.BLOG_POST_SUCCESS, true);
		when(blogService.createPost(postBlogInDto)).thenReturn(response);
		mockMvc
				.perform(post(RequestMappingConst.BLOG_URL + "/").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(postBlogInDto)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.message").value(ResponseMessage.BLOG_POST_SUCCESS))
				.andExpect(jsonPath("$.success").value(true));

		verify(blogService, times(1)).createPost(postBlogInDto);
	}

	@Test
	public void testGetPostById() throws Exception {
		BlogOutDto response = new BlogOutDto();
		response.setId(POST_ID);
		response.setTitle("Test Title");
		response.setContent("Test Content");
		response.setTechCategory(TechnologyCategory.JAVA);

		when(blogService.getBlogById(POST_ID)).thenReturn(response);
		mockMvc.perform(get(RequestMappingConst.BLOG_URL + "/{post_id}", POST_ID))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(POST_ID)).andExpect(jsonPath("$.title").value("Test Title"))
				.andExpect(jsonPath("$.content").value("Test Content")).andExpect(jsonPath("$.techCategory").value("JAVA"));

		verify(blogService, times(1)).getBlogById(POST_ID);
	}

	@Test
	public void testUpdateBlogPost() throws Exception {
		UpdateBlogInDto updateBlogInDto = new UpdateBlogInDto();
		updateBlogInDto.setId(POST_ID);
		updateBlogInDto.setTitle("Updated Title");
		updateBlogInDto.setContent("Updated Content");

		ApiResponse response = new ApiResponse(ResponseMessage.BLOG_UPDATE_SUCCESS, true);
		when(blogService.editBlog(updateBlogInDto)).thenReturn(response);

		mockMvc
				.perform(put(RequestMappingConst.BLOG_URL + "/").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(updateBlogInDto)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.message").value(ResponseMessage.BLOG_UPDATE_SUCCESS))
				.andExpect(jsonPath("$.success").value(true));

		verify(blogService, times(1)).editBlog(updateBlogInDto);
	}

	@Test
	public void testGetApprovedPosts() throws Exception {
		ApprovedBlogsInDto filterDto = new ApprovedBlogsInDto();
		filterDto.setTitle("Test Title");
		filterDto.setTechCategory(TechnologyCategory.JAVA);

		List<ApprovedBlogsOutDto> responseList = new ArrayList<>();
		ApprovedBlogsOutDto dashboardOutDto = new ApprovedBlogsOutDto();
		dashboardOutDto.setId(POST_ID);
		dashboardOutDto.setTitle("Test Title");
		dashboardOutDto.setStatus(BlogStatus.APPROVED);
		dashboardOutDto.setTechnology(TechnologyCategory.JAVA);
		responseList.add(dashboardOutDto);

		when(blogService.getApprovedBlog(filterDto)).thenReturn(responseList);

		/*
		 * mockMvc .perform(post(RequestMappingConst.BLOG_URL+"read-approved")
		 * .contentType(MediaType.APPLICATION_JSON) .content(asJsonString(filterDto)))
		 * .andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(POST_ID))
		 * .andExpect(jsonPath("$[0].title").value("Test Title")).andExpect(jsonPath(
		 * "$[0].status").value("APPROVED"))
		 * .andExpect(jsonPath("$[0].technology").value("JAVA"));
		 * 
		 * verify(blogService, times(1)).getAllPostFilter(filterDto);
		 */
	}

	@Test
	public void testGetUserPosts() throws Exception {
		UserBlogsInDto filterDto = new UserBlogsInDto();
		filterDto.setUserId("Test User id");
		filterDto.setTechCategory(TechnologyCategory.JAVA);

		List<UserBlogsOutDto> responseList = new ArrayList<>();
		UserBlogsOutDto myBlogPostOutDto = new UserBlogsOutDto();
		myBlogPostOutDto.setId(POST_ID);
		myBlogPostOutDto.setTitle("Test Title");
		myBlogPostOutDto.setTechnology(TechnologyCategory.JAVA);
		responseList.add(myBlogPostOutDto);

		when(blogService.getUserBlogs(filterDto)).thenReturn(responseList);

		mockMvc
				.perform(post(RequestMappingConst.BLOG_URL + "/all/user/blogs").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(filterDto)))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(POST_ID))
				.andExpect(jsonPath("$[0].title").value("Test Title")).andExpect(jsonPath("$[0].technology").value("JAVA"));

		verify(blogService, times(1)).getUserBlogs(filterDto);
	}

	@Test
	public void testGetUnreviewedPost() throws Exception {
		UnReviewedBlogsInDto unReviewedBlogsInDto = new UnReviewedBlogsInDto();
		unReviewedBlogsInDto.setTechnologyCategory(TechnologyCategory.JAVA);

		List<UnReviewedBlogsOutDto> responseList = new ArrayList<>();
		UnReviewedBlogsOutDto unReviewedBlogsOutDto = new UnReviewedBlogsOutDto();
		unReviewedBlogsOutDto.setId(POST_ID);
		unReviewedBlogsOutDto.setTitle("Test Title");
		unReviewedBlogsOutDto.setTechCategory(TechnologyCategory.JAVA);
		responseList.add(unReviewedBlogsOutDto);

		when(blogService.getUnreviewedBlogs(unReviewedBlogsInDto)).thenReturn(responseList);

		/*
		 * mockMvc .perform(
		 * post("/blog/unreviewed").contentType(MediaType.APPLICATION_JSON).content(
		 * asJsonString(unReviewedPostInDto)))
		 * .andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(POST_ID))
		 * .andExpect(jsonPath("$[0].title").value("Test Title")).andExpect(jsonPath(
		 * "$[0].techCategory").value("JAVA"));
		 * 
		 * verify(blogService, times(1)).getUnreviewedPosts(unReviewedPostInDto);
		 */
	}

	@Test
	public void testResponseUnreviewedPost() throws Exception {
		ActOnUnReviewedBlogInDto actOnUnReviewedBlogInDto = new ActOnUnReviewedBlogInDto();
		actOnUnReviewedBlogInDto.setPostId(POST_ID);
		actOnUnReviewedBlogInDto.setPostStatus(BlogStatus.APPROVED);
		ApiResponse response = new ApiResponse(ResponseMessage.UNREVIEW_BLOG_APPROVED, true);
		when(blogService.actOnUnreviewedBlog(actOnUnReviewedBlogInDto)).thenReturn(response);

		/*
		 * mockMvc
		 * .perform(put("/blog/action-unreview").contentType(MediaType.APPLICATION_JSON)
		 * .content(asJsonString(approveOrRejectPostInDto)))
		 * .andExpect(status().isOk()).andExpect(jsonPath("$.message").value(
		 * ResponseMessage.UNREVIEW_BLOG_APPROVED))
		 * .andExpect(jsonPath("$.success").value(true));
		 * 
		 * verify(blogService,
		 * times(1)).responseUnreviewedPost(approveOrRejectPostInDto);
		 */ }

	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
