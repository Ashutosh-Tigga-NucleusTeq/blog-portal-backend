package com.example.demo.serviceImpl;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.serviceimpl.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepo userRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAdmin() {
        // Create a UserDto object for testing
        UserDto userDto = new UserDto("Ashu123", "ashu", "tigga", "Male", "ashu@gmail.com",
                "password123", "Software Engineer", "1234567890", "Admin");

        // Convert UserDto into User JPA Entity using UserMapper
        User userEntity = UserMapper.mapToUser(userDto);

        // Mock the userRepo.save method to return the user entity
        when(userRepo.save(any(User.class))).thenReturn(userEntity);

        // Call the createAdmin method
        UserDto savedUserDto = userServiceImpl.createAdmin(userDto);

        // Verify that userRepo.save was called with the correct user entity
        verify(userRepo, times(1)).save(any(User.class));

        // Check the returned UserDto
        assertNotNull(savedUserDto);
        assertEquals(savedUserDto, userDto);
        // Add more assertions for other properties if needed
    }
}
