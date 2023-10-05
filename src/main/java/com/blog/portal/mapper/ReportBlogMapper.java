package com.blog.portal.mapper;

import com.blog.portal.entities.ReportedBlog;
import com.blog.portal.requestPayload.ReportBlogInDto;
import com.blog.portal.responsePayload.ReportedBlogsOutDto;

/**
 * This class provides static methods for mapping
 * between DTOs and the ReportedBlog entity.
 * @author Ashutosh Tigga
 */
public class ReportBlogMapper {

	/**
	 * This method converts ReportBlogInDto into ReportedBlog.
	 * @param inDto
	 * @return reportedPostEntity.
	 */
	public static ReportedBlog inDtoToEntity(final ReportBlogInDto inDto) {
		ReportedBlog reportedPostEntity = new ReportedBlog();
		reportedPostEntity.setPostId(inDto.getPostId());
		reportedPostEntity.setUserId(inDto.getUserId());
		reportedPostEntity.setReportReason(inDto.getReportReason());
		return reportedPostEntity;
	}
	/**
	 * This method converts Blog into ReportedBlog.
	 * @param reportedBlog
	 * @return outDto
	 */
	public static ReportedBlogsOutDto entityToOutDto(final ReportedBlog reportedBlog) {
		ReportedBlogsOutDto outDto = new ReportedBlogsOutDto();
		outDto.setId(reportedBlog.getId());
		outDto.setPost(reportedBlog.getPost());
		outDto.setUserId(reportedBlog.getUserId());
		outDto.setPostId(reportedBlog.getPostId());
		return outDto;
	}

}
