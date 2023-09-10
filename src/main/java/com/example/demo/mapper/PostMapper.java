package com.example.demo.mapper;

import com.example.demo.dto.PostInDto;
import com.example.demo.dto.PostOutDto;
import com.example.demo.model.Post;

/**
 * The {@code PostMapper} class provides static methods for mapping
 * between DTOs and the Post entity.
 *
 * @author Your Name
 */
public class PostMapper {

    /**
     * Converts a {@link PostInDto} to a {@link Post}.
     *
     * @param inDto The input DTO containing post data.
     * @return A {@link Post} object with the data from the input DTO.
     */
    public static Post inDtoToPost(PostInDto inDto) {
        return new Post(
                inDto.getTitle(),
                inDto.getContent(),
                inDto.getCreatedAt(),
                inDto.getTechCategory(),
                inDto.getAuthorId()

        );
    }

    /**
     * Converts a {@link Post} to a {@link PostOutDto}.
     *
     * @param post The post entity object to be converted.
     * @return A {@link PostOutDto} containing post information.
     */
    public static PostOutDto postToOutDto(Post post) {
        return new PostOutDto(
        				post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getStatus(),
                post.getTechCategory(),
                post.getCreatedAt(),
                post.getAuthorId()
        );
    }
}
