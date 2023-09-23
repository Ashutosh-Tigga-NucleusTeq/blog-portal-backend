package com.blog.portal.responsePayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;

public class AuthenticateUserOutDtoTest {
	/**
	 * Instance of AuthenticateUserOutDto.
	 */
    private AuthenticateUserOutDto user1;
    /**
  	 * Instance of AuthenticateUserOutDto.
  	 */
    private AuthenticateUserOutDto user2;
    /**
  	 * Instance of AuthenticateUserOutDto.
  	 */
    private AuthenticateUserOutDto user3;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        user1 = new AuthenticateUserOutDto("1", "John", "Doe", Gender.Male, "john@example.com",
                Designation.Intern, "1234567890", Role.Employee);
        user2 = new AuthenticateUserOutDto("2", "Jane", "Smith", Gender.Female, "jane@example.com",
                Designation.DataAnalyst, "9876543210", Role.Admin);
        user3 = new AuthenticateUserOutDto("1", "John", "Doe", Gender.Male, "john@example.com",
                Designation.Intern, "1234567890", Role.Employee);
    }

    /**
     * Testing of tostring.
     */
    @Test
    public void testToString() {
        assertEquals("AuthenticateOutDto [id=1, firstName=John, lastName=Doe,"
        		+ " gender=Male, email=john@example.com, designation=Intern, contactNumber=1234567890,"
        		+ " role=Employee]", user1.toString());
    }

    /**
     * Testing of HashCode.
     */
    @Test
    public void testHashCode() {
        assertEquals(user1.hashCode(), user3.hashCode());
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    /**
     * Testing equals.
     */
    @Test
    public void testEquals() {
        assertTrue(user1.equals(user3));
        assertTrue(user3.equals(user1));
        assertNotEquals(user1, user2);
        assertNotEquals(user2, user1);
    }
}
