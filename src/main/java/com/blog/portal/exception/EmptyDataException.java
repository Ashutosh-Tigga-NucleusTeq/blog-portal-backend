package com.blog.portal.exception;

/**
 * The `EmptyDataException` class represents an exception that can be thrown during fetching data from DB.
 * It extends the `RuntimeException` class.
 * @author Ashutosh Tigga
 */
public class EmptyDataException extends RuntimeException {
	/**
	 *  The serial version UID for serialization and Deserialization.
	 */
	private static final long serialVersionUID = 6302141886898367322L;

	/**
	 * Parameterized Constructor for sending parameter to super class.
	 * @param message
	 */
	public EmptyDataException(final String message) {
		super(message);
	}

}
