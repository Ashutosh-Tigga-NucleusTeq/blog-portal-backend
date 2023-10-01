package com.blog.portal.messagePayloads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.responseMessage.ApiResponse;

public class ApiResponseTest {


    private ApiResponse apiResponse;


    @BeforeEach
    public void setUp() {
        apiResponse = new ApiResponse();
    }


    @Test
    public void testMessageGetterAndSetter() {
        apiResponse.setMessage("Test Message");
        assertEquals("Test Message", apiResponse.getMessage());

        apiResponse.setMessage("New Message");
        assertEquals("New Message", apiResponse.getMessage());

        apiResponse.setMessage("Another Message");
        assertEquals("Another Message", apiResponse.getMessage());
    }


    @Test
    public void testSuccessGetterAndSetter() {
        apiResponse.setSuccess(true);
        assertTrue(apiResponse.isSuccess());

        apiResponse.setSuccess(false);
        assertFalse(apiResponse.isSuccess());

        apiResponse.setSuccess(true);
        assertTrue(apiResponse.isSuccess());
    }


    @Test
    public void testHashCode() {
        apiResponse.setMessage("Test Message");
        apiResponse.setSuccess(true);

        ApiResponse other = new ApiResponse("Test Message", true);
        assertEquals(other.hashCode(), apiResponse.hashCode());
    }


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
        ApiResponse response1 = new ApiResponse("Message", true);

        assertTrue(response1.equals(response1));

        ApiResponse response2 = new ApiResponse("Message", true);

        assertTrue(response1.equals(response2));

        ApiResponse response3 = new ApiResponse("Error", false);

        assertFalse(response1.equals(response3));

        assertFalse(response1.equals(null));

        assertFalse(response1.equals("SomeString"));
    }


    @Test
    public void testToString() {
        apiResponse.setMessage("Test Message");
        apiResponse.setSuccess(true);

        String expected = "ApiResponse [message=Test Message, success=true]";
        assertEquals(expected, apiResponse.toString());
    }
}
