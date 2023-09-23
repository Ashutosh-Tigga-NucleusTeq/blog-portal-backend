package com.blog.portal.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.portal.entities.LikeOrDislike;
import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.React;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.LikeOrDislikePostMapper;
import com.blog.portal.repository.ReactionRepo;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.requestPayload.ReactionInDto;
import com.blog.portal.responsePayload.ReactionOutDto;
import com.blog.portal.services.ReactionService;

@Service
public class ReactionServiceImpl implements ReactionService {

	/**
	 * Contains Query of LikeAndDislike Entity.
	 */
	@Autowired
	private ReactionRepo likeAndDislikeRepo;

	/**
	 * Contains Query of Post Entity.
	 */
	@Autowired
	private BlogPostRepo blogPostRepo;
	/**
	 * This method for performing like or dislike functionality.
	 */
	@Override
	public ReactionOutDto doReactOnPost(ReactionInDto inDto) {
	    LikeOrDislike userReaction = likeAndDislikeRepo.findByUserIdAndPostId(
	            inDto.getUserId(), inDto.getPostId());

	    Post post = blogPostRepo.findById(inDto.getPostId())
	            .orElseThrow(() -> new ResourceNotFoundException("Post", "postId", inDto.getPostId()));

	    if (userReaction == null) {
		    LikeOrDislike reaction = new LikeOrDislike();
	        if (inDto.getType() == React.Like) {
	            post.getLikedBy().add(inDto.getUserId());
	            reaction.setType(React.Like);
	        } else if (inDto.getType() == React.Dislike) {
	            post.getDislikedBy().add(inDto.getUserId());
	            reaction.setType(React.Dislike);
	        }
	        reaction.setPostId(inDto.getPostId());
	        reaction.setUserId(inDto.getUserId());
	  	    LikeOrDislike savedResponse = likeAndDislikeRepo.save(reaction);
	  	    return LikeOrDislikePostMapper.entityToOutDto(savedResponse);
	    } else {
	        if (userReaction.getType() != inDto.getType() && inDto.getType() == React.Like) {
	        	userReaction.setType(React.Like);
	        	post.getLikedBy().remove(inDto.getUserId());
	        	post.getDislikedBy().add(inDto.getUserId());
	        } else if (userReaction.getType() != inDto.getType() && inDto.getType() == React.Dislike) {
	        	userReaction.setType(React.Dislike);
	        	post.getDislikedBy().remove(inDto.getUserId());
	        	post.getLikedBy().add(inDto.getUserId());
	        } else {
	        	userReaction.setType(React.RemoveReaction);
	        }
	    }
	    blogPostRepo.save(post);
	    LikeOrDislike savedResponse = likeAndDislikeRepo.save(userReaction);
	    ReactionOutDto outDto = LikeOrDislikePostMapper.entityToOutDto(savedResponse);
	    return outDto;
	}


}
