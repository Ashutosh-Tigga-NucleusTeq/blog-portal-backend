package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CommentPostInDtoTest {

    @Test
    public void testGettersAndSetters() {
        String content = "This is a test comment.";
        String userId = "user123";
        String postId = "post456";

        CommentPostInDto dto = new CommentPostInDto(content, userId, postId);

        assertEquals(content, dto.getContent());
        assertEquals(userId, dto.getUserId());
        assertEquals(postId, dto.getPostId());

        String newContent = "Updated comment content.";
        String newUserId = "user789";
        String newPostId = "post101";

        dto.setContent(newContent);
        dto.setUserId(newUserId);
        dto.setPostId(newPostId);

        assertEquals(newContent, dto.getContent());
        assertEquals(newUserId, dto.getUserId());
        assertEquals(newPostId, dto.getPostId());
    }

    @Test
    public void testEqualsAndHashCode() {
        String content1 = "This is a test comment.";
        String userId1 = "user123";
        String postId1 = "post456";
        CommentPostInDto dto1 = new CommentPostInDto(content1, userId1, postId1);

        String content2 = "This is a test comment.";
        String userId2 = "user123";
        String postId2 = "post456";
        CommentPostInDto dto2 = new CommentPostInDto(content2, userId2, postId2);

        assertTrue(dto1.equals(dto2));
        assertTrue(dto2.equals(dto1));

        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void testNotEquals() {
        String content1 = "This is a test comment.";
        String userId1 = "user123";
        String postId1 = "post456";
        CommentPostInDto dto1 = new CommentPostInDto(content1, userId1, postId1);

        String content2 = "Another comment.";
        String userId2 = "user789";
        String postId2 = "post101";
        CommentPostInDto dto2 = new CommentPostInDto(content2, userId2, postId2);

        assertFalse(dto1.equals(dto2));
        assertFalse(dto2.equals(dto1));

        assertNotEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void testToString() {
        String content = "This is a test comment.";
        String userId = "user123";
        String postId = "post456";
        CommentPostInDto dto = new CommentPostInDto(content, userId, postId);

        String expectedToString = "CommentPostInDto [content=This is a test comment., userId=user123, postId=post456]";
        assertEquals(expectedToString, dto.toString());
    }
}
