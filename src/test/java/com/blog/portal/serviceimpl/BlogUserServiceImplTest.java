package com.blog.portal.serviceimpl;

import com.blog.portal.entities.User;
import com.blog.portal.exception.UserRegistrationException;
import com.blog.portal.mapper.AuthenticateUserMapper;
import com.blog.portal.mapper.RegisterUserMapper;
import com.blog.portal.messagePayloads.ApiResponse;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BlogUserServiceImplTest {

    @InjectMocks
    private BlogUserServiceImpl userService;

    @Mock
    private BlogUserRepo blogUserRepo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser_Success() throws UserRegistrationException {
        // Mock the behavior of blogUserRepo.findByEmail
        when(blogUserRepo.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());

        // Create a sample RegisterUserInDto
        RegisterUserInDto inputDto = new RegisterUserInDto();
        inputDto.setEmail("test@example.com");
        inputDto.setPassword("password");

        // Call the createUser method
        ApiResponse response = userService.createUser(inputDto);

        // Verify that the user was saved and the response is as expected
        verify(blogUserRepo, times(1)).save(any(User.class));
        assertTrue(response.isSuccess());
        assertEquals("User Registered Succesfully", response.getMessage());
    }

    @Test
    public void testCreateUser_UserAlreadyExists() {
        // Mock the behavior of blogUserRepo.findByEmail to return a user
        when(blogUserRepo.findByEmail(Mockito.anyString())).thenReturn(Optional.of(new User()));

        // Create a sample RegisterUserInDto
        RegisterUserInDto inputDto = new RegisterUserInDto();
        inputDto.setEmail("test@example.com");
        inputDto.setPassword("password");

        // Call the createUser method and expect a UserRegistrationException
        assertThrows(UserRegistrationException.class, () -> userService.createUser(inputDto));

        // Verify that the user was not saved
        verify(blogUserRepo, never()).save(any(User.class));
    }

    @Test
    public void testAuthenticateUser_Success() {
        // Mock the behavior of blogUserRepo.findByEmail to return a user
        User mockUser = new User();
        mockUser.setEmail("test@example.com");
        mockUser.setPassword("password");
        when(blogUserRepo.findByEmail(Mockito.anyString())).thenReturn(Optional.of(mockUser));

        // Create a sample AuthenticateUserInDto
        AuthenticateUserInDto inputDto = new AuthenticateUserInDto();
        inputDto.setEmail("test@example.com");
        inputDto.setPassword("password");

        // Call the authenticateUser method
        AuthenticateUserOutDto outDto = userService.authenticateUser(inputDto);

        // Verify that the authenticated user is returned
        assertNotNull(outDto);
        assertEquals(mockUser.getEmail(), outDto.getEmail());
        assertEquals(AuthenticateUserMapper.userToOutDto(mockUser).getId(), outDto.getId());
    }

    @Test
    public void testAuthenticateUser_InvalidCredentials() {
        // Mock the behavior of blogUserRepo.findByEmail to return a user with a different password
        User mockUser = new User();
        mockUser.setEmail("test@example.com");
        mockUser.setPassword("password");
        when(blogUserRepo.findByEmail(Mockito.anyString())).thenReturn(Optional.of(mockUser));

        // Create a sample AuthenticateUserInDto with incorrect password
        AuthenticateUserInDto inputDto = new AuthenticateUserInDto();
        inputDto.setEmail("test@example.com");
        inputDto.setPassword("wrong_password");

        // Call the authenticateUser method and expect null output
        AuthenticateUserOutDto outDto = userService.authenticateUser(inputDto);

        // Verify that no user is authenticated
        assertNull(outDto);
    }
}
