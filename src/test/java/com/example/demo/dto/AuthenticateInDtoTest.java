package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains JUnit tests for the {@code AuthenticateInDto} class.
 */
public class AuthenticateInDtoTest {

		/**
		 * Instance of {@code AuthenticateInDto}.
		 */
    private AuthenticateInDto authenticateInDto;

    /**
     * Initializes a new instance of {@code AuthenticateInDto} before each test.
     */
    @BeforeEach
    public void setUp() {
        authenticateInDto = new AuthenticateInDto();
    }

    /**
     * Tests the getter and setter methods of the {@code AuthenticateInDto} class.
     */
    @Test
    public void testGetterSetterMethods() {
        String email = "test@nucleusteq.com";
        String password = "password123";

        // Test setEmail and getEmail
        authenticateInDto.setEmail(email);
        assertEquals(email, authenticateInDto.getEmail());

        // Test setPassword and getPassword
        authenticateInDto.setPassword(password);
        assertEquals(password, authenticateInDto.getPassword());
    }

    /**
     * Tests the equals and hashCode methods of the {@code AuthenticateInDto} class.
     */
    @Test
    public void testEqualsAndHashCode() {
        AuthenticateInDto dto1 = new AuthenticateInDto("test@nucleusteq.com", "password123");
        AuthenticateInDto dto2 = new AuthenticateInDto("test@nucleusteq.com", "password123");
        AuthenticateInDto dto3 = new AuthenticateInDto("test1@nucleusteq.com", "differentPassword");

        // Test equals method
        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);

        // Test hashCode method
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
    }

    /**
     * Tests the toString method of the {@code AuthenticateInDto} class.
     */
    @Test
    public void testToString() {
        String email = "test@nucleusteq.com";
        String password = "password123";
        AuthenticateInDto dto = new AuthenticateInDto(email, password);

        String expectedString = "AuthenticateInDto [email=" + email + ", password=" + password + "]";
        assertEquals(expectedString, dto.toString());
    }
}
