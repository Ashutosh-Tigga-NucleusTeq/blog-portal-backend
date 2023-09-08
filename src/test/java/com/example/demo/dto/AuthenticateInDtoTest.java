package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthenticateInDtoTest {

		/**
		 * instance of AtuthenticateInDto.
		 */
    private AuthenticateInDto dto;

    /**
     * configure something before testing of each case perform.
     */
    @BeforeEach
    public void setUp() {
        dto = new AuthenticateInDto();
    }

    /**
     * Setter and Getter method testing.
     */
    @Test
    public void testGetterAndSetterMethods() {
        // Set values using setter methods
        dto.setEmail("test@nucleusteq.com");
        dto.setPassword("password123");

        // Test getter methods
        assertEquals("test@nucleusteq.com", dto.getEmail());
        assertEquals("password123", dto.getPassword());
    }

    /**
     * hashCode method testing.
     */
    @Test
    public void testHashCode() {
        // Set values using setter methods
        dto.setEmail("test@nucleusteq.com");
        dto.setPassword("password123");

        // Create another DTO with the same values
        AuthenticateInDto anotherDto = new AuthenticateInDto();
        anotherDto.setEmail("test@nucleusteq.com");
        anotherDto.setPassword("password123");

        // Test hashCode
        assertEquals(dto.hashCode(), anotherDto.hashCode());
    }

    /**
     * equals method testing.
     */
    @Test
    public void testEquals() {
        // Set values using setter methods
        dto.setEmail("test@nucleusteq.com");
        dto.setPassword("password123");

        // Create another DTO with the same values
        AuthenticateInDto anotherDto = new AuthenticateInDto();
        anotherDto.setEmail("test@nucleusteq.com");
        anotherDto.setPassword("password123");

        // Test equals
        assertTrue(dto.equals(anotherDto));
    }

    /**
     * toString method testing.
     */
    @Test
    public void testToString() {
        // Set values using setter methods
        dto.setEmail("test@nucleusteq.com");
        dto.setPassword("password123");

        // Test toString
        assertEquals("AuthenticateInDto [email=test@nucleusteq.com, passwordSize=6, password=password123]", dto.toString());
    }
}
