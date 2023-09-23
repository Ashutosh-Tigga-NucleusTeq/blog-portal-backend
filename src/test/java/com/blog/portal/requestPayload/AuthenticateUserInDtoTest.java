package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthenticateUserInDtoTest {

	/**
	 * Instance of AuthencateUserInDto.
	 */
    private AuthenticateUserInDto authenticateUserInDto;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        authenticateUserInDto = new AuthenticateUserInDto();
    }

    /**
     * Testing setter and getter.
     */
    @Test
    public void testGettersAndSetters() {
        // Test email getter and setter
        authenticateUserInDto.setEmail("test@example.com");
        assertEquals("test@example.com", authenticateUserInDto.getEmail());

        // Test password getter and setter
        authenticateUserInDto.setPassword("password123");
        assertEquals("password123", authenticateUserInDto.getPassword());

        // Test changing email and password
        authenticateUserInDto.setEmail("new@example.com");
        authenticateUserInDto.setPassword("newpassword456");
        assertEquals("new@example.com", authenticateUserInDto.getEmail());
        assertEquals("newpassword456", authenticateUserInDto.getPassword());
    }

    /**
     * Testing hashCode.
     */
    @Test
    public void testHashCode() {
        authenticateUserInDto.setEmail("test@example.com");
        authenticateUserInDto.setPassword("password123");

        AuthenticateUserInDto other = new AuthenticateUserInDto("test@example.com", "password123");
        assertEquals(other.hashCode(), authenticateUserInDto.hashCode());
    }

    /**
     * Testing equals.
     */
    @Test
    public void testEquals() {
        authenticateUserInDto.setEmail("test@example.com");
        authenticateUserInDto.setPassword("password123");

        AuthenticateUserInDto same = new AuthenticateUserInDto("test@example.com", "password123");
        AuthenticateUserInDto differentEmail = new AuthenticateUserInDto("different@example.com", "password123");
        AuthenticateUserInDto differentPassword = new AuthenticateUserInDto("test@example.com", "different123");

        assertTrue(authenticateUserInDto.equals(same));
        assertFalse(authenticateUserInDto.equals(differentEmail));
        assertFalse(authenticateUserInDto.equals(differentPassword));
        assertFalse(authenticateUserInDto.equals(null));
        assertFalse(authenticateUserInDto.equals("Not an AuthenticateUserInDto"));
    }

    /**
     * Testing toString.
     */
    @Test
    public void testToString() {
        authenticateUserInDto.setEmail("test@example.com");
        authenticateUserInDto.setPassword("password123");

        String expected = "AuthenticateInDto [email=test@example.com, password=password123]";
        assertEquals(expected, authenticateUserInDto.toString());
    }
}
