package com.blog.portal.mapper;
import com.blog.portal.entities.Post;
import com.blog.portal.requestPayload.FilterDashboardPostInDto;
import com.blog.portal.responsePayload.FilterDashboardOutDto;

public class FilterDashboardPostMapper {

	/**
	 * This method convert {@code ShowPostInDto} into {@code Post}.
	 * @param inDto
	 * @return instance of Post.
	 */
  public static Post inDtoToPost(FilterDashboardPostInDto inDto) {
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
  public static FilterDashboardOutDto postToOutDto(Post post) {
  	FilterDashboardOutDto res = new FilterDashboardOutDto();
  	res.setId(post.getId());
  	res.setUser(post.getUser());
  	res.setStatus(post.getStatus());
  	res.setContent(post.getContent());
  	res.setTechCategory(post.getTechCategory());
  	res.setTitle(post.getTitle());
  	res.setCreatedAt(post.getCreatedAt());
  	res.setLikedBy(post.getLikedBy());
  	res.setDisLikedBy(post.getDislikedBy());
  	res.setComments(post.getComments());
  	res.setReportedBy(post.getReportedBy());
  	return res;
  }
}
