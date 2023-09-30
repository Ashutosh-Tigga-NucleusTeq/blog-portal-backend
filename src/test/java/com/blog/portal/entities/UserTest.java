package com.blog.portal.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    public void setUp() {
        user1 = new User("firstname", "lastname", Gender.MALE, "firstname@example.com", "password123", Designation.INTERN, "1234567890");
        user2 = new User("anotherfname", "anotherlname", Gender.FEMALE, "anotherfname@example.com", "password456", Designation.HR, "9876543210");
        user3 = new User("firstname", "lastname", Gender.MALE, "firstname@example.com", "password123", Designation.INTERN, "1234567890");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("firstname", user1.getFirstName());
        assertEquals("lastname", user1.getLastName());
        assertEquals(Gender.MALE, user1.getGender());
        assertEquals("firstname@example.com", user1.getEmail());
        assertEquals("password123", user1.getPassword());
        assertEquals(Designation.INTERN, user1.getDesignation());
        assertEquals("1234567890", user1.getContactNumber());

        user1.setFirstName("anotherfname");
        user1.setLastName("anotherlname");
        user1.setGender(Gender.FEMALE);
        user1.setEmail("anotherfname@example.com");
        user1.setPassword("newpassword");
        user1.setDesignation(Designation.HR);
        user1.setContactNumber("9876543210");

        assertEquals("anotherfname", user1.getFirstName());
        assertEquals("anotherlname", user1.getLastName());
        assertEquals(Gender.FEMALE, user1.getGender());
        assertEquals("anotherfname@example.com", user1.getEmail());
        assertEquals("newpassword", user1.getPassword());
        assertEquals(Designation.HR, user1.getDesignation());
        assertEquals("9876543210", user1.getContactNumber());
    }

    @Test
    public void testEqualsAndHashCode() {
        assertTrue(user1.equals(user1));
        assertEquals(user1.hashCode(), user1.hashCode());

        assertTrue(user1.equals(user3));
        assertTrue(user3.equals(user1));
        assertEquals(user1.hashCode(), user3.hashCode());

        assertFalse(user1.equals(null));
        assertFalse(user1.equals("string"));

        assertFalse(user1.equals(user2));
        assertFalse(user2.equals(user1));
        assertNotEquals(user1.hashCode(), user2.hashCode());

        user2.setEmail("different@example.com");
        assertFalse(user1.equals(user2));
    }

    @Test
    public void testToString() {
        String expectedToString = "User [id=null, firstName=firstname, lastName=lastname, gender=MALE, " +
                "email=firstname@example.com, password=password123, designation=INTERN, " +
                "contactNumber=1234567890, role=EMPLOYEE, posts=null]";
        assertEquals(expectedToString, user1.toString());
    }
}
