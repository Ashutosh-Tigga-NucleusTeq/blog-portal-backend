package com.example.demo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.dto.RegisterInDto;
import com.example.demo.dto.RegisterOutDto;
import com.example.demo.model.User;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

public class RegisterMapperTest {

		/**
		 * Testing of InDto to Entity method.
		 */
    @Test
    public void testInDtoToUser() {
        RegisterInDto inDto = new RegisterInDto();
        inDto.setFirstName("John");
        inDto.setLastName("Doe");
        inDto.setGender(Gender.Male);
        inDto.setEmail("john.doe@example.com");
        inDto.setPassword("password123");
        inDto.setDesignation(Designation.Intern);
        inDto.setContactNumber("1234567890");
        inDto.setRole(Role.Admin);

        User user = RegisterMapper.inDtoToUser(inDto);

        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(Gender.Male, user.getGender());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(Designation.Intern, user.getDesignation());
        assertEquals("1234567890", user.getContactNumber());
        assertEquals(Role.Admin, user.getRole());
    }

    /**
     * testing of Entity to OutDto method.
     */
    @Test
    public void testUserToOutDto() {
        User user = new User("John", "Doe", Gender.Male, "john.doe@example.com", "password123",
                Designation.Intern, "1234567890", Role.Admin);

        RegisterOutDto outDto = RegisterMapper.userToOutDto(user);

        assertEquals("John", outDto.getFirstName());
        assertEquals("Doe", outDto.getLastName());
        assertEquals(Gender.Male, outDto.getGender());
        assertEquals("john.doe@example.com", outDto.getEmail());
        assertEquals(Designation.Intern, outDto.getDesignation());
        assertEquals("1234567890", outDto.getContactNumber());
        assertEquals(Role.Admin, outDto.getRole());
    }
}
