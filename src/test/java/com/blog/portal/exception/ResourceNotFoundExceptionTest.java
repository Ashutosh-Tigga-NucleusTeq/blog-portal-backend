package com.blog.portal.exception;

import com.blog.portal.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceNotFoundExceptionTest {

    @Test
    public void testResourceNotFoundException() {
        String resourceName = "User";
        String fieldName = "id";
        String fieldValue = "123";
        ResourceNotFoundException exception = new ResourceNotFoundException(resourceName, fieldName, fieldValue);

        String expectedMessage = "User not found with id : 123";
        assertEquals(expectedMessage, exception.getMessage());

        assertEquals(resourceName, exception.getResourceName());
        assertEquals(fieldName, exception.getFieldName());
        assertEquals(fieldValue, exception.getFieldValue());
    }

    @Test
    public void testSettersAndGetters() {
        ResourceNotFoundException exception = new ResourceNotFoundException("User", "id", "123");

        exception.setResourceName("Blog");
        exception.setFieldName("title");
        exception.setFieldValue("Title123");

        assertEquals("Blog", exception.getResourceName());
        assertEquals("title", exception.getFieldName());
        assertEquals("Title123", exception.getFieldValue());
    }
}
