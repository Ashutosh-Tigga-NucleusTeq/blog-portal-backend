package com.example.demo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;
import com.example.demo.model.User;

public class AuthenticateMapperTest {

		/**
		 * testing inDto to Entity method.
		 */
    @Test
    public void testInDtoToUser() {
        AuthenticateInDto inDto = new AuthenticateInDto();
        inDto.setEmail("test@example.com");
        inDto.setPassword("password");

        User user = AuthenticateMapper.inDtoToUser(inDto);

        assertEquals("test@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }

    /**
     * tesing user to outDto method.
     */
    @Test
    public void testUserToOutDto() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setGender(Gender.Male);
        user.setEmail("johndoe@example.com");
        user.setDesignation(Designation.Intern);
        user.setContactNumber("1234567890");
        user.setRole(Role.Admin);

        AuthenticateOutDto outDto = AuthenticateMapper.userToOutDto(user);

        assertEquals("John", outDto.getFirstName());
        assertEquals("Doe", outDto.getLastName());
        assertEquals(Gender.Male, outDto.getGender());
        assertEquals("johndoe@example.com", outDto.getEmail());
        assertEquals(Designation.Intern, outDto.getDesignation());
        assertEquals("1234567890", outDto.getContactNumber());
        assertEquals(Role.Admin, outDto.getRole());
    }
}
