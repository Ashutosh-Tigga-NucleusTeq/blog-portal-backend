package com.example.demo.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterDtoTest {

    private RegisterDto dto;

    @BeforeEach
    public void setUp() {
        dto = new RegisterDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", "password", Designation.WebDeveloper, "1234567890",Role.Admin);
    }

    @Test
    public void testSetterAndGetterMethods() {
        assertEquals("firstname", dto.getUserFirstName());
        assertEquals("lastname", dto.getUserLastName());
        assertEquals(Gender.Male, dto.getUserGender());
        assertEquals("test@nucleusteq.com", dto.getUserEmail());
        assertEquals("password", dto.getUserPassword());
        assertEquals(Designation.WebDeveloper, dto.getUserDesignation());
        assertEquals("1234567890", dto.getUserContactNumber());

        // Modify the values using setter methods
        dto.setUserFirstName("firstname1");
        dto.setUserLastName("lastname1");
        dto.setUserGender(Gender.Female);
        dto.setUserEmail("test1@nucleusteq.com");
        dto.setUserPassword("password1");
        dto.setUserDesignation(Designation.DataAnalyst);
        dto.setUserContactNumber("1076543210");

        // Verify the values after modification
        assertEquals("firstname1", dto.getUserFirstName());
        assertEquals("lastname1", dto.getUserLastName());
        assertEquals(Gender.Female, dto.getUserGender());
        assertEquals("test1@nucleusteq.com", dto.getUserEmail());
        assertEquals("password1", dto.getUserPassword());
        assertEquals(Designation.DataAnalyst, dto.getUserDesignation());
        assertEquals("1076543210", dto.getUserContactNumber());
    }

    @Test
    public void testEqualsAndHashCode() {
        RegisterDto dto1 = new RegisterDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", "password", Designation.WebDeveloper, "1234567890",Role.Admin);
        RegisterDto dto2 =  new RegisterDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", "password", Designation.WebDeveloper, "1234567890",Role.Admin);
        RegisterDto dto3 = new RegisterDto("firstname1", "lastname1", Gender.Female, "test1@nucleusteq.com", "password1", Designation.WebDeveloper, "2234567890",Role.Employee);

        assertEquals(dto1, dto2); // dto1 and dto2 should be equal
        assertNotEquals(dto1, dto3); // dto1 and dto3 should not be equal
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void testToString() {
        String expectedToString = "UserDto [userFirstName=firstname, userLastName=lastname, userGender=Male, " +
                "userEmail=test@nucleusteq.com, userPassword=password, userDesignation=WebDeveloper, " +
                "userContactNumber=1234567890]";
        assertEquals(expectedToString, dto.toString());
    }
}
