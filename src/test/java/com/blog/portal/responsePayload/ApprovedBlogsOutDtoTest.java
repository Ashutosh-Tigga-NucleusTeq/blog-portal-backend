package com.blog.portal.responsePayload;

import com.blog.portal.entities.User;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ApprovedBlogsOutDtoTest {


    private ApprovedBlogsOutDto post1;
  	
    private ApprovedBlogsOutDto post2;
  	
    private ApprovedBlogsOutDto post3;

  	final	int year = 2023;
  	final	int month = 9;
  	final	int day = 1;
   
		@BeforeEach
    public void setUp() {

        post1 = new ApprovedBlogsOutDto("1", "Title 1", "Content 1", BlogStatus.PENDING,
                TechnologyCategory.CSS, new Date(year, month, day), new User("user1", null));

        post2 = new ApprovedBlogsOutDto("2", "Title 2", "Content 2", BlogStatus.APPROVED,
                TechnologyCategory.DATA_SCIENCE, new Date(year, month, day + 1), new User("user2", null));

        post3 = new ApprovedBlogsOutDto("3", "Title 3", "Content 3", BlogStatus.PENDING,
                TechnologyCategory.DATA_SCIENCE, new Date(year, month, day ), new User("user3", null));
    }


    @Test
    public void testGettersAndSetters() {
        assertEquals("1", post1.getId());
        assertEquals("Title 1", post1.getTitle());
        assertEquals("Content 1", post1.getContent());
        assertEquals(BlogStatus.PENDING, post1.getStatus());
        assertEquals(TechnologyCategory.CSS, post1.getTechnology());

        post1.setId("newId");
        post1.setTitle("New Title");
        post1.setContent("New Content");
        post1.setStatus(BlogStatus.APPROVED);
        post1.setTechnology(TechnologyCategory.DATA_SCIENCE);
        post1.setUser(new User("newUser", null));

        assertEquals("newId", post1.getId());
        assertEquals("New Title", post1.getTitle());
        assertEquals("New Content", post1.getContent());
        assertEquals(BlogStatus.APPROVED, post1.getStatus());
        assertEquals(TechnologyCategory.DATA_SCIENCE, post1.getTechnology());
    }


    @Test
    public void testEqualsAndHashCode() {
        ApprovedBlogsOutDto post1Copy = new ApprovedBlogsOutDto("1", "Title 1", "Content 1",
                BlogStatus.PENDING, TechnologyCategory.CSS, new Date(year, month, day), new User("user1", null));

        assertEquals(post1, post1Copy);
        assertEquals(post1.hashCode(), post1Copy.hashCode());

        assertNotEquals(post1, post2);
        assertNotEquals(post1.hashCode(), post2.hashCode());

        assertNotEquals(post1, post3);
        assertNotEquals(post1.hashCode(), post3.hashCode());

        post3.setStatus(BlogStatus.APPROVED);
        assertNotEquals(post1, post3);
        assertNotEquals(post1.hashCode(), post3.hashCode());
    }


    @Test
    public void testCompareTo() {

    }


    @Test
    public void testToString() {
        String expected = "ApprovedBlogsOutDto [id=1, title=Title 1, content=Content 1, "
        		+ "createdAt=" + post1.getCreatedAt() + ", technology=CSS, "
        		+ "user=" + post1.getUser() + ", status=PENDING, commentBy=null,"
        				+ " likedBy=[], disLikedBy=[]]";
        assertEquals(expected, post1.toString());
    }
}
