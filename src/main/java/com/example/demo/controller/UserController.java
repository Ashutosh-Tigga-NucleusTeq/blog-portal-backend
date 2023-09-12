package com.example.demo.controller;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterInDto;
import com.example.demo.dto.RegisterOutDto;
import com.example.demo.services.UserService;
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

/**
 * The {@code UserController} class handles HTTP requests related to user
 * management.
 *
 * @author Ashutosh Tigga.
 */
@RestController
@RequestMapping("/blog-portal/api")
public class UserController {
    /**
     * An instance of the {@link UserService} class for handling user operations.
     */
    @Autowired
    private UserService userService;

    /**
     * An instance of the Logger class for logging.
     */
    private Logger logger = LogManager.getLogger(UserController.class);

    /**
     * Creates a new user.
     *
     * @param user The user data to be registered as a user.
     * @return ResponseEntity containing the created user and HTTP status code.
     * @throws MethodArgumentNotValidException if validation of the user data fails.
     */
    @PostMapping("/register")
    public final ResponseEntity<RegisterOutDto> registerUser(
            @Valid @RequestBody final RegisterInDto user)
            throws MethodArgumentNotValidException {
        logger.info("Registering user: " + user);
        // Encoding password with Base64 encoding
        user.setPassword(encoder(user.getPassword()));
        RegisterOutDto responseDto = userService.createUser(user);
        logger.info("Successfully executed registration with data: " + responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    /**
     * API endpoint to perform user authentication.
     *
     * @param inDto Request DTO for user authentication.
     * @return ResponseEntity containing the authenticated user and HTTP status code.
     */
    @PostMapping("/login")
    public final ResponseEntity<AuthenticateOutDto> authenticate(@Valid @RequestBody AuthenticateInDto inDto) {
        logger.info("Authenticating user: " + inDto);
        inDto.setPassword(encoder(inDto.getPassword()));
        AuthenticateOutDto authenticatedUserData =
                this.userService.authenticateUser(inDto);
        logger.info("Successfully authenticated user: " + authenticatedUserData);
        return new ResponseEntity<>(authenticatedUserData, HttpStatus.OK);

    }

    /**
     * Encodes the password using Base64 encoding.
     *
     * @param password The password to be encoded.
     * @return The Base64 encoded password.
     */
    private String encoder(final String password) {
      byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
      return Base64.getEncoder().encodeToString(passwordBytes);
  }
}
