package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthenticateUserInDtoTest {


    private UserInDTO userInDTO;


    @BeforeEach
    public void setUp() {
        userInDTO = new UserInDTO();
    }


    @Test
    public void testGettersAndSetters() {
        userInDTO.setEmail("test@example.com");
        assertEquals("test@example.com", userInDTO.getEmail());

        userInDTO.setPassword("password123");
        assertEquals("password123", userInDTO.getPassword());

        userInDTO.setEmail("new@example.com");
        userInDTO.setPassword("newpassword456");
        assertEquals("new@example.com", userInDTO.getEmail());
        assertEquals("newpassword456", userInDTO.getPassword());
    }


    @Test
    public void testHashCode() {
        userInDTO.setEmail("test@example.com");
        userInDTO.setPassword("password123");

        UserInDTO other = new UserInDTO("test@example.com", "password123");
        assertEquals(other.hashCode(), userInDTO.hashCode());
    }


    @Test
    public void testEquals() {
        userInDTO.setEmail("test@example.com");
        userInDTO.setPassword("password123");

        UserInDTO same = new UserInDTO("test@example.com", "password123");
        UserInDTO differentEmail = new UserInDTO("different@example.com", "password123");
        UserInDTO differentPassword = new UserInDTO("test@example.com", "different123");

        assertTrue(userInDTO.equals(same));
        assertFalse(userInDTO.equals(differentEmail));
        assertFalse(userInDTO.equals(differentPassword));
        assertFalse(userInDTO.equals(null));
        assertFalse(userInDTO.equals("Not an UserInDTO"));
    }


    @Test
    public void testToString() {
        userInDTO.setEmail("test@example.com");
        userInDTO.setPassword("password123");

        String expected = "AuthenticateInDto [email=test@example.com, password=password123]";
        assertEquals(expected, userInDTO.toString());
    }
}
