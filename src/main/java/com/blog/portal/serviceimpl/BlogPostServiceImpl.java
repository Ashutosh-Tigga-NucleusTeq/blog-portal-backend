package com.blog.portal.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.portal.entities.Post;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.FilterDashboardPostMapper;
import com.blog.portal.mapper.FilterMyBlogPostMapper;
import com.blog.portal.mapper.GetPostMapper;
import com.blog.portal.mapper.PostBlogMapper;
import com.blog.portal.mapper.UnReviewedPostMapper;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.requestPayload.FilterDashboardPostInDto;
import com.blog.portal.requestPayload.FilterMyBlogPostInDto;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.requestPayload.ApproveOrRejectPostInDto;
import com.blog.portal.requestPayload.UnReviewedPostInDto;
import com.blog.portal.requestPayload.UpdatePostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.FilterDashboardOutDto;
import com.blog.portal.responsePayload.FilterMyBlogPostOutDto;
import com.blog.portal.responsePayload.GetPostOutDto;
import com.blog.portal.responsePayload.UnReviewedPostOutDto;
import com.blog.portal.services.BlogPostService;
import com.blog.portal.util.ResponseMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

/**
 * Implementation of the UserService interface responsible for post-related
 * operations.
 *
 * @author Ashutosh Tigga.
 */
@Service
public class BlogPostServiceImpl implements BlogPostService {

	/**
	 * Instance of PostRepo for performing operations on Post related data in
	 * database.
	 */
	@Autowired
	private BlogPostRepo blogPostRepo;
	/**
	 * Instance of UserRepo for performing operation on User.
	 */
	@Autowired
	private BlogUserRepo blogUserRepo;

