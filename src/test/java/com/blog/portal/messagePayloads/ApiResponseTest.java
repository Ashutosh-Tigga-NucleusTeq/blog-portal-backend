package com.blog.portal.messagePayloads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.responsePayload.ResponseOutDTO;

public class ApiResponseTest {


    private ResponseOutDTO responseOutDTO;


    @BeforeEach
    public void setUp() {
        responseOutDTO = new ResponseOutDTO();
    }


    @Test
    public void testMessageGetterAndSetter() {
        responseOutDTO.setMessage("Test Message");
        assertEquals("Test Message", responseOutDTO.getMessage());

        responseOutDTO.setMessage("New Message");
        assertEquals("New Message", responseOutDTO.getMessage());

        responseOutDTO.setMessage("Another Message");
        assertEquals("Another Message", responseOutDTO.getMessage());
    }


    @Test
    public void testSuccessGetterAndSetter() {
        responseOutDTO.setSuccess(true);
        assertTrue(responseOutDTO.isSuccess());

        responseOutDTO.setSuccess(false);
        assertFalse(responseOutDTO.isSuccess());

        responseOutDTO.setSuccess(true);
        assertTrue(responseOutDTO.isSuccess());
    }


    @Test
    public void testHashCode() {
        responseOutDTO.setMessage("Test Message");
        responseOutDTO.setSuccess(true);

        ResponseOutDTO other = new ResponseOutDTO("Test Message", true);
        assertEquals(other.hashCode(), responseOutDTO.hashCode());
    }


    @Test
    public void testEquals() {
        responseOutDTO.setMessage("Test Message");
        responseOutDTO.setSuccess(true);

        ResponseOutDTO same = new ResponseOutDTO("Test Message", true);
        ResponseOutDTO differentMessage = new ResponseOutDTO("Different Message", true);
        ResponseOutDTO differentSuccess = new ResponseOutDTO("Test Message", false);

        assertTrue(responseOutDTO.equals(same));
        assertFalse(responseOutDTO.equals(differentMessage));
        assertFalse(responseOutDTO.equals(differentSuccess));
        assertFalse(responseOutDTO.equals(null));
        assertFalse(responseOutDTO.equals("Not an ResponseOutDTO"));
        ResponseOutDTO response1 = new ResponseOutDTO("Message", true);

        assertTrue(response1.equals(response1));

        ResponseOutDTO response2 = new ResponseOutDTO("Message", true);

        assertTrue(response1.equals(response2));

        ResponseOutDTO response3 = new ResponseOutDTO("Error", false);

        assertFalse(response1.equals(response3));

        assertFalse(response1.equals(null));

        assertFalse(response1.equals("SomeString"));
    }


    @Test
    public void testToString() {
        responseOutDTO.setMessage("Test Message");
        responseOutDTO.setSuccess(true);

        String expected = "ResponseOutDTO [message=Test Message, success=true]";
        assertEquals(expected, responseOutDTO.toString());
    }
}
