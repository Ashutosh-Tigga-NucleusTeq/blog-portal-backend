package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.dto.UserDto;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

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
        user.setUserName("username");
        assertEquals("username", user.getUserName());
        // Test setter and getter for userFirstName
        user.setUserFirstName("firstname");
        assertEquals("firstname", user.getUserFirstName());
        // Test setter and getter for userLastName
        user.setUserLastName("lastname");
        assertEquals("lastname", user.getUserLastName());
        // Test setter and getter for userGender
        user.setUserGender(Gender.Male);
        assertEquals("Male", user.getUserGender());
        // Test setter and getter for userEmail
        user.setUserEmail("test@nucleusteq.com");
        assertEquals("test@nucleusteq.com", user.getUserEmail());
        // Test setter and getter for userPassword
        user.setUserPassword("password");
        assertEquals("password", user.getUserPassword());
        // Test setter and getter for userDesignation
        user.setUserDesignation(Designation.Trainee_Engineer);
        assertEquals("desingation", user.getUserDesignation());
        // Test setter and getter for userContactNumber
        user.setUserContactNumber("1234567890");
        assertEquals("1234567890", user.getUserContactNumber());
        // Test setter and getter for userRole
        user.setUserRole(Role.Admin);
        assertEquals(Role.Admin, user.getUserRole());
    }

    @Test
    public void testUserConstructor() {
        // Test constructor
        User newUser = new User("username", "firstname", "lastname", Gender.Male, "test@nucleusteq.com",
                "password", Designation.Trainee_Engineer, "1234567890", Role.Admin);

        assertEquals("username", newUser.getUserName());
        assertEquals("firstname", newUser.getUserFirstName());
        assertEquals("lastname", newUser.getUserLastName());
        assertEquals("Male", newUser.getUserGender());
        assertEquals("test@nucleusteq.com", newUser.getUserEmail());
        assertEquals("password", newUser.getUserPassword());
        assertEquals("designation", newUser.getUserDesignation());
        assertEquals("1234567890", newUser.getUserContactNumber());
        assertEquals(Role.Admin, newUser.getUserRole());
    }
    
  	@Test
  	void testToString() {
  		 User user = new User();
  		 user.setUserName("username");
  		 user.setUserFirstName("firstname");
  		 user.setUserLastName("lastname");
  		 user.setUserEmail("test@nucleusteq.com");
  		 user.setUserPassword("password");
  		 user.setUserGender(Gender.Male);
  		 user.setUserDesignation(Designation.Trainee_Engineer);
  		 user.setUserContactNumber("1234567890");
  		 user.setUserRole(Role.Admin);

       // Expected toString result
       String expectedToString = "User [userName=username,userFirstName=firstname,userLastName=lastname,userGender=Male,userEmail=test@nucleusteq.com,userPassword=password,userDesignation=Trainee_Engineer,userContactNumber=1234567890,userRole=Admin]";

       // Test the toString method
       String actualToString = user.toString();

       // Assert that the actual result matches the expected result
       assertEquals(expectedToString, actualToString);
  	}
}
