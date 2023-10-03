package com.blog.portal.serviceimpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.portal.entities.Reaction;
import com.blog.portal.entities.Blog;
import com.blog.portal.enumResource.React;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ReactOnBlogMapper;
import com.blog.portal.repository.ReactionRepository;
import com.blog.portal.repository.BlogRepository;
import com.blog.portal.requestPayload.ReactOnBlogInDto;
import com.blog.portal.responsePayload.ReactionOnBlogOutDto;
import com.blog.portal.services.ReactionService;
import com.blog.portal.util.BlogConst;


/**
 * Implementation of the ReactionService interface responsible for React on Blog related
 * operations.
 *
 * @author Ashutosh Tigga.
 */
@Service
public class ReactionServiceImpl implements ReactionService {

	/**
	 * Contains Query of LikeAndDislike Entity.
	 */
	@Autowired
	private ReactionRepository likeAndDislikeRepo;

	/**
	 * Contains Query of Blog Entity.
	 */
	@Autowired
	private BlogRepository blogRepository;
	/**
	 * This method for performing like or dislike functionality.
	 */
	@Override
	public ReactionOnBlogOutDto doReactOnBlog(final ReactOnBlogInDto inDto) {
	    Reaction userReaction = likeAndDislikeRepo.findByUserIdAndPostId(
	            inDto.getUserId(), inDto.getPostId());

	    Blog blog = blogRepository.findById(inDto.getPostId())
	            .orElseThrow(() -> new ResourceNotFoundException(BlogConst.CLASS_NAME,
	            		BlogConst.FIELD_POST_ID,
	            		inDto.getPostId()));

	    if (Objects.isNull(userReaction)) {
		    Reaction reaction = new Reaction();
	        if (inDto.getType().equals(React.LIKE)) {
	            blog.getLikedBy().add(inDto.getUserId());
	            reaction.setType(React.LIKE);
	        } else if (inDto.getType().equals(React.DISLIKE)) {
	            blog.getDisLikedBy().add(inDto.getUserId());
	            reaction.setType(React.DISLIKE);
	        }
	        reaction.setPostId(inDto.getPostId());
	        reaction.setUserId(inDto.getUserId());
	        blogRepository.save(blog);
	  	    Reaction savedResponse = likeAndDislikeRepo.save(reaction);
	  	    return ReactOnBlogMapper.entityToOutDto(savedResponse);
	    } else {
	        if (!userReaction.getType().equals(inDto.getType()) && inDto.getType().equals(React.LIKE)) {
	        	userReaction.setType(React.LIKE);
	        	blog.getLikedBy().add(inDto.getUserId());
	        	blog.getDisLikedBy().remove(inDto.getUserId());
	        } else if (userReaction.getType() != inDto.getType() && inDto.getType().equals(React.DISLIKE)) {
	        	userReaction.setType(React.DISLIKE);
	        	blog.getDisLikedBy().add(inDto.getUserId());
	        	blog.getLikedBy().remove(inDto.getUserId());
	        }
	    }
	    blogRepository.save(blog);
	    Reaction savedResponse = likeAndDislikeRepo.save(userReaction);
	    ReactionOnBlogOutDto outDto = ReactOnBlogMapper.entityToOutDto(savedResponse);
	    return outDto;
	}


}
