package com.blog.portal.controller;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.portal.requestPayload.UserInDTO;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.UserOutDTO;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.services.UserService;
import com.blog.portal.util.RestPathConstants;

/**
 * This class handles HTTP requests related to USER Management.
 * @author Ashutosh Tigga.
 */
@RestController
@RequestMapping(RestPathConstants.USER_URL)
public class UserController {

	/**
	 * An instance of the UserService class for handling user
	 * operations.
	 */
	@Autowired
	private UserService userService;

	/**
	 * An instance of the Logger class for logging.
	 */
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	/**
	 * API end-point to Creates a new user.
	 * @param user The user data to be registered as a user.
	 * @return ResponseEntity containing the created user and HTTP status code.
	 * @throws MethodArgumentNotValidException if validation of the user data fails.
	 */
	@PostMapping("/register")
	public final ResponseEntity<ResponseOutDTO> registerUser(@Valid @RequestBody final RegisterUserInDto user) {
		LOGGER.info("Registering user controller invoked with request payload [" + user + "]");
		ResponseOutDTO response = userService.createUser(user);
		LOGGER.info("Fetching response from  createUser service [" + response + "]");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	/**
	 * API end-point to perform user authentication.
	 * @param inDto Request DTO for user authentication.
	 * @return ResponseEntity containing the authenticated user and HTTP status
	 *         code.
	 */
	@PostMapping("/login")
	public final ResponseEntity<UserOutDTO> authenticate(@Valid @RequestBody final UserInDTO inDto) {
		LOGGER.info("Authenticating user controller invoked with request payload [" + inDto + "]");
		UserOutDTO response = userService.authenticateUser(inDto);
		LOGGER.info("Fetching response from authenticateUser service [" + response + "]");
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
