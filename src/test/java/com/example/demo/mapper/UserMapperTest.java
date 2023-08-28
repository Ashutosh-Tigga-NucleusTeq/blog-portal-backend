package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

    @Test
    public void testMapToUserDto() {
        // Create a User object
        User user = new User(
            "Ashu123",
            "ashu",
            "tigga",
            "Male",
            "ashu@gmail.com",
            "1234",
            "Developer",
            "1234567890",
            "admin"
        );

        // Map User to UserDto
        UserDto userDto = UserMapper.mapToUserDto(user);

        // Assert that the mapped UserDto matches the original User
        assertEquals(user.getUserName(), userDto.getUserName());
        assertEquals(user.getUserFirstName(), userDto.getUserFirstName());
        assertEquals(user.getUserLastName(), userDto.getUserLastName());
        assertEquals(user.getUserGender(), userDto.getUserGender());
        assertEquals(user.getUserEmail(), userDto.getUserEmail());
        assertEquals(user.getUserPassword(), userDto.getUserPassword());
        assertEquals(user.getUserDesignation(), userDto.getUserDesignation());
        assertEquals(user.getUserContactNumber(), userDto.getUserContactNumber());
        assertEquals(user.getUserRole(), userDto.getUserRole());
    }

    @Test
    public void testMapToUser() {
        // Create a UserDto object
        UserDto userDto = new UserDto(
        		"Ashu123",
            "ashu",
            "tigga",
            "Male",
            "ashu@gmail.com",
            "1234",
            "Developer",
            "1234567890",
            "admin"
        );

        // Map UserDto to User
        User user = UserMapper.mapToUser(userDto);

        // Assert that the mapped User matches the original UserDto
        assertEquals(userDto.getUserName(), user.getUserName());
        assertEquals(userDto.getUserFirstName(), user.getUserFirstName());
        assertEquals(userDto.getUserLastName(), user.getUserLastName());
        assertEquals(userDto.getUserGender(), user.getUserGender());
        assertEquals(userDto.getUserEmail(), user.getUserEmail());
        assertEquals(userDto.getUserPassword(), user.getUserPassword());
        assertEquals(userDto.getUserDesignation(), user.getUserDesignation());
        assertEquals(userDto.getUserContactNumber(), user.getUserContactNumber());
        assertEquals(userDto.getUserRole(), user.getUserRole());
    }
}
