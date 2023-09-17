package com.blog.portal.requestPayload;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.React;

public class LikeOrDislikePostInDtoTest {
		/**
		 * Tesing of full Method.
		 */
    @Test
    public void testGetterSetterAndMethods() {
        LikeOrDislikePostInDto likeOrDislikePostInDto1 = new LikeOrDislikePostInDto();
        likeOrDislikePostInDto1.setPostId("123");
        likeOrDislikePostInDto1.setUserId("user123");
        likeOrDislikePostInDto1.setType(React.Like);

        LikeOrDislikePostInDto likeOrDislikePostInDto2 = new LikeOrDislikePostInDto();
        likeOrDislikePostInDto2.setPostId("123");
        likeOrDislikePostInDto2.setUserId("user123");
        likeOrDislikePostInDto2.setType(React.Like);

        // Test hashCode and equals
        assertEquals(likeOrDislikePostInDto1.hashCode(), likeOrDislikePostInDto2.hashCode());
        assertTrue(likeOrDislikePostInDto1.equals(likeOrDislikePostInDto2));


        // Test getters
        assertEquals("123", likeOrDislikePostInDto1.getPostId());
        assertEquals("user123", likeOrDislikePostInDto1.getUserId());
        assertEquals(React.Like, likeOrDislikePostInDto1.getType());

        // Test setters
        likeOrDislikePostInDto2.setPostId("456");
        likeOrDislikePostInDto2.setUserId("user456");
        likeOrDislikePostInDto2.setType(React.Dislike);

        assertEquals("456", likeOrDislikePostInDto2.getPostId());
        assertEquals("user456", likeOrDislikePostInDto2.getUserId());
        assertEquals(React.Dislike, likeOrDislikePostInDto2.getType());

        // Test toString
        String expectedToString = "LikeOrDislikePostInDto [postId=456, userId=user456, type=Dislike]";
        assertEquals(expectedToString, likeOrDislikePostInDto2.toString());


    }
}
