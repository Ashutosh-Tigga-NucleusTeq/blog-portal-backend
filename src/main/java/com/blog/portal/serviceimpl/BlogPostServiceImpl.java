package com.blog.portal.serviceimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.portal.controller.BlogUserController;
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
	 * An instance of the Logger class for logging.
	 */
	private Logger logger = LogManager.getLogger(BlogUserController.class);

	/**
	 * Method that deal with creation of post API in database.
	 */
	@Override
	public ApiResponse createPost(@Valid PostBlogInDto postBlogInDto) {

		ApiResponse reponse = null;
		User user = this.blogUserRepo.findById(postBlogInDto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException(null, null, null));
		user.setPassword(null);
		Post post = PostBlogMapper.inDtoToPost(postBlogInDto);
		post.setUser(user);
		post.setUserId(user.getId());
		try {
			this.blogPostRepo.save(post);
			reponse = new ApiResponse("Blog created With pending status and Waiting for Admin Approval", true);
		} catch (RuntimeException ex) {
			throw new RuntimeException();
		} catch (Exception e) {
			reponse = new ApiResponse("Blog post not created ", false);
		}
		return reponse;
	}

	/**
	 * Get All Posts by filtering by status = approved , title and techcategory.
	 *
	 * @param inDto
	 * @return List<ShowPostDto>
	 */
	public List<FilterDashboardOutDto> getAllPostFilter(@Valid FilterDashboardPostInDto inDto)
			throws IllegalArgumentException {
		PostStatus status = PostStatus.Approved; // set staus approved for fetching post which is approved by admin
		List<Post> fetchedPost = new ArrayList<Post>();
		List<FilterDashboardOutDto> outDtoList = new ArrayList<FilterDashboardOutDto>();
		if (inDto.getTitle() == null && inDto.getTechCategory() == null) {
			fetchedPost = blogPostRepo.findByStatus(status);
		} else if (inDto.getTechCategory() != null && inDto.getTitle() == null) {
			fetchedPost = blogPostRepo.findByTechCategoryAndStatus(inDto.getTechCategory(), status);
		} else if (inDto.getTitle() != "" && inDto.getTechCategory() == null) {
			fetchedPost = blogPostRepo.findByTitleContainingIgnoreCaseAndStatus(inDto.getTitle(), status);
		} else if ((inDto.getTitle() != "") && (inDto.getTechCategory() != null)) {
			fetchedPost = blogPostRepo.findByTitleContainingIgnoreCaseAndStatusAndTechCategory(
					inDto.getTitle(), status,
					inDto.getTechCategory());
		}
		for (Post p : fetchedPost) {
			System.out.println(" page " + p);
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
		logger.info("get User posts method called in service implement method with data " + "[" + inDto + "]");
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
		// TODO Auto-generated method stub
		ApiResponse response = new ApiResponse("Blog updation failed", false);
		Post fetchPost = this.blogPostRepo.findById(inDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException(null, null, null));
		fetchPost.setContent(inDto.getContent());
		fetchPost.setTitle(inDto.getTitle());
		fetchPost.setEditedAt(new Date());
		fetchPost.setStatus(PostStatus.Pending);
		try {
			this.blogPostRepo.save(fetchPost);
			response.setSuccess(true);
			response.setMessage("Blog updated ");
		} catch (Exception ex) {
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
		// TODO Auto-generated method stub
		System.out.println(postId);
		Post post = this.blogPostRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(postId, postId, postId));
		System.out.println(" after getting data " + post);
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
		// TODO Auto-generated method stub
		PostStatus status = PostStatus.Pending;
		String keyword = inDto.getKeyword();
		System.out.println(" keyword " + keyword);
		List<Post> fetchedResponse = new ArrayList<Post>();
		List<UnReviewedPostOutDto> responseDto = new ArrayList<UnReviewedPostOutDto>();
		if (keyword == null) {
			System.out.println(" keyword is " + inDto.getKeyword());
			fetchedResponse = blogPostRepo.findByStatus(PostStatus.Pending);
		} else {
			fetchedResponse = blogPostRepo.findByTitleContainingIgnoreCaseAndStatus(inDto.getKeyword(), status);
		}
		for (Post post : fetchedResponse) {
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
		if (fetchedPost.getStatus() == PostStatus.Pending) {
			if (status == PostStatus.Approved) {
				fetchedPost.setStatus(PostStatus.Approved);
				blogPostRepo.save(fetchedPost);
				response.setMessage(" Post Approved ");
				response.setSuccess(true);
			} else if (status == PostStatus.Rejected) {
				fetchedPost.setStatus(PostStatus.Rejected);
				blogPostRepo.save(fetchedPost);
				response.setMessage(" Post Rejected ");
				response.setSuccess(true);
			}
		} else {
			response.setMessage("Post status is already either approved or Rejected");
			response.setSuccess(false);
		}
		return response;
	}

}