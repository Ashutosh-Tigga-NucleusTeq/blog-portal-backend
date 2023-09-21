package com.blog.portal.serviceimpl;

import javax.validation.Valid;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.portal.controller.BlogUserController;
import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.exception.UserRegistrationException;
import com.blog.portal.mapper.AuthenticateUserMapper;
import com.blog.portal.mapper.RegisterUserMapper;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;
import com.blog.portal.responsePayload.UserOutDto;
import com.blog.portal.services.BlogUserService;

/**
 * Implementation of the UserService interface responsible for user-related
 * operations.
 *
 * @author Ashutosh Tigga.
 */
@Service
public class BlogUserServiceImpl implements BlogUserService {
    /**
     * instance of UserRepository.
     */
    @Autowired
    private BlogUserRepo blogUserRepo;

    /**
     * instance of logger.
     */
    private Logger logger = LogManager.getLogger(BlogUserController.class);

    /**
     * Creates an user based on the provided UserDto.
     *
     * @param inDto
     *         The UserDto containing the details of the  user to be created.
     * @return response A UserDto representing the created  user.
     */
    @Override
    public ApiResponse createUser(@Valid RegisterUserInDto inDto)
            throws UserRegistrationException {
        // Convert UserDto into User JPA Entity
    	ApiResponse response = new ApiResponse();
        User user = RegisterUserMapper.inDtoToUser(inDto);
        Optional<User> isExists = blogUserRepo.findByEmail(user.getEmail());
        System.out.println(isExists);
        if (isExists.isPresent()) {
        	throw new UserRegistrationException("User Already Exists");
        } else {
        	this.blogUserRepo.save(user);
        	response.setMessage("User Registered Succesfully");
        	response.setSuccess(true);
        }
        return response;
    }

    /**
     * Authenticate an user based on the provided AuthenicateInDto.
     *
     * @param inDto
     *         The AuthenticateInDto containing the details of the user to be
     *         authenticate.
     * @return AuthenticateOutDto representing authenticated user.
     */
    @Override
    public AuthenticateUserOutDto authenticateUser(@Valid AuthenticateUserInDto inDto) {
        // TODO Auto-generated method stub
        logger.info(" authentication in UserService " + inDto);
        User user = this.blogUserRepo.findByEmail(inDto.getEmail()).orElseThrow(() -> new ResourceNotFoundException("User",
        		"email", inDto.getEmail()));
        AuthenticateUserOutDto outDto = null;
        if (user.getPassword()
                .equals(inDto.getPassword())) {
            outDto = AuthenticateUserMapper.userToOutDto(user);
        }
        logger.info(
                " successfull authentication in UserService  authenticated user details:" + outDto);

        return outDto;
    }

    /**
     * This mehtod gets the user by id.
     * @param userId
     * @return responseOutDto
     */
		@Override
		public UserOutDto getUserById(String userId) {
			// TODO Auto-generated method stub
			User fetchedUser = blogUserRepo.findById(userId).orElseThrow();
			UserOutDto responseOutDto = new UserOutDto();
			responseOutDto.setFirstName(fetchedUser.getFirstName());
			responseOutDto.setLastName(fetchedUser.getLastName());
			return responseOutDto;
		}

}
