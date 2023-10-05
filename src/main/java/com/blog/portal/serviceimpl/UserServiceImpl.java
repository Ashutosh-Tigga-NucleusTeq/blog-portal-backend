package com.blog.portal.serviceimpl;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Locale;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.portal.entities.User;
import com.blog.portal.exception.UnauthorizedUserExeption;
import com.blog.portal.exception.UserAlreadyExistsException;
import com.blog.portal.mapper.AuthenticateUserMapper;
import com.blog.portal.mapper.RegisterUserMapper;
import com.blog.portal.repository.UserRepository;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.services.UserService;
import com.blog.portal.util.ExceptionMessage;
import com.blog.portal.util.ResponseMessage;

/**
 * Implementation of the UserService interface responsible for user-related
 * operations.
 * @author Ashutosh Tigga.
 */
@Service
public class UserServiceImpl implements UserService {
	/**
	 * instance of UserRepository.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Creates an user based on the provided UserDto.
	 * @param inDto The UserDto containing the details of the user to be created.
	 * @return response A UserDto representing the created user.
	 */
	@Override
	public ResponseOutDTO createUser(@Valid final RegisterUserInDto inDto) {
		ResponseOutDTO response = new ResponseOutDTO();
		User user = RegisterUserMapper.inDtoToUser(inDto);
		Optional<User> isUserExists = userRepository.findByEmail(user.getEmail());
		if (isUserExists.isPresent()) {
			throw new UserAlreadyExistsException(ExceptionMessage.EMAIL_ALREADY_EXISTS);
		}
		userRepository.save(user);
		response.setMessage(ResponseMessage.USER_REGISTER_SUCCESS);
		response.setSuccess(true);
		return response;
	}

	/**
	 * Authenticate an user based on the provided AuthenicateInDto.
	 * @param inDto The AuthenticateInDto containing the details of the user to be
	 * authenticate.
	 * @return AuthenticateOutDto representing authenticated user.
	 */
	@Override
	public AuthenticateUserOutDto authenticateUser(@Valid final AuthenticateUserInDto inDto) {
		inDto.setPassword(encoder(inDto.getPassword()));
		String emailLowerCase = inDto.getEmail().toLowerCase(Locale.ENGLISH);
		User user = userRepository.findByEmail(emailLowerCase)
		        .orElseThrow(() -> new UnauthorizedUserExeption(ExceptionMessage.UNAUTHORIZED_USER));
		AuthenticateUserOutDto outDto = null;
		if (!user.getPassword().equals(inDto.getPassword())) {
			throw new UnauthorizedUserExeption(ExceptionMessage.UNAUTHORIZED_USER);
		}
		outDto = AuthenticateUserMapper.userToOutDto(user);
		return outDto;
	}

	/**
	 * Encodes the password using Base64 encoding.
	 * @param password The password to be encoded.
	 * @return The Base64 encoded password.
	 */
	String encoder(final String password) {
		byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
		return Base64.getEncoder().encodeToString(passwordBytes);
	}

}
