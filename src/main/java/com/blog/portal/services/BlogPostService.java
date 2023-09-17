package com.blog.portal.services;

import java.util.List;

import com.blog.portal.messagePayloads.ApiResponse;
import com.blog.portal.requestPayload.FilterDashboardPostInDto;
import com.blog.portal.requestPayload.FilterMyBlogPostInDto;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.requestPayload.UpdatePostInDto;
import com.blog.portal.responsePayload.FilterDashboardOutDto;
import com.blog.portal.responsePayload.FilterMyBlogPostOutDto;
import com.blog.portal.responsePayload.GetPostOutDto;

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
	 * @param pageNumber
	 * @param pageSize
	 * @return List<ShowPostOutDto>
	 */
	List<FilterDashboardOutDto> getAllPostFilter(FilterDashboardPostInDto indto, Integer pageNumber, Integer pageSize);

	/**
	 * Method that returns user's Post.
	 *@param inDto
	 *@param pageNumber
	 *@param pageSize
	 *@return List<UserPostOutDto>
	 */
	List<FilterMyBlogPostOutDto> getAllPostOfUserFilter(FilterMyBlogPostInDto inDto, Integer pageNumber, Integer pageSize);

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


}
