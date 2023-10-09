package com.blog.portal.responsePayload;

import java.util.Objects;

/**
 * ResponseOutDTO is a class used to represent API responses.
 * @author [ Ashutosh Tigga]
 */
public class ResponseOutDTO {
	/**
	 * A message describing the response.
	 */
	private String message;

	/**
	 * Indicates whether the API call was successful.
	 */
	private boolean success;

	/**
	 * Default constructor for ResponseOutDTO.
	 */
	public ResponseOutDTO() {
	}

	/**
	 * Constructor for ResponseOutDTO with a message and success status.
	 * @param messageParam A message describing the response.
	 * @param successParam Indicates whether the API call was successful.
	 */
	public ResponseOutDTO(final String messageParam, final boolean successParam) {
		this.message = messageParam;
		this.success = successParam;
	}

	/**
	 * Get the response message.
	 * @return message The response message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the response message.
	 * @param messageParam The response message to set.
	 */
	public void setMessage(final String messageParam) {
		this.message = messageParam;
	}

	/**
	 * Check if the API call was successful.
	 * @return True if the API call was successful, otherwise false.
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Set the success status of the API call.
	 * @param successParam True if the API call was successful, otherwise false.
	 */
	public void setSuccess(final boolean successParam) {
		this.success = successParam;
	}

	/**
	 * generate hashcode of ResponseOutDTO.
	 * @return hashcode in numeric type.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(message, success);
	}

	/**
	 * It checks if two objects are equal or not.
	 * @param obj pass Object instance as parameter.
	 * @return true if succes or else false.
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
		ResponseOutDTO other = (ResponseOutDTO) obj;
		return Objects.equals(message, other.message) && success == other.success;
	}

	/**
	 * Returns a string representation of the {@code User} object.
	 * @return A string containing user information.
	 */
	@Override
	public String toString() {
		return "ResponseOutDTO [message=" + message + ", success=" + success + "]";
	}
}
