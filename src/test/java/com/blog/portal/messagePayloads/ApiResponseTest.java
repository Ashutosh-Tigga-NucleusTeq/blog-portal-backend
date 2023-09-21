package com.blog.portal.messagePayloads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.responseMessage.ApiResponse;

public class ApiResponseTest {

	/**
	 * Instance of ApiResponse.
	 */
    private ApiResponse apiResponse;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        apiResponse = new ApiResponse();
    }

    /**
     * Testing setter and getter.
     */
    @Test
    public void testMessageGetterAndSetter() {
        // Test the setter
        apiResponse.setMessage("Test Message");
        assertEquals("Test Message", apiResponse.getMessage());

        // Test changing the message
        apiResponse.setMessage("New Message");
        assertEquals("New Message", apiResponse.getMessage());

        // Test the setter again
        apiResponse.setMessage("Another Message");
        assertEquals("Another Message", apiResponse.getMessage());
    }

    /**
     * Testing Setter and getter.
     */
    @Test
    public void testSuccessGetterAndSetter() {
        // Test the setter
        apiResponse.setSuccess(true);
        assertTrue(apiResponse.isSuccess());

        // Test changing the success status
        apiResponse.setSuccess(false);
        assertFalse(apiResponse.isSuccess());

        // Test the setter again
        apiResponse.setSuccess(true);
        assertTrue(apiResponse.isSuccess());
    }

    /**
     * Testing hashcoode.
     */
    @Test
    public void testHashCode() {
        apiResponse.setMessage("Test Message");
        apiResponse.setSuccess(true);

        ApiResponse other = new ApiResponse("Test Message", true);
        assertEquals(other.hashCode(), apiResponse.hashCode());
    }

    /**
     * Testing equals.
     */
    @Test
    public void testEquals() {
        apiResponse.setMessage("Test Message");
        apiResponse.setSuccess(true);

        ApiResponse same = new ApiResponse("Test Message", true);
        ApiResponse differentMessage = new ApiResponse("Different Message", true);
        ApiResponse differentSuccess = new ApiResponse("Test Message", false);

        assertTrue(apiResponse.equals(same));
        assertFalse(apiResponse.equals(differentMessage));
        assertFalse(apiResponse.equals(differentSuccess));
        assertFalse(apiResponse.equals(null));
        assertFalse(apiResponse.equals("Not an ApiResponse"));
        // Create an ApiResponse object
        ApiResponse response1 = new ApiResponse("Message", true);

        // Verify that response1 is equal to itself
        assertTrue(response1.equals(response1));

        // Create another ApiResponse object with the same values as response1
        ApiResponse response2 = new ApiResponse("Message", true);

        // Verify that response1 is equal to response2
        assertTrue(response1.equals(response2));

        // Create a different ApiResponse object
        ApiResponse response3 = new ApiResponse("Error", false);

        // Verify that response1 is not equal to response3
        assertFalse(response1.equals(response3));

        // Verify that response1 is not equal to null
        assertFalse(response1.equals(null));

        // Verify that response1 is not equal to an object of a different class
        assertFalse(response1.equals("SomeString"));
    }

    /**
     * Testing to string.
     */
    @Test
    public void testToString() {
        apiResponse.setMessage("Test Message");
        apiResponse.setSuccess(true);

        String expected = "ApiResponse [message=Test Message, success=true]";
        assertEquals(expected, apiResponse.toString());
    }
}
