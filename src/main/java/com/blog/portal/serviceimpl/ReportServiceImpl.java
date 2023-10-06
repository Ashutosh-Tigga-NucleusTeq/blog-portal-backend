package com.blog.portal.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.portal.entities.Blog;
import com.blog.portal.entities.ReportedBlog;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.ReportedBlogAction;
import com.blog.portal.exception.EmptyDataException;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ReportBlogMapper;
import com.blog.portal.repository.BlogRepository;
import com.blog.portal.repository.UserRepository;
import com.blog.portal.repository.CommentRepository;
import com.blog.portal.repository.ReactionRepository;
import com.blog.portal.repository.ReportRepository;
import com.blog.portal.requestPayload.ReportBlogInDto;
import com.blog.portal.requestPayload.ActOnReportedBlogInDto;
import com.blog.portal.responsePayload.ReportedBlogReasonsOutDto;
import com.blog.portal.responsePayload.ReportedBlogsOutDto;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.services.ReportService;
import com.blog.portal.util.Constants;
import com.blog.portal.util.ErrorConstants;
import com.blog.portal.util.ResponseMessageConstants;

/**
 * Implementation of the ReportService interface responsible for Report blog
 * related operations.
 * @author Ashutosh Tigga.
 */
@Service
public class ReportServiceImpl implements ReportService {

	/**
	 * This ReportRepository deal with db to perform taks on data.
	 */
	@Autowired
	private ReportRepository reportRepository;

	/**
	 * This BlogRepository deals with db to perform task related to Blog
	 * entity.
	 */
	@Autowired
	private BlogRepository blogRepository;

	/**
	 * This UserRepository deals with db operation related to BlogUser
	 * entity.
	 */
	@Autowired
	private UserRepository userRepository;
	/**
	 * This ReactionRepository deals with db operation perform on
	 * LikeOrDislike entity.
	 */
	@Autowired
	private ReactionRepository reactionRepository;
	/**
	 * This CommentRepository deals with db operation to be performm on
	 * Comment entity.
	 */
	@Autowired
	private CommentRepository commentRepository;

	/**
	 * This method is for report on post by employee.
	 * @param inDto
	 * @return response
	 */
	@Override
	public ResponseOutDTO reportOnBlog(final ReportBlogInDto inDto) {
		ResponseOutDTO response = new ResponseOutDTO();
		ReportedBlog isReportedPostExists = reportRepository.findByUserIdAndPostId(
				inDto.getUserId(), inDto.getPostId());
		if (isReportedPostExists == null) {
			User isUserExists = userRepository.findById(inDto.getUserId()).orElseThrow(
					() -> new ResourceNotFoundException(
							Constants.USER_CLASS_NAME, Constants.USER_ID,
							inDto.getUserId()));
			Blog isPostExists = blogRepository.findById(inDto.getPostId()).orElseThrow(
					() -> new ResourceNotFoundException(
							Constants.POST_CLASS_NAME, Constants.POST_ID,
							inDto.getPostId()));
			ReportedBlog reportedBlog = ReportBlogMapper.inDtoToEntity(inDto);
			if (isPostExists != null && isUserExists != null) {
				isPostExists.getReportedBy().add(inDto.getUserId());
				Blog savedPost = blogRepository.save(isPostExists);
				reportedBlog.setPost(savedPost);
				reportRepository.save(reportedBlog);
				response.setSuccess(true);
				response.setMessage(ResponseMessageConstants.BLOG_REPORT_SUCCESS);
			}
		} else {
			response.setMessage(ResponseMessageConstants.BLOG_ALREADY_REPORTED);
			response.setSuccess(false);
		}
		return response;
	}

	/**
	 * Gets All ReportedBlog.
	 * @return response Collection of ReportedBlogsOutDto.
	 */
	public List<ReportedBlogsOutDto> getReportedBlogs() {
		List<ReportedBlogsOutDto> responseDto = new ArrayList<>();
		List<ReportedBlog> fetchedListOfReportedPost = reportRepository.findAll();

		Set<String> uniquePostReferences = new HashSet<>();

		for (ReportedBlog reportedBlog : fetchedListOfReportedPost) {
			String postReference = reportedBlog.getPost().getId();
			if (!uniquePostReferences.contains(postReference)) {
				responseDto.add(ReportBlogMapper.entityToOutDto(reportedBlog));
				uniquePostReferences.add(postReference);
			}
		}

		if (Objects.isNull(responseDto)) {
			throw new EmptyDataException(ErrorConstants.EMPTY_REPORT_REASON);
		}
		return responseDto;
	}

	/**
	 * This method is for admin who can act on reported Blog post if he clicked on
	 * delete then reported post must be deleted or if he clicked on ignore then all
	 * the reports must be clear from blog post.
	 * @param inDto
	 * @return reponse.
	 */
	@Override
	public ResponseOutDTO actOnReportedBlog(final ActOnReportedBlogInDto inDto) {
		ResponseOutDTO response = new ResponseOutDTO();
		ReportedBlogAction action = inDto.getAdminAction();
		String postId = inDto.getPostId();
		List<ReportedBlog> fetchedReportedPost = reportRepository.findByPostId(postId);
		if (fetchedReportedPost.size() != 0) {
			Blog fetchedPost = blogRepository.findById(postId).orElseThrow(
					() -> new ResourceNotFoundException(Constants.POST_CLASS_NAME,
							Constants.POST_ID, postId));
			if (action == ReportedBlogAction.IGNORE) {
				fetchedPost.getReportedBy().clear();
				blogRepository.save(fetchedPost);
				reportRepository.deleteByPostId(postId);
				response.setMessage(ResponseMessageConstants.REPORTED_BLOG_ACT_IGNORED);
				response.setSuccess(true);
			} else if (action == ReportedBlogAction.DELETE) {
				reportRepository.deleteByPostId(postId);
				blogRepository.deleteById(postId);
				reactionRepository.deleteByPostId(postId);
				commentRepository.deleteByPostId(postId);
				response.setMessage(ResponseMessageConstants.REPORTED_BLOG_ACT_DELETED);
				response.setSuccess(true);
			}
		} else {
			response.setMessage(ResponseMessageConstants.REPORTED_BLOG_ACT_FAILED);
			response.setSuccess(false);
		}
		return response;
	}

	/**
	 * Gets Reporting Message. return response Reporting message of post.
	 * @param postId
	 * @return responseDto
	 */
	@Override
	public ReportedBlogReasonsOutDto getReportedBlogReason(final String postId) {
		ReportedBlogReasonsOutDto responseDto = new ReportedBlogReasonsOutDto();
		List<ReportedBlog> fetchReportedPost = reportRepository.findByPostId(postId);
		List<String> listOfMessage = new ArrayList<String>();
		for (ReportedBlog reportPost : fetchReportedPost) {
			listOfMessage.add(reportPost.getReportReason());
		}
		if (listOfMessage.isEmpty()) {
			throw new EmptyDataException(ErrorConstants.EMPTY_REPORT_REASON);
		}
		responseDto.setReasons(listOfMessage);
		return responseDto;
	}
}
