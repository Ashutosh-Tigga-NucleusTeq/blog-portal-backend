package com.blog.portal.requestPayload;

import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Represents a Data Transfer Object (DTO) used for authenticating a user.
 * It contains the user's email address and password for authentication.
 * @author [ Ashutosh Tigga]
 */
public class AuthenticateUserInDto {
    /**
     * The email address of the user.
     */
    @Email(message = "Invalid email format") // Validates that the email format is correct
    @NotBlank(message = "Email is required") // Ensures that the email is not blank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$",
            message = "Email is not Valid") // Applies a custom regular expression pattern for email validation
    private String email;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * Creates a new instance of the {@code AuthenticateInDto} class with the specified email and password.
     *
     * @param email    The email address of the user.
     * @param password The password of the user.
     */
    public AuthenticateUserInDto(
            @Email(message = "Invalid email format") @NotBlank(message = "Email is required")
            @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$", message = "Email is not Valid") String email,
            String password) {
        super();
        this.email = email;
        this.password = password;
    }

    /**
     * Default constructor for the {@code AuthenticateInDto} class.
     */
    public AuthenticateUserInDto() {
        super();
    }

    /**
     * Gets the email address of the user.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Generates a hash code for this {@code AuthenticateInDto} object based on its email and password.
     *
     * @return The generated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    /**
     * Compares this {@code AuthenticateInDto} object with another object to determine if they are equal.
     * Two {@code AuthenticateInDto} objects are considered equal if their email and password are the same.
     *
     * @param obj The object to compare with.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AuthenticateUserInDto other = (AuthenticateUserInDto) obj;
        return Objects.equals(email, other.email) && Objects.equals(password, other.password);
    }

    /**
     * Generates a string representation of this {@code AuthenticateInDto} object.
     *
     * @return The string representation of the {@code AuthenticateInDto} object.
     */
    @Override
    public String toString() {
        return "AuthenticateInDto [email=" + email + ", password=" + password + "]";
    }
}
