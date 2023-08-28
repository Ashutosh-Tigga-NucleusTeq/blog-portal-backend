package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		userDto.setUserRole("admin");
		assertEquals("admin", userDto.getUserRole());
	}

	@Test
	void testUserDto() {
		UserDto newUser = new UserDto("Ashu123", "ashu", "tigga", "Male", "ashu@mail.com", "password123", "Software Engineer",
				"1234567890", "Admin");
		assertEquals("Ashu123", newUser.getUserName());
		assertEquals("ashu", newUser.getUserFirstName());
		assertEquals("tigga", newUser.getUserLastName());
		assertEquals("Male", newUser.getUserGender());
		assertEquals("ashu@mail.com", newUser.getUserEmail());
		assertEquals("password123", newUser.getUserPassword());
		assertEquals("Software Engineer", newUser.getUserDesignation());
		assertEquals("1234567890", newUser.getUserContactNumber());
		assertEquals("Admin", newUser.getUserRole());

	}

	@Test
	void testGetUserGender() {
		userDto.setUserGender("male");
		assertEquals("male", userDto.getUserGender());
	}

	@Test
	void testSetAndGetUserName() {
		userDto.setUserName("Ashu123");
		assertEquals("Ashu123", userDto.getUserName());
	}


	@Test
	void testSetAndGetUserFirstName() {
		userDto.setUserFirstName("ashu");
		assertEquals("ashu", userDto.getUserFirstName());
	}

	@Test
	void testSetAndGetUserLastName() {
		userDto.setUserLastName("tigga");
		assertEquals("tigga", userDto.getUserLastName());
	}


	@Test
	void testSetAndGetUserEmail() {
		userDto.setUserEmail("ashu@nucleusteq.com");
		assertEquals("ashu@nucleusteq.com", userDto.getUserEmail());
	}


	@Test
	void testSetAndGetUserPassword() {
		userDto.setUserPassword("1234");
		assertEquals("1234", userDto.getUserPassword());
	}


	@Test
	void testSetAndGetUserDesignation() {
		userDto.setUserDesignation("sde");
		assertEquals("sde",userDto.getUserDesignation());
	}


	@Test
	void testSetAndGetUserContactNumber() {
		userDto.setUserContactNumber("1234567890");
		assertEquals("1234567890", userDto.getUserContactNumber());
	}


	@Test
	void testToString() {
		 UserDto userDto = new UserDto();
     userDto.setUserName("Ashu123");
     userDto.setUserFirstName("ashu");
     userDto.setUserLastName("tigga");
     userDto.setUserEmail("ashu@nucleusteq.com");
     userDto.setUserPassword("1234");
     userDto.setUserDesignation("sde");
     userDto.setUserContactNumber("1234567890");
     userDto.setUserRole("admin");

     // Expected toString result
     String expectedToString = "UserDto [userName=Ashu123,userFirstName=ashu,userLastName=tigga,userEmail=ashu@nucleusteq.com,userPassword=1234,userDesignation=sde,userContactNumber=1234567890userRole=admin]";

     // Test the toString method
     String actualToString = userDto.toString();

     // Assert that the actual result matches the expected result
     assertEquals(expectedToString, actualToString);
	}
}
