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
import com.blog.portal.responsePayload.ReportedPostOutDto;
import com.blog.portal.services.ReportedPostService;

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
		ReportedPost ifExists = reportedPostRepo.findByUserIdAndPostId(inDto.getUserId(), inDto.getPostId());
		if (ifExists == null) {
			User isUserExists = blogUserRepo.findById(inDto.getUserId()).orElseThrow(
					() -> new ResourceNotFoundException("User", "userId", inDto.getUserId()));
			Post isPostExists = blogPostRepo.findById(inDto.getPostId()).orElseThrow(
					() -> new ResourceNotFoundException("Post", "postId", inDto.getPostId()));
			ReportedPost reportedPost = ReportedPostMapper.inDtoToEntity(inDto);
			if (isPostExists != null && isUserExists != null) {
			isPostExists.getReportedBy().add(inDto.getUserId());
			Post savedPost = blogPostRepo.save(isPostExists);
			savedPost.getUser().setPassword(null);
			reportedPost.setPost(savedPost);
			ReportedPost savedReportedPost = reportedPostRepo.save(reportedPost);
			System.out.println(savedReportedPost);
			if (savedReportedPost != null && savedPost != null) {
				response.setSuccess(true);
				response.setMessage("Blog Reported");
			} else {
				response.setSuccess(false);
				response.setMessage("Blog Reporting failed");
			}
		}
		} else {
			response.setMessage("Already Reported");
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
		// TODO Auto-generated method stub
		ApiResponse response = new ApiResponse();
		AdminAction action = inDto.getAdminAction();
		String postId = inDto.getpostId();
		List<ReportedPost> fetchedReportedPost = reportedPostRepo.findByPostId(postId);
		if (fetchedReportedPost.size() != 0) {
			Post fetchedPost = blogPostRepo.findById(postId).orElseThrow(()
					-> new ResourceNotFoundException("Post", "postId", postId));
			if (action == AdminAction.Ignore) {
				fetchedPost.getReportedBy().clear();
				blogPostRepo.save(fetchedPost);
				reportedPostRepo.deleteByPostId(postId);
				response.setMessage("Post Ignored");
				response.setSuccess(true);
			} else if (action == AdminAction.Delete) {
				reportedPostRepo.deleteByPostId(postId);
				blogPostRepo.deleteById(postId);
				likeOrDislikePostRepo.deleteByPostId(postId);
				commentPostRepo.deleteByPostId(postId);
				response.setMessage("Post Deleted");
				response.setSuccess(true);
			}
		} else {
			response.setMessage("No report found on this post");
			response.setSuccess(false);
		}
		return response;
	}
}
