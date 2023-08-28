package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.dto.UserDto;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        // Initialize a User object before each test
        user = new User();
    }

    @Test
    public void testSetAndGetUserName() {
        // Test setter and getter for userName
        user.setUserName("Ashu123");
        assertEquals("Ashu123", user.getUserName());
    }

    @Test
    public void testSetAndGetUserFirstName() {
        // Test setter and getter for userFirstName
        user.setUserFirstName("ashu");
        assertEquals("ashu", user.getUserFirstName());
    }

    @Test
    public void testSetAndGetUserLastName() {
        // Test setter and getter for userLastName
        user.setUserLastName("tigga");
        assertEquals("tigga", user.getUserLastName());
    }

    @Test
    public void testSetAndGetUserGender() {
        // Test setter and getter for userGender
        user.setUserGender("Male");
        assertEquals("Male", user.getUserGender());
    }

    @Test
    public void testSetAndGetUserEmail() {
        // Test setter and getter for userEmail
        user.setUserEmail("ashu@mail.com");
        assertEquals("ashu@mail.com", user.getUserEmail());
    }

    @Test
    public void testSetAndGetUserPassword() {
        // Test setter and getter for userPassword
        user.setUserPassword("password123");
        assertEquals("password123", user.getUserPassword());
    }

    @Test
    public void testSetAndGetUserDesignation() {
        // Test setter and getter for userDesignation
        user.setUserDesignation("Software Engineer");
        assertEquals("Software Engineer", user.getUserDesignation());
    }

    @Test
    public void testSetAndGetUserContactNumber() {
        // Test setter and getter for userContactNumber
        user.setUserContactNumber("1234567890");
        assertEquals("1234567890", user.getUserContactNumber());
    }

    @Test
    public void testSetAndGetUserRole() {
        // Test setter and getter for userRole
        user.setUserRole("Admin");
        assertEquals("Admin", user.getUserRole());
    }

    @Test
    public void testUserConstructor() {
        // Test constructor
        User newUser = new User("Ashu123", "ashu", "tigga", "Male", "ashu@mail.com",
                "password123", "Software Engineer", "1234567890", "Admin");

        assertEquals("Ashu123", newUser.getUserName());
        assertEquals("ashu", newUser.getUserFirstName());
        assertEquals("tigga", newUser.getUserLastName());
        assertEquals("Male", newUser.getUserGender());
        assertEquals("ashu@mail.com", newUser.getUserEmail());
        assertEquals("password123", newUser.getUserPassword());
        assertEquals("Software Engineer", newUser.getUserDesignation());
        assertEquals("1234567890", newUser.getUserContactNumber());
        assertEquals("Admin", newUser.getUserRole());
    }
    

  	@Test
  	void testToString() {
  		 User user = new User();
  		 user.setUserName("Ashu123");
  		 user.setUserFirstName("ashu");
  		 user.setUserLastName("tigga");
  		 user.setUserEmail("ashu@nucleusteq.com");
  		 user.setUserPassword("1234");
  		 user.setUserDesignation("sde");
  		 user.setUserContactNumber("1234567890");
  		 user.setUserRole("admin");

       // Expected toString result
       String expectedToString = "User [userName=Ashu123,userFirstName=ashu,userLastName=tigga,userEmail=ashu@nucleusteq.com,userPassword=1234,userDesignation=sde,userContactNumber=1234567890userRole=admin]";

       // Test the toString method
       String actualToString = user.toString();

       // Assert that the actual result matches the expected result
       assertEquals(expectedToString, actualToString);
  	}
}
