package com.blog.portal.responsePayload;

import org.junit.jupiter.api.Test;

import com.blog.portal.entities.User;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;
public class PostBlogOutDtoTest {

	/**
	 * Default constructor testing.
	 */
    @Test
    public void testDefaultConstructor() {
        PostBlogOutDto dto = new PostBlogOutDto();
        assertNull(dto.getId());
        assertNull(dto.getTitle());
        assertNull(dto.getContent());
				/* assertNull(dto.getCreatedAt()); */
        assertNull(dto.getTechCategory());
        assertNull(dto.getUser());
        assertNull(dto.getStatus());
    }
    /**
     * Testing paratererized testing.
     */
    @Test
    public void testParameterizedConstructor() {
        Date createdAt = new Date();
        User user = new User(); // You can create a User object as needed
        PostBlogOutDto dto = new PostBlogOutDto("1", "Title", "Content", PostStatus.PENDING,
                TechnologyCategory.CSS, createdAt, user);

        assertEquals("1", dto.getId());
        assertEquals("Title", dto.getTitle());
        assertEquals("Content", dto.getContent());
        assertEquals(createdAt, dto.getCreatedAt());
        assertEquals(TechnologyCategory.CSS, dto.getTechCategory());
        assertEquals(user, dto.getUser());
        assertEquals(PostStatus.PENDING, dto.getStatus());
    }

    /**
     * testing setter and getter.
     */
    @Test
    public void testSetterAndGetterMethods() {
        PostBlogOutDto dto = new PostBlogOutDto();
        Date createdAt = new Date();
        User user = new User(); // You can create a User object as needed

        dto.setId("2");
        dto.setTitle("New Title");
        dto.setContent("New Content");
        dto.setCreatedAt(createdAt);
        dto.setTechCategory(TechnologyCategory.BLOCKCHAIN);
        dto.setUser(user);
        dto.setStatus(PostStatus.APPROVED);

        assertEquals("2", dto.getId());
        assertEquals("New Title", dto.getTitle());
        assertEquals("New Content", dto.getContent());
        assertEquals(createdAt, dto.getCreatedAt());
        assertEquals(TechnologyCategory.BLOCKCHAIN, dto.getTechCategory());
        assertEquals(user, dto.getUser());
        assertEquals(PostStatus.APPROVED, dto.getStatus());
    }

    /**
     * testing hashcode and equals.
     */
    @Test
    public void testHashCodeAndEquals() {
        Date createdAt = new Date();
        User user = new User(); 

        PostBlogOutDto dto1 = new PostBlogOutDto("1", "Title", "Content", PostStatus.PENDING,
                TechnologyCategory.CSS, createdAt, user);
        PostBlogOutDto dto2 = new PostBlogOutDto("1", "Title", "Content", PostStatus.PENDING,
                TechnologyCategory.CSS, createdAt, user);
        PostBlogOutDto dto3 = new PostBlogOutDto("2", "Different Title", "Different Content",
                PostStatus.APPROVED, TechnologyCategory.BLOCKCHAIN, new Date(), new User());

        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
    }

    /**
     * testing toString.
     */
    @Test
    public void testToString() {
        Date createdAt = new Date();
        User user = new User(); 

        PostBlogOutDto dto = new PostBlogOutDto("1", "Title", "Content", PostStatus.PENDING,
                TechnologyCategory.CSS, createdAt, user);
        String expectedString = "PostOutDto [id=1, title=Title, content=Content, createdAt="
                + createdAt + ", techCategory=CSS, author=" + user + ", status=PENDING]";
        assertEquals(expectedString, dto.toString());
    }
}
