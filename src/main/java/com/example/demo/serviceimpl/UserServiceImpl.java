package com.example.demo.serviceimpl;

import com.example.demo.controller.UserController;
import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.UserRegistrationException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.payloads.ApiResponse;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.UserService;
import org.springframework.dao.DuplicateKeyException;
import com.mongodb.MongoException;

import jakarta.validation.Valid;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the UserService interface responsible for user-related
 * operations.
 *
 *@author Ashutosh Tigga.
 */
@Service
public class UserServiceImpl implements UserService {
  /**
   *instance of UserRepository.
   */
  @Autowired
  private UserRepo userRepo;
  
  /**
   * instance of logger.
   */
  private Logger logger = LogManager.getLogger(UserController.class);


  /**
   * Creates an user based on the provided UserDto.
   *
   * @param userDto The UserDto containing the details of the  user to be
   *                created.
   * @return A UserDto representing the created  user.
   */
	@Override
	public ApiResponse createUser( RegisterDto userDto) throws UserRegistrationException{
	// Convert UserDto into User JPA Entity
		logger.info("create user method in service layer with passing"+userDto);
    User user = UserMapper.mapRegistrationDtoToUser(userDto);
    User savedUser = null;
    ApiResponse response=new ApiResponse();
    Optional<User> isUserExists=userRepo.findById(user.getUserEmail());
    //check if user already there 
    if(isUserExists.isPresent()) {
    	//if user already exists then throw exceptionS
    	throw new UserRegistrationException( "User Already Exists  ");
    }else {
    	// Save the user entity to the repository
    	try {
    	 savedUser= userRepo.save(user);
    	 response.setMessage("Congratulation Your Account is created successfully");
    	 response.setSuccess(true);
    	 }catch(DuplicateKeyException e) {
    		 logger.info("dublicate email entered");
    		 response.setMessage("dublicate email entered");
      	 response.setSuccess(false);
    	 }catch(MongoException e) {
    		 logger.info("Database related exception");
    		 response.setMessage("db exception");
      	 response.setSuccess(false);
    	 }
    	 
    }
    // Convert User JPA entity to UserDto
    //RegisterDto savedUserDto = UserMapper.mapToUserDto(savedUser);
    logger.info("successfull"+savedUser);
    return response;
	}

	/**
	 * Authenticate an user based on the provided AuthenicateInDto.
	 * 
	 * @param inDto The AuthenticateInDto containing the details of the user
	 * to be authenticate.
	 * 
	 * @return AuthenticateOutDto representing authenticated user.
	 */
	@Override
	public AuthenticateOutDto authenticateUser(@Valid AuthenticateInDto inDto) {
		// TODO Auto-generated method stub
		logger.info(" authentication in UserService "+inDto);
		Optional<User> user=this.userRepo.findById(inDto.getUserEmail());
		AuthenticateOutDto outDto;
		if(user.isPresent() && user.get().getUserPassword().equals(inDto.getUserPassword())) {
				outDto=UserMapper.userToAuthenticateOutDto(user.get());
		}else {
			throw new ResourceNotFoundException("User","userEmail",inDto.getUserEmail());
		}
		logger.info(" successfull authentication in UserService  authenticated user details:"+outDto);
		
		return outDto;
	}




	
}
