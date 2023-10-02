package com.blog.portal.serviceimpl;

import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.exception.UnauthorizedUserExeption;
import com.blog.portal.exception.UserAlreadyExistsException;
import com.blog.portal.mapper.AuthenticateUserMapper;
import com.blog.portal.mapper.RegisterUserMapper;
import com.blog.portal.repository.UserRepository;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;
import com.blog.portal.services.UserService;
import com.blog.portal.util.ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser_Success() throws UserAlreadyExistsException {
        RegisterUserInDto userDto = new RegisterUserInDto();
        userDto.setFirstName("firstname");
        userDto.setLastName("lastname");
        userDto.setEmail("firstname.lastname@example.com");

        User user = RegisterUserMapper.inDtoToUser(userDto);

        when(userRepo.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepo.save(any(User.class))).thenReturn(user);

        ApiResponse response = userService.createUser(userDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.USER_REGISTER_SUCCESS, response.getMessage());
    }

    @Test
    public void testCreateUser_UserAlreadyExists() {
        RegisterUserInDto userDto = new RegisterUserInDto();
        userDto.setFirstName("firstname");
        userDto.setLastName("lastname");
        userDto.setEmail("firstname.lastname@example.com");

        User user = RegisterUserMapper.inDtoToUser(userDto);

        when(userRepo.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        assertThrows(UserAlreadyExistsException.class, () -> userService.createUser(userDto));
    }

    @Test
    public void testAuthenticateUser_Success() {
        AuthenticateUserInDto authDto = new AuthenticateUserInDto();
        authDto.setEmail("firstname.lastname@example.com");
        authDto.setPassword("password123");

        User user = new User();
        user.setEmail(authDto.getEmail());
        user.setPassword(authDto.getPassword());

        when(userRepo.findByEmail(authDto.getEmail())).thenReturn(Optional.of(user));

        AuthenticateUserOutDto outDto = userService.authenticateUser(authDto);

        assertNotNull(outDto);
        assertEquals(authDto.getEmail(), outDto.getEmail());
    }

    @Test
    public void testAuthenticateUser_UserNotFound() {
        AuthenticateUserInDto authDto = new AuthenticateUserInDto();
        authDto.setEmail("firstname.lastname@example.com");
        authDto.setPassword("password123");

        when(userRepo.findByEmail(authDto.getEmail())).thenReturn(Optional.empty());

        assertThrows(UnauthorizedUserExeption.class, () -> userService.authenticateUser(authDto));
    }


}
