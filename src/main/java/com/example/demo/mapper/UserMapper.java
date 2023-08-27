package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

/**
 * The {@code UserMapper} class provides static methods for mapping between
 * {@link User} and {@link UserDto} objects.
 *
 *@author Ashutosh Tigga
 */

public class UserMapper {

  /**
   * Maps a User object to a UserDto object.
   *
   * @param user The User object to be mapped.
   * @return A {@link UserDto} object representing the mapped data.
   */
  public static UserDto mapToUserDto(final User user) {
    UserDto userDto = new UserDto(
        user.getUserName(),
        user.getUserFirstName(),
        user.getUserLastName(),
        user.getUserGender(),
        user.getUserEmail(),
        user.getUserPassword(),
        user.getUserDesignation(),
        user.getUserContactNumber(),
        user.getUserRole()
    );

    return userDto;
  }

  /**
   * Maps a {@link UserDto} object to a {@link User} object.
   *
   * @param userDto The {@link UserDto} object to be mapped.
   * @return A {@link User} object representing the mapped data.
   */
  public static User mapToUser(final UserDto userDto) {
    User user = new User(
        userDto.getUserName(),
        userDto.getUserFirstName(),
        userDto.getUserLastName(),
        userDto.getUserGender(),
        userDto.getUserEmail(),
        userDto.getUserPassword(),
        userDto.getUserDesignation(),
        userDto.getUserContactNumber(),
        userDto.getUserRole()
    );

    return user;
  }
}
