package com.blog.portal.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnauthorizedUserExeptionTest {
    private UnauthorizedUserExeption exception;

    @BeforeEach
    public void setUp() {
        exception = new UnauthorizedUserExeption("Unauthorized User");
    }

    @Test
    public void testConstructorWithMessage() {
        assertEquals("Unauthorized User", exception.getMessage());
    }


}
