package com.blog.portal.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class BadRequestExceptionTest {
		
    @Test
    public void testUserRegistrationExceptionWithMessage() {
        BadRequestException exception = new BadRequestException("User registration failed");

        assertEquals("User registration failed", exception.getMessage());
    }
}
