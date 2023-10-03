package com.blog.portal.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.portal.entities.Blog;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ApprovedBlogMapper;
import com.blog.portal.mapper.UserBlogMapper;
import com.blog.portal.mapper.FetchBlogMapper;
import com.blog.portal.mapper.PostBlogMapper;
import com.blog.portal.mapper.UnReviewedBlogMapper;
import com.blog.portal.repository.BlogRepository;
import com.blog.portal.repository.UserRepository;
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
import com.blog.portal.services.BlogService;
import com.blog.portal.util.BlogConst;
import com.blog.portal.util.ResponseMessage;
import com.blog.portal.util.UserConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

/**
 * Implementation of the BlogService interface responsible for Blog-related
 * operations.
 *
 * @author Ashutosh Tigga.
 */
@Service
public class BlogServiceImpl implements BlogService {

	/**
	 * Instance of PostRepo for performing operations on Blog related data in
	 * database.
	 */
	@Autowired
	private BlogRepository blogRepository;
	/**
	 * Instance of UserRepo for performing operation on User.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Method that deal with creation of post API in database.
	 *
	 *	@param postBlogInDto
	 *	@return response in the form of String and boolean field.
	 */
	@Override
	public ApiResponse createPost(@Valid final PostBlogInDto postBlogInDto) {
		ApiResponse reponse = null;
		User user = userRepository.findById(postBlogInDto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException(UserConst.CLASS_NAME,
						UserConst.FIELD_USER_ID,
						postBlogInDto.getUserId()));
		user.setPassword(null);
		Blog blog = PostBlogMapper.inDtoToPost(postBlogInDto);
		blog.setUser(user);
		blog.setUserId(user.getId());
		Blog savedBlog = blogRepository.save(blog);
		if (Objects.isNull(savedBlog)) {
			reponse = new ApiResponse(ResponseMessage.BLOG_POST_FAILED, false);
			return reponse;
		}
		reponse = new ApiResponse(ResponseMessage.BLOG_POST_SUCCESS, true);
		return reponse;
	}

	/**
	 * Get All Posts by filtering by status = approved , title and techcategory.
	 *
	 * @param inDto
	 * @return outDtoList collection of approved Blogs.
	 */
	public List<ApprovedBlogsOutDto> getApprovedBlog(@Valid final ApprovedBlogsInDto inDto) {
		BlogStatus status = BlogStatus.APPROVED;
		List<Blog> fetchedPost = new ArrayList<Blog>();
		List<ApprovedBlogsOutDto> outDtoList = new ArrayList<ApprovedBlogsOutDto>();
		if (inDto.getTitle() == null && inDto.getTechCategory() == null) {
			fetchedPost = blogRepository.findByStatus(status);
		}
		if (inDto.getTechCategory() != null && inDto.getTitle() == null) {
			fetchedPost = blogRepository.findByTechCategoryAndStatus(inDto.getTechCategory(), status);
		}
		if (inDto.getTitle() != null && inDto.getTechCategory() == null) {
			fetchedPost = blogRepository.findByTitleContainingIgnoreCaseAndStatus(inDto.getTitle(), status);
		}
		if (inDto.getTitle() != null && inDto.getTechCategory() != null) {
			fetchedPost = blogRepository.findByTitleContainingIgnoreCaseAndStatusAndTechCategory(
					inDto.getTitle(), status,
					inDto.getTechCategory());
		}
		for (Blog p : fetchedPost) {
			ApprovedBlogsOutDto outDto = ApprovedBlogMapper.postToOutDto(p);
			outDtoList.add(outDto);
		}
		Collections.sort(outDtoList);
		return outDtoList;
	}

	/**
	 * This method gets user post.
	 *
	 * @param inDto
	 * @return outDtoList collection of user BLOGS.
	 */
	@Override
	public List<UserBlogsOutDto> getUserBlogs(final UserBlogsInDto inDto) {
		List<Blog> fetchedPost = new ArrayList<Blog>();
		if (inDto.getTitle() == null && inDto.getTechCategory() == null && inDto.getStatus() == null) {
			fetchedPost = blogRepository.findByUserId(inDto.getUserId());
		}
		if (inDto.getTitle() != null && inDto.getStatus() == null && inDto.getTechCategory() == null) {
			fetchedPost = blogRepository.findByTitleContainingIgnoreCaseAndUserId(
					inDto.getTitle(),
					inDto.getUserId());
		}
		if (inDto.getTechCategory() != null && inDto.getStatus() == null && inDto.getTitle() == null) {
			fetchedPost = blogRepository.findByTechCategoryAndUserId(
					inDto.getTechCategory(),
					inDto.getUserId());
		}
		if (inDto.getStatus() != null && inDto.getTechCategory() == null && inDto.getTitle() == null) {
			fetchedPost = blogRepository.findByStatusAndUserId(
					inDto.getStatus(),
					inDto.getUserId());
		}
		if (inDto.getStatus() != null && inDto.getTechCategory() != null && inDto.getTitle() == null) {
			fetchedPost = blogRepository.findByStatusAndTechCategoryAndUserId(
					inDto.getStatus(),
					inDto.getTechCategory(),
					inDto.getUserId());
		}
		if (inDto.getStatus() == null && inDto.getTechCategory() != null && inDto.getTitle() != null) {
			fetchedPost = blogRepository.findByTechCategoryAndTitleContainingIgnoreCaseAndUserId(
					inDto.getTechCategory(),
					inDto.getTitle(),
					inDto.getUserId());
		}
		if (inDto.getStatus() != null && inDto.getTechCategory() == null && inDto.getTitle() != null) {
			fetchedPost = blogRepository.findByStatusAndTitleContainingIgnoreCaseAndUserId(
					inDto.getStatus(),
					inDto.getTitle(),
					inDto.getUserId());
		}
		if (inDto.getStatus() != null && inDto.getTechCategory() != null && inDto.getTitle() != null) {
			fetchedPost = blogRepository.findByStatusAndTechCategoryAndTitleContainingIgnoreCaseAndUserId(
					inDto.getStatus(),
					inDto.getTechCategory(),
					inDto.getTitle(),
					inDto.getUserId());
		}
		List<UserBlogsOutDto> outDtoList = new ArrayList<UserBlogsOutDto>();
		for (Blog p : fetchedPost) {
			UserBlogsOutDto outDto = UserBlogMapper.postToOutDto(p);
			outDtoList.add(outDto);
		}
		Collections.sort(outDtoList);
		return outDtoList;
	}

