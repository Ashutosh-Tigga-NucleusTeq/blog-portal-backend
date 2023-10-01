package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.blog.portal.entities.User;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.RegisterUserOutDto;

public class RegisterUserMapperTest {

    @Test
    public void testInDtoToUser() {
        RegisterUserInDto inDto = new RegisterUserInDto();
        inDto.setFirstName("firstname");
        inDto.setLastName("lastname");
        inDto.setGender(Gender.MALE);
        inDto.setEmail("test@nucleusteq.com");
        inDto.setPassword("password123");
        inDto.setDesignation(Designation.INTERN);
        inDto.setContactNumber("1234567890");

        User user = RegisterUserMapper.inDtoToUser(inDto);

        assertEquals("Firstname", user.getFirstName());
        assertEquals("Lastname", user.getLastName());
        assertEquals(Gender.MALE, user.getGender());
        assertEquals("test@nucleusteq.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(Designation.INTERN, user.getDesignation());
        assertEquals("1234567890", user.getContactNumber());
    }

    @Test
    public void testUserToOutDto() {
        User user = new User();
        user.setId("user123");
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setGender(Gender.MALE);
        user.setEmail("test@nucleusteq.com");
        user.setDesignation(Designation.INTERN);
        user.setContactNumber("1234567890");

        RegisterUserOutDto outDto = RegisterUserMapper.userToOutDto(user);

        assertEquals("user123", outDto.getId());
        assertEquals("firstname", outDto.getFirstName());
        assertEquals("lastname", outDto.getLastName());
        assertEquals(Gender.MALE, outDto.getGender());
        assertEquals("test@nucleusteq.com", outDto.getEmail());
        assertEquals(Designation.INTERN, outDto.getDesignation());
        assertEquals("1234567890", outDto.getContactNumber());
    }
}
