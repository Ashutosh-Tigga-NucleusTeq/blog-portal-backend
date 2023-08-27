package com.example.demo.services;

import com.example.demo.dto.UserDto;

/**
 * The UserService interface defines operations related to user management.
 *
 *@author Ashutosh Tigga
 */
public interface UserService {
  /**
   * Creates an admin user based on the provided UserDto.
   *
   * @param userDto The UserDto containing the details of the admin user to be
   *                created.
   * @return A UserDto representing the created admin user.
   */
  UserDto createAdmin(UserDto userDto);
}
