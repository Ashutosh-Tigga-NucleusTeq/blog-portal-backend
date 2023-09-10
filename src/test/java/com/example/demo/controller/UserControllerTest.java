package com.example.demo.controller;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterInDto;
import com.example.demo.dto.RegisterOutDto;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;
import com.example.demo.mapper.RegisterMapper;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserControllerTest {

		/**
		 * instance of user controller.
		 */
    @InjectMocks
    private UserController userController;

    /**
     * instance of user service.
     */
    @Mock
    private UserService userService;

    /**
     * before ,calling each test configure something.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * testing registration method of controller.
     * @throws MethodArgumentNotValidException
     */
    @Test
    public void testRegisterUser() throws MethodArgumentNotValidException {
        RegisterInDto registerInDto = new RegisterInDto();
        registerInDto.setFirstName("firstname");
        registerInDto.setLastName("lastname");
        registerInDto.setEmail("test@nucleusteq.com");
        registerInDto.setGender(Gender.Male);
        registerInDto.setDesignation(Designation.Intern);
        registerInDto.setContactNumber("1234567890");
        registerInDto.setPassword("password");

        User responseUser = new User();
        responseUser.setId("id");
        responseUser.setFirstName("firstname");
        responseUser.setLastName("lastname");
        responseUser.setEmail("test@nucleusteq.com");
        responseUser.setGender(Gender.Male);
        responseUser.setDesignation(Designation.Intern);
        responseUser.setContactNumber("1234567890");
        responseUser.setRole(Role.Employee);

        RegisterOutDto outDto = RegisterMapper.userToOutDto(responseUser);

        User register = RegisterMapper.inDtoToUser(registerInDto);
        when(userService.createUser(any(RegisterInDto.class))).thenReturn(outDto);

        ResponseEntity<RegisterOutDto> responseEntity = userController.registerUser(registerInDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(outDto, responseEntity.getBody());
    }

    /**
     * testing authenticate Contoller method..
     */
    @Test
    public void testAuthenticate() {
        AuthenticateInDto authenticateInDto = new AuthenticateInDto();
        authenticateInDto.setEmail("test@nucleusteq.com");
        authenticateInDto.setPassword("testPassword");

        AuthenticateOutDto mockResponseDto = new AuthenticateOutDto();
        mockResponseDto.setEmail("test@nucleusteq.com");
        mockResponseDto.setId("id");
        mockResponseDto.setFirstName("firstname");
        mockResponseDto.setLastName("lastname");
        mockResponseDto.setGender(Gender.Male);
        mockResponseDto.setDesignation(Designation.Intern);
        mockResponseDto.setContactNumber("1234567890");
        mockResponseDto.setRole(Role.Employee);
        when(userService.authenticateUser(any(AuthenticateInDto.class))).thenReturn(mockResponseDto);

        ResponseEntity<AuthenticateOutDto> responseEntity = userController.authenticate(authenticateInDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponseDto, responseEntity.getBody());
    }
}
