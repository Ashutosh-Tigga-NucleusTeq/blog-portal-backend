package com.blog.portal.serviceimpl;

import javax.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.exception.UnauthorizedUserExeption;
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
import com.blog.portal.util.ExceptionMessage;
import com.blog.portal.util.ResponseMessage;

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
     * Creates an user based on the provided UserDto.
     *
     * @param inDto
     *         The UserDto containing the details of the  user to be created.
     * @return response A UserDto representing the created  user.
     */
    @Override
    public ApiResponse createUser(@Valid RegisterUserInDto inDto)
            throws UserRegistrationException {
    		ApiResponse response = new ApiResponse();
        User user = RegisterUserMapper.inDtoToUser(inDto);
        Optional<User> isUserExists = blogUserRepo.findByEmail(user.getEmail());
        if (isUserExists.isPresent()) {
        	throw new UserRegistrationException(ExceptionMessage.EMAIL_ALREADY_EXISTS);
        } else {
        	blogUserRepo.save(user);
        	response.setMessage(ResponseMessage.USER_REGISTER_SUCCESS);
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
        User user = blogUserRepo.findByEmail(inDto.getEmail()).orElseThrow(()
        		-> new UnauthorizedUserExeption(ExceptionMessage.UNAUTHORIZED_USER));
        AuthenticateUserOutDto outDto = null;
        if (user.getPassword()
                .equals(inDto.getPassword())) {
            outDto = AuthenticateUserMapper.userToOutDto(user);
        } else {
        	throw new UnauthorizedUserExeption(ExceptionMessage.UNAUTHORIZED_USER);
        }
        return outDto;
    }

    /**
     * This method gets the user by id.
     * @param userId
     * @return responseOutDto
     */
		@Override
		public UserOutDto getUserById(String userId) {
			User fetchedUser = blogUserRepo.findById(userId).orElseThrow(
					() -> new ResourceNotFoundException("User", "userId", userId));
			UserOutDto responseOutDto = new UserOutDto();
			responseOutDto.setFirstName(fetchedUser.getFirstName());
			responseOutDto.setLastName(fetchedUser.getLastName());
			return responseOutDto;
		}

}
