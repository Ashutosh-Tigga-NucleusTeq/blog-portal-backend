package com.example.demo.services;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterInDto;
import com.example.demo.dto.RegisterOutDto;

import javax.validation.Valid;

/**
 * The UserService interface defines operations related to user management.
 *
 *@author Ashutosh Tigga
 */
public interface UserService {
  /**
   * Creates an  user based on the provided UserDto.
   *
   * @param user containing the details of the  user to be
   *                created.
   * @return A RegisterInDto representing the created  user.
   */
	RegisterOutDto createUser(@Valid RegisterInDto user);

	/**
	 * method that helps us to Authenticate user.
	 *
	 * @param inDto
	 * @return AuthenticateOutDto.
	 */
	AuthenticateOutDto authenticateUser(@Valid AuthenticateInDto inDto);
}
