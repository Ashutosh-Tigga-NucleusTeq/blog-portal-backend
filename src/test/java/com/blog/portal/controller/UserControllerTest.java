package com.blog.portal.controller;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.requestPayload.UserInDTO;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.UserOutDTO;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.services.UserService;
import com.blog.portal.util.RestPathConstants;
import com.blog.portal.util.ResponseMessageConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {

	private MockMvc mockMvc;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;


	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testRegisterUser() throws Exception {
		RegisterUserInDto userDto = new RegisterUserInDto();
		userDto.setFirstName("firstname");
		userDto.setLastName("lastname");
		userDto.setEmail("firstname.lastname@nucleusteq.com");
		userDto.setContactNumber("9876567839");
		userDto.setGender(Gender.MALE);
		userDto.setPassword("password");
		userDto.setDesignation(Designation.INTERN);

		ResponseOutDTO expectedApiResponse = new ResponseOutDTO(ResponseMessageConstants.USER_REGISTER_SUCCESS, true);

		when(userService.createUser(any(RegisterUserInDto.class))).thenReturn(expectedApiResponse);

		mockMvc
				.perform(post(RestPathConstants.USER_URL + "/register").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(userDto)))
				.andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.message").value(expectedApiResponse.getMessage()))
				.andExpect(jsonPath("$.success").value(expectedApiResponse.isSuccess()));
	}

	@Test
	public void testAuthenticateUser() throws Exception {
		UserInDTO authDto = new UserInDTO();
		authDto.setEmail("firstname.lastname@nucleusteq.com");
		authDto.setPassword("password123");

		UserOutDTO expectedOutDto = new UserOutDTO();
		expectedOutDto.setId("1");
		expectedOutDto.setFirstName("firstname");
		expectedOutDto.setLastName("lastname");
		expectedOutDto.setEmail("firstname.lastname@nucleusteq.com");
		expectedOutDto.setContactNumber("9876567839");
		expectedOutDto.setGender(Gender.MALE);
		expectedOutDto.setDesignation(Designation.INTERN);

		when(userService.authenticateUser(any(UserInDTO.class))).thenReturn(expectedOutDto);

		mockMvc
				.perform(post(RestPathConstants.USER_URL + "/login").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(authDto)))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(expectedOutDto.getId()))
				.andExpect(jsonPath("$.firstName").value(expectedOutDto.getFirstName()))
				.andExpect(jsonPath("$.lastName").value(expectedOutDto.getLastName()))
				.andExpect(jsonPath("$.email").value(expectedOutDto.getEmail()))
				.andExpect(jsonPath("$.contactNumber").value(expectedOutDto.getContactNumber()));
	}

	private String asJsonString(Object object) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
