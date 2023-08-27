package com.example.demo.dto;

/**
 * The {@code UserDto} class represents a Data Transfer Object (DTO) for
 * user-related data. It is used to transfer user information between different
 * parts of the application.
 *
 * @author Ashutosh Tigga
 */
public class UserDto {

  /**
   * The unique identifier for the user.
   */
  private String userId;

  /**
   * The username of the user.
   */
  private String userName;

  /**
   * The first name of the user.
   */
  private String userFirstName;

  /**
   * The last name of the user.
   */
  private String userLastName;

  /**
   * The gender of the user.
   */
  private String userGender;

  /**
   * The email address of the user.
   */
  private String userEmail;

  /**
   * The password of the user.
   */
  private String userPassword;

  /**
   * The designation of the user.
   */
  private String userDesignation;

  /**
   * The contact number of the user.
   */
  private String userContactNumber;


  /**
   * Constructs a new {@code UserDto} with the specified user details.
   *
   * @param userIdParam            The unique identifier for the user.
   * @param userNameParam          The username of the user.
   * @param userFirstNameParam     The first name of the user.
   * @param userLastNameParam      The last name of the user.
   * @param userGenderParam        The gender of the user.
   * @param userEmailParam         The email address of the user.
   * @param userPasswordParam      The password of the user.
   * @param userDesignationParam   The designation of the user.
   * @param userContactNumberParam The contact number of the user.
   */
  public UserDto(final String userIdParam,
      final String userNameParam,
      final String userFirstNameParam,
      final String userLastNameParam,
      final String userGenderParam,
      final  String userEmailParam,
      final String userPasswordParam,
      final String userDesignationParam,
      final String userContactNumberParam
  ) {
    this.userId = userIdParam;
    this.userName = userNameParam;
    this.userFirstName = userFirstNameParam;
    this.userLastName = userLastNameParam;
    this.userGender = userGenderParam;
    this.userEmail = userEmailParam;
    this.userPassword = userPasswordParam;
    this.userDesignation = userDesignationParam;
    this.userContactNumber = userContactNumberParam;
  }

  /**
   * Default constructor for the {@code UserDto} class.
   */
  public UserDto() {
    // Default constructor
  }

  /**
   * Retrieves the gender of the user.
   *
   * @return userGender The gender of the user.
   */
  public String getUserGender() {
    return userGender;
  }

  /**
   * Sets the gender of the user.
   *
   * @param userGenderParam The gender of the user.
   */
  public void setUserGender(final String userGenderParam) {
    this.userGender = userGenderParam;
  }

  /**
   * Retrieves the unique identifier for the user.
   *
   * @return userId The unique identifier for the user.
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Sets the unique identifier for the user.
   *
   * @param userIdParam The unique identifier for the user.
   */
  public void setUserId(final String userIdParam) {
    this.userId = userIdParam;
  }

  /**
   * Retrieves the username of the user.
   *
   * @return userName The username of the user.
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the username of the user.
   *
   * @param userNameParam The username of the user.
   */
  public void setUserName(final String userNameParam) {
    this.userName = userNameParam;
  }

  /**
   * Retrieves the first name of the user.
   *
   * @return userFirstName The first name of the user.
   */
  public String getUserFirstName() {
    return userFirstName;
  }

  /**
   * Sets the first name of the user.
   *
   * @param userFirstNameParam The first name of the user.
   */
  public void setUserFirstName(final String userFirstNameParam) {
    this.userFirstName = userFirstNameParam;
  }

  /**
   * Retrieves the last name of the user.
   *
   * @return userLastName The last name of the user.
   */
  public String getUserLastName() {
    return userLastName;
  }

  /**
   * Sets the last name of the user.
   *
   * @param userLastNameParam The last name of the user.
   */
  public void setUserLastName(final String userLastNameParam) {
    this.userLastName = userLastNameParam;
  }

  /**
   * Retrieves the email address of the user.
   *
   * @return userEmail The email address of the user.
   */
  public String getUserEmail() {
    return userEmail;
  }

  /**
   * Sets the email address of the user.
   *
   * @param userEmailParam The email address of the user.
   */
  public void setUserEmail(final String userEmailParam) {
    this.userEmail = userEmailParam;
  }

  /**
   * Retrieves the password of the user.
   *
   * @return userPassword The password of the user.
   */
  public String getUserPassword() {
    return userPassword;
  }

  /**
   * Sets the password of the user.
   *
   * @param userPasswordParam The password of the user.
   */
  public void setUserPassword(final String userPasswordParam) {
    this.userPassword = userPasswordParam;
  }

  /**
   * Retrieves the designation of the user.
   *
   * @return userDesignation The designation of the user.
   */
  public String getUserDesignation() {
    return userDesignation;
  }

  /**
   * Sets the designation of the user.
   *
   * @param userDesignationParam The designation of the user.
   */
  public void setUserDesignation(final String userDesignationParam) {
    this.userDesignation = userDesignationParam;
  }

  /**
   * Retrieves the contact number of the user.
   *
   * @return userContactNumber The contact number of the user.
   */
  public String getUserContactNumber() {
    return userContactNumber;
  }

  /**
   * Sets the contact number of the user.
   *
   * @param userContactNumberParam The contact number of the user.
   */
  public void setUserContactNumber(final String userContactNumberParam) {
    this.userContactNumber = userContactNumberParam;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "UserDto [userId="
          + ", userName="
          + userName
          + userId
          + ",userFirstName="
          + userFirstName
          + ",userLastName="
          + userLastName
          + ",userEmail="
          + userEmail
          + ",userPassword="
          + userPassword
          + ",userDesignation="
          + userDesignation
          + ",userContactNumber="
          + userContactNumber
          + ",userPostedBlog="
          + "]";
  }
}
