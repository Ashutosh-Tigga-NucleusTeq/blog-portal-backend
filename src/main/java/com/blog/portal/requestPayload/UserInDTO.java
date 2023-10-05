package com.blog.portal.requestPayload;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * This class Represents a Request DTO used for authenticating a user. It
 * contains the user's email address and password for authentication.
 * @author [ Ashutosh Tigga]
 */
public class UserInDTO {
	/**
	 * The email address of the user.
	 */
	@NotBlank(message = "Email is required")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$", message = "Email is not Valid")
	private String email;

	/**
	 * The password of the user.
	 */
	private String password;

	/**
	 * Creates a new instance of the AuthenticateInDto class with the
	 * specified email and password.
	 * @param email    The email address of the user.
	 * @param password The password of the user.
	 */
	public UserInDTO(final String email, final String password) {
		super();
		this.email = email;
		this.password = password;
	}

	/**
	 * Default constructor for the AuthenticateInDto class.
	 */
	public UserInDTO() {
		super();
	}

	/**
	 * Gets the email address of the user.
	 * @return The user's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 * @param email The email address to set.
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets the password of the user.
	 * @return The user's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 * @param password The password to set.
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Generates a hash code for this AuthenticateInDto object based on its
	 * email and password.
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	/**
	 * Compares this AuthenticateInDto object with another object to
	 * determine if they are equal. Two AuthenticateInDto objects are
	 * considered equal if their email and password are the same.
	 * @param obj The object to compare with.
	 * @return {@code true} if the objects are equal; {@code false} otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserInDTO other = (UserInDTO) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(password, other.password);
	}

	/**
	 * Generates a string representation of this AuthenticateInDto object.
	 * @return The string representation of the AuthenticateInDto object.
	 */
	@Override
	public String toString() {
		return "AuthenticateInDto [email=" + email
				+ ", password=" + password + "]";
	}
}
