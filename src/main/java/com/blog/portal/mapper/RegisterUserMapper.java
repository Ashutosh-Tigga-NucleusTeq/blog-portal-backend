package com.blog.portal.mapper;

import java.util.Locale;
import com.blog.portal.entities.User;
import com.blog.portal.requestPayload.RegisterUserInDto;
import com.blog.portal.responsePayload.RegisterUserOutDto;

/**
 * The {@code RegisterUserMapper} class provides static methods for mapping
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
            capitalizeFirstLetter(inDto.getFirstName()),
            capitalizeFirstLetter(inDto.getLastName()),
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

    /**
     * Capitalizes the first letter of a string and makes the rest of the string lowercase.
     *
     * @param input The input string.
     * @return The input string with the first letter capitalized and the rest lowercase.
     */
    private static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase(Locale.getDefault()) + input.substring(1).toLowerCase(Locale.getDefault());
    }
}
