package com.example.demo.services;

import com.example.demo.dto.PostInDto;
import com.example.demo.dto.PostOutDto;

/**
 * Interface PostService that represent the rule of Post that would follow by it's child.
 */
public interface PostService {

	/**
	 * method that create post blog.
	 * @param postBlogInDto takes PostBlogInDto as parameter.
	 * @param userId takes userId who Posted that blog.
	 * @return ApiResponse.
	 */
	PostOutDto createPost(PostInDto postBlogInDto, String userId);
}
