package com.example.demo.services;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.payloads.ApiResponse;

import jakarta.validation.Valid;

/**
 * The UserService interface defines operations related to user management.
 *
 *@author Ashutosh Tigga
 */
public interface UserService {
  /**
   * Creates an  user based on the provided UserDto.
   *
   * @param userDto The UserDto containing the details of the  user to be
   *                created.
   * @return A UserDto representing the created  user.
   */
	ApiResponse createUser(@Valid RegisterDto user);

	AuthenticateOutDto authenticateUser(@Valid AuthenticateInDto inDto);
}
