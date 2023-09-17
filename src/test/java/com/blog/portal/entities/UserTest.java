package com.blog.portal.entities;

import org.junit.Before;
import org.junit.Test;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.Role;
import com.blog.portal.enumResource.TechnologyCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

	/**
	 * Instance of User.
	 */
    private User user;

    /**
     * Setting up before testing.
     */
    @Before
    public void setUp() {
        user = new User();
    }

    /**
     * Setter and Getter testing.
     */
    @Test
    public void testSettersAndGetters() {
        // Test setId and getId
        user.setId("1");
        assertEquals("1", user.getId());

        // Test setFirstName and getFirstName
        user.setFirstName("John");
        assertEquals("John", user.getFirstName());

        // Test setLastName and getLastName
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());

        // Test setGender and getGender
        user.setGender(Gender.Male);
        assertEquals(Gender.Male, user.getGender());

        // Test setEmail and getEmail
        user.setEmail("john@example.com");
        assertEquals("john@example.com", user.getEmail());

        // Test setPassword and getPassword
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());

        // Test setDesignation and getDesignation
        user.setDesignation(Designation.Intern);
        assertEquals(Designation.Intern, user.getDesignation());

        // Test setContactNumber and getContactNumber
        user.setContactNumber("1234567890");
        assertEquals("1234567890", user.getContactNumber());

        // Test setRole and getRole
        user.setRole(Role.Admin);
        assertEquals(Role.Admin, user.getRole());

        // Test setPosts and getPosts
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("1", "Title 1", "Content 1",
        		PostStatus.Pending, TechnologyCategory.Java, null, null, "1", user, null, null, null);
        Post post2 = new Post("2", "Title 2", "Content 2",
        		PostStatus.Approved, TechnologyCategory.Python, null, null, "1", user, null, null, null);
        posts.add(post1);
        posts.add(post2);
        user.setPosts(posts);
        assertEquals(posts, user.getPosts());
    }

    /**
     * Testing of hashcode.
     */
    @Test
    public void testHashCode() {
        User user1 = new User("John", "Doe", Gender.Male, "john@example.com", "password123", Designation.Intern, "1234567890");
        User user2 = new User("John", "Doe", Gender.Male, "john@example.com", "password123", Designation.Intern, "1234567890");

        assertEquals(user1.hashCode(), user2.hashCode());
    }

    /**
     * Testing of equals.
     */
    @Test
    public void testEquals() {
        User user1 = new User("John", "Doe", Gender.Male, "john@example.com", "password123", Designation.Intern, "1234567890");
        User user2 = new User("John", "Doe", Gender.Male, "john@example.com", "password123", Designation.Intern, "1234567890");

        assertTrue(user1.equals(user2));
    }

    /**
     * Testing of toString.
     */
    @Test
    public void testToString() {
        User usercheck = new User("John", "Doe", Gender.Male,
        		"john@example.com", "password123", Designation.Intern, "1234567890");
        String expectedString = "User [id=null, firstName=John,"
        		+ "lastName=Doe, gender=Male, email=john@example.com, password=password123,"
        		+ " designation=Intern, contactNumber=1234567890, role=Employee, posts=null]";

        assertEquals(expectedString, usercheck.toString());
    }
}
