package com.example.demo.controller;
import com.example.demo.dto.UserDto;
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

public class AdminUserControllerTest {

    @InjectMocks
    private UserController adminUserController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterAdminUser() throws MethodArgumentNotValidException {
        // Create a UserDto object for testing
        UserDto userDto = new UserDto("Ashu123", "Ashu", "Tigga", "Male", "ashu@nucleusteq.com",
                "password123", "Software Engineer", "1234567890", "Admin");

        // Mock the userService.createAdmin method
        when(userService.createAdmin(userDto)).thenReturn(userDto);

        // Call the registerAdminUser method
        ResponseEntity<UserDto> responseEntity = adminUserController.registerAdminUser(userDto);

        // Verify that userService.createAdmin was called with the correct userDto
        verify(userService, times(1)).createAdmin(userDto);

        // Check the response status code
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        // Check the response body
        UserDto savedUser = responseEntity.getBody();
        assertNotNull(savedUser);
        assertEquals("Ashu123", savedUser.getUserName());

    }

}
