package com.blog.portal.responsePayload;

import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.responsePayload.UserBlogsOutDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserBlogsOutDtoTest {

    @Test
    public void testGetterAndSetterMethods() {
        String id = "1";
        String title = "Sample Blog";
        BlogStatus status = BlogStatus.APPROVED;
        String content = "This is a sample post content.";
        TechnologyCategory technology = TechnologyCategory.PYTHON;
        Date createdAt = new Date();
        Date editedAt = new Date();
        List<String> commentBy = Arrays.asList("User1", "User2");
        HashSet<String> likedBy = new HashSet<>(Arrays.asList("User3", "User4"));
        HashSet<String> disLikedBy = new HashSet<>(Arrays.asList("User5", "User6"));
        HashSet<String> reportedBy = new HashSet<>(Arrays.asList("User7", "User8"));

        UserBlogsOutDto postDto = new UserBlogsOutDto(id, title, status, content, technology, createdAt, editedAt, likedBy, disLikedBy, commentBy, reportedBy);

        assertEquals(id, postDto.getId());
        assertEquals(title, postDto.getTitle());
        assertEquals(status, postDto.getStatus());
        assertEquals(content, postDto.getContent());
        assertEquals(technology, postDto.getTechnology());
        assertEquals(createdAt, postDto.getCreatedAt());
        assertEquals(editedAt, postDto.getEditedAt());
        assertEquals(likedBy, postDto.getLikedBy());
        assertEquals(disLikedBy, postDto.getDisLikedBy());
        assertEquals(commentBy, postDto.getCommentBy());
        assertEquals(reportedBy, postDto.getReportedBy());

        String newId = "2";
        postDto.setId(newId);
        assertEquals(newId, postDto.getId());

        String newTitle = "Updated Blog";
        postDto.setTitle(newTitle);
        assertEquals(newTitle, postDto.getTitle());

        BlogStatus newStatus = BlogStatus.PENDING;
        postDto.setStatus(newStatus);
        assertEquals(newStatus, postDto.getStatus());

        String newContent = "Updated content.";
        postDto.setContent(newContent);
        assertEquals(newContent, postDto.getContent());

        TechnologyCategory newTech = TechnologyCategory.JAVA;
        postDto.setTechnology(newTech);
        assertEquals(newTech, postDto.getTechnology());

        Date newCreatedAt = new Date();
        postDto.setCreatedAt(newCreatedAt);
        assertEquals(newCreatedAt, postDto.getCreatedAt());

        Date newEditedAt = new Date();
        postDto.setEditedAt(newEditedAt);
        assertEquals(newEditedAt, postDto.getEditedAt());

        List<String> newCommentBy = Arrays.asList("User9", "User10");
        postDto.setCommentBy(newCommentBy);
        assertEquals(newCommentBy, postDto.getCommentBy());

        HashSet<String> newLikedBy = new HashSet<>(Arrays.asList("User11", "User12"));
        postDto.setLikedBy(newLikedBy);
        assertEquals(newLikedBy, postDto.getLikedBy());

        HashSet<String> newDisLikedBy = new HashSet<>(Arrays.asList("User13", "User14"));
        postDto.setDisLikedBy(newDisLikedBy);
        assertEquals(newDisLikedBy, postDto.getDisLikedBy());

        HashSet<String> newReportedBy = new HashSet<>(Arrays.asList("User15", "User16"));
        postDto.setReportedBy(newReportedBy);
        assertEquals(newReportedBy, postDto.getReportedBy());
    }

    @Test
    public void testEqualsAndHashCodeMethods() {
        UserBlogsOutDto postDto1 = new UserBlogsOutDto("1", "Sample Blog", BlogStatus.APPROVED,
                "This is a sample post content.", TechnologyCategory.PYTHON,
                new Date(), new Date(), new HashSet<>(Arrays.asList("User1", "User2")),
                new HashSet<>(Arrays.asList("User3", "User4")), Arrays.asList("User5", "User6"),
                new HashSet<>(Arrays.asList("User7", "User8")));

        UserBlogsOutDto postDto2 = new UserBlogsOutDto("1", "Sample Blog", BlogStatus.APPROVED,
                "This is a sample post content.", TechnologyCategory.PYTHON,
                new Date(), new Date(), new HashSet<>(Arrays.asList("User1", "User2")),
                new HashSet<>(Arrays.asList("User3", "User4")), Arrays.asList("User5", "User6"),
                new HashSet<>(Arrays.asList("User7", "User8")));

        assertEquals(postDto1, postDto1);

        assertEquals(postDto1.hashCode(), postDto1.hashCode());

        postDto2.setId("2");
        assertNotEquals(postDto1, postDto2);
        assertNotEquals(postDto1.hashCode(), postDto2.hashCode());
    }

    @Test
    public void testToStringMethod() {
        UserBlogsOutDto postDto = new UserBlogsOutDto("1", "Sample Blog", BlogStatus.APPROVED,
                "This is a sample post content.", TechnologyCategory.PYTHON,
                new Date(), new Date(), new HashSet<>(Arrays.asList("User1", "User2")),
                new HashSet<>(Arrays.asList("User3", "User4")), Arrays.asList("User5", "User6"),
                new HashSet<>(Arrays.asList("User7", "User8")));

        String expectedToString = "UserBlogsOutDto [id=1, title=Sample Blog, status=APPROVED, content=This is a sample post content., technology=PYTHON, createdAt="
                + postDto.getCreatedAt() + ", editedAt=" + postDto.getEditedAt() + ", likedBy=" + postDto.getLikedBy()
                + ", disLikedBy=" + postDto.getDisLikedBy() + ", comments=" + postDto.getCommentBy() + "]";
        assertEquals(expectedToString, postDto.toString());
    }
}
