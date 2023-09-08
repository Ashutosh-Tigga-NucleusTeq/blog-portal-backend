package com.example.demo.mapper;

import com.example.demo.dto.AuthenticateInDto;
import com.example.demo.dto.AuthenticateOutDto;
import com.example.demo.model.User;

/**
 * The {@code AuthenticateMapper} class provides static methods for mapping
 * between authentication-related DTOs and the User entity.
 *
 * @author Your Name
 */
public class AuthenticateMapper {

    /**
     * Converts an {@link AuthenticateInDto} to a {@link User}.
     *
     * @param inDto The input DTO containing authentication data.
     * @return A {@link User} object with the email and password from the input DTO.
     */
    public static User inDtoToUser(AuthenticateInDto inDto) {
        return new User(
                inDto.getEmail(),
                inDto.getPassword()
        );
    }

    /**
     * Converts a {@link User} to an {@link AuthenticateOutDto}.
     *
     * @param user The user entity object to be converted.
     * @return An {@link AuthenticateOutDto} containing user information.
     */
    public static AuthenticateOutDto userToOutDto(User user) {
        return new AuthenticateOutDto(
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
