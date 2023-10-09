package com.blog.portal.exception;

/**
 * ResourceNotFoundException is a custom exception class that extends
 * RuntimeException. It is used to indicate that a specific resource was not
 * found.
 * @author Ashutosh Tigga
 */
public class ResourceNotFoundException extends RuntimeException {

	 /**
   * The serial version UID for serialization and deserialization.
   */
	private static final long serialVersionUID = 4892890817943756296L;
	/**
	 * Constructor for ResourceNotFoundException.
	 * @param resourceNameParam The name of the resource that was not found.
	 * @param fieldNameParam    The name of the field that was used as a query
	 *                          parameter.
	 * @param fieldValueParam   The value of the field that was used as a query
	 *                          parameter.
	 */
	public ResourceNotFoundException(final String resourceNameParam, final String fieldNameParam,
			final String fieldValueParam) {
		super(String.format("%s not found with %s : %s", resourceNameParam, fieldNameParam, fieldValueParam));
	}
}
