package com.example.demo.controller;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.payloads.ApiResponse;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import java.util.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** The {@code UserController} class handles HTTP requests
 *related to user management.
 *
 *@author Ashutosh Tigga.
 */
@RestController
@RequestMapping("/blog-portal/api")
@CrossOrigin(origins = "http://localhost:3000")
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
  @PostMapping("/register")
  public final ResponseEntity<ApiResponse> registerUser(
      @Valid @RequestBody final RegisterDto user) throws MethodArgumentNotValidException {
    logger.info("Info tracing" + user);
    // Encoding password with Base64 encoding
    user.setUserPassword(encoder(user.getUserPassword()));
    ApiResponse response = userService.createUser(user);
    logger.info("successfully executed above code with data "+response);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
  
  /**
   * API to perform authentication operation.
   * 
   * @param inDto.
   * @return ResponseEntity containing the authenticaed user and HTTP status code.
   */
  @PostMapping("/login")
  public final ResponseEntity<AuthenticateOutDto> authenticate(@Valid @RequestBody AuthenticateInDto inDto){
  	logger.info("Info tracing login controller " + inDto);
  	inDto.setUserPassword(encoder(inDto.getUserPassword()));
  	AuthenticateOutDto authenticatedUserData=this.userService.authenticateUser(inDto);
  	logger.info("successfull authenticated user " + authenticatedUserData);
  	return new ResponseEntity<>(authenticatedUserData,HttpStatus.OK);
  	
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