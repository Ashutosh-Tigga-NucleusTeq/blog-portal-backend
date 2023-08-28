package com.example.demo.controller;
import com.example.demo.dto.UserDto;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;
import com.example.demo.services.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    private static final Role Admin = null;

		@InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterAdminUser() throws MethodArgumentNotValidException {
        // Create a UserDto object for testing
        UserDto userDto = new UserDto("Ashu123", "Ashu", "Tigga", Gender.Male, "ashu@nucleusteq.com",
                "password123", Designation.Trainee_Engineer, "1234567890", Admin);

        // Mock the userService.createAdmin method
        when(userService.createUser(userDto)).thenReturn(userDto);

        // Call the registerAdminUser method
        ResponseEntity<UserDto> responseEntity = userController.registerUser(userDto);

        // Verify that userService.createAdmin was called with the correct userDto
        verify(userService, times(1)).createUser(userDto);

        // Check the response status code
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        // Check the response body
        UserDto savedUser = responseEntity.getBody();
        assertNotNull(savedUser);
        assertEquals("Ashu123", savedUser.getUserName());

    }

}
