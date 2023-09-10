package com.example.demo.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class UserRegistrationExceptionTest {
		/**
		 * Constructor Testing with message.
		 */
    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "test error message";
        UserRegistrationException exception = new UserRegistrationException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    /**
     * Contructor Testing without message.
     */
    @Test
    public void testConstructorWithoutMessage() {
        UserRegistrationException exception = new UserRegistrationException();

        assertNull(exception.getMessage());
    }

    /**
     * Getter and Setter testing.
     */
    @Test
    public void testSetterAndGetters() {
        String errorMessage = "test error message";
        UserRegistrationException exception = new UserRegistrationException();

        exception.setMessage(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    /**
     * toString method testing.
     */
    @Test
    public void testToString() {
        String errorMessage = "test error message";
        UserRegistrationException exception = new UserRegistrationException(errorMessage);

        assertEquals("UserRegistrationException [message=" + errorMessage + "]", exception.toString());
    }
}
