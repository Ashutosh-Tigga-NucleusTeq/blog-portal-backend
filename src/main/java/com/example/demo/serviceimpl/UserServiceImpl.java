package com.example.demo.serviceimpl;

import com.example.demo.controller.UserController;
import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.dto.RegisterInDto;
import com.example.demo.dto.RegisterOutDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.UserRegistrationException;
import com.example.demo.mapper.AuthenticateMapper;
import com.example.demo.mapper.RegisterMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.UserService;
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
 * @author Ashutosh Tigga.
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * instance of UserRepository.
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
     * @param inDto
     *         The UserDto containing the details of the  user to be created.
     * @return response A UserDto representing the created  user.
     */
    @Override
    public RegisterOutDto createUser(@Valid RegisterInDto inDto)
            throws UserRegistrationException {
        // Convert UserDto into User JPA Entity
    	RegisterOutDto response = null;
        logger.info("create user method in service layer with passing" + inDto);
        User user = RegisterMapper.inDtoToUser(inDto);
        Optional<User> isExists = userRepo.findByEmail(user.getEmail());
        System.out.println(isExists);
        if (isExists.isPresent()) {
        	throw new UserRegistrationException("User Already Exists");
        } else {
        	response = RegisterMapper.userToOutDto(this.userRepo.save(user));
        }
        logger.info("successfull" + response);
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
    public AuthenticateOutDto authenticateUser(@Valid AuthenticateInDto inDto) {
        // TODO Auto-generated method stub
        logger.info(" authentication in UserService " + inDto);
        User user = this.userRepo.findByEmail(inDto.getEmail()).orElseThrow(() -> new ResourceNotFoundException("User",
        		"email", inDto.getEmail()));
        AuthenticateOutDto outDto = null;
        if (user.getPassword()
                .equals(inDto.getPassword())) {
            outDto = AuthenticateMapper.userToOutDto(user);
        }
        logger.info(
                " successfull authentication in UserService  authenticated user details:" + outDto);

        return outDto;
    }

}
