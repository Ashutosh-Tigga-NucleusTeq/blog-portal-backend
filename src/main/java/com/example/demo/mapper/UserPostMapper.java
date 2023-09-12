package com.example.demo.mapper;

import com.example.demo.dto.UserPostInDto;
import com.example.demo.dto.UserPostOutDto;
import com.example.demo.model.Post;

public class UserPostMapper {
	/**
	 *This methods convert {@code UserPostInDto} into {@code Post}.
	 * @param inDto
	 * @return post
	 */
	public static Post inDtoToPost(UserPostInDto inDto) {
		Post post = new Post();
		post.setTitle(inDto.getTitle());
		post.setTechCategory(inDto.getTechCategory());
		post.setUserId(inDto.getUserId());
		post.setStatus(inDto.getStatus());
		return post;
	}

	/**
	 * This method converts {@code post} into {@code UserPostOutDto}.
	 * @param post
	 * @return outDto
	 */
	public static UserPostOutDto postToOutDto(Post post) {
		UserPostOutDto outDto = new UserPostOutDto();
		outDto.setTitle(post.getTitle());
		outDto.setTechnology(post.getTechCategory());
		outDto.setStatus(post.getStatus());
		outDto.setCreatedAt(post.getCreatedAt());
		outDto.setEditedAt(post.getEditedAt());
		return outDto;
	}
}
