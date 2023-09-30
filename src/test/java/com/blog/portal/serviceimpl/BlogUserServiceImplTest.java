package com.blog.portal.serviceimpl;

import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.exception.UnauthorizedUserExeption;
import com.blog.portal.exception.UserRegistrationException;
import com.blog.portal.mapper.AuthenticateUserMapper;
import com.blog.portal.mapper.RegisterUserMapper;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;
import com.blog.portal.responsePayload.UserOutDto;
import com.blog.portal.services.BlogUserService;
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

public class BlogUserServiceImplTest {

    @InjectMocks
    private BlogUserServiceImpl blogUserService;

    @Mock
    private BlogUserRepo blogUserRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser_Success() throws UserRegistrationException {
        RegisterUserInDto userDto = new RegisterUserInDto();
        userDto.setFirstName("firstname");
        userDto.setLastName("lastname");
        userDto.setEmail("firstname.lastname@example.com");

        User user = RegisterUserMapper.inDtoToUser(userDto);

        when(blogUserRepo.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(blogUserRepo.save(any(User.class))).thenReturn(user);

        ApiResponse response = blogUserService.createUser(userDto);

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

        when(blogUserRepo.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        assertThrows(UserRegistrationException.class, () -> blogUserService.createUser(userDto));
    }

    @Test
    public void testAuthenticateUser_Success() {
        AuthenticateUserInDto authDto = new AuthenticateUserInDto();
        authDto.setEmail("firstname.lastname@example.com");
        authDto.setPassword("password123");

        User user = new User();
        user.setEmail(authDto.getEmail());
        user.setPassword(authDto.getPassword());

        when(blogUserRepo.findByEmail(authDto.getEmail())).thenReturn(Optional.of(user));

        AuthenticateUserOutDto outDto = blogUserService.authenticateUser(authDto);

        assertNotNull(outDto);
        assertEquals(authDto.getEmail(), outDto.getEmail());
    }

    @Test
    public void testAuthenticateUser_UserNotFound() {
        AuthenticateUserInDto authDto = new AuthenticateUserInDto();
        authDto.setEmail("firstname.lastname@example.com");
        authDto.setPassword("password123");

        when(blogUserRepo.findByEmail(authDto.getEmail())).thenReturn(Optional.empty());

        Exception exception = assertThrows(UnauthorizedUserExeption.class, () -> blogUserService.authenticateUser(authDto));
        assertEquals("The user is not authenticated", exception.getMessage());
    }


    @Test
    public void testGetUserById_Success() {
        String userId = "1";
        User user = new User();
        user.setId(userId);
        user.setFirstName("firstname");
        user.setLastName("lastname");

        when(blogUserRepo.findById(userId)).thenReturn(Optional.of(user));

        UserOutDto userOutDto = blogUserService.getUserById(userId);

        assertNotNull(userOutDto);
        assertEquals(user.getFirstName(), userOutDto.getFirstName());
        assertEquals(user.getLastName(), userOutDto.getLastName());
    }

}
