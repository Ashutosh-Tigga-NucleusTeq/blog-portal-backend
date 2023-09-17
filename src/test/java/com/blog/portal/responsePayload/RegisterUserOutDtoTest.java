package com.blog.portal.responsePayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;


public class RegisterUserOutDtoTest {
		/**
		 * Testing default constructor.
		 */
    @Test
    public void testDefaultConstructor() {
        RegisterUserOutDto dto = new RegisterUserOutDto();
        assertNull(dto.getId());
        assertNull(dto.getFirstName());
        assertNull(dto.getLastName());
        assertNull(dto.getGender());
        assertNull(dto.getEmail());
        assertNull(dto.getDesignation());
        assertNull(dto.getContactNumber());
        assertNull(dto.getRole());
    }
    /**
     * Testing parameterized constructor.
     */
    @Test
    public void testParameterizedConstructor() {
        RegisterUserOutDto dto = new RegisterUserOutDto("1", "firstname",
        		"lastname", Gender.Male, "firstname.lastname@nucleusteq.com",
                Designation.DevopsEngineer, "1234567890", Role.Employee);

        assertEquals("1", dto.getId());
        assertEquals("firstname", dto.getFirstName());
        assertEquals("lastname", dto.getLastName());
        assertEquals(Gender.Male, dto.getGender());
        assertEquals("firstname.lastname@nucleusteq.com", dto.getEmail());
        assertEquals(Designation.DevopsEngineer, dto.getDesignation());
        assertEquals("1234567890", dto.getContactNumber());
        assertEquals(Role.Employee, dto.getRole());
    }
    /**
     * Testing Setter and Getter.
     */
    @Test
    public void testSetterAndGetterMethods() {
        RegisterUserOutDto dto = new RegisterUserOutDto();
        dto.setId("2");
        dto.setFirstName("fname");
        dto.setLastName("lname");
        dto.setGender(Gender.Female);
        dto.setEmail("fname.lname@nucleusteq.com");
        dto.setDesignation(Designation.Architect);
        dto.setContactNumber("9876543210");
        dto.setRole(Role.Admin);

        assertEquals("2", dto.getId());
        assertEquals("fname", dto.getFirstName());
        assertEquals("lname", dto.getLastName());
        assertEquals(Gender.Female, dto.getGender());
        assertEquals("fname.lname@nucleusteq.com", dto.getEmail());
        assertEquals(Designation.Architect, dto.getDesignation());
        assertEquals("9876543210", dto.getContactNumber());
        assertEquals(Role.Admin, dto.getRole());
    }

    /**
     * Testing hashcode and equals.
     */
    @Test
    public void testHashCodeAndEquals() {
        RegisterUserOutDto dto1 = new RegisterUserOutDto("1",
        		"firstname", "lastname", Gender.Male, "firstname.lastname@nucleusteq.com",
                Designation.DevopsEngineer, "1234567890", Role.Employee);
        RegisterUserOutDto dto2 = new RegisterUserOutDto("1",
        		"firstname", "lastname", Gender.Male, "firstname.lastname@nucleusteq.com",
                Designation.DevopsEngineer, "1234567890", Role.Employee);
        RegisterUserOutDto dto3 = new RegisterUserOutDto("2", "fname", "lname", Gender.Female, "fname.lname@nucleusteq.com",
                Designation.Architect, "9876543210", Role.Admin);

        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
    }

    /**
     * Testing tostring.
     */
    @Test
    public void testToString() {
        RegisterUserOutDto dto = new RegisterUserOutDto("1", "firstname",
        		"lastname", Gender.Male, "firstname.lastname@nucleusteq.com",
                Designation.DevopsEngineer, "1234567890", Role.Employee);

        String expectedString = "RegisterOutDto [id=1, firstName=firstname, lastName=lastname, gender=Male,"
        		+ " email=firstname.lastname@nucleusteq.com, designation=DevopsEngineer,"
        		+ " contactNumber=1234567890, role=Employee]";
        assertEquals(expectedString, dto.toString());
    }
}
