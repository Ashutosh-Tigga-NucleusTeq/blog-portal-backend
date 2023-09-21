package com.blog.portal.services;

import java.util.List;

import com.blog.portal.requestPayload.FilterDashboardPostInDto;
import com.blog.portal.requestPayload.FilterMyBlogPostInDto;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.requestPayload.ApproveOrRejectPostInDto;
import com.blog.portal.requestPayload.UnReviewedPostInDto;
import com.blog.portal.requestPayload.UpdatePostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.FilterDashboardOutDto;
import com.blog.portal.responsePayload.FilterMyBlogPostOutDto;
import com.blog.portal.responsePayload.GetPostOutDto;
import com.blog.portal.responsePayload.UnReviewedPostOutDto;

/**
 * Interface PostService that represent the rule of Post that would follow by it's child.
 * @author {Ashutosh Tigga]
 */
public interface BlogPostService {

	/**
	 * method that create post blog.
	 * @param postBlogInDto takes PostBlogInDto as parameter.
	 * @return ApiResponse.
	 */
	ApiResponse createPost(PostBlogInDto postBlogInDto);

	/**
	 * Method that fetches post.
	 * @param indto
	 * @return List<ShowPostOutDto>
	 */
	List<FilterDashboardOutDto> getAllPostFilter(FilterDashboardPostInDto indto);

	/**
	 * Method that returns user's Post.
	 *@param inDto
	 *@return List<UserPostOutDto>
	 */
	List<FilterMyBlogPostOutDto> getAllPostOfUserFilter(FilterMyBlogPostInDto inDto);

	/**
	 * update Blog post.
	 * @param inDto
	 * @return ApiResponse
	 */
	ApiResponse editBlog(UpdatePostInDto inDto);

	/**
	 * Get post by id.
	 * @param postId
	 * @return GetPostOutDto
	 */
	GetPostOutDto getPost(String postId);

	/**
	 * This method returns the unreviewed posted blogs.
	 * @param inDto Contains keyword for filtering.
	 * @return Collection of post which is not reviewed yet.
	 */
	List<UnReviewedPostOutDto> getUnreviewedPosts(UnReviewedPostInDto inDto);

	/**
	 * Admin can approve or reject unreviewed code using inDto that contains
	 * post id and post status.
	 * @param inDto
	 * @return response
	 */
	ApiResponse responseUnreviewedPost(ApproveOrRejectPostInDto inDto);


}
