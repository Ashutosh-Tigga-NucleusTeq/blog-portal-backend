package com.blog.portal.exception;

/**
 * The `EmptyDataException` class represents an exception that can be thrown during fetching data from DB.
 * It extends the `RuntimeException` class.
 * @author Ashutosh Tigga
 */
public class EmptyDataException extends RuntimeException {
	/**
	 * Parameterized Constructor for initialization of Object.
	 * @param message
	 */
	public EmptyDataException(final String message) {
		super(message);
	}

}
