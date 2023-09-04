package com.example.demo.serviceImpl;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.UserRegistrationException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.serviceimpl.UserServiceImpl;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepo userRepo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser_Success() throws UserRegistrationException {
        // Prepare a RegisterDto
        RegisterDto userDto = new RegisterDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", "password", Designation.WebDeveloper, "1234567890",Role.Admin);

        // Mock the behavior of userRepo
        Mockito.when(userRepo.findById("test@nucleusteq.com")).thenReturn(Optional.empty());
        Mockito.when(userRepo.save(any(User.class))).thenReturn(UserMapper.mapRegistrationDtoToUser(userDto));

        // Call the createUser method
        RegisterDto savedUserDto = userService.createUser(userDto);

        // Verify the result
        assertNotNull(savedUserDto);
        assertEquals("firstname", savedUserDto.getUserFirstName());
        assertEquals("lastname", savedUserDto.getUserLastName());
        assertEquals(Gender.Male, savedUserDto.getUserGender());
        assertEquals("test@nucleusteq.com", savedUserDto.getUserEmail());
        assertEquals("password", savedUserDto.getUserPassword());
        assertEquals(Designation.WebDeveloper, savedUserDto.getUserDesignation());
        assertEquals("1234567890", savedUserDto.getUserContactNumber());
    }

    @Test
    public void testCreateUser_UserAlreadyExists() {
        // Prepare a RegisterDto
        RegisterDto userDto = new RegisterDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", "password", Designation.WebDeveloper, "1234567890",Role.Admin);

        // Mock the behavior of userRepo to return an existing user
        Mockito.when(userRepo.findById("test@nucleusteq.com")).thenReturn(Optional.of(UserMapper.mapRegistrationDtoToUser(userDto)));

        // Call the createUser method and expect a UserRegistrationException
        assertThrows(UserRegistrationException.class, () -> userService.createUser(userDto));
    }

    @Test
    public void testAuthenticateUser_Success() {
        // Prepare an AuthenticateInDto
        AuthenticateInDto inDto = new AuthenticateInDto("test@nucleusteq.com", "password");

        // Prepare a User entity
        User user = new User("firstname", "lastname", Gender.Male, "test@nucleusteq.com", "password", Designation.WebDeveloper, "1234567890");

        // Mock the behavior of userRepo to return the user
        Mockito.when(userRepo.findById("test@nucleusteq.com")).thenReturn(Optional.of(user));

        // Call the authenticateUser method
        AuthenticateOutDto outDto = userService.authenticateUser(inDto);

        // Verify the result
        assertNotNull(outDto);
        assertEquals("firstname", outDto.getUserFirstName());
        assertEquals("lastname", outDto.getUserLastName());
        assertEquals(Gender.Male, outDto.getUserGender());
        assertEquals("test@nucleusteq.com", outDto.getUserEmail());
        assertEquals(Designation.WebDeveloper, outDto.getUserDesgination());
        assertEquals("1234567890", outDto.getUserContactNumber());
    }

    @Test
    public void testAuthenticateUser_UserNotFound() {
        // Prepare an AuthenticateInDto
        AuthenticateInDto inDto = new AuthenticateInDto("test@nucleusteq.com", "password");

        // Mock the behavior of userRepo to return an empty Optional
        Mockito.when(userRepo.findById("test@nucleusteq.com")).thenReturn(Optional.empty());

        // Call the authenticateUser method and expect a ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> userService.authenticateUser(inDto));
    }

    @Test
    public void testAuthenticateUser_InvalidPassword() {
        // Prepare an AuthenticateInDto
        AuthenticateInDto inDto = new AuthenticateInDto("test@nucleusteq.com", "wrongpassword");

        // Prepare a User entity
        User user = new User("firstname", "lastname", Gender.Male, "test@nucleusteq.com", "password", Designation.WebDeveloper, "1234567890");

        // Mock the behavior of userRepo to return the user
        Mockito.when(userRepo.findById("test@nucleusteq.com")).thenReturn(Optional.of(user));

        // Call the authenticateUser method and expect a ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> userService.authenticateUser(inDto));
    }
}
