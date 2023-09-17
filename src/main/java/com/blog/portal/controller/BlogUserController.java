package com.blog.portal.controller;

import javax.validation.Valid;

import java.nio.charset.StandardCharsets;
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
import com.blog.portal.messagePayloads.ApiResponse;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;
import com.blog.portal.services.BlogUserService;

/**
 * The {@code UserController} class handles HTTP requests related to user
 * management.
 *
 * @author Ashutosh Tigga.
 */
@RestController
@RequestMapping("/blog/portal")
public class BlogUserController {
    /**
     * An instance of the {@link BlogUserService} class for handling user operations.
     */
    @Autowired
    private BlogUserService blogUserService;

    /**
     * An instance of the Logger class for logging.
     */
    private Logger logger = LogManager.getLogger(BlogUserController.class);

    /**
     * Creates a new user.
     *
     * @param user The user data to be registered as a user.
     * @return ResponseEntity containing the created user and HTTP status code.
     * @throws MethodArgumentNotValidException if validation of the user data fails.
     */
    @PostMapping("/register")
    public final ResponseEntity<ApiResponse> registerUser(
            @Valid @RequestBody final RegisterUserInDto user)
            throws MethodArgumentNotValidException {
        logger.info("Registering user controller invoked with request payload [" + user + "]");
        user.setPassword(encoder(user.getPassword()));
        ApiResponse response = blogUserService.createUser(user);
        logger.info("Fetching response from  createUser service [" + response + "]");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * API endpoint to perform user authentication.
     *
     * @param inDto Request DTO for user authentication.
     * @return ResponseEntity containing the authenticated user and HTTP status code.
     */
    @PostMapping("/login")
    public final ResponseEntity<AuthenticateUserOutDto> authenticate(@Valid @RequestBody AuthenticateUserInDto inDto) {
        logger.info("Authenticating user controller invoked with request payload [" + inDto + "]");
        inDto.setPassword(encoder(inDto.getPassword()));
        AuthenticateUserOutDto response =
                this.blogUserService.authenticateUser(inDto);
        logger.info("Fetching response from authenticateUser service [" + response + "]");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /**
     * Encodes the password using Base64 encoding.
     *
     * @param password The password to be encoded.
     * @return The Base64 encoded password.
     */
    String encoder(final String password) {
      byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
      return Base64.getEncoder().encodeToString(passwordBytes);
  }
}
