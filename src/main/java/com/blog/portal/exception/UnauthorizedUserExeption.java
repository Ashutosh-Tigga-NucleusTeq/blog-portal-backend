package com.blog.portal.exception;

/**
 * The `BadRequestException` class represents an exception that can be thrown during user registration.
 * It extends the `RuntimeException` class and is used to handle registration-related errors.
 * @author Ashutosh Tigga
 */
public class UnauthorizedUserExeption extends RuntimeException {

	/**
	 * The serial version UID for serialization and deserialization.
	 */
	private static final long serialVersionUID = 8047145034164159166L;
	/**
	 * Constructs a new `BadRequestException` with the specified error message.
	 * @param message The error message describing the registration exception.
	 */
	public UnauthorizedUserExeption(final String message) {
		super(message);
	}

}
