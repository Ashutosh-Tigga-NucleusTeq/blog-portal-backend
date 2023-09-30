package com.blog.portal.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.portal.entities.Reaction;
import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.React;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ReactionPostMapper;
import com.blog.portal.repository.LikeOrDislikePostRepo;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.requestPayload.ReactionPostInDto;
import com.blog.portal.responsePayload.ReactionPostOutDto;
import com.blog.portal.services.ReactionPostService;

@Service
public class ReactionPostServiceImpl implements ReactionPostService {

	/**
	 * Contains Query of LikeAndDislike Entity.
	 */
	@Autowired
	private LikeOrDislikePostRepo likeAndDislikeRepo;

	/**
	 * Contains Query of Post Entity.
	 */
	@Autowired
	private BlogPostRepo blogPostRepo;
	/**
	 * This method for performing like or dislike functionality.
	 */
	@Override
	public ReactionPostOutDto doReactOnPost(ReactionPostInDto inDto) {
	    Reaction userReaction = likeAndDislikeRepo.findByUserIdAndPostId(
	            inDto.getUserId(), inDto.getPostId());

	    Post post = blogPostRepo.findById(inDto.getPostId())
	            .orElseThrow(() -> new ResourceNotFoundException("Post", "postId", inDto.getPostId()));

	    if (userReaction == null) {
		    Reaction reaction = new Reaction();
	        if (inDto.getType().equals(React.LIKE)) {
	            post.getLikedBy().add(inDto.getUserId());
	            reaction.setType(React.LIKE);
	        } else if (inDto.getType().equals(React.DISLIKE)) {
	            post.getDisLikedBy().add(inDto.getUserId());
	            reaction.setType(React.DISLIKE);
	        }
	        reaction.setPostId(inDto.getPostId());
	        reaction.setUserId(inDto.getUserId());
	        blogPostRepo.save(post);
	  	    Reaction savedResponse = likeAndDislikeRepo.save(reaction);
	  	    return ReactionPostMapper.entityToOutDto(savedResponse);
	    } else {
	        if (!userReaction.getType().equals(inDto.getType()) && inDto.getType().equals(React.LIKE)) {
	        	userReaction.setType(React.LIKE);
	        	post.getLikedBy().add(inDto.getUserId());
	        	post.getDisLikedBy().remove(inDto.getUserId());
	        } else if (userReaction.getType() != inDto.getType() && inDto.getType().equals(React.DISLIKE)) {
	        	userReaction.setType(React.DISLIKE);
	        	post.getDisLikedBy().add(inDto.getUserId());
	        	post.getLikedBy().remove(inDto.getUserId());
	        }
	    }
	    blogPostRepo.save(post);
	    Reaction savedResponse = likeAndDislikeRepo.save(userReaction);
	    ReactionPostOutDto outDto = ReactionPostMapper.entityToOutDto(savedResponse);
	    return outDto;
	}


}
