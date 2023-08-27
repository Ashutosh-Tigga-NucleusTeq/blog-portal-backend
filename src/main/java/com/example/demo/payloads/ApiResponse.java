package com.example.demo.payloads;

/**
 * ApiResponse is a class used to represent API responses.
 *
 *@author Ashutosh Tigga
 */
public class ApiResponse {
  /**
   * A message describing the response.
   */
  private String message;

  /**
   * Indicates whether the API call was successful.
   */
  private boolean success;

  /**
   * Default constructor for ApiResponse.
   */
  public ApiResponse() {
  }

  /**
   * Constructor for ApiResponse with a message and success status.
   *
   * @param messageParam A message describing the response.
   * @param successParam Indicates whether the API call was successful.
   */
  public ApiResponse(final String messageParam, final boolean successParam) {
    this.message = messageParam;
    this.success = successParam;
  }

  /**
   * Get the response message.
   *
   * @return  message The response message.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Set the response message.
   *
   * @param messageParam The response message to set.
   */
  public void setMessage(final String messageParam) {
    this.message = messageParam;
  }

  /**
   * Check if the API call was successful.
   *
   * @return True if the API call was successful, otherwise false.
   */
  public boolean isSuccess() {
    return success;
  }

  /**
   * Set the success status of the API call.
   *
   * @param successParam True if the API call was successful, otherwise false.
   */
  public void setSuccess(final boolean successParam) {
    this.success = successParam;
  }
}
