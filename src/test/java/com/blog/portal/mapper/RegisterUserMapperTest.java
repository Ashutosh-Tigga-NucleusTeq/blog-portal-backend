package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.blog.portal.entities.User;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.RegisterUserOutDto;

public class RegisterUserMapperTest {

	/**
	 * Testing inDtoToUser method.
	 */
    @Test
    public void testInDtoToUser() {
        // Create a RegisterUserInDto for testing
        RegisterUserInDto inDto = new RegisterUserInDto();
        inDto.setFirstName("firstname");
        inDto.setLastName("lastname");
        inDto.setGender(Gender.Male);
        inDto.setEmail("test@nucleusteq.com");
        inDto.setPassword("password123");
        inDto.setDesignation(Designation.Intern);
        inDto.setContactNumber("1234567890");

        // Call the inDtoToUser method
        User user = RegisterUserMapper.inDtoToUser(inDto);

        // Check if the User object is created with the correct values
        assertEquals("firstname", user.getFirstName());
        assertEquals("lastname", user.getLastName());
        assertEquals(Gender.Male, user.getGender());
        assertEquals("test@nucleusteq.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(Designation.Intern, user.getDesignation());
        assertEquals("1234567890", user.getContactNumber());
    }

    /**
     * Testing User to OutDto method.
     */
    @Test
    public void testUserToOutDto() {
        // Create a User object for testing
        User user = new User();
        user.setId("user123");
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setGender(Gender.Male);
        user.setEmail("test@nucleusteq.com");
        user.setDesignation(Designation.Intern);
        user.setContactNumber("1234567890");

        // Call the userToOutDto method
        RegisterUserOutDto outDto = RegisterUserMapper.userToOutDto(user);

        // Check if the RegisterUserOutDto object is created with the correct values
        assertEquals("user123", outDto.getId());
        assertEquals("firstname", outDto.getFirstName());
        assertEquals("lastname", outDto.getLastName());
        assertEquals(Gender.Male, outDto.getGender());
        assertEquals("test@nucleusteq.com", outDto.getEmail());
        assertEquals(Designation.Intern, outDto.getDesignation());
        assertEquals("1234567890", outDto.getContactNumber());
    }
}
