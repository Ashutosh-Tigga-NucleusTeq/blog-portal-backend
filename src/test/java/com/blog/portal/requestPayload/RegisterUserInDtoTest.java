package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;

public class RegisterUserInDtoTest {

	/**
	 * Instance of RegisterUserInDto.
	 */
    private RegisterUserInDto user;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        // Initialize a sample RegisterUserInDto object for testing
        user = new RegisterUserInDto("firstname", "lastname", Gender.Male, "firstnamelastname@example.com",
        		"password", Designation.Intern, "1234567890");
    }

    /**
     * Testing of setter and getter.
     */
    @Test
    public void testGettersAndSetters() {
        // Test getters and setters for all properties
        assertEquals("firstname", user.getFirstName());
        assertEquals("lastname", user.getLastName());
        assertEquals(Gender.Male, user.getGender());
        assertEquals("firstnamelastname@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals(Designation.Intern, user.getDesignation());
        assertEquals("1234567890", user.getContactNumber());

        // Modify the properties using setters
        user.setFirstName("fname");
        user.setLastName("lname");
        user.setGender(Gender.Female);
        user.setEmail("fnamelname@example.com");
        user.setPassword("newpassword");
        user.setDesignation(Designation.Architect);
        user.setContactNumber("9876543210");

        // Check if the properties have been updated
        assertEquals("fname", user.getFirstName());
        assertEquals("lname", user.getLastName());
        assertEquals(Gender.Female, user.getGender());
        assertEquals("fnamelname@example.com", user.getEmail());
        assertEquals("newpassword", user.getPassword());
        assertEquals(Designation.Architect, user.getDesignation());
        assertEquals("9876543210", user.getContactNumber());
    }

    /**
     * Testing HashCode and equals method.
     */
    @Test
    public void testHashCodeAndEquals() {
        // Create a new RegisterUserInDto with the same properties as the original
        RegisterUserInDto sameUser = new RegisterUserInDto("firstname", "lastname", Gender.Male, "firstnamelastname@example.com",
        		"password", Designation.Intern, "1234567890");

        // Check if the two objects have the same hash code and are equal
        assertEquals(user.hashCode(), sameUser.hashCode());
        assertEquals(user, sameUser);
    }
    /**
     * Testing toString method.
     */
    @Test
    public void testToString() {
        // Check the string representation of the object
        String expectedToString = "RegisterInDto [firstName=firstname,"
        		+ " lastName=lastname, gender=Male, email=firstnamelastname@example.com,"
        		+ " password=password, designation=Intern, contactNumber=1234567890]";
        assertEquals(expectedToString, user.toString());
    }
}
