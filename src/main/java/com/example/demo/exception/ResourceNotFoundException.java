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
  private String fieldValue;

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
      final String fieldValueParam
  ) {
    super(
        String.format("%s not found with %s : %s", resourceNameParam,
        fieldNameParam, fieldValueParam)
    );
    this.resourceName = resourceNameParam;
    this.fieldName = fieldNameParam;
    this.fieldValue = fieldValueParam;
  }

  /**
   * gets resource name.
   *
   * @return resourceName resource name.
   */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * sets resource name.
	 *
	 * @param resourceNameParam resource name.
	 */
	public void setResourceName(String resourceNameParam) {
		this.resourceName = resourceNameParam;
	}

	/**
	 * gets field name.
	 *
	 * @return fieldName name of the field.
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * sets fieldName.
	 *
	 * @param fieldNameParam name of the field.
	 */
	public void setFieldName(String fieldNameParam) {
		this.fieldName = fieldNameParam;
	}

	/**
	 * gets fieldValue.
	 *
	 * @return fieldValue field value.
	 */
	public String getFieldValue() {
		return fieldValue;
	}

	/**
	 * sets fieldValue.
	 *
	 * @param fieldValueParam field value.
	 */
	public void setFieldValue(String fieldValueParam) {
		this.fieldValue = fieldValueParam;
	}

}
