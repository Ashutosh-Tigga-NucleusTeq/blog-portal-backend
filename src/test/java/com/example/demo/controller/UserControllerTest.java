package com.example.demo.controller;

import com.example.demo.controller.UserController;
import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;
import com.example.demo.services.UserService;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Base64;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser_Success() throws MethodArgumentNotValidException {
        // Prepare a RegisterDto
        RegisterDto userDto = new RegisterDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", "password", Designation.WebDeveloper, "1234567890",Role.Admin);

        // Mock the behavior of userService
        when(userService.createUser(any(RegisterDto.class))).thenReturn(userDto);

        // Call the registerUser method
        ResponseEntity<RegisterDto> responseEntity = userController.registerUser(userDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        RegisterDto savedUserDto = responseEntity.getBody();
        assertEquals(userDto.getUserFirstName(), savedUserDto.getUserFirstName());
        assertEquals(userDto.getUserLastName(), savedUserDto.getUserLastName());
        assertEquals(userDto.getUserGender(), savedUserDto.getUserGender());
        assertEquals(userDto.getUserEmail(), savedUserDto.getUserEmail());
        assertEquals(encodePassword(userDto.getUserPassword()), savedUserDto.getUserPassword());
        assertEquals(userDto.getUserDesignation(), savedUserDto.getUserDesignation());
        assertEquals(userDto.getUserContactNumber(), savedUserDto.getUserContactNumber());
    }

    @Test
    public void testAuthenticate_Success() {
        // Prepare an AuthenticateInDto
        AuthenticateInDto inDto = new AuthenticateInDto("test@nucleusteq.com", "password");

        // Prepare a user from AuthenticateOutDto
        AuthenticateOutDto userDto = new AuthenticateOutDto("firstname", "lastname", Gender.Male, "test@nucleusteq.com", Designation.WebDeveloper, "1234567890");

        // Mock the behavior of userService
        when(userService.authenticateUser(any(AuthenticateInDto.class))).thenReturn(userDto);

        // Call the authenticate method
        ResponseEntity<AuthenticateOutDto> responseEntity = userController.authenticate(inDto);

        // Verify the result
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        AuthenticateOutDto authenticatedUser = responseEntity.getBody();
        assertEquals(userDto.getUserFirstName(), authenticatedUser.getUserFirstName());
        assertEquals(userDto.getUserLastName(), authenticatedUser.getUserLastName());
        assertEquals(userDto.getUserGender(), authenticatedUser.getUserGender());
        assertEquals(userDto.getUserEmail(), authenticatedUser.getUserEmail());
        assertEquals(userDto.getUserDesgination(), authenticatedUser.getUserDesgination());
        assertEquals(userDto.getUserContactNumber(), authenticatedUser.getUserContactNumber());
    }

    @Test
    public void testRegisterUser_InvalidData() throws MethodArgumentNotValidException {
        // Prepare an invalid RegisterDto with missing fields
        RegisterDto userDto = new RegisterDto();

        // Call the registerUser method with invalid data
        try {
            userController.registerUser(userDto);
        } catch (ValidationException e) {
            assertEquals("Validation failed for object='registerDto'. Error count: 6", e.getMessage());
        }
    }

    @Test
    public void testAuthenticate_InvalidData() {
        // Prepare an invalid AuthenticateInDto with missing fields
        AuthenticateInDto inDto = new AuthenticateInDto();

        // Call the authenticate method with invalid data
        try {
            userController.authenticate(inDto);
        } catch (ValidationException e) {
            assertEquals("Validation failed for object='inDto'. Error count: 2", e.getMessage());
        }
    }

    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(Objects.requireNonNull(password).getBytes());
    }
}
