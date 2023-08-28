package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import java.util.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** The {@code UserController} class handles HTTP requests
 *related to user management.
 *
 *@author Ashutosh Tigga
 */
@RestController
@RequestMapping("/blog-portal/api")
public class UserController {
  /**
   *instance of UserService.
   */
  @Autowired
  private UserService userService;

  /**
   * instance of Logger.
   */
  private Logger logger = LogManager.getLogger(UserController.class);

  /**
   * Creates a new user.
   *
   * @param user The user data to be registered as an user.
   * @return ResponseEntity containing the created user and HTTP status code.
   */
  @PostMapping("/register_user")
  public final ResponseEntity<UserDto> registerUser(
      @Valid @RequestBody final UserDto user) throws MethodArgumentNotValidException {
    logger.info("Info tracing" + user);
    // Encoding password with Base64 encoding
    user.setUserPassword(encoder(user.getUserPassword()));
    UserDto savedUser = userService.createUser(user);
    logger.info("successfully executed above code with data "+savedUser);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }

  /**
   * Encodes the password using Base64 encoding.
   *
   * @param password The password to be encoded.
   * @return The Base64 encoded password.
   */
  private String encoder(final String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
}