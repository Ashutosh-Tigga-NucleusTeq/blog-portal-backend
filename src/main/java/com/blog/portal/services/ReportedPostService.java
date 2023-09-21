package com.blog.portal.services;


import java.util.List;

import com.blog.portal.requestPayload.ReportedPostInDto;
import com.blog.portal.requestPayload.ActionOnReportedPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.ReportedPostOutDto;


public interface ReportedPostService {

	/**
	 * This method is for reporting on post.
	 * @param inDto
	 * @return ApiResponse
	 */
	 ApiResponse reportPost(ReportedPostInDto inDto);

	/**
	 * Fetches All reported Post.
	 * @return Collection of All Reported Post.
	 */
	List<ReportedPostOutDto> getAllReportedPost();

	/**
	 * This is mmethod responsible for fetch the action from adimn on reported blog
	 * and if admin action is approve then all the reported associate with that id will re removed
	 * or if admin action is delete then that reported post must be deleted.
	 * @param inDto
	 * @return response.
	 */
	ApiResponse actOnReportedBlog(ActionOnReportedPostInDto inDto);

}
