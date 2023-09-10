package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;


/**
 * A JUnit test class for the AuthenticateOutDto class.
 */
public class AuthenticateOutDtoTest {

		/**
		 * Instance of {@code AuthenticateOutDto}.
		 */
    private AuthenticateOutDto authenticateOutDto;

    /**
     * Initializes a new instance of AuthenticateOutDto before each test.
     */
    @BeforeEach
    public void setUp() {
        authenticateOutDto = new AuthenticateOutDto();
    }

    /**
     * Test the getter and setter methods of AuthenticateOutDto.
     * This method sets various properties of the AuthenticateOutDto object and verifies
     * if the getter methods retrieve the expected values.
     */
    @Test
    public void testGetterSetterMethods() {
        // Test data
        String id = "12345";
        String firstName = "firstname";
        String lastName = "lastname";
        Gender gender = Gender.Male;
        String email = "test@nucleusteq.com";
        Designation designation = Designation.Intern;
        String contactNumber = "1234567890";
        Role role = Role.Employee;

        // Test setId and getId
        authenticateOutDto.setId(id);
        assertEquals(id, authenticateOutDto.getId());

        // Test setFirstName and getFirstName
        authenticateOutDto.setFirstName(firstName);
        assertEquals(firstName, authenticateOutDto.getFirstName());

        // Test setLastName and getLastName
        authenticateOutDto.setLastName(lastName);
        assertEquals(lastName, authenticateOutDto.getLastName());

        // Test setGender and getGender
        authenticateOutDto.setGender(gender);
        assertEquals(gender, authenticateOutDto.getGender());

        // Test setEmail and getEmail
        authenticateOutDto.setEmail(email);
        assertEquals(email, authenticateOutDto.getEmail());

        // Test setDesignation and getDesignation
        authenticateOutDto.setDesignation(designation);
        assertEquals(designation, authenticateOutDto.getDesignation());

        // Test setContactNumber and getContactNumber
        authenticateOutDto.setContactNumber(contactNumber);
        assertEquals(contactNumber, authenticateOutDto.getContactNumber());

        // Test setRole and getRole
        authenticateOutDto.setRole(role);
        assertEquals(role, authenticateOutDto.getRole());
    }

    /**
     * Test the equals and hashCode methods of AuthenticateOutDto.
     * This method creates AuthenticateOutDto objects with different data and verifies
     * if the equals method correctly identifies equal and unequal objects.
     * It also checks if the hashCode method produces consistent hash codes for equal objects.
     */
    @Test
    public void testEqualsAndHashCode() {
        AuthenticateOutDto dto1 = new AuthenticateOutDto("12345", "firstname", "lastname", Gender.Male,
                "test@nucleusteq.com", Designation.Intern, "1234567890", Role.Employee);
        AuthenticateOutDto dto2 = new AuthenticateOutDto("12345", "firstname", "lastname", Gender.Male,
                "test@nucleusteq.com", Designation.Intern, "1234567890", Role.Employee);
        AuthenticateOutDto dto3 = new AuthenticateOutDto("54321", "firstname1", "lastname1", Gender.Female,
                "test1@nucleusteq.com", Designation.Architect, "9876543210", Role.Admin);

        // Test equals method
        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);

        // Test hashCode method
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
    }

    /**
     * Test the toString method of AuthenticateOutDto.
     * This method creates an AuthenticateOutDto object and verifies if the toString
     * method returns the expected string representation of the object.
     */
    @Test
    public void testToString() {
        AuthenticateOutDto dto = new AuthenticateOutDto("12345", "firstname", "lastname", Gender.Male,
                "test@nucleusteq.com", Designation.Intern, "1234567890", Role.Employee);

        String expectedString = "AuthenticateOutDto [id=12345, firstName=firstname, lastName=lastname, gender=Male, "
        + "email=test@nucleusteq.com, designation=Intern, contactNumber=1234567890, role=Employee]";
        assertEquals(expectedString, dto.toString());
    }
}
