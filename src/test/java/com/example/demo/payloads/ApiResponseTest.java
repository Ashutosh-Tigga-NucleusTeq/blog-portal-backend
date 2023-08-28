package com.example.demo.payloads;

import com.example.demo.payloads.ApiResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        assertNull(apiResponse.getMessage(), "Default message should be null");
        assertFalse(apiResponse.isSuccess(), "Default success status should be false");
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
    }

    /**
     * Test case for setMessage method of ApiResponse.
     */
    @Test
    public void testSetMessage() {
        ApiResponse apiResponse = new ApiResponse();

        // Set a message using setMessage method
        apiResponse.setMessage("New message");

        // Assertion
        assertEquals("New message", apiResponse.getMessage(), "Message should be set correctly");
    }

    /**
     * Test case for isSuccess method of ApiResponse.
     */
    @Test
    public void testIsSuccess() {
        ApiResponse apiResponse = new ApiResponse("Test message", true);

        // Assertion
        assertTrue(apiResponse.isSuccess(), "Success status should be true");
    }

    /**
     * Test case for setSuccess method of ApiResponse.
     */
    @Test
    public void testSetSuccess() {
        ApiResponse apiResponse = new ApiResponse();

        // Set success status using setSuccess method
        apiResponse.setSuccess(true);

        // Assertion
        assertTrue(apiResponse.isSuccess(), "Success status should be set correctly");
    }
}
