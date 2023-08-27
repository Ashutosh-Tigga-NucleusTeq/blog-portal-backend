package com.example.demo.exception;

/**
 * ResourceNotFoundException is a custom exception class that extends
 * RuntimeException. It is used to indicate that a specific resource was not
 * found.
 *
 *@author Ashutosh Tigga
 */
public class ResourceNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 5072947128220942876L;

  /**
   * The name of the resource that was not found.
   */
  private String resourceName;

  /**
   * The name of the field that was used as a query parameter.
   */
  private String fieldName;

  /**
   * The value of the field that was used as a query parameter.
   */
  private long fieldValue;

  /**
   * Constructor for ResourceNotFoundException.
   *
   * @param resourceNameParam The name of the resource that was not found.
   * @param fieldNameParam    The name of the field that was used
   *     as a query parameter.
   * @param fieldValueParam   The value of the field that was used as a query
   *                     parameter.
   */
  public ResourceNotFoundException(
      final String resourceNameParam,
      final String fieldNameParam,
      final long fieldValueParam
  ) {
    super(
        String.format("%s not found with %s : %s", resourceNameParam,
        fieldNameParam, fieldValueParam)
    );
    this.resourceName = resourceNameParam;
    this.fieldName = fieldNameParam;
    this.fieldValue = fieldValueParam;
  }
}
