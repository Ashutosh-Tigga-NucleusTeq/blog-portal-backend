package com.example.demo.mapper;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.model.User;

/**
 * The `UserMapper` class provides static methods for mapping between
 * {@link User} and {@link RegisterDto} objects, as well as other related
 * mappings.
 *
 * This class is responsible for converting data between the database entity,
 * DTO, and other data transfer objects. It simplifies the conversion process
 * and ensures consistency in data mapping.
 *
 * @author Ashutosh Tigga.
 */
public class UserMapper {

	/* *//**
				 * Maps a {@link User} object to a {@link RegisterDto} object.
				 *
				 * @param user The {@link User} object to be mapped.
				 * @return A {@link RegisterDto} object representing the mapped data.
				 *//*
						 * public static RegisterDto mapToUserDto(final User user) { RegisterDto userDto
						 * = new RegisterDto( user.getUserFirstName(), user.getUserLastName(),
						 * user.getUserGender(), user.getUserEmail(), user.getUserPassword(),
						 * user.getUserDesignation(), user.getUserContactNumber(), user.getUserRole() );
						 * 
						 * return userDto; }
						 */
	/**
	 * Maps a {@link RegisterDto} object to a {@link User} object.
	 *
	 * @param userDto The {@link RegisterDto} object to be mapped.
	 * @return A {@link User} object representing the mapped data.
	 */
	public static User mapRegistrationDtoToUser(final RegisterDto userDto) {
		User user = new User(userDto.getUserFirstName(), userDto.getUserLastName(), userDto.getUserGender(),
				userDto.getUserEmail(), userDto.getUserPassword(), userDto.getUserDesignation(), userDto.getUserContactNumber(),
				userDto.getUserRole());
		return user;
	}

	/**
	 * Maps an {@link AuthenticateInDto} object to a {@link User} object for
	 * authentication purposes.
	 *
	 * @param inDto The {@link AuthenticateInDto} object to be mapped.
	 * @return A {@link User} object representing the mapped data.
	 */
	public static User authenticateInDtoToUser(AuthenticateInDto inDto) {
		User user = new User(inDto.getUserEmail(), inDto.getUserPassword());
		return user;
	}

	/**
	 * Maps a {@link User} object to an {@link AuthenticateOutDto} object.
	 *
	 * @param user The {@link User} object to be mapped.
	 * @return An {@link AuthenticateOutDto} object representing the mapped data.
	 */
	public static AuthenticateOutDto userToAuthenticateOutDto(User user) {
		AuthenticateOutDto authOutDto = new AuthenticateOutDto(user.getUserFirstName(), user.getUserLastName(),
				user.getUserGender(), user.getUserEmail(), user.getUserDesignation(), user.getUserContactNumber(),user.getUserRole());
		return authOutDto;
	}
}
