package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

public class UserTest {

		/**
		 * tesing setter and getter.
		 */
    @Test
    public void testUserGetterAndSetter() {
        // Create a User object
        User user = new User();

        // Set values using setter methods
        user.setId("123");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setGender(Gender.Male);
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        user.setDesignation(Designation.Intern);
        user.setContactNumber("1234567890");
        user.setRole(Role.Admin);

        // Get values using getter methods and assert their correctness
        assertEquals("123", user.getId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(Gender.Male, user.getGender());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(Designation.Intern, user.getDesignation());
        assertEquals("1234567890", user.getContactNumber());
        assertEquals(Role.Admin, user.getRole());
    }
}
