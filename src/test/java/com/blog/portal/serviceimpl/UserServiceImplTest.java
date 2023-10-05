package com.blog.portal.serviceimpl;

import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.exception.UnauthorizedUserExeption;
import com.blog.portal.exception.BadRequestException;
import com.blog.portal.mapper.AuthenticateUserMapper;
import com.blog.portal.mapper.RegisterUserMapper;
import com.blog.portal.repository.UserRepository;
import com.blog.portal.requestPayload.UserInDTO;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.UserOutDTO;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.services.UserService;
import com.blog.portal.util.ResponseMessageConstants;
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
    public void testCreateUser_Success() throws BadRequestException {
        RegisterUserInDto userDto = new RegisterUserInDto();
        userDto.setFirstName("firstname");
        userDto.setLastName("lastname");
        userDto.setEmail("test@nucleusteq.com");

        User user = RegisterUserMapper.inDtoToUser(userDto);

        when(userRepo.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepo.save(any(User.class))).thenReturn(user);

        ResponseOutDTO response = userService.createUser(userDto);

        assertTrue(response.isSuccess());
        assertEquals(ResponseMessageConstants.USER_REGISTER_SUCCESS, response.getMessage());
    }

    @Test
    public void testUserAlreadyExists() {
        RegisterUserInDto userDto = new RegisterUserInDto();
        userDto.setFirstName("firstname");
        userDto.setLastName("lastname");
        userDto.setEmail("test@nucleusteq.com");

        User user = RegisterUserMapper.inDtoToUser(userDto);

        when(userRepo.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        assertThrows(BadRequestException.class, () -> userService.createUser(userDto));
    }

    @Test
    public void testAuthenticateUserSuccess() {
        UserInDTO authDto = new UserInDTO();
        authDto.setEmail("test@nucleusteq.com");
        authDto.setPassword("Ashu@1234");

        User user = new User();
        user.setEmail(authDto.getEmail());
        user.setPassword(userService.encoder(authDto.getPassword()));

        when(userRepo.findByEmail(authDto.getEmail())).thenReturn(Optional.of(user));
        
        UserOutDTO outDto = userService.authenticateUser(authDto);
        
        assertEquals(authDto.getEmail(), outDto.getEmail());
    }

    @Test
    public void testAuthenticateUserNotFound() {
        UserInDTO authDto = new UserInDTO();
        authDto.setEmail("test@nucleusteq.com");
        authDto.setPassword("password123");

        when(userRepo.findByEmail(authDto.getEmail())).thenReturn(Optional.empty());

        assertThrows(UnauthorizedUserExeption.class, () -> userService.authenticateUser(authDto));
    }


}
