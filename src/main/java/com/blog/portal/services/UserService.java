package com.blog.portal.services;

import javax.validation.Valid;

import com.blog.portal.requestPayload.UserInDTO;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.UserOutDTO;
import com.blog.portal.responsePayload.ResponseOutDTO;

/**
 * Interface UserService that represent the rule of user that would follow by it's child.
 * @author {Ashutosh Tigga]
 */
public interface UserService {
	/**
	 * Creates an user based on the provided UserDto.
	 * @param user containing the details of the user to be created.
	 * @return A RegisterInDto representing the created user.
	 */
	ResponseOutDTO createUser(@Valid RegisterUserInDto user);

	/**
	 * method that helps us to Authenticate user.
	 * @param inDto
	 * @return AuthenticateOutDto.
	 */
	UserOutDTO authenticateUser(@Valid UserInDTO inDto);

}
