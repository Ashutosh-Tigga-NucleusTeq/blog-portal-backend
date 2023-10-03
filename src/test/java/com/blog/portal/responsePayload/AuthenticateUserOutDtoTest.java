package com.blog.portal.responsePayload;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticateUserOutDtoTest {

    private AuthenticateUserOutDto user1;
    private AuthenticateUserOutDto user2;
    private AuthenticateUserOutDto user3;

    @BeforeEach
    public void setUp() {
        user1 = new AuthenticateUserOutDto("1", "firstname", "lastname", Gender.MALE, "firstname@example.com", Designation.INTERN, "1234567890", Role.EMPLOYEE);
        user2 = new AuthenticateUserOutDto("2", "anotherfirstname", "anotherlastname", Gender.FEMALE, "anotherfirstname@example.com", Designation.HR, "9876543210", Role.ADMIN);
        user3 = new AuthenticateUserOutDto("1", "firstname", "lastname", Gender.MALE, "firstname@example.com", Designation.INTERN, "1234567890", Role.EMPLOYEE);
    }


    @Test
    public void testConstructors() {
        assertEquals("1", user1.getId());
        assertEquals("firstname", user1.getFirstName());
        assertEquals("lastname", user1.getLastName());
        assertEquals(Gender.MALE, user1.getGender());
        assertEquals("firstname@example.com", user1.getEmail());
        assertEquals(Designation.INTERN, user1.getDesignation());
        assertEquals("1234567890", user1.getContactNumber());
        assertEquals(Role.EMPLOYEE, user1.getRole());

        AuthenticateUserOutDto defaultUser = new AuthenticateUserOutDto();
        assertNull(defaultUser.getId());
        assertNull(defaultUser.getFirstName());
        assertNull(defaultUser.getLastName());
        assertNull(defaultUser.getGender());
        assertNull(defaultUser.getEmail());
        assertNull(defaultUser.getDesignation());
        assertNull(defaultUser.getContactNumber());
        assertNull(defaultUser.getRole());
    }
    
    @Test
    public void testGettersAndSetters() {
        assertEquals("1", user1.getId());
        assertEquals("firstname", user1.getFirstName());
        assertEquals("lastname", user1.getLastName());
        assertEquals(Gender.MALE, user1.getGender());
        assertEquals("firstname@example.com", user1.getEmail());
        assertEquals(Designation.INTERN, user1.getDesignation());
        assertEquals("1234567890", user1.getContactNumber());
        assertEquals(Role.EMPLOYEE, user1.getRole());

        user1.setId("3");
        user1.setFirstName("anotherfirstname");
        user1.setLastName("anotherlastname");
        user1.setGender(Gender.FEMALE);
        user1.setEmail("anotherfirstname@example.com");
        user1.setDesignation(Designation.HR);
        user1.setContactNumber("9876543210");
        user1.setRole(Role.ADMIN);

        assertEquals("3", user1.getId());
        assertEquals("anotherfirstname", user1.getFirstName());
        assertEquals("anotherlastname", user1.getLastName());
        assertEquals(Gender.FEMALE, user1.getGender());
        assertEquals("anotherfirstname@example.com", user1.getEmail());
        assertEquals(Designation.HR, user1.getDesignation());
        assertEquals("9876543210", user1.getContactNumber());
        assertEquals(Role.ADMIN, user1.getRole());
    }

    @Test
    public void testEqualsAndHashCode() {
        assertTrue(user1.equals(user1));
        assertEquals(user1.hashCode(), user1.hashCode());

        assertTrue(user1.equals(user3));
        assertTrue(user3.equals(user1));
        assertEquals(user1.hashCode(), user3.hashCode());

        assertFalse(user1.equals(null));
        assertFalse(user1.equals("string"));

        assertFalse(user1.equals(user2));
        assertFalse(user2.equals(user1));
        assertNotEquals(user1.hashCode(), user2.hashCode());

        user2.setEmail("different@example.com");
        assertFalse(user1.equals(user2));
    }

    @Test
    public void testToString() {
        String expectedToString = "AuthenticateOutDto [id=1, firstName=firstname, lastName=lastname, gender=MALE, " +
                "email=firstname@example.com, designation=INTERN, contactNumber=1234567890, role=EMPLOYEE]";
        assertEquals(expectedToString, user1.toString());
    }
}
