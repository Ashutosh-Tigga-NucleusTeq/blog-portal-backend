package com.example.demo.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticateOutDtoTest {

    private AuthenticateOutDto dto;

    @BeforeEach
    public void setUp() {
        dto = new AuthenticateOutDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", Designation.WebDeveloper, "1234567890");
    }

    @Test
    public void testSetterAndGetterMethods() {
        assertEquals("firstname", dto.getUserFirstName());
        assertEquals("lastname", dto.getUserLastName());
        assertEquals(Gender.Male, dto.getUserGender());
        assertEquals("test@nucleusteq.com", dto.getUserEmail());
        assertEquals(Designation.WebDeveloper, dto.getUserDesgination());
        assertEquals("1234567890", dto.getUserContactNumber());

        // Modify the values using setter methods
        dto.setUserFirstName("firstname2");
        dto.setUserLastName("lastname2");
        dto.setUserGender(Gender.Female);
        dto.setUserEmail("test2@nucleusteq.com");
        dto.setUserDesgination(Designation.DataAnalyst);
        dto.setUserContactNumber("0348535839");

        // Verify the values after modification
        assertEquals("firstname2", dto.getUserFirstName());
        assertEquals("lastname2", dto.getUserLastName());
        assertEquals(Gender.Female, dto.getUserGender());
        assertEquals("test2@nucleusteq.com", dto.getUserEmail());
        assertEquals(Designation.DataAnalyst, dto.getUserDesgination());
        assertEquals("0348535839", dto.getUserContactNumber());
    }

    @Test
    public void testEqualsAndHashCode() {
        AuthenticateOutDto dto1 = new AuthenticateOutDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", Designation.WebDeveloper, "1234567890");
        AuthenticateOutDto dto2 = new AuthenticateOutDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", Designation.WebDeveloper, "1234567890");
        AuthenticateOutDto dto3 = new AuthenticateOutDto("firstname1", "lastname1", Gender.Female, "test1@nucleusteq.com", Designation.DataAnalyst, "4324567890");

        assertEquals(dto1, dto2); // dto1 and dto2 should be equal
        assertNotEquals(dto1, dto3); // dto1 and dto3 should not be equal
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void testToString() {
        String expectedToString = "AuthenticateOutDto [userFirstName=firstname, userLastName=lastname, userGender=Male, " +
                "userEmail=test@nucleusteq.com, userDesgination=WebDeveloper, userContactNumber=1234567890]";
        assertEquals(expectedToString, dto.toString());
    }
}
