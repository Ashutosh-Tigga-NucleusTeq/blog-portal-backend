package com.blog.portal.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class UserAlreadyExistsExceptionTest {
		
    @Test
    public void testUserRegistrationExceptionWithMessage() {
        UserAlreadyExistsException exception = new UserAlreadyExistsException("User registration failed");

        assertEquals("User registration failed", exception.getMessage());
    }


    @Test
    public void testUserRegistrationExceptionWithoutMessage() {
        UserAlreadyExistsException exception = new UserAlreadyExistsException();

        assertNull(exception.getMessage());

        exception.setMessage("New error message");

        assertEquals("New error message", exception.getMessage());
    }


    @Test
    public void testToString() {
        UserAlreadyExistsException exception = new UserAlreadyExistsException("User registration failed");

        assertEquals("UserAlreadyExistsException [message=User registration failed]", exception.toString());
    }
}
