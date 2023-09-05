package com.example.demo.exception;

import com.example.demo.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ResourceNotFoundException.
 */
public class ResourceNotFoundExceptionTest {

    /**
     * Test case to ensure that the exception message is correctly formatted.
     */
    @Test
    public void testExceptionMessageFormat() {
        // Create an instance of ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException(
            "Resource",
            "Resource field",
            "Resource value"
        );

        // Get the exception message
        String message = exception.getMessage();

        // Assert that the exception message is formatted correctly
        assertEquals("User not found with userId : Resource value", message);
    }

    /**
     * Test case to ensure that the resourceName field is set correctly.
     */
    @Test
    public void testResourceNameField() {
        // Create an instance of ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException(
            "Resource",
            "Resource field",
            "Resource value"
        );

        // Get the resourceName field
        String resourceName = exception.getResourceName();

        // Assert that the resourceName field is set correctly
        assertEquals("Resource", resourceName);
    }

    /**
     * Test case to ensure that the fieldName field is set correctly.
     */
    @Test
    public void testFieldNameField() {
        // Create an instance of ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException(
            "Resource",
            "Resource field",
            "Resource value"
        );

        // Get the fieldName field
        String fieldName = exception.getFieldName();

        // Assert that the fieldName field is set correctly
        assertEquals("Resource field", fieldName);
    }

    /**
     * Test case to ensure that the fieldValue field is set correctly.
     */
    @Test
    public void testFieldValueField() {
        // Create an instance of ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException(
            "Resource",
            "Resource field",
            "Resource value"
        );

        // Get the fieldValue field
        String fieldValue = exception.getFieldValue();

        // Assert that the fieldValue field is set correctly
        assertEquals("Resource value", fieldValue);
    }
}
