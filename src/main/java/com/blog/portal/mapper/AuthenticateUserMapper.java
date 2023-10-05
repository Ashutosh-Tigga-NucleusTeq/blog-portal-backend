package com.blog.portal.mapper;

import com.blog.portal.entities.User;
import com.blog.portal.requestPayload.AuthenticateUserInDto;
import com.blog.portal.responsePayload.AuthenticateUserOutDto;

/**
 * This class provides static methods for mapping
 * between authentication-related DTOs and the User entity.
 * @author Ashutosh Tigga
 */
public class AuthenticateUserMapper {

    /**
     * Converts an  AuthenticateUserInDto to a  User.
     * @param inDto The input DTO containing authentication data.
     * @return A  User object with the email and password from the input DTO.
     */
    public static User inDtoToUser(final AuthenticateUserInDto inDto) {
        return new User(
                inDto.getEmail(),
                inDto.getPassword()
        );
    }

    /**
     * Converts a  User to an  AuthenticateUserOutDto.
     * @param user The user entity object to be converted.
     * @return An AuthenticateUserOutDto containing user information.
     */
    public static AuthenticateUserOutDto userToOutDto(final User user) {
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
