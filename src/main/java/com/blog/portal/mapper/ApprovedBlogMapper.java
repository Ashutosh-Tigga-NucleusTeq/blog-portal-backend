package com.blog.portal.mapper;
import com.blog.portal.entities.Blog;
import com.blog.portal.requestPayload.ApprovedBlogsInDto;
import com.blog.portal.responsePayload.ApprovedBlogsOutDto;

/**
 * The ApprovedBlogMapper class provides static methods for mapping
 * between Approved BLOG related DTOs and the BLOG entity.
 * @author Ashutosh Tigga
 */
public class ApprovedBlogMapper {

	/**
	 * This method convert  ShowPostInDto into  Blog.
	 * @param inDto
	 * @return instance of BLOG.
	 */
  public static Blog inDtoToPost(final ApprovedBlogsInDto inDto) {
  	Blog blog = new Blog();
  	blog.setTitle(inDto.getTitle());
  	blog.setTechCategory(inDto.getTechCategory());
  	return blog;
  }

  /**
   * This method Converts  Blog into  ShowPostOutDto.
   * @param blog
   * @return List<ShowPostOutDto>
   */
  public static ApprovedBlogsOutDto postToOutDto(final Blog blog) {
  	ApprovedBlogsOutDto res = new ApprovedBlogsOutDto();
  	res.setId(blog.getId());
  	res.setUser(blog.getUser());
  	res.setStatus(blog.getStatus());
  	res.setContent(blog.getContent());
  	res.setTechnology(blog.getTechCategory());
  	res.setTitle(blog.getTitle());
  	res.setCreatedAt(blog.getCreatedAt());
  	res.setLikedBy(blog.getLikedBy());
  	res.setDisLikedBy(blog.getDisLikedBy());
  	res.setCommentBy(blog.getCommentBy());
  	res.setReportedBy(blog.getReportedBy());
  	return res;
  }
}
