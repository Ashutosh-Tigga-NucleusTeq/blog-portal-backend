package com.blog.portal.requestPayload;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.React;

public class ReactOnBlogInDtoTest {
		
    @Test
    public void testGetterSetterAndMethods() {
        ReactOnBlogInDto likeOrDislikePostInDto1 = new ReactOnBlogInDto();
        likeOrDislikePostInDto1.setPostId("123");
        likeOrDislikePostInDto1.setUserId("user123");
        likeOrDislikePostInDto1.setType(React.LIKE);

        ReactOnBlogInDto likeOrDislikePostInDto2 = new ReactOnBlogInDto();
        likeOrDislikePostInDto2.setPostId("123");
        likeOrDislikePostInDto2.setUserId("user123");
        likeOrDislikePostInDto2.setType(React.LIKE);

        assertEquals(likeOrDislikePostInDto1.hashCode(), likeOrDislikePostInDto2.hashCode());
        assertTrue(likeOrDislikePostInDto1.equals(likeOrDislikePostInDto2));


        assertEquals("123", likeOrDislikePostInDto1.getPostId());
        assertEquals("user123", likeOrDislikePostInDto1.getUserId());
        assertEquals(React.LIKE, likeOrDislikePostInDto1.getType());

        likeOrDislikePostInDto2.setPostId("456");
        likeOrDislikePostInDto2.setUserId("user456");
        likeOrDislikePostInDto2.setType(React.DISLIKE);

        assertEquals("456", likeOrDislikePostInDto2.getPostId());
        assertEquals("user456", likeOrDislikePostInDto2.getUserId());
        assertEquals(React.DISLIKE, likeOrDislikePostInDto2.getType());

        String expectedToString = "LikeOrDislikePostInDto [postId=456, userId=user456, type=DISLIKE]";
        assertEquals(expectedToString, likeOrDislikePostInDto2.toString());


    }
}
