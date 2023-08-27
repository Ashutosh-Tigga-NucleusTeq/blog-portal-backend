package com.example.demo.serviceimpl;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the UserService interface responsible for user-related
 * operations.
 *
 *@author Ashutosh Tigga
 */
@Service
public class UserServiceImpl implements UserService {
  /*
   *   instance of UserRepository
   */
  @Autowired
  private UserRepo userRepo;

  /**
   * Creates an admin user based on the provided UserDto.
   *
   * @param userDto The UserDto containing the details of the admin user to be
   *                created.
   * @return A UserDto representing the created admin user.
   */
  @Override
  public UserDto createAdmin(final UserDto user) {
    // Convert UserDto into User JPA Entity
    User user1 = UserMapper.mapToUser(user);

    // Save the user entity to the repository
    User savedUser = userRepo.save(user1);

    // Convert User JPA entity to UserDto
    UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
    return savedUserDto;
  }
}
