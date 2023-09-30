package com.blog.portal.exception;

/**
 * The `UserRegistrationException` class represents an exception that can be
 * thrown during user registration. It extends the `RuntimeException` class and
 * is used to handle registration-related errors.
 */
public class UnauthorizedUserExeption extends RuntimeException {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * The error message associated with the exception.
	 */
	private String message;

	/**
	 * Constructs a new `UserRegistrationException` with the specified error
	 * message.
	 *
	 * @param message The error message describing the registration exception.
	 */
	public UnauthorizedUserExeption(String message) {
		super();
		this.message = message;
	}

	/**
	 * Gets the error message associated with the exception.
	 *
	 * @return The error message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the error message for the exception.
	 *
	 * @param message The error message to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Returns a string representation of the `UserRegistrationException` object.
	 *
	 * @return A string representation of the exception, including the error
	 *         message.
	 */
	@Override
	public String toString() {
		return "UserRegistrationException [message=" + message + "]";
	}

	/**
	 * Constructs a new `UserRegistrationException`.
	 */
	public UnauthorizedUserExeption() {
		super();
	}
}
