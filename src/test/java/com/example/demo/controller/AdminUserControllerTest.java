package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Base64;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.dto.UserDto;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AdminUserController.class)
public class AdminUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @InjectMocks
    private AdminUserController adminUserController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterAdminUser() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserPassword("password"); // Set your test data
        userDto.setUserFirstName("Ashutosh Tigga");
        userDto.setUserGender("Male");

        when(userService.createAdmin(any())).thenReturn(userDto);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/blog-portal/api/registerAdminUser")
                .content(asJsonString(userDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userPassword").value(encoder("password")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.otherPropertiesHere").value("expectedValue"));
    }

    private String encoder(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    // Helper method to convert objects to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}