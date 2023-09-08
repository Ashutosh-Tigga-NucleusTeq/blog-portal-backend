package com.example.demo.mapper;

import com.example.demo.dto.RegisterInDto;
import com.example.demo.dto.RegisterOutDto;
import com.example.demo.model.User;

/**
 * The {@code RegisterMapper} class provides static methods for mapping
 * between DTOs and the User entity for user registration.
 *
 * @author Your Name
 */
public class RegisterMapper {

    /**
     * Converts a {@link RegisterInDto} to a {@link User}.
     *
     * @param inDto The input DTO containing user registration data.
     * @return A {@link User} object with the data from the input DTO.
     */
    public static User inDtoToUser(RegisterInDto inDto) {
        return new User(
                inDto.getFirstName(),
                inDto.getLastName(),
                inDto.getGender(),
                inDto.getEmail(),
                inDto.getPassword(),
                inDto.getDesignation(),
                inDto.getContactNumber(),
                inDto.getRole()
        );
    }

    /**
     * Converts a {@link User} to a {@link RegisterOutDto}.
     *
     * @param user The user entity object to be converted.
     * @return A {@link RegisterOutDto} containing user information.
     */
    public static RegisterOutDto userToOutDto(User user) {
        return new RegisterOutDto(
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
