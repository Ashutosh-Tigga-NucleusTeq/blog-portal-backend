package com.example.demo.dto;
import java.util.Objects;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * This class represents a Data Transfer Object (DTO) used for authenticating a user.
 * It contains the user's email address and password for authentication.
 */
public class AuthenticateInDto {
    /**
     * The email address of the user.
     */
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$", message = "Email is not Valid")
    private String userEmail;

    /**
     * The minimum password size required.
     */
    private final int passwordSize = 6;

    /**
     * The password of the user.
     */
    @Size(min = passwordSize, message = "Password must be at least 6 characters")
    private String userPassword;

    /**
     * Get the user's email address.
     *
     * @return The user's email address.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Set the user's email address.
     *
     * @param userEmail The user's email address to set.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Get the user's password.
     *
     * @return The user's password.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Set the user's password.
     *
     * @param password The user's password to set.
     */
    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    /**
     * Constructs a new AuthenticateInDto object.
     *
     * @param userEmail The user's email address.
     * @param password  The user's password.
     */
    public AuthenticateInDto(
            @Email(message = "Invalid email format") @NotBlank(message = "Email is required") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$", message = "Email is not Valid") String userEmail,
            @Size(min = 6, message = "Password must be at least 6 characters") String password) {
        super();
        this.userEmail = userEmail;
        this.userPassword = password;
    }

    public AuthenticateInDto() {
			// TODO Auto-generated constructor stub
		}

		/**
     * {@inheritDoc} toString
     */
    @Override
    public String toString() {
        return "AuthenticateInDto [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
    }

    /**
     * {@inheritDoc} hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(userPassword, userEmail);
    }

    /**
     * {@inheritDoc} equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AuthenticateInDto other = (AuthenticateInDto) obj;
        return Objects.equals(userPassword, other.userPassword) && Objects.equals(userEmail, other.userEmail);
    }
}
