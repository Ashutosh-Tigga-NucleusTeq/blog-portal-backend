package com.example.demo.serviceimpl;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserRegistrationException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.UserService;

import jakarta.validation.Valid;

import java.util.Optional;

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
  /**
   *   instance of UserRepository.
   */
  @Autowired
  private UserRepo userRepo;

  /**
   * Creates an user based on the provided UserDto.
   *
   * @param userDto The UserDto containing the details of the  user to be
   *                created.
   * @return A UserDto representing the created  user.
   */
	@Override
	public UserDto createUser( UserDto userDto) throws UserRegistrationException{
	// Convert UserDto into User JPA Entity
    User user = UserMapper.mapToUser(userDto);
    User savedUser;
    Optional<User> isUserExists=userRepo.findById(user.getUserEmail());
    //check if user already there 
    if(isUserExists.isPresent()) {
    	//if user already exists then throw exceptionS
    	throw new UserRegistrationException(409, "User Already Exists");
    
    }else {
    	// Save the user entity to the repository
    	 savedUser= userRepo.save(user);
    }

    // Convert User JPA entity to UserDto
    UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

    return savedUserDto;
	}
}
