package com.blog.portal.mapper;

import com.blog.portal.entities.User;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;

/**
 * The {@code AuthenticateMapper} class provides static methods for mapping
 * between authentication-related DTOs and the User entity.
 *
 * @author Your Name
 */
public class AuthenticateUserMapper {

    /**
     * Converts an {@link AuthenticateUserInDto} to a {@link User}.
     *
     * @param inDto The input DTO containing authentication data.
     * @return A {@link User} object with the email and password from the input DTO.
     */
    public static User inDtoToUser(AuthenticateUserInDto inDto) {
        return new User(
                inDto.getEmail(),
                inDto.getPassword()
        );
    }

    /**
     * Converts a {@link User} to an {@link AuthenticateUserOutDto}.
     *
     * @param user The user entity object to be converted.
     * @return An {@link AuthenticateUserOutDto} containing user information.
     */
    public static AuthenticateUserOutDto userToOutDto(User user) {
        return new AuthenticateUserOutDto(
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
