package com.example.demo.model;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testSetterAndGetterMethods() {
        user.setUserName("testuser");
        user.setUserFirstName("firstname");
        user.setUserLastName("lastname");
        user.setUserGender(Gender.Male);
        user.setUserEmail("test@nucleusteq.com");
        user.setUserPassword("testpassword");
        user.setUserDesignation(Designation.WebDeveloper);
        user.setUserContactNumber("1234567890");
        user.setUserRole(Role.Admin);

        assertEquals("testUser", user.getUserName());
        assertEquals("firstname", user.getUserFirstName());
        assertEquals("lastname", user.getUserLastName());
        assertEquals(Gender.Male, user.getUserGender());
        assertEquals("test@nucleusteq.com", user.getUserEmail());
        assertEquals("testpassword", user.getUserPassword());
        assertEquals(Designation.WebDeveloper, user.getUserDesignation());
        assertEquals("1234567890", user.getUserContactNumber());
        assertEquals(Role.Admin, user.getUserRole());
    }

    @Test
    public void testEqualsAndHashCode() {
        User user1 = new User("testuser", "firstname", Gender.Male, "test@nucleusteq.com", "testpassword", Designation.WebDeveloper, "1234567890");
        User user2 = new User("testuser2", "firstnameg", Gender.Female, "test2@nucleusteq.com", "testpassword", Designation.DataAnalyst, "0276543210");
        User user3 = new User("testuser", "firstname", Gender.Male, "test@nucleusteq.com", "testpassword", Designation.WebDeveloper, "1234567890");

        assertEquals(user1, user3); // User 1 and User 3 should be equal
        assertNotEquals(user1, user2); // User 1 and User 2 should not be equal
        assertEquals(user1.hashCode(), user3.hashCode());
    }

    @Test
    public void testToString() {
        user.setUserName("testuser");
        user.setUserFirstName("firstname");
        user.setUserLastName("lastname");
        user.setUserGender(Gender.Male);
        user.setUserEmail("test@nucleusteq.com");
        user.setUserPassword("testpassword");
        user.setUserDesignation(Designation.WebDeveloper);
        user.setUserContactNumber("1234567890");
        user.setUserRole(Role.Admin);

        String expectedToString = "User [userName=testuser, userFirstName=firstname, userLastName=lastname, " +
                "userGender=Male, userEmail=test@nucleusteq.com, userPassword=testpassword, " +
                "userDesignation=WebDeveloper, userContactNumber=1234567890, userRole=Admin]";

        assertEquals(expectedToString, user.toString());
    }
}
