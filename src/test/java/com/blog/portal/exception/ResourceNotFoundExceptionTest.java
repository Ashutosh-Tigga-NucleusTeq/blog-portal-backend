package com.blog.portal.exception;

import com.blog.portal.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceNotFoundExceptionTest {

    @Test
    public void testResourceNotFoundException() {
        // Create a ResourceNotFoundException
        String resourceName = "User";
        String fieldName = "id";
        String fieldValue = "123";
        ResourceNotFoundException exception = new ResourceNotFoundException(resourceName, fieldName, fieldValue);

        // Verify that the exception message is as expected
        String expectedMessage = "User not found with id : 123";
        assertEquals(expectedMessage, exception.getMessage());

        // Verify that the getter methods return the expected values
        assertEquals(resourceName, exception.getResourceName());
        assertEquals(fieldName, exception.getFieldName());
        assertEquals(fieldValue, exception.getFieldValue());
    }

    @Test
    public void testSettersAndGetters() {
        // Create a ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException("User", "id", "123");

        // Use setters to change values
        exception.setResourceName("Post");
        exception.setFieldName("title");
        exception.setFieldValue("Title123");

        // Verify that the getter methods return the updated values
        assertEquals("Post", exception.getResourceName());
        assertEquals("title", exception.getFieldName());
        assertEquals("Title123", exception.getFieldValue());
    }
}