	/**
	 * Method that deal with creation of post API in database.
	 */
	@Override
	public ApiResponse createPost(@Valid PostBlogInDto postBlogInDto) {

		ApiResponse reponse = null;
		User user = blogUserRepo.findById(postBlogInDto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", postBlogInDto.getUserId()));
		user.setPassword(null);
		Post post = PostBlogMapper.inDtoToPost(postBlogInDto);
		post.setUser(user);
		post.setUserId(user.getId());
		try {
			blogPostRepo.save(post);
			reponse = new ApiResponse(ResponseMessage.BLOG_POST_SUCCESS, true);
		} catch (RuntimeException ex) {
			reponse = new ApiResponse(ResponseMessage.BLOG_POST_FAILED, false);
		} catch (Exception e) {
			reponse = new ApiResponse(ResponseMessage.BLOG_POST_FAILED, false);
		}
		return reponse;
	}

	/**
	 * Get All Posts by filtering by status = approved , title and techcategory.
	 *
	 * @param inDto
	 * @return List<ShowPostDto>
	 */
	public List<FilterDashboardOutDto> getAllPostFilter(@Valid FilterDashboardPostInDto inDto) {
		PostStatus status = PostStatus.APPROVED; // set status approved for fetching post which is approved by admin
		List<Post> fetchedPost = new ArrayList<Post>();
		List<FilterDashboardOutDto> outDtoList = new ArrayList<FilterDashboardOutDto>();
		if (inDto.getTitle() == null && inDto.getTechCategory() == null) {
			fetchedPost = blogPostRepo.findByStatus(status);
		} else if (inDto.getTechCategory() != null && inDto.getTitle() == null) {
			fetchedPost = blogPostRepo.findByTechCategoryAndStatus(inDto.getTechCategory(), status);
		} else if (inDto.getTitle() != null && inDto.getTechCategory() == null) {
			fetchedPost = blogPostRepo.findByTitleContainingIgnoreCaseAndStatus(inDto.getTitle(), status);
		} else if (inDto.getTitle() != null && inDto.getTechCategory() != null) {
			fetchedPost = blogPostRepo.findByTitleContainingIgnoreCaseAndStatusAndTechCategory(
					inDto.getTitle(), status,
					inDto.getTechCategory());
		}
		for (Post p : fetchedPost) {
			FilterDashboardOutDto outDto = FilterDashboardPostMapper.postToOutDto(p);
			outDtoList.add(outDto);
		}
		Collections.sort(outDtoList);
		return outDtoList;
	}

	/**
	 * This Serviceimpl method gets user post.
	 *
	 * @param inDto
	 * @return List<UserPostOutDto>
	 */
	@Override
	public List<FilterMyBlogPostOutDto> getAllPostOfUserFilter(FilterMyBlogPostInDto inDto) {
		List<Post> fetchedPost = new ArrayList<Post>();
		if (inDto.getTitle() == null && inDto.getTechCategory() == null && inDto.getStatus() == null) {
			fetchedPost = blogPostRepo.findByUserId(inDto.getUserId());
		} else if (inDto.getTitle() != null && inDto.getStatus() == null && inDto.getTechCategory() == null) {
			fetchedPost = blogPostRepo.findByTitleContainingIgnoreCaseAndUserId(inDto.getTitle(), inDto.getUserId());
		} else if (inDto.getTechCategory() != null && inDto.getStatus() == null && inDto.getTitle() == null) {
			fetchedPost = blogPostRepo.findByTechCategoryAndUserId(inDto.getTechCategory(), inDto.getUserId());
		} else if (inDto.getStatus() != null && inDto.getTechCategory() == null && inDto.getTitle() == null) {
			fetchedPost = blogPostRepo.findByStatusAndUserId(inDto.getStatus(), inDto.getUserId());
		} else if (inDto.getStatus() != null && inDto.getTechCategory() != null && inDto.getTitle() == null) {
			fetchedPost = blogPostRepo.findByStatusAndTechCategoryAndUserId(inDto.getStatus(),
					inDto.getTechCategory(),
					inDto.getUserId());
		} else if (inDto.getStatus() == null && inDto.getTechCategory() != null && inDto.getTitle() != null) {
			fetchedPost = blogPostRepo.findByTechCategoryAndTitleContainingIgnoreCaseAndUserId(
					inDto.getTechCategory(),
					inDto.getTitle(), inDto.getUserId());
		} else if (inDto.getStatus() != null && inDto.getTechCategory() == null && inDto.getTitle() != null) {
			fetchedPost = blogPostRepo.findByStatusAndTitleContainingIgnoreCaseAndUserId(
					inDto.getStatus(), inDto.getTitle(),
					inDto.getUserId());
		} else if (inDto.getStatus() != null && inDto.getTechCategory() != null && inDto.getTitle() != null) {
			fetchedPost = blogPostRepo.findByStatusAndTechCategoryAndTitleContainingIgnoreCaseAndUserId(
					inDto.getStatus(),
					inDto.getTechCategory(), inDto.getTitle(), inDto.getUserId());
		}
		List<FilterMyBlogPostOutDto> outDtoList = new ArrayList<FilterMyBlogPostOutDto>();
		for (Post p : fetchedPost) {
			FilterMyBlogPostOutDto outDto = FilterMyBlogPostMapper.postToOutDto(p);
			outDtoList.add(outDto);
		}
		Collections.sort(outDtoList);
		return outDtoList;
	}

	/**
	 * This Method is for editing blog .
	 */
	@Override
	public ApiResponse editBlog(UpdatePostInDto inDto) {
		ApiResponse response = new ApiResponse();
		Post fetchPost = blogPostRepo.findById(inDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", inDto.getId()));
		fetchPost.setContent(inDto.getContent());
		fetchPost.setTitle(inDto.getTitle());
		fetchPost.setEditedAt(new Date());
		fetchPost.setStatus(PostStatus.PENDING);
		try {
			blogPostRepo.save(fetchPost);
			response.setSuccess(true);
			response.setMessage(ResponseMessage.BLOG_UPDATE_SUCCESS);
		} catch (Exception ex) {
			response.setMessage(ResponseMessage.BLOG_UPDATE_FAILED);
			response.setSuccess(false);
		}
		return response;
	}

	/**
	 * This method for getting post by id.
	 *
	 * @param postId
	 * @return GetP
	 */
	@Override
	public GetPostOutDto getPost(String postId) {
		Post post = blogPostRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
		GetPostOutDto outDto = GetPostMapper.entityToOutDto(post);
		return outDto;
	}

	/**
	 * This method for Fetching Collection of post which is not approved by admin.
	 *
	 * @return Collection of Post which status is in Pending.
	 */
	@Override
	public List<UnReviewedPostOutDto> getUnreviewedPosts(UnReviewedPostInDto inDto) {
		PostStatus status = PostStatus.PENDING;
		List<Post> fetchedListOfPost = new ArrayList<Post>();
		List<UnReviewedPostOutDto> responseDto = new ArrayList<UnReviewedPostOutDto>();
		if (inDto.getTitle() == null && inDto.getTechnologyCategory() == null) {
			fetchedListOfPost = blogPostRepo.findByStatus(status);
		} else if (inDto.getTechnologyCategory() != null && inDto.getTitle() == null) {
			fetchedListOfPost = blogPostRepo.findByTechCategoryAndStatus(inDto.getTechnologyCategory(), status);
		} else if (inDto.getTitle() != null && inDto.getTechnologyCategory() == null) {
			fetchedListOfPost = blogPostRepo.findByTitleContainingIgnoreCaseAndStatus(inDto.getTitle(), status);
		} else if (inDto.getTitle() != null && inDto.getTechnologyCategory() != null) {
			fetchedListOfPost = blogPostRepo.findByTitleContainingIgnoreCaseAndStatusAndTechCategory(
					inDto.getTitle(), status,
					inDto.getTechnologyCategory());
		}
		for (Post post : fetchedListOfPost) {
			responseDto.add(UnReviewedPostMapper.entityToOutDto(post));
		}
		return responseDto;
	}

	/**
	 * This method is for admin with response approve or reject on unreviewed post.
	 *
	 * @param inDto
	 * @return response
	 *
	 */
	@Override
	public ApiResponse responseUnreviewedPost(ApproveOrRejectPostInDto inDto) {
		// TODO Auto-generated method stub
		ApiResponse response = new ApiResponse();
		PostStatus status = inDto.getPostStatus();
		Post fetchedPost = blogPostRepo.findById(inDto.getPostId())
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", inDto.getPostId()));
		if (fetchedPost.getStatus() == PostStatus.PENDING) {
			if (status == PostStatus.APPROVED) {
				fetchedPost.setStatus(PostStatus.APPROVED);
				blogPostRepo.save(fetchedPost);
				response.setMessage(ResponseMessage.UNREVIEW_BLOG_APPROVED);
				response.setSuccess(true);
			} else if (status == PostStatus.REJECTED) {
				fetchedPost.setStatus(PostStatus.REJECTED);
				blogPostRepo.save(fetchedPost);
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
