package com.blog.portal.requestPayload;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.blog.portal.enumResource.BlogStatus;

public class ActOnUnReviewedBlogInDtoTest {

    @Test
    public void testGettersAndSetters() {
        String postId = "123";
        BlogStatus blogStatus = BlogStatus.APPROVED;

        ActOnUnReviewedBlogInDto dto = new ActOnUnReviewedBlogInDto(postId, blogStatus);

        assertEquals(postId, dto.getPostId());
        assertEquals(blogStatus, dto.getPostStatus());

        String newPostId = "456";
        BlogStatus newPostStatus = BlogStatus.REJECTED;

        dto.setPostId(newPostId);
        dto.setPostStatus(newPostStatus);

        assertEquals(newPostId, dto.getPostId());
        assertEquals(newPostStatus, dto.getPostStatus());
    }

    @Test
    public void testEqualsAndHashCode() {
        String postId1 = "123";
        BlogStatus postStatus1 = BlogStatus.APPROVED;
        ActOnUnReviewedBlogInDto dto1 = new ActOnUnReviewedBlogInDto(postId1, postStatus1);

        String postId2 = "123";
        BlogStatus postStatus2 = BlogStatus.APPROVED;
        ActOnUnReviewedBlogInDto dto2 = new ActOnUnReviewedBlogInDto(postId2, postStatus2);

        assertTrue(dto1.equals(dto2));
        assertTrue(dto2.equals(dto1));

        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void testNotEquals() {
        String postId1 = "123";
        BlogStatus postStatus1 = BlogStatus.APPROVED;
        ActOnUnReviewedBlogInDto dto1 = new ActOnUnReviewedBlogInDto(postId1, postStatus1);

        String postId2 = "456";
        BlogStatus postStatus2 = BlogStatus.REJECTED;
        ActOnUnReviewedBlogInDto dto2 = new ActOnUnReviewedBlogInDto(postId2, postStatus2);

        assertFalse(dto1.equals(dto2));
        assertFalse(dto2.equals(dto1));

        assertNotEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void testToString() {
        String postId = "123";
        BlogStatus blogStatus = BlogStatus.APPROVED;
        ActOnUnReviewedBlogInDto dto = new ActOnUnReviewedBlogInDto(postId, blogStatus);

        String expectedToString = "ActOnUnReviewedBlogInDto [postId=123, blogStatus=APPROVED]";
        assertEquals(expectedToString, dto.toString());
    }
}
