package com.blog.portal.requestPayload;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.blog.portal.enumResource.PostStatus;

public class ApproveOrRejectPostInDtoTest {

    @Test
    public void testGettersAndSetters() {
        String postId = "123";
        PostStatus postStatus = PostStatus.APPROVED;

        ApproveOrRejectPostInDto dto = new ApproveOrRejectPostInDto(postId, postStatus);

        assertEquals(postId, dto.getPostId());
        assertEquals(postStatus, dto.getPostStatus());

        String newPostId = "456";
        PostStatus newPostStatus = PostStatus.REJECTED;

        dto.setPostId(newPostId);
        dto.setPostStatus(newPostStatus);

        assertEquals(newPostId, dto.getPostId());
        assertEquals(newPostStatus, dto.getPostStatus());
    }

    @Test
    public void testEqualsAndHashCode() {
        String postId1 = "123";
        PostStatus postStatus1 = PostStatus.APPROVED;
        ApproveOrRejectPostInDto dto1 = new ApproveOrRejectPostInDto(postId1, postStatus1);

        String postId2 = "123";
        PostStatus postStatus2 = PostStatus.APPROVED;
        ApproveOrRejectPostInDto dto2 = new ApproveOrRejectPostInDto(postId2, postStatus2);

        assertTrue(dto1.equals(dto2));
        assertTrue(dto2.equals(dto1));

        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void testNotEquals() {
        String postId1 = "123";
        PostStatus postStatus1 = PostStatus.APPROVED;
        ApproveOrRejectPostInDto dto1 = new ApproveOrRejectPostInDto(postId1, postStatus1);

        String postId2 = "456";
        PostStatus postStatus2 = PostStatus.REJECTED;
        ApproveOrRejectPostInDto dto2 = new ApproveOrRejectPostInDto(postId2, postStatus2);

        assertFalse(dto1.equals(dto2));
        assertFalse(dto2.equals(dto1));

        assertNotEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void testToString() {
        String postId = "123";
        PostStatus postStatus = PostStatus.APPROVED;
        ApproveOrRejectPostInDto dto = new ApproveOrRejectPostInDto(postId, postStatus);

        String expectedToString = "ApproveOrRejectPostInDto [postId=123, postStatus=APPROVED]";
        assertEquals(expectedToString, dto.toString());
    }
}
