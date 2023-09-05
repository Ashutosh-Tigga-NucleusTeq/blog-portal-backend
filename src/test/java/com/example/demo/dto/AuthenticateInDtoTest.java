package com.example.demo.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticateInDtoTest {

    private AuthenticateInDto dto;

    @BeforeEach
    public void setUp() {
        dto = new AuthenticateInDto();
    }

    @Test
    public void testSetterAndGetterMethods() {
        String userEmail = "test@nucleusteq.com";
        String userPassword = "testpassword";

        dto.setUserEmail(userEmail);
        dto.setUserPassword(userPassword);

        assertEquals(userEmail, dto.getUserEmail());
        assertEquals(userPassword, dto.getUserPassword());
    }

    @Test
    public void testToString() {
        String userEmail = "test@nucleusteq.com";
        String userPassword = "testpassword";
        dto.setUserEmail(userEmail);
        dto.setUserPassword(userPassword);

        String expectedToString = "AuthenticateInDto [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
        assertEquals(expectedToString, dto.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        AuthenticateInDto dto1 = new AuthenticateInDto("test@nucleusteq.com", "testpassword");
        AuthenticateInDto dto2 = new AuthenticateInDto("test@nucleusteq.com", "testpassword");
        AuthenticateInDto dto3 = new AuthenticateInDto("another@nucleusteq.com", "anotherpassword");

        assertEquals(dto1, dto2); // dto1 and dto2 should be equal
        assertNotEquals(dto1, dto3); // dto1 and dto3 should not be equal
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}
