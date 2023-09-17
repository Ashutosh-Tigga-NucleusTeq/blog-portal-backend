package com.blog.portal.mapper;

import com.blog.portal.entities.Post;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.responsePayload.PostBlogOutDto;

/**
 * The {@code PostMapper} class provides static methods for mapping
 * between DTOs and the Post entity.
 *
 * @author Your Name
 */
public class PostBlogMapper {

    /**
     * Converts a {@link PostBlogInDto} to a {@link Post}.
     *
     * @param inDto The input DTO containing post data.
     * @return A {@link Post} object with the data from the input DTO.
     */
    public static Post inDtoToPost(PostBlogInDto inDto) {
    	Post post = new Post();
    	post.setTitle(inDto.getTitle());
    	post.setContent(inDto.getContent());
    	post.setCreatedAt(inDto.getCreatedAt());
    	post.setTechCategory(inDto.getTechCategory());
      return post;
    }

    /**
     * Converts a {@link Post} to a {@link PostBlogOutDto}.
     *
     * @param post The post entity object to be converted.
     * @return A {@link PostBlogOutDto} containing post information.
     */
    public static PostBlogOutDto postToOutDto(Post post) {
        return new PostBlogOutDto(
        				post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getStatus(),
                post.getTechCategory(),
                post.getCreatedAt(),
                post.getUser()
        );
    }
}
