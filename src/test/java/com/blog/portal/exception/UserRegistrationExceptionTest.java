package com.blog.portal.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class UserRegistrationExceptionTest {
		/**
		 * Testting of exception with message.
		 */
    @Test
    public void testUserRegistrationExceptionWithMessage() {
        // Create a UserRegistrationException with a custom message
        UserRegistrationException exception = new UserRegistrationException("User registration failed");

        // Test getMessage method
        assertEquals("User registration failed", exception.getMessage());
    }

    /**
     * Testing of exception without message.
     */
    @Test
    public void testUserRegistrationExceptionWithoutMessage() {
        // Create a UserRegistrationException without a custom message
        UserRegistrationException exception = new UserRegistrationException();

        // Test getMessage method (should return null for an exception without a message)
        assertNull(exception.getMessage());

        // Update the message using setMessage method
        exception.setMessage("New error message");

        // Test getMessage method again
        assertEquals("New error message", exception.getMessage());
    }

    /**
     * Testing of toString.
     */
    @Test
    public void testToString() {
        // Create a UserRegistrationException with a custom message
        UserRegistrationException exception = new UserRegistrationException("User registration failed");

        // Test the toString method
        assertEquals("UserRegistrationException [message=User registration failed]", exception.toString());
    }
}
