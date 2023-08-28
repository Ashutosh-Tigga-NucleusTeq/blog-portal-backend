package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;
import com.example.demo.model.User;

class UserDtoTest {

	private UserDto userDto;

	@BeforeEach
	public void setUp() {
		// Initialize a User object before each test
		userDto = new UserDto();
	}

	@Test
	void testSetAndGetUserRole() {
		userDto.setUserRole(Role.Admin);
		assertEquals("admin", userDto.getUserRole());
	}

	@Test
	void testUserDto() {
		UserDto newUser = new UserDto("userName", "firstName", "lastName", Gender.Male, "test@nucleusteq.com", "password", Designation.Trainee_Engineer,
				"1234567890", Role.Admin);
		assertEquals("userName", newUser.getUserName());
		assertEquals("firstName", newUser.getUserFirstName());
		assertEquals("lastName", newUser.getUserLastName());
		assertEquals(Gender.Male, newUser.getUserGender());
		assertEquals("test@nucleusteq.com", newUser.getUserEmail());
		assertEquals("password", newUser.getUserPassword());
		assertEquals(Designation.Trainee_Engineer, newUser.getUserDesignation());
		assertEquals("1234567890", newUser.getUserContactNumber());
		assertEquals(Role.Admin, newUser.getUserRole());

	}

	@Test
	void testSetterAndGetter() {
		userDto.setUserGender(Gender.Male);
		assertEquals("male", userDto.getUserGender());
		userDto.setUserName("userName");
		assertEquals("userName", userDto.getUserName());
		userDto.setUserFirstName("firstName");
		assertEquals("firstName", userDto.getUserFirstName());
		userDto.setUserLastName("lastName");
		assertEquals("lastName", userDto.getUserLastName());
		userDto.setUserEmail("test@nucleusteq.com");
		assertEquals("test@nucleusteq.com", userDto.getUserEmail());
		userDto.setUserPassword("password");
		assertEquals("password", userDto.getUserPassword());
		userDto.setUserDesignation(Designation.Trainee_Engineer);
		assertEquals("designation",userDto.getUserDesignation());
		userDto.setUserContactNumber("1234567890");
		assertEquals("1234567890", userDto.getUserContactNumber());
	}

	@Test
	void testToString() {
		 UserDto userDto = new UserDto();
     userDto.setUserName("username");
     userDto.setUserFirstName("firstname");
     userDto.setUserLastName("lastname");
     userDto.setUserEmail("test@nucleusteq.com");
     userDto.setUserPassword("password");
     userDto.setUserGender(Gender.Male);
     userDto.setUserDesignation(Designation.Trainee_Engineer);
     userDto.setUserContactNumber("1234567890");
     userDto.setUserRole(Role.Admin);

     // Expected toString result
     String expectedToString = "UserDto [userName=username,userFirstName=firstname,userLastName=lastname,userEmail=test@nucleusteq.com,userPassword=password,userDesignation=designation,userContactNumber=1234567890,userRole=Admin]";

     // Test the toString method
     String actualToString = userDto.toString();

     // Assert that the actual result matches the expected result
     assertEquals(expectedToString, actualToString);
	}
}
