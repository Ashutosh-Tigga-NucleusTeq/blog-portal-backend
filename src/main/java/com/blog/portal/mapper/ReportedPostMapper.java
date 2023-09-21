package com.blog.portal.mapper;

import com.blog.portal.entities.ReportedPost;
import com.blog.portal.requestPayload.ReportedPostInDto;
import com.blog.portal.responsePayload.ReportedPostOutDto;

public class ReportedPostMapper {

	/**
	 * This method converts {@code ReportedPostInDto} into {@code ReportedPost}.
	 * @param inDto
	 * @return reportedPostEntity.
	 */
	public static ReportedPost inDtoToEntity(ReportedPostInDto inDto) {
		ReportedPost reportedPostEntity = new ReportedPost();
		reportedPostEntity.setPostId(inDto.getPostId());
		reportedPostEntity.setUserId(inDto.getUserId());
		return reportedPostEntity;
	}
	/**
	 * This method converts {@code Post} into {@code ReportedPost}.
	 * @param reportedPost
	 * @return outDto
	 */
	public static ReportedPostOutDto entityToOutDto(ReportedPost reportedPost) {
		ReportedPostOutDto outDto = new ReportedPostOutDto();
		outDto.setId(reportedPost.getId());
		outDto.setPost(reportedPost.getPost());
		outDto.setUserId(reportedPost.getUserId());
		outDto.setReportReason(reportedPost.getReportReason());
		outDto.setPostId(reportedPost.getPostId());
		return outDto;
	}

}
