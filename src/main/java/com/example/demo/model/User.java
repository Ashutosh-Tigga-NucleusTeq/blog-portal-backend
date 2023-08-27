package com.example.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The {@code User} class represents a user entity in the application.
 *
 *@author Ashutosh Tigga
 */
@Document(collection = "user")
public final class User {

  /**
   * The unique identifier for the user.
   */
  @Id
  private String userId;

  /**
   * The username of the user.
   */
  @NotNull(message = "User Name is compulsory")
  private String userName;

  /**
   * The first name of the user.
   */
  @NotBlank(message = "First name is required")
  @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
  private String userFirstName;

  /**
   * The last name of the user.
   */
  @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
  @NotBlank(message = "Last name is required")
  private String userLastName;

  /**
   * The gender of the user.
   */
  @NotNull
  private String userGender;

  /**
   * The email address of the user.
   */
  @Email(message = "Invalid email format")
  @NotBlank(message = "Email is required")
  @Indexed(unique = true)
  private String userEmail;

  /**
   * The password of the user.
   */
  @Size(min = 6, message = "Password must be at least 6 characters")
  private String userPassword;

  /**
   * The designation of the user.
   */
  @NotNull
  private String userDesignation;

  /**
   * The contact number of the user.
   */
  @Pattern(regexp = "^\\d{10}$", message = "Contact number"
      + "must be a 10-digit number")
  @NotBlank(message = "Contact number is required")
  @Indexed(unique = true)
  private String userContactNumber;

  /**
   * The role of the user.
   */
  @NotNull
  private String userRole;

  /**
   * Constructs a {@code User} object with the specified attributes.
   *
   * @param userIdParam            The unique identifier of the user.
   * @param userNameParam          The username of the user.
   * @param userFirstNameParam     The first name of the user.
   * @param userLastNameParam      The last name of the user.
   * @param userGenderParam        The gender of the user.
   * @param userEmailParam         The email address of the user.
   * @param userPasswordParam      The password of the user.
   * @param userDesignationParam   The designation of the user.
   * @param userContactNumberParam The contact number of the user.
   */
  public User(final String userIdParam,
          final String userNameParam,
          final String userFirstNameParam,
          final String userLastNameParam,
          final String userGenderParam,
          final String userEmailParam,
          final String userPasswordParam,
          final String userDesignationParam,
          final String userContactNumberParam
  ) {
    super();
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
   * Constructs an empty {@code User} object.
   */
  public User() {
    super();
  }

  // Getter and setter methods for each field (omitted for brevity).

  /**
   * Returns a string representation of the {@code User} object.
   *
   * @return A string containing user information.
   */
  @Override
  public String toString() {
    return "User [userId="
      + userId
      + ", userName="
      + userName
      + ", userFirstName="
      + userFirstName
      + ", userLastName="
      + userLastName
      + ","
      + "userEmail="
      + userEmail
      + ",userPassword="
      + userPassword
      + ", userDesignation="
      + userDesignation
      + ", userContactNumber="
      + userContactNumber
      + ", userPostedBlog="
      + "]";
  }

  /*
   * Gets the userGender of the user.
   *
   * @return userGender gender of user
   */
  public String getUserGender() {
    return userGender;
  }

  /*
   * Sets the userGenderParam of the user.
   *
   * @param userGenderParam gender of user
   */
  public void setUserGender(final String userGenderParam) {
    this.userGender = userGenderParam;
  }
 
  /*
   * gets the userId of user
   * @return userId user id of user
   */
  public String getUserId() {
    return userId;
  }
  
  /* sets the userIdParam of user
   * 
   * @param userIdParam
   */
  public void setUserId(final String userIdParam) {
    this.userId = userIdParam;
  }
  
  /*
   * get the userName of user
   * 
   * @return userName returns userName of user
   */
  public String getUserName() {
    return userName;
  }

  /*
   * sets the userNameParam of user
   * 
   * @param userNameParam userName of user
   */
  public void setUserName(final String userNameParam) {
    this.userName = userNameParam;
  }

  /*
   * gets the userFirstName of user
   * 
   * @return userFirstName returns userFirstName
   */
  public String getUserFirstName() {
    return userFirstName;
  }

  /*
   * sets the user first name of user
   * 
   * @param userFirstNameParam first name of user
   */
  public void setUserFirstName(final String userFirstNameParam) {
    this.userFirstName = userFirstNameParam;
  }

  /*
   * gets the user last name of user
   * 
   * @return userLastName last name of user
   */
  public String getUserLastName() {
    return userLastName;
  }

  /*
   * sets the last name of user
   * 
   * @param userLastNameParam last name of user
   */
  public void setUserLastName(final String userLastNameParam) {
    this.userLastName = userLastNameParam;
  }
  
  /*
   * gets the Email of userc
   * 
   * @return userEmail email of user
   */
  public String getUserEmail() {
    return userEmail;
  }

  /*
   * sets the Email of user
   * 
   * @param userEmailParam email of user
   */
  public void setUserEmail(final String userEmailParam) {
    this.userEmail = userEmailParam;
  }

  /*
   * gets the password of user
   * 
   * @return userPassword password of user
   */
  public String getUserPassword() {
    return userPassword;
  }

  /*
   * sets password of user
   * 
   * @param userPasswordParam password of user
   */
  public void setUserPassword(final String userPasswordParam) {
    this.userPassword = userPasswordParam;
  }

  /*
   * gets designation of user
   * 
   * @return userDesignation designation of user
   */
  public String getUserDesignation() {
    return userDesignation;
  }
  
  /*
   * gets designation of user
   * 
   * @param userDesignationParam designation of user
   */
  public void setUserDesignation(final String userDesignationParam) {
    this.userDesignation = userDesignationParam;
  }
  
  /*
   * gets userContactNumber of user
   * 
   * @return userContactNumber contact number of user
   */
  public String getUserContactNumber() {
    return userContactNumber;
  }

  /*
   * sets userContactNumber of user
   * 
   * @param userContactNumber contact number of user
   */
  public void setUserContactNumber(final String userContactNumberParam) {
    this.userContactNumber = userContactNumberParam;
  }
  
  /*
   * gets userRole of user
   * 
   * @param userRole role of user
   */
  public String getUserRole() {
    return userRole;
  }

  /*
   * sets userRole of user
   * 
   * @param userRole role of user
   */
  public void setUserRole(final String userRoleParam) {
    this.userRole = userRoleParam;
  }
}
