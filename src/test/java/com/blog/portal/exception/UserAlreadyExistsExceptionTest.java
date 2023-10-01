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
        UserRegistrationException exception = new UserRegistrationException("User registration failed");

        assertEquals("User registration failed", exception.getMessage());
    }

    /**
     * Testing of exception without message.
     */
    @Test
    public void testUserRegistrationExceptionWithoutMessage() {
        UserRegistrationException exception = new UserRegistrationException();

        assertNull(exception.getMessage());

        exception.setMessage("New error message");

        assertEquals("New error message", exception.getMessage());
    }

    /**
     * Testing of toString.
     */
    @Test
    public void testToString() {
        UserRegistrationException exception = new UserRegistrationException("User registration failed");

        assertEquals("UserRegistrationException [message=User registration failed]", exception.toString());
    }
}
