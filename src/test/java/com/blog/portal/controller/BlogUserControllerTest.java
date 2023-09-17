package com.blog.portal.controller;
//CHECKSTYLE:OFF
import static org.mockito.Mockito.*;

import com.blog.portal.controller.BlogUserController;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;
import com.blog.portal.services.BlogUserService;
import com.blog.portal.messagePayloads.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BlogUserControllerTest {

  @InjectMocks
  private BlogUserController blogUserController;

  @Mock
  private BlogUserService blogUserService;

  @BeforeEach
  public void setUp() {
      MockitoAnnotations.initMocks(this);
  }


    @Test
    public void testRegisterUser() throws MethodArgumentNotValidException {
        // Create a sample RegisterUserInDto
        RegisterUserInDto userInDto = new RegisterUserInDto(
                "firstname",
                "lastname",
                Gender.Male, // Fill in with a valid gender enum value
                "test@nucleusteq.com",
                "password123",
                Designation.Intern, // Fill in with a valid designation enum value
                "1234567890" // Replace with a valid contact number
        );

        // Mock the behavior of your service method
        ApiResponse apiResponse = new ApiResponse("User registered successfully", true);
        when(blogUserService.createUser(any(RegisterUserInDto.class))).thenReturn(apiResponse);

        // Invoke the controller method
        ResponseEntity<ApiResponse> responseEntity = blogUserController.registerUser(userInDto);

        // Verify that the response status code is HttpStatus.CREATED
        assert(responseEntity.getStatusCode() == HttpStatus.CREATED);
        // You can add more assertions based on the expected ApiResponse
    }

    @Test
    public void testAuthenticateUser() {
        // Create a sample AuthenticateUserInDto
        AuthenticateUserInDto authenticateUserInDto = new AuthenticateUserInDto(
                "user@example.com",
                "password123"
        );

        // Mock the behavior of your service method
        AuthenticateUserOutDto authenticateUserOutDto = new AuthenticateUserOutDto(
                "123", // Replace with a valid user ID
                "firstname",
                "lastname",
                Gender.Male, // Fill in with a valid gender enum value
                "test@nucleusteq.com",
                Designation.Intern, // Fill in with a valid designation enum value
                "1234567890", // Replace with a valid contact number
                Role.Employee // Fill in with a valid role enum value
        );
        when(blogUserService.authenticateUser(any(AuthenticateUserInDto.class))).thenReturn(authenticateUserOutDto);

        // Invoke the controller method
        ResponseEntity<AuthenticateUserOutDto> responseEntity = blogUserController.authenticate(authenticateUserInDto);

        // Verify that the response status code is HttpStatus.OK
        assert(responseEntity.getStatusCode() == HttpStatus.OK);
        // You can add more assertions based on the expected AuthenticateUserOutDto
    }

    @Test
    public void testEncoder() {
        // Create an instance of the controller
        BlogUserController controller = new BlogUserController();
        String password = "password123"; // Replace with the password you want to encode
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        String p1= Base64.getEncoder().encodeToString(passwordBytes);
        String encodedPassword = controller.encoder(password);
        assert(p1.equals(encodedPassword));
    }
    
    
    
    
}
