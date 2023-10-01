package com.blog.portal.responsePayload;

import com.blog.portal.entities.User;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FilterDashboardOutDtoTest {


    private FilterDashboardOutDto post1;
  	
    private FilterDashboardOutDto post2;
  	
    private FilterDashboardOutDto post3;

  	final	int year = 2023;
  	final	int month = 9;
  	final	int day = 1;
   
		@BeforeEach
    public void setUp() {

        post1 = new FilterDashboardOutDto("1", "Title 1", "Content 1", PostStatus.PENDING,
                TechnologyCategory.CSS, new Date(year, month, day), new User("user1", null));

        post2 = new FilterDashboardOutDto("2", "Title 2", "Content 2", PostStatus.APPROVED,
                TechnologyCategory.DATA_SCIENCE, new Date(year, month, day + 1), new User("user2", null));

        post3 = new FilterDashboardOutDto("3", "Title 3", "Content 3", PostStatus.PENDING,
                TechnologyCategory.DATA_SCIENCE, new Date(year, month, day ), new User("user3", null));
    }


    @Test
    public void testGettersAndSetters() {
        assertEquals("1", post1.getId());
        assertEquals("Title 1", post1.getTitle());
        assertEquals("Content 1", post1.getContent());
        assertEquals(PostStatus.PENDING, post1.getStatus());
        assertEquals(TechnologyCategory.CSS, post1.getTechnology());
				/* assertEquals("user1", post1.getUser().getFirstName()); */

        post1.setId("newId");
        post1.setTitle("New Title");
        post1.setContent("New Content");
        post1.setStatus(PostStatus.APPROVED);
        post1.setTechnology(TechnologyCategory.DATA_SCIENCE);
        post1.setUser(new User("newUser", null));

        assertEquals("newId", post1.getId());
        assertEquals("New Title", post1.getTitle());
        assertEquals("New Content", post1.getContent());
        assertEquals(PostStatus.APPROVED, post1.getStatus());
        assertEquals(TechnologyCategory.DATA_SCIENCE, post1.getTechnology());
    }


    @Test
    public void testEqualsAndHashCode() {
        FilterDashboardOutDto post1Copy = new FilterDashboardOutDto("1", "Title 1", "Content 1",
                PostStatus.PENDING, TechnologyCategory.CSS, new Date(year, month, day), new User("user1", null));

        assertEquals(post1, post1Copy);
        assertEquals(post1.hashCode(), post1Copy.hashCode());

        assertNotEquals(post1, post2);
        assertNotEquals(post1.hashCode(), post2.hashCode());

        assertNotEquals(post1, post3);
        assertNotEquals(post1.hashCode(), post3.hashCode());

        post3.setStatus(PostStatus.APPROVED);
        assertNotEquals(post1, post3);
        assertNotEquals(post1.hashCode(), post3.hashCode());
    }


    @Test
    public void testCompareTo() {

    }


    @Test
    public void testToString() {
        String expected = "FilterDashboardOutDto [id=1, title=Title 1, content=Content 1, "
        		+ "createdAt=" + post1.getCreatedAt() + ", technology=CSS, "
        		+ "user=" + post1.getUser() + ", status=PENDING, commentBy=null,"
        				+ " likedBy=[], disLikedBy=[]]";
        assertEquals(expected, post1.toString());
    }
}
