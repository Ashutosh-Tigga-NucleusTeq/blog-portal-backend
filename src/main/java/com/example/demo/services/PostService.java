package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.PostInDto;
import com.example.demo.dto.ShowPostInDto;
import com.example.demo.dto.ShowPostOutDto;
import com.example.demo.dto.UserPostInDto;
import com.example.demo.dto.UserPostOutDto;
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

	/**
	 * Method that fetches post.
	 * @param indto
	 * @return List<ShowPostOutDto>
	 */
	List<ShowPostOutDto> getAllPost(ShowPostInDto indto);

	/**
	 * Method that returns user's Post.
	 *@param inDto
	 *@return List<UserPostOutDto>
	 */
	List<UserPostOutDto> getUserPosts(UserPostInDto inDto);


}