	/**
	 * This method is for Edit existing Blog.
	 *
	 * @param inDto Dto Contains data that need for Update.
	 * @return response in the form of String and boolean field.
	 */
	@Override
	public ApiResponse editBlog(final UpdateBlogInDto inDto) {
		ApiResponse response = new ApiResponse();
		Blog fetchPost = blogRepository.findById(inDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException(BlogConst.CLASS_NAME,
						BlogConst.FIELD_POST_ID,
						inDto.getId()));
		fetchPost.setContent(inDto.getContent());
		fetchPost.setTitle(inDto.getTitle());
		fetchPost.setEditedAt(new Date());
		fetchPost.setStatus(BlogStatus.PENDING);
		Blog fetchedBlog = blogRepository.save(fetchPost);
		if (Objects.isNull(fetchedBlog)) {
			response.setMessage(ResponseMessage.BLOG_UPDATE_FAILED);
			response.setSuccess(false);
			return response;
		}
		response.setSuccess(true);
		response.setMessage(ResponseMessage.BLOG_UPDATE_SUCCESS);
		return response;
	}

	/**
	 * This method for getting post by id.
	 *
	 * @param postId
   * @return response in the form of String and boolean field.
	 */
	@Override
	public BlogOutDto getBlogById(final String postId) {
		Blog blog = blogRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(BlogConst.CLASS_NAME,
						BlogConst.FIELD_POST_ID, postId));
		BlogOutDto outDto = FetchBlogMapper.entityToOutDto(blog);
		return outDto;
	}

	/**
	 * This method for Fetching Collection of post which is not approved by ADMIN.
	 *
	 * @param inDto DTO contains fields.
	 * @return Collection of BLOG which status is in Pending.
	 */
	@Override
	public List<UnReviewedBlogsOutDto> getUnreviewedBlogs(final UnReviewedBlogsInDto inDto) {
		BlogStatus status = BlogStatus.PENDING;
		List<Blog> fetchedListOfPost = new ArrayList<Blog>();
		List<UnReviewedBlogsOutDto> responseDto = new ArrayList<UnReviewedBlogsOutDto>();
		if (inDto.getTitle() == null && inDto.getTechnologyCategory() == null) {
			fetchedListOfPost = blogRepository.findByStatus(status);
		}
		if (inDto.getTechnologyCategory() != null && inDto.getTitle() == null) {
			fetchedListOfPost = blogRepository.findByTechCategoryAndStatus(
					inDto.getTechnologyCategory(),
					status);
		}
		if (inDto.getTitle() != null && inDto.getTechnologyCategory() == null) {
			fetchedListOfPost = blogRepository.findByTitleContainingIgnoreCaseAndStatus(
					inDto.getTitle(),
					status);
		}
		if (inDto.getTitle() != null && inDto.getTechnologyCategory() != null) {
			fetchedListOfPost = blogRepository.findByTitleContainingIgnoreCaseAndStatusAndTechCategory(
					inDto.getTitle(),
					status,
					inDto.getTechnologyCategory());
		}
		for (Blog blog : fetchedListOfPost) {
			responseDto.add(UnReviewedBlogMapper.entityToOutDto(blog));
		}
		return responseDto;
	}

	/**
	 * This method is for ADMIN with response approve or reject on UNREVIEWED post.
	 *
	 * @param inDto
	 * @return response from in the from of string.
	 */
	@Override
	public ApiResponse actOnUnreviewedBlog(final ActOnUnReviewedBlogInDto inDto) {
		ApiResponse response = new ApiResponse();
		BlogStatus status = inDto.getPostStatus();
		Blog fetchedPost = blogRepository.findById(inDto.getPostId())
				.orElseThrow(() -> new ResourceNotFoundException(BlogConst.CLASS_NAME,
				BlogConst.FIELD_POST_ID, inDto.getPostId()));
		if (fetchedPost.getStatus() == BlogStatus.PENDING) {
			if (status == BlogStatus.APPROVED) {
				fetchedPost.setStatus(BlogStatus.APPROVED);
				blogRepository.save(fetchedPost);
				response.setMessage(ResponseMessage.UNREVIEW_BLOG_APPROVED);
				response.setSuccess(true);
			} else if (status == BlogStatus.REJECTED) {
				fetchedPost.setStatus(BlogStatus.REJECTED);
				blogRepository.save(fetchedPost);
				response.setMessage(ResponseMessage.UNREVIEW_BLOG_REJECTED);
				response.setSuccess(true);
			}
		} else {
			response.setMessage(ResponseMessage.UNREVIEW_BLOG_FAILED);
			response.setSuccess(false);
		}
		return response;
	}

}
