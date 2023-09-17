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

	/**
	 * Instance of FilterDashboardOutDto.
	 */
    private FilterDashboardOutDto post1;
  	/**
  	 * Instance of FilterDashboardOutDto.
  	 */
    private FilterDashboardOutDto post2;
  	/**
  	 * Instance of FilterDashboardOutDto.
  	 */
    private FilterDashboardOutDto post3;

  	final	int year = 2023;
  	final	int month = 9;
  	final	int day = 1;
    /**
     * Setting up before testing.
     */
		@BeforeEach
    public void setUp() {

        post1 = new FilterDashboardOutDto("1", "Title 1", "Content 1", PostStatus.Pending,
                TechnologyCategory.CSS, new Date(year, month, day), new User("user1", null));

        post2 = new FilterDashboardOutDto("2", "Title 2", "Content 2", PostStatus.Approved,
                TechnologyCategory.DataScience, new Date(year, month, day + 1), new User("user2", null));

        post3 = new FilterDashboardOutDto("3", "Title 3", "Content 3", PostStatus.Pending,
                TechnologyCategory.DataScience, new Date(year, month, day ), new User("user3", null));
    }

    /**
     * Testing setter and getter.
     */
    @Test
    public void testGettersAndSetters() {
        assertEquals("1", post1.getId());
        assertEquals("Title 1", post1.getTitle());
        assertEquals("Content 1", post1.getContent());
        assertEquals(PostStatus.Pending, post1.getStatus());
        assertEquals(TechnologyCategory.CSS, post1.getTechCategory());
				/* assertEquals("user1", post1.getUser().getFirstName()); */

        post1.setId("newId");
        post1.setTitle("New Title");
        post1.setContent("New Content");
        post1.setStatus(PostStatus.Approved);
        post1.setTechCategory(TechnologyCategory.DataScience);
        post1.setUser(new User("newUser", null));

        assertEquals("newId", post1.getId());
        assertEquals("New Title", post1.getTitle());
        assertEquals("New Content", post1.getContent());
        assertEquals(PostStatus.Approved, post1.getStatus());
        assertEquals(TechnologyCategory.DataScience, post1.getTechCategory());
				/* assertEquals("newUser", post1.getUser().getFirstName()); */
    }

    /**
     * testing hashcode and equals.
     */
    @Test
    public void testEqualsAndHashCode() {
        // Test equal objects
        FilterDashboardOutDto post1Copy = new FilterDashboardOutDto("1", "Title 1", "Content 1",
                PostStatus.Pending, TechnologyCategory.CSS, new Date(year, month, day), new User("user1", null));

        assertEquals(post1, post1Copy);
        assertEquals(post1.hashCode(), post1Copy.hashCode());

        // Test objects with different IDs
        assertNotEquals(post1, post2);
        assertNotEquals(post1.hashCode(), post2.hashCode());

        // Test objects with different titles
        assertNotEquals(post1, post3);
        assertNotEquals(post1.hashCode(), post3.hashCode());

        // Test objects with different statuses
        post3.setStatus(PostStatus.Approved);
        assertNotEquals(post1, post3);
        assertNotEquals(post1.hashCode(), post3.hashCode());
    }

    /**
     * Testing compareTo.
     */
    @Test
    public void testCompareTo() {
        // post1 and post3 have the same creation date, so they should be compared by ID
        assertEquals(1, post2.compareTo(post1));

        // post1 and post2 have different creation dates
        assertNotEquals(0, post1.compareTo(post2));
        // Since post1 is created earlier, it should come before post2
        assertEquals(-1, post1.compareTo(post2));
        // The opposite for post2 and post1
        assertEquals(1, post2.compareTo(post1));
    }

    /**
     * Testing toString.
     */
    @Test
    public void testToString() {
        String expected = "FilterDashboardOutDto [id=1, title=Title 1, content=Content 1, "
        		+ "createdAt=" + post1.getCreatedAt() + ", techCategory=CSS, "
        		+ "user=" + post1.getUser() + ", status=Pending, comments=null,"
        				+ " likedBy=[], disLikedBy=[]]";
        assertEquals(expected, post1.toString());
    }
}
