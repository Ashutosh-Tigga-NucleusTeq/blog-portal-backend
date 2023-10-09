package com.blog.portal.mapper;

import com.blog.portal.entities.User;
import com.blog.portal.requestPayload.UserInDTO;
import com.blog.portal.responsePayload.UserOutDTO;

/**
 * This class provides static methods for mapping
 * between authentication-related DTOs and the User entity.
 * @author Ashutosh Tigga
 */
public class AuthenticateUserMapper {

    /**
     * Converts an  UserInDTO to a  User.
     * @param inDto The input DTO containing authentication data.
     * @return A  User object with the email and password from the input DTO.
     */
    public static User inDtoToUser(final UserInDTO inDto) {
        return new User(
                inDto.getEmail(),
                inDto.getPassword()
        );
    }

    /**
     * Converts a  User to an  UserOutDTO.
     * @param user The user entity object to be converted.
     * @return An UserOutDTO containing user information.
     */
    public static UserOutDTO userToOutDto(final User user) {
        return new UserOutDTO(
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
