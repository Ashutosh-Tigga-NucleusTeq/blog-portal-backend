package com.example.demo.dto;

import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Represents a Data Transfer Object (DTO) used for authenticating a user.
 * It contains the user's email address and password for authentication.
 */
public class AuthenticateInDto {
    /**
     * The email address of the user.
     */
    @Email(message = "Invalid email format") // Validates that the email format is correct
    @NotBlank(message = "Email is required") // Ensures that the email is not blank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$",
            message = "Email is not Valid") // Applies a custom regular expression pattern for email validation
    private String email;

    /**
     * The minimum password size required.
     */
    private final int passwordSize = 6; // Specifies the minimum password size as a constant

    /**
     * The password of the user.
     */
    @Size(min = passwordSize,
            message = "Password must be at least 6 characters") // Validates that the password is at least 6 characters long
    private String password;

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
     * Generates a hash code for this object.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, password, passwordSize);
    }

    /**
     * Compares this object to another object for equality.
     *
     * @param obj The object to compare to.
     * @return True if the objects are equal, false otherwise.
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
        AuthenticateInDto other = (AuthenticateInDto) obj;
        return Objects.equals(email, other.email) && Objects.equals(password, other.password)
                && passwordSize == other.passwordSize;
    }

    /**
     * Returns a string representation of this object.
     *
     * @return A string describing the object.
     */
    @Override
    public String toString() {
        return "AuthenticateInDto [email=" + email + ", passwordSize=" + passwordSize + ", password=" + password + "]";
    }
}
