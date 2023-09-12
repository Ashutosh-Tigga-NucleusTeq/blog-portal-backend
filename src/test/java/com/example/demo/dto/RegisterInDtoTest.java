package com.example.demo.dto;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterInDtoTest {
		/**
		 * Instance of RegisterInDto.
		 */
    private RegisterInDto registerInDto;

    /**
     * Setting values before calling test.
     */
    @BeforeEach
    public void setUp() {
        registerInDto = new RegisterInDto();
        registerInDto.setFirstName("firstname");
        registerInDto.setLastName("lastname");
        registerInDto.setGender(Gender.Male);
        registerInDto.setEmail("test@nucleusteq.com");
        registerInDto.setPassword("password");
        registerInDto.setDesignation(Designation.Intern);
        registerInDto.setContactNumber("1234567890");

    }

    /**
     * Testing of setter and getter.
     */
    @Test
    public void testGettersAndSetters() {


      assertEquals("firstname", registerInDto.getFirstName());
      assertEquals("lastname", registerInDto.getLastName());
      assertEquals(Gender.Male, registerInDto.getGender());
      assertEquals("test@nucleusteq.com", registerInDto.getEmail());
      assertEquals("password", registerInDto.getPassword());
      assertEquals(Designation.Intern, registerInDto.getDesignation());
      assertEquals("1234567890", registerInDto.getContactNumber());
        // Test setters
        registerInDto.setFirstName("firstname1");
        registerInDto.setLastName("lastname1");
        registerInDto.setGender(Gender.Female);
        registerInDto.setEmail("test1@nucleusteq.com");
        registerInDto.setPassword("password1");
        registerInDto.setDesignation(Designation.Intern);
        registerInDto.setContactNumber("1234675894");

        assertEquals("firstname1", registerInDto.getFirstName());
        assertEquals("lastname1", registerInDto.getLastName());
        assertEquals(Gender.Female, registerInDto.getGender());
        assertEquals("test1@nucleusteq.com", registerInDto.getEmail());
        assertEquals("password1", registerInDto.getPassword());
        assertEquals(Designation.Intern, registerInDto.getDesignation());
        assertEquals("1234675894", registerInDto.getContactNumber());
    }

    /**
     * Testing of hashcode and equals.
     */
    @Test
    public void testHashCodeAndEquals() {
        RegisterInDto sameDto = new RegisterInDto();
        sameDto.setFirstName("firstname");
        sameDto.setLastName("lastname");
        sameDto.setGender(Gender.Male);
        sameDto.setEmail("test@nucleusteq.com");
        sameDto.setPassword("password");
        sameDto.setDesignation(Designation.Intern);
        sameDto.setContactNumber("1234567890");

        RegisterInDto differentDto = new RegisterInDto();
        differentDto.setFirstName("firstname1");
        differentDto.setLastName("lastname1");
        differentDto.setGender(Gender.Female);
        differentDto.setEmail("test1@nucleusteq.com");
        differentDto.setPassword("newpassword");
        differentDto.setDesignation(Designation.Intern);
        differentDto.setContactNumber("1876543210");

        assertEquals(registerInDto.hashCode(), sameDto.hashCode());
        assertNotEquals(registerInDto.hashCode(), differentDto.hashCode());

        assertTrue(registerInDto.equals(sameDto));
        assertFalse(registerInDto.equals(differentDto));
    }

    /**
     * Tesing of toString method.
     */
    @Test
    public void testToString() {
        String expectedToString = "RegisterInDto [firstName=" + registerInDto.getFirstName() + ","
        		+ " lastName=" + registerInDto.getLastName() + ","
        		+ " gender=" + registerInDto.getGender() + ","
        		+ " email=" + registerInDto.getEmail() + ","
        		+ " password=" + registerInDto.getPassword() + ","
        		+ " designation=" + registerInDto.getDesignation() + ","
        		+ " contactNumber=" + registerInDto.getContactNumber() + "]";
        assertEquals(expectedToString, registerInDto.toString());
    }
}
