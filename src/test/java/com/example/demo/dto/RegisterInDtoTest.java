package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

public class RegisterInDtoTest {

    @Test
    void testGettersAndSetters() {
        // Create a RegisterInDto object
        RegisterInDto registerInDto = new RegisterInDto();

        // Set values using setters
        registerInDto.setFirstName("John");
        registerInDto.setLastName("Doe");
        registerInDto.setGender(Gender.Male);
        registerInDto.setEmail("john.doe@example.com");
        registerInDto.setPassword("password");
        registerInDto.setDesignation(Designation.Intern);
        registerInDto.setContactNumber("1234567890");
        registerInDto.setRole(Role.Admin);

        // Check if values can be retrieved using getters
        assertEquals("John", registerInDto.getFirstName());
        assertEquals("Doe", registerInDto.getLastName());
        assertEquals(Gender.Male, registerInDto.getGender());
        assertEquals("john.doe@example.com", registerInDto.getEmail());
        assertEquals("password", registerInDto.getPassword());
        assertEquals(Designation.Intern, registerInDto.getDesignation());
        assertEquals("1234567890", registerInDto.getContactNumber());
        assertEquals(Role.Admin, registerInDto.getRole());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two RegisterInDto objects with the same values
        RegisterInDto registerInDto1 = new RegisterInDto();
        registerInDto1.setFirstName("John");
        registerInDto1.setLastName("Doe");
        registerInDto1.setGender(Gender.Female);
        registerInDto1.setEmail("john.doe@example.com");
        registerInDto1.setPassword("password");
        registerInDto1.setDesignation(Designation.Intern);
        registerInDto1.setContactNumber("1234567890");
        registerInDto1.setRole(Role.Employee);

        RegisterInDto registerInDto2 = new RegisterInDto();
        registerInDto2.setFirstName("John");
        registerInDto2.setLastName("Doe");
        registerInDto2.setGender(Gender.Female);
        registerInDto2.setEmail("john.doe@example.com");
        registerInDto2.setPassword("password");
        registerInDto2.setDesignation(Designation.Intern);
        registerInDto2.setContactNumber("1234567890");
        registerInDto2.setRole(Role.Employee);

        // Check if the two objects are equal
        assertTrue(registerInDto1.equals(registerInDto2));
        assertTrue(registerInDto2.equals(registerInDto1));

        // Check their hash codes
        assertEquals(registerInDto1.hashCode(), registerInDto2.hashCode());
    }

    @Test
    void testToString() {
        // Create a RegisterInDto object and set values
        RegisterInDto registerInDto = new RegisterInDto();
        registerInDto.setFirstName("firstname");
        registerInDto.setLastName("lastname");
        registerInDto.setGender(Gender.Male);
        registerInDto.setEmail("test@nucleusteq.com");
        registerInDto.setPassword("password");
        registerInDto.setDesignation(Designation.Intern);
        registerInDto.setContactNumber("1234567890");
        registerInDto.setRole(Role.Employee);

        // Define the expected string representation
        String expectedToString = "RegisterInDto [nameMinSize=4,"
        		+ " firstName=firstname,"
        		+ " lastName=lastname,"
        		+ " gender=Male,"
        		+ " email=test@nucleusteq.com,"
        		+ " passwordSize=6,"
        		+ " password=password,"
        		+ " designation=Intern,"
        		+ " contactNumber=1234567890,"
        		+ " role=Employee]";

        // Check if toString returns the expected string
        assertEquals(expectedToString, registerInDto.toString());
    }
}
