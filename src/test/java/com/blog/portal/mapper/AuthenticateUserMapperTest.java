package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.blog.portal.entities.User;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;

public class AuthenticateUserMapperTest {

	/**
	 * Testing of inDto to entity.
	 */
    @Test
    public void testInDtoToUser() {
        // Arrange
        AuthenticateUserInDto inDto = new AuthenticateUserInDto();
        inDto.setEmail("test@nucleusteq.com");
        inDto.setPassword("password");

        // Act
        User user = AuthenticateUserMapper.inDtoToUser(inDto);

        // Assert
        assertEquals("test@nucleusteq.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }

    /**
     * Testing of Entity to outDto.
     */
    @Test
    public void testUserToOutDto() {
        // Arrange
        User user = new User();
        user.setId("1");
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setGender(Gender.Male);
        user.setEmail("firstnamelastname@example.com");
        user.setDesignation(Designation.Intern);
        user.setContactNumber("1234567890");
        user.setRole(Role.Admin);

        // Act
        AuthenticateUserOutDto outDto = AuthenticateUserMapper.userToOutDto(user);

        // Assert
        assertEquals("1", outDto.getId());
        assertEquals("firstname", outDto.getFirstName());
        assertEquals("lastname", outDto.getLastName());
        assertEquals(Gender.Male, outDto.getGender());
        assertEquals("firstnamelastname@example.com", outDto.getEmail());
        assertEquals(Designation.Intern, outDto.getDesignation());
        assertEquals("1234567890", outDto.getContactNumber());
        assertEquals(Role.Admin, outDto.getRole());
    }
}
