package com.blog.portal.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnauthorizedUserExeptionTest {
    private UnauthorizedUserExeption exception;

    @BeforeEach
    public void setUp() {
        exception = new UnauthorizedUserExeption("Unauthorized access detected");
    }

    @Test
    public void testConstructorWithMessage() {
        assertEquals("Unauthorized access detected", exception.getMessage());
    }

    @Test
    public void testConstructorWithoutMessage() {
    	UnauthorizedUserExeption exceptionWithoutMessage = new UnauthorizedUserExeption();
        assertNull(exceptionWithoutMessage.getMessage());
    }

    @Test
    public void testSetMessage() {
        exception.setMessage("New message");
        assertEquals("New message", exception.getMessage());
    }

    @Test
    public void testToString() {
        assertEquals("UserAlreadyExistsException [message=Unauthorized access detected]", exception.toString());
    }
}
