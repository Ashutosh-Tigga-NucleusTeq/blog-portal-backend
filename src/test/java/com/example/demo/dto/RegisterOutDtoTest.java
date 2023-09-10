package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

public class RegisterOutDtoTest {

    @Test
    void testGettersAndSetters() {
        // Create a RegisterOutDto object
        RegisterOutDto registerOutDto = new RegisterOutDto();

        // Set values using setters
        registerOutDto.setFirstName("firstname");
        registerOutDto.setLastName("lastname");
        registerOutDto.setGender(Gender.Male);
        registerOutDto.setEmail("test@nucleusteq.com");
        registerOutDto.setDesignation(Designation.Intern);
        registerOutDto.setContactNumber("1234567890");
        registerOutDto.setRole(Role.Employee);

        // Check if values can be retrieved using getters
        assertEquals("firstname", registerOutDto.getFirstName());
        assertEquals("lastname", registerOutDto.getLastName());
        assertEquals(Gender.Male, registerOutDto.getGender());
        assertEquals("test@nucleusteq.com", registerOutDto.getEmail());
        assertEquals(Designation.Intern, registerOutDto.getDesignation());
        assertEquals("1234567890", registerOutDto.getContactNumber());
        assertEquals(Role.Employee, registerOutDto.getRole());
    }

    @Test
    void testConstructor() {
        // Create a RegisterOutDto object using the constructor
        RegisterOutDto registerOutDto = new RegisterOutDto("id", "firstname", "lastname", Gender.Male,
                "test@nucleusteq.com", Designation.Intern, "1234567890", Role.Employee);

        // Check if values can be retrieved using getters
        assertEquals("id", registerOutDto.getId());
        assertEquals("firstname", registerOutDto.getFirstName());
        assertEquals("lastname", registerOutDto.getLastName());
        assertEquals(Gender.Male, registerOutDto.getGender());
        assertEquals("test@nucleusteq.com", registerOutDto.getEmail());
        assertEquals(Designation.Intern, registerOutDto.getDesignation());
        assertEquals("1234567890", registerOutDto.getContactNumber());
        assertEquals(Role.Employee, registerOutDto.getRole());
    }
}
