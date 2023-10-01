package com.blog.portal.controller;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;
import com.blog.portal.services.BlogUserService;
import com.blog.portal.util.RequestMappingConst;
import com.blog.portal.util.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitWebConfig
public class BlogUserControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private BlogUserController blogUserController;

	@Mock
	private BlogUserService blogUserService;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(blogUserController).build();
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

		ApiResponse expectedApiResponse = new ApiResponse(ResponseMessage.USER_REGISTER_SUCCESS, true);

		when(blogUserService.createUser(any(RegisterUserInDto.class))).thenReturn(expectedApiResponse);

		mockMvc
				.perform(post(RequestMappingConst.USER_URL + "/register").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(userDto)))
				.andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.message").value(expectedApiResponse.getMessage()))
				.andExpect(jsonPath("$.success").value(expectedApiResponse.isSuccess()));
	}

	@Test
	public void testAuthenticateUser() throws Exception {
		AuthenticateUserInDto authDto = new AuthenticateUserInDto();
		authDto.setEmail("firstname.lastname@nucleusteq.com");
		authDto.setPassword("password123");

		AuthenticateUserOutDto expectedOutDto = new AuthenticateUserOutDto();
		expectedOutDto.setId("1");
		expectedOutDto.setFirstName("firstname");
		expectedOutDto.setLastName("lastname");
		expectedOutDto.setEmail("firstname.lastname@nucleusteq.com");
		expectedOutDto.setContactNumber("9876567839");
		expectedOutDto.setGender(Gender.MALE);
		expectedOutDto.setDesignation(Designation.INTERN);

		when(blogUserService.authenticateUser(any(AuthenticateUserInDto.class))).thenReturn(expectedOutDto);

		mockMvc
				.perform(post(RequestMappingConst.USER_URL + "/login").contentType(MediaType.APPLICATION_JSON)
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
