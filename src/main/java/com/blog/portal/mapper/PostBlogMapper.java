package com.blog.portal.mapper;

import com.blog.portal.entities.Blog;
import com.blog.portal.requestPayload.PostBlogInDto;

/**
 * The {@code PostMapper} class provides static methods for mapping
 * between DTOs and the Blog entity.
 *
 * @author Ashutosh Tigga
 */
public class PostBlogMapper {

    /**
     * Converts a {@link PostBlogInDto} to a {@link Blog}.
     *
     * @param inDto The input DTO containing post data.
     * @return A {@link Blog} object with the data from the input DTO.
     */
    public static Blog inDtoToPost(final PostBlogInDto inDto) {
    	Blog blog = new Blog();
    	blog.setTitle(inDto.getTitle());
    	blog.setContent(inDto.getContent());
    	blog.setCreatedAt(inDto.getCreatedAt());
    	blog.setTechCategory(inDto.getTechCategory());
      return blog;
    }

}
