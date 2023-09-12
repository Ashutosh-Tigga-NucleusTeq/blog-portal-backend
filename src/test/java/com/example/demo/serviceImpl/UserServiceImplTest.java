package com.example.demo.serviceImpl;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterInDto;
import com.example.demo.dto.RegisterOutDto;
import com.example.demo.enumResource.Gender;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.UserRegistrationException;
import com.example.demo.mapper.AuthenticateMapper;
import com.example.demo.mapper.RegisterMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.serviceimpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

	/**
	 * Instance of UserServiceImpl.
	 */
    @InjectMocks
    private UserServiceImpl userService;

    /**
     * Instance of UserRepo.
     */
    @Mock
    private UserRepo userRepo;


    /**
     * Setting before calling test.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testing the success case of createuser.
     * @throws UserRegistrationException
     */
    @Test
    public void testCreateUserSuccess() throws UserRegistrationException {
        RegisterInDto registerInDto = new RegisterInDto();
        registerInDto.setEmail("test@example.com");
        registerInDto.setFirstName("firstname");
        registerInDto.setLastName("lastname");
        registerInDto.setContactNumber("1234567890");
        registerInDto.setGender(Gender.Male);

        User user = RegisterMapper.inDtoToUser(registerInDto);

        when(userRepo.findByEmail("test@example.com")).thenReturn(Optional.empty());
        when(userRepo.save(any(User.class))).thenReturn(user);

        RegisterOutDto response = userService.createUser(registerInDto);

        assertNotNull(response);
        assertEquals("test@example.com", response.getEmail());
        // ... (assert other properties)
    }

    /**
     * testing of user already exists case of create user.
     */
    @Test
    public void testCreateUserAlreadyExists() {
        RegisterInDto registerInDto = new RegisterInDto();
        registerInDto.setEmail("test@example.com");
        // ... (set other properties)

        User existingUser = new User();
        existingUser.setEmail("test@example.com");
        // ... (set other properties)

        when(userRepo.findByEmail("test@example.com")).thenReturn(Optional.of(existingUser));

        assertThrows(UserRegistrationException.class, () -> userService.createUser(registerInDto));
    }

    /**
     * Testing of success case of authentication.
     */
    @Test
    public void testAuthenticateUserSuccess() {
        AuthenticateInDto authenticateInDto = new AuthenticateInDto();
        authenticateInDto.setEmail("test@nucleusteq.com");
        authenticateInDto.setPassword("password");

        User user = new User();
        user.setEmail("test@nucleusteq.com");
        user.setPassword("password");

        when(userRepo.findByEmail("test@nucleusteq.com")).thenReturn(Optional.of(user));
        AuthenticateOutDto response = userService.authenticateUser(authenticateInDto);
        assertNotNull(response);

    }

    /**
     * Testing of user not found case of authentication.
     */
    @Test
    public void testAuthenticateUserNotFound() {
        AuthenticateInDto authenticateInDto = new AuthenticateInDto();
        authenticateInDto.setEmail("test@nucleusteq.com");
        authenticateInDto.setPassword("password");

        when(userRepo.findByEmail("test@example.com")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.authenticateUser(authenticateInDto));
    }

    /**
     * Testing of incorrect password case of authentication.
     */
    @Test
    public void testAuthenticateUserIncorrectPassword() {
        AuthenticateInDto authenticateInDto = new AuthenticateInDto();
        authenticateInDto.setEmail("tet@nucleusteq.com");
        authenticateInDto.setPassword("password");

        User user = AuthenticateMapper.inDtoToUser(authenticateInDto);

        when(userRepo.findByEmail("test@nucleusteq.com")).thenReturn(Optional.of(user));

        assertThrows(ResourceNotFoundException.class, () -> userService.authenticateUser(authenticateInDto));
    }
}
