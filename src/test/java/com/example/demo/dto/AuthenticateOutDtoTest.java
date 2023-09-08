package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;


public class AuthenticateOutDtoTest {

		/**
		 * instance of AuthenticateOutDto.
		 */
    private AuthenticateOutDto dto;

    /**
     * Sets up something before testing.
     */
    @BeforeEach
    public void setUp() {
        // Initialize a new AuthenticateOutDto object before each test
        dto = new AuthenticateOutDto("id",
                "firstname", "lastname", Gender.Male, "test@nucleusteq.com",
                Designation.Intern, "1234567890", Role.Admin
        );
    }

    /**
     * Setter and Getter testing.
     */
    @Test
    public void testGetterAndSetterMethods() {
        // Modify values using setter methods
        dto.setFirstName("firstname");
        dto.setLastName("lastname");
        dto.setGender(Gender.Female);
        dto.setEmail("test@nucleusteq.com");
        dto.setDesignation(Designation.DataAnalyst);
        dto.setContactNumber("1234567890");
        dto.setRole(Role.Employee);

        // Test getter methods to ensure they return the modified values
        assertEquals("firstname", dto.getFirstName());
        assertEquals("lastname", dto.getLastName());
        assertEquals(Gender.Female, dto.getGender());
        assertEquals("test@nucleusteq.com", dto.getEmail());
        assertEquals(Designation.DataAnalyst, dto.getDesignation());
        assertEquals("1234567890", dto.getContactNumber());
        assertEquals(Role.Employee, dto.getRole());
    }

    /**
     * hashcode method testing.
     */
    @Test
    public void testHashCode() {
        // Create another AuthenticateOutDto object with the same values
        AuthenticateOutDto anotherDto = new AuthenticateOutDto(
        				"id", "firstname", "lastname", Gender.Male, "test@nucleusteq.com",
                Designation.Intern, "1234567890", Role.Admin
        );

        // Test hashCode
        assertEquals(dto.hashCode(), anotherDto.hashCode());
    }

    /**
     * equals method testing.
     */
    @Test
    public void testEquals() {
        // Create another AuthenticateOutDto object with the same values
        AuthenticateOutDto anotherDto = new AuthenticateOutDto(
                "id", "firstname", "lastname", Gender.Male, "test@nucleusteq.com",
                Designation.Intern, "1234567890", Role.Admin
        );

        // Test equals
        assertTrue(dto.equals(anotherDto));
    }
    /**
     * tostring method Testing.
     */
    @Test
    public void testToString() {
        // Test toString
        assertEquals("AuthenticateOutDto [id=id, firstName=firstname, lastName=lastname, gender=Male, email=test@nucleusteq.com, "
        + "designation=Intern, contactNumber=1234567890, role=Admin]", dto.toString());
    }
}
