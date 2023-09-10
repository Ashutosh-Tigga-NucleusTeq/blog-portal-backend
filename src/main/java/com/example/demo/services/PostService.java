package com.example.demo.services;

import com.example.demo.dto.PostInDto;
/*import com.example.demo.dto.PostOutDto;*/
import com.example.demo.payloads.ApiResponse;

/**
 * Interface PostService that represent the rule of Post that would follow by it's child.
 * @author {Ashutosh Tigga]
 */
public interface PostService {

	/**
	 * method that create post blog.
	 * @param postBlogInDto takes PostBlogInDto as parameter.
	 * @return ApiResponse.
	 */
	ApiResponse createPost(PostInDto postBlogInDto);
}
