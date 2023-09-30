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
        user = new RegisterUserInDto("firstname", "lastname", Gender.MALE, "firstnamelastname@example.com",
        		"password", Designation.INTERN, "1234567890");
    }

    /**
     * Testing of setter and getter.
     */
    @Test
    public void testGettersAndSetters() {
        assertEquals("firstname", user.getFirstName());
        assertEquals("lastname", user.getLastName());
        assertEquals(Gender.MALE, user.getGender());
        assertEquals("firstnamelastname@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals(Designation.INTERN, user.getDesignation());
        assertEquals("1234567890", user.getContactNumber());

        user.setFirstName("fname");
        user.setLastName("lname");
        user.setGender(Gender.FEMALE);
        user.setEmail("fnamelname@example.com");
        user.setPassword("newpassword");
        user.setDesignation(Designation.ARCHITECT);
        user.setContactNumber("9876543210");

        assertEquals("fname", user.getFirstName());
        assertEquals("lname", user.getLastName());
        assertEquals(Gender.FEMALE, user.getGender());
        assertEquals("fnamelname@example.com", user.getEmail());
        assertEquals("newpassword", user.getPassword());
        assertEquals(Designation.ARCHITECT, user.getDesignation());
        assertEquals("9876543210", user.getContactNumber());
    }

    /**
     * Testing HashCode and equals method.
     */
    @Test
    public void testHashCodeAndEquals() {
        RegisterUserInDto sameUser = new RegisterUserInDto("firstname", "lastname", Gender.MALE, "firstnamelastname@example.com",
        		"password", Designation.INTERN, "1234567890");

        assertEquals(user.hashCode(), sameUser.hashCode());
        assertEquals(user, sameUser);
    }
    /**
     * Testing toString method.
     */
    @Test
    public void testToString() {
        String expectedToString = "RegisterInDto [firstName=firstname,"
        		+ " lastName=lastname, gender=MALE, email=firstnamelastname@example.com,"
        		+ " password=password, designation=INTERN, contactNumber=1234567890]";
        assertEquals(expectedToString, user.toString());
    }
}
