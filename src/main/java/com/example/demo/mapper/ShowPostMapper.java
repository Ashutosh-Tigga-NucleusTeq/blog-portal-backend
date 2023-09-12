package com.example.demo.mapper;
import com.example.demo.dto.ShowPostInDto;
import com.example.demo.dto.ShowPostOutDto;
import com.example.demo.model.Post;

public class ShowPostMapper {

	/**
	 * This method convert {@code ShowPostInDto} into {@code Post}.
	 * @param inDto
	 * @return instance of Post.
	 */
  public static Post inDtoToPost(ShowPostInDto inDto) {
  	Post post = new Post();
  	post.setTitle(inDto.getTitle());
  	post.setTechCategory(inDto.getTechCategory());
  	return post;
  }

  /**
   * This method Converts {@code Post} into {@code ShowPostOutDto}.
   * @param post
   * @return List<ShowPostOutDto>
   */
  public static ShowPostOutDto postToOutDto(Post post) {
  	ShowPostOutDto res = new ShowPostOutDto();
  	res.setUser(post.getUser());
  	res.setStatus(post.getStatus());
  	res.setContent(post.getContent());
  	res.setTechCategory(post.getTechCategory());
  	res.setTitle(post.getTitle());
  	res.setCreatedAt(post.getCreatedAt());
  	return res;
  }
}
