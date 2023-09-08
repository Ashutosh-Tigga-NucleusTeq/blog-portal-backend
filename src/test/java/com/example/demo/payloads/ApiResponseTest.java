package com.example.demo.payloads;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test class for ApiResponse.
 */
public class ApiResponseTest {

    /**
     * Test case for the default constructor of ApiResponse.
     */
    @Test
    public void testDefaultConstructor() {
        // Create an instance of ApiResponse using the default constructor
        ApiResponse apiResponse = new ApiResponse();

        // Assertions
        assertNull(apiResponse.getMessage(), null);
        assertFalse(apiResponse.isSuccess(), "false");
    }

    /**
     * Test case for the parameterized constructor of ApiResponse.
     */
    @Test
    public void testParameterizedConstructor() {
        // Create an instance of ApiResponse using the parameterized constructor
        ApiResponse apiResponse = new ApiResponse("Test message", true);

        // Assertions
        assertEquals("Test message", apiResponse.getMessage(), "Message should match the input");
        assertTrue(apiResponse.isSuccess(), "Success status should be true");
    }

    /**
     * Test case for getMessage method of ApiResponse.
     */
    @Test
    public void testGetMessage() {
        ApiResponse apiResponse = new ApiResponse("Test message", true);

        // Assertion
        assertEquals("Test message", apiResponse.getMessage(), "Message should be retrieved correctly");
        ApiResponse apiResponse1 = new ApiResponse();

        // Set a message using setMessage method
        apiResponse.setMessage("New message");

        // Assertion
        assertEquals("New message", apiResponse.getMessage(), "Message should be set correctly");

        ApiResponse apiResponse2 = new ApiResponse("Test message", true);

        // Assertion
        assertTrue(apiResponse.isSuccess(), "Success status should be true");

        ApiResponse apiResponse3 = new ApiResponse();

        // Set success status using setSuccess method
        apiResponse.setSuccess(true);

        // Assertion
        assertTrue(apiResponse.isSuccess(), "Success status should be set correctly");
    }

    /**
     * testing of equals and hashcode method.
     */
    @Test
    public void testEqualsAndHashCode() {
        ApiResponse apiResponse1 = new ApiResponse("Message", true);
        ApiResponse apiResponse2 = new ApiResponse("Message", true);
        ApiResponse apiResponse3 = new ApiResponse("Different Message", true);

        // Test equality
        assertTrue(apiResponse1.equals(apiResponse2));
        assertFalse(apiResponse1.equals(apiResponse3));

        // Test hashCode
        assertEquals(apiResponse1.hashCode(), apiResponse2.hashCode());
        assertNotEquals(apiResponse1.hashCode(), apiResponse3.hashCode());
    }

    /**
     * testing of toString method.
     */
    @Test
    public void testToString() {
        ApiResponse apiResponse = new ApiResponse("message", true);

        String expectedToString = "ApiResponse [message=message, success=true]";
        assertEquals(expectedToString, apiResponse.toString());
    }


}
