package com.example.demo.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResourceNotFoundExceptionTest {

		/**
		 * Setter and Getter testing.
		 */
    @Test
    public void testSetterAndGetters() {
        // Create an instance of ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException(
            "testresource", "testfield", "testvalue"
        );

        // Test setter and getter for resourceName
        exception.setResourceName("newresource");
        assertEquals("newresource", exception.getResourceName());

        // Test setter and getter for fieldName
        exception.setFieldName("newfield");
        assertEquals("newfield", exception.getFieldName());

        // Test setter and getter for fieldValue
        exception.setFieldValue("newvalue");
        assertEquals("newvalue", exception.getFieldValue());
    }

    /**
     * Testing of Constructor.
     */
    @Test
    public void testConstructor() {
        // Create an instance of ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException(
            "testresource", "testfield", "testvalue"
        );

        // Verify that the constructor correctly set the resource name
        assertEquals("testresource", exception.getResourceName());

        // Verify that the constructor correctly set the field name
        assertEquals("testfield", exception.getFieldName());

        // Verify that the constructor correctly set the field value
        assertEquals("testvalue", exception.getFieldValue());

        // Verify the exception message
        String expectedMessage = "testresource not found with testfield : testvalue";
        assertEquals(expectedMessage, exception.getMessage());
    }

}
