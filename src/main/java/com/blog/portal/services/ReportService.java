package com.blog.portal.services;

import java.util.List;
import com.blog.portal.requestPayload.ReportBlogInDto;
import com.blog.portal.requestPayload.ActOnReportedBlogInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.ReportedBlogReasonsOutDto;
import com.blog.portal.responsePayload.ReportedBlogsOutDto;

/**
 * Interface ReportService that represent the rule of ReportedBlog that would follow by
 * it's child.
 *
 * @author {Ashutosh Tigga]
 */
public interface ReportService {

	/**
	 * This method is for reporting on post.
	 *
	 * @param inDto
	 * @return ApiResponse
	 */
	ApiResponse reportOnBlog(ReportBlogInDto inDto);

	/**
	 * Fetches All reported Blog.
	 *
	 * @return Collection of All Reported Blog.
	 */
	List<ReportedBlogsOutDto> getReportedBlogs();

	/**
	 * This is mmethod responsible for fetch the action from adimn on reported blog
	 * and if admin action is approve then all the reported associate with that id
	 * will re removed or if admin action is delete then that reported post must be
	 * deleted.
	 *
	 * @param inDto
	 * @return response.
	 */
	ApiResponse actOnReportedBlog(ActOnReportedBlogInDto inDto);

	/**
	 * This returns the reporting message of particular post that we mentioned in
	 * path var.
	 *
	 * @param postId
	 * @return reason message of reporting.
	 */
	ReportedBlogReasonsOutDto getReportedBlogReason(String postId);

}
