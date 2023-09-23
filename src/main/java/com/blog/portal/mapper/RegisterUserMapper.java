package com.blog.portal.mapper;

import com.blog.portal.entities.User;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.RegisterUserOutDto;

/**
 * The {@code RegisterMapper} class provides static methods for mapping
 * between DTOs and the User entity for user registration.
 *
 * @author Your Name
 */
public class RegisterUserMapper {

    /**
     * Converts a {@link RegisterUserInDto} to a {@link User}.
     *
     * @param inDto The input DTO containing user registration data.
     * @return A {@link User} object with the data from the input DTO.
     */
    public static User inDtoToUser(RegisterUserInDto inDto) {
        return new User(
                inDto.getFirstName(),
                inDto.getLastName(),
                inDto.getGender(),
                inDto.getEmail(),
                inDto.getPassword(),
                inDto.getDesignation(),
                inDto.getContactNumber()
                );
    }

    /**
     * Converts a {@link User} to a {@link RegisterUserOutDto}.
     *
     * @param user The user entity object to be converted.
     * @return A {@link RegisterUserOutDto} containing user information.
     */
    public static RegisterUserOutDto userToOutDto(User user) {
        return new RegisterUserOutDto(
        				user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getGender(),
                user.getEmail(),
                user.getDesignation(),
                user.getContactNumber(),
                user.getRole()
        );
    }
}
