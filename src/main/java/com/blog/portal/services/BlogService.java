package com.blog.portal.services;

import java.util.List;

import com.blog.portal.requestPayload.ApprovedBlogsInDto;
import com.blog.portal.requestPayload.UserBlogsInDto;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.requestPayload.ActOnUnReviewedBlogInDto;
import com.blog.portal.requestPayload.UnReviewedBlogsInDto;
import com.blog.portal.requestPayload.UpdateBlogInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.ApprovedBlogsOutDto;
import com.blog.portal.responsePayload.UserBlogsOutDto;
import com.blog.portal.responsePayload.BlogOutDto;
import com.blog.portal.responsePayload.UnReviewedBlogsOutDto;

/**
 * Interface PostService that represent the rule of Blog that would follow by
 * it's child.
 *
 * @author {Ashutosh Tigga]
 */
public interface BlogService {

	/**
	 * method that create post blog.
	 *
	 * @param postBlogInDto takes PostBlogInDto as parameter.
	 * @return ApiResponse.
	 */
	ApiResponse createPost(PostBlogInDto postBlogInDto);

	/**
	 * Method that fetches post.
	 *
	 * @param indto
	 * @return List<ShowPostOutDto>
	 */
	List<ApprovedBlogsOutDto> getApprovedBlog(ApprovedBlogsInDto indto);

	/**
	 * Method that returns user's Blog.
	 *
	 * @param inDto
	 * @return List<UserPostOutDto>
	 */
	List<UserBlogsOutDto> getUserBlogs(UserBlogsInDto inDto);

	/**
	 * update Blog post.
	 *
	 * @param inDto
	 * @return ApiResponse
	 */
	ApiResponse editBlog(UpdateBlogInDto inDto);

	/**
	 * Get post by id.
	 *
	 * @param postId
	 * @return BlogOutDto
	 */
	BlogOutDto getBlogById(String postId);

	/**
	 * This method returns the unreviewed posted blogs.
	 *
	 * @param inDto Contains keyword for filtering.
	 * @return Collection of post which is not reviewed yet.
	 */
	List<UnReviewedBlogsOutDto> getUnreviewedBlogs(UnReviewedBlogsInDto inDto);

	/**
	 * Admin can approve or reject unreviewed code using inDto that contains post id
	 * and post status.
	 *
	 * @param inDto
	 * @return response
	 */
	ApiResponse actOnUnreviewedBlog(ActOnUnReviewedBlogInDto inDto);

}
