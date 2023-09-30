package com.blog.portal.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.portal.entities.Post;
import com.blog.portal.entities.ReportedPost;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.AdminAction;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ReportedPostMapper;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.repository.CommentPostRepo;
import com.blog.portal.repository.LikeOrDislikePostRepo;
import com.blog.portal.repository.ReportedPostRepo;
import com.blog.portal.requestPayload.ReportedPostInDto;
import com.blog.portal.requestPayload.ActionOnReportedPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.ReportedPostMessageOutDto;
import com.blog.portal.responsePayload.ReportedPostOutDto;
import com.blog.portal.services.ReportedPostService;
import com.blog.portal.util.ResponseMessage;

@Service
public class ReportedPostServiceImpl  implements ReportedPostService {

	/**
	 * This {@code ReportedPostRepo} deal with db to perform taks on data.
	 */
	@Autowired
	private ReportedPostRepo reportedPostRepo;

	/**
	 * This {@code BlogPostRepo} deals with db to perform task related to Post entity.
	 */
	@Autowired
	private BlogPostRepo blogPostRepo;

	/**
	 * This {@code BlogUserRepo} deals with db operation related to BlogUser entity.
	 */
	@Autowired
	private BlogUserRepo blogUserRepo;
	/**
	 * This {@code LikeOrDislikePostRepo} deals with db operation perform on LikeOrDislike entity.
	 */
	@Autowired
	private LikeOrDislikePostRepo likeOrDislikePostRepo;
	/**
	 * This {@code CommentPostRepo} deals with db operation to be performm on Comment entity.
	 */
	@Autowired
	private CommentPostRepo commentPostRepo;
	/**
	 * This method is for report on post by employee.
	 * @param inDto
	 * @return response
	 */
	@Override
	public ApiResponse reportPost(ReportedPostInDto inDto) {
		ApiResponse response = new ApiResponse();
		ReportedPost isReportedPostExists = reportedPostRepo.findByUserIdAndPostId(inDto.getUserId(), inDto.getPostId());
		if (isReportedPostExists == null) {
			User isUserExists = blogUserRepo.findById(inDto.getUserId()).orElseThrow(
					() -> new ResourceNotFoundException("User", "userId", inDto.getUserId()));
			Post isPostExists = blogPostRepo.findById(inDto.getPostId()).orElseThrow(
					() -> new ResourceNotFoundException("Post", "postId", inDto.getPostId()));
			ReportedPost reportedPost = ReportedPostMapper.inDtoToEntity(inDto);
			if (isPostExists != null && isUserExists != null) {
				isPostExists.getReportedBy().add(inDto.getUserId());
				Post savedPost = blogPostRepo.save(isPostExists);
				reportedPost.setPost(savedPost);
				reportedPostRepo.save(reportedPost);
				response.setSuccess(true);
				response.setMessage(ResponseMessage.BLOG_REPORT_SUCCESS);
		}
		} else {
			response.setMessage(ResponseMessage.BLOG_ALREADY_REPORTED);
			response.setSuccess(false);
		}
		return response;
	}

	/**
	 * Gets All ReportedPost.
	 * @return response Collection of ReportedPostOutDto.
	 */
	public List<ReportedPostOutDto> getAllReportedPost() {
    List<ReportedPostOutDto> response = new ArrayList<>();
    List<ReportedPost> fetchedListOfReportedPost = reportedPostRepo.findAll();

    Set<String> uniquePostReferences = new HashSet<>();

    for (ReportedPost reportedPost : fetchedListOfReportedPost) {
        String postReference = reportedPost.getPost().getId();
        if (!uniquePostReferences.contains(postReference)) {
            response.add(ReportedPostMapper.entityToOutDto(reportedPost));
            uniquePostReferences.add(postReference);
        }
    }

    return response;
}

	/**
	 * This method is for admin who can act on reported Blog post
	 * if he clicked on delete then reported post must be deleted
	 * or if he clicked on ignore then all the reports must be clear from blog post.
	 * @param inDto
	 * @return reponse.
	 */
	@Override
	public ApiResponse actOnReportedBlog(ActionOnReportedPostInDto inDto) {
		ApiResponse response = new ApiResponse();
		AdminAction action = inDto.getAdminAction();
		String postId = inDto.getPostId();
		List<ReportedPost> fetchedReportedPost = reportedPostRepo.findByPostId(postId);
		if (fetchedReportedPost.size() != 0) {
			Post fetchedPost = blogPostRepo.findById(postId).orElseThrow(()
					-> new ResourceNotFoundException("Post", "postId", postId));
			if (action == AdminAction.IGNORE) {
				fetchedPost.getReportedBy().clear();
				blogPostRepo.save(fetchedPost);
				reportedPostRepo.deleteByPostId(postId);
				response.setMessage(ResponseMessage.REPORTED_BLOG_ACT_IGNORED);
				response.setSuccess(true);
			} else if (action == AdminAction.DELETE) {
				reportedPostRepo.deleteByPostId(postId);
				blogPostRepo.deleteById(postId);
				likeOrDislikePostRepo.deleteByPostId(postId);
				commentPostRepo.deleteByPostId(postId);
				response.setMessage(ResponseMessage.REPORTED_BLOG_ACT_DELETED);
				response.setSuccess(true);
			}
		} else {
			response.setMessage(ResponseMessage.REPORTED_BLOG_ACT_FAILED);
			response.setSuccess(false);
		}
		return response;
	}

	/**
	 * Gets Reporting Message.
	 * return response Reporting message of post.
	 */
	@Override
	public ReportedPostMessageOutDto getMessage(String postId) {
		ReportedPostMessageOutDto response = new ReportedPostMessageOutDto();
		List<ReportedPost> fetchReportedPost = reportedPostRepo.findByPostId(postId);
		List<String> listOfMessage = new ArrayList<String>();
		for (ReportedPost reportPost : fetchReportedPost) {
			listOfMessage.add(reportPost.getReportReason());
		}
		response.setReasons(listOfMessage);
		return response;
	}
}
