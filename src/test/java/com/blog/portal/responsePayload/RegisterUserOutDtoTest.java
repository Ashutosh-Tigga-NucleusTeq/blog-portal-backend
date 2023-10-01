package com.blog.portal.responsePayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;


public class RegisterUserOutDtoTest {
		
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

    @Test
    public void testParameterizedConstructor() {
        RegisterUserOutDto dto = new RegisterUserOutDto("1", "firstname",
        		"lastname", Gender.MALE, "firstname.lastname@nucleusteq.com",
                Designation.DEVOPS_ENGINEER, "1234567890", Role.EMPLOYEE);

        assertEquals("1", dto.getId());
        assertEquals("firstname", dto.getFirstName());
        assertEquals("lastname", dto.getLastName());
        assertEquals(Gender.MALE, dto.getGender());
        assertEquals("firstname.lastname@nucleusteq.com", dto.getEmail());
        assertEquals(Designation.DEVOPS_ENGINEER, dto.getDesignation());
        assertEquals("1234567890", dto.getContactNumber());
        assertEquals(Role.EMPLOYEE, dto.getRole());
    }

    @Test
    public void testSetterAndGetterMethods() {
        RegisterUserOutDto dto = new RegisterUserOutDto();
        dto.setId("2");
        dto.setFirstName("fname");
        dto.setLastName("lname");
        dto.setGender(Gender.FEMALE);
        dto.setEmail("fname.lname@nucleusteq.com");
        dto.setDesignation(Designation.ARCHITECT);
        dto.setContactNumber("9876543210");
        dto.setRole(Role.ADMIN);

        assertEquals("2", dto.getId());
        assertEquals("fname", dto.getFirstName());
        assertEquals("lname", dto.getLastName());
        assertEquals(Gender.FEMALE, dto.getGender());
        assertEquals("fname.lname@nucleusteq.com", dto.getEmail());
        assertEquals(Designation.ARCHITECT, dto.getDesignation());
        assertEquals("9876543210", dto.getContactNumber());
        assertEquals(Role.ADMIN, dto.getRole());
    }


    @Test
    public void testHashCodeAndEquals() {
        RegisterUserOutDto dto1 = new RegisterUserOutDto("1",
        		"firstname", "lastname", Gender.MALE, "firstname.lastname@nucleusteq.com",
                Designation.DEVOPS_ENGINEER, "1234567890", Role.EMPLOYEE);
        RegisterUserOutDto dto2 = new RegisterUserOutDto("1",
        		"firstname", "lastname", Gender.MALE, "firstname.lastname@nucleusteq.com",
                Designation.DEVOPS_ENGINEER, "1234567890", Role.EMPLOYEE);
        RegisterUserOutDto dto3 = new RegisterUserOutDto("2", "fname", "lname", Gender.FEMALE, "fname.lname@nucleusteq.com",
                Designation.ARCHITECT, "9876543210", Role.ADMIN);

        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
    }


    @Test
    public void testToString() {
        RegisterUserOutDto dto = new RegisterUserOutDto("1", "firstname",
        		"lastname", Gender.MALE, "firstname.lastname@nucleusteq.com",
                Designation.DEVOPS_ENGINEER, "1234567890", Role.EMPLOYEE);

        String expectedString = "RegisterOutDto [id=1, firstName=firstname, lastName=lastname, gender=MALE,"
        		+ " email=firstname.lastname@nucleusteq.com, designation=DEVOPS_ENGINEER,"
        		+ " contactNumber=1234567890, role=EMPLOYEE]";
        assertEquals(expectedString, dto.toString());
    }
}
