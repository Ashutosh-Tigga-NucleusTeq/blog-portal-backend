package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.blog.portal.entities.User;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;
import com.blog.portal.requestPayload.UserInDTO;
import com.blog.portal.responsePayload.UserOutDTO;

public class AuthenticateUserMapperTest {


    @Test
    public void testInDtoToUser() {
        UserInDTO inDto = new UserInDTO();
        inDto.setEmail("test@nucleusteq.com");
        inDto.setPassword("password");

        User user = AuthenticateUserMapper.inDtoToUser(inDto);

        assertEquals("test@nucleusteq.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }


    @Test
    public void testUserToOutDto() {
        User user = new User();
        user.setId("1");
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setGender(Gender.MALE);
        user.setEmail("firstnamelastname@example.com");
        user.setDesignation(Designation.INTERN);
        user.setContactNumber("1234567890");
        user.setRole(Role.ADMIN);

        UserOutDTO outDto = AuthenticateUserMapper.userToOutDto(user);

        assertEquals("1", outDto.getId());
        assertEquals("firstname", outDto.getFirstName());
        assertEquals("lastname", outDto.getLastName());
        assertEquals(Gender.MALE, outDto.getGender());
        assertEquals("firstnamelastname@example.com", outDto.getEmail());
        assertEquals(Designation.INTERN, outDto.getDesignation());
        assertEquals("1234567890", outDto.getContactNumber());
        assertEquals(Role.ADMIN, outDto.getRole());
    }
}
