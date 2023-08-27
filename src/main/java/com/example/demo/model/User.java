package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotNull;

/**
 * The {@code User} class represents a user entity in the application.
 *
 * @author Ashutosh Tigga
 */
@Document(collection = "user")
public final class User {

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
	@NotNull
	private String userGender;

	/**
	 * The email address of the user.
	 */
	@Id
	@Indexed(unique = true)
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
	 * The role of the user.
	 */
	private String userRole;
	
	/**
	 * Constructs an empty {@code User} object.
	 */
	public User() {
		super();
	}

	/*
	 * Gets userGender of the user
	 * 
	 * @return userGender
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
	 * gets the Email of user
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

	public User(String userName, String userFirstName, String userLastName, @NotNull String userGender, String userEmail,
			String userPassword, String userDesignation, String userContactNumber, String userRole) {
		super();
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userDesignation = userDesignation;
		this.userContactNumber = userContactNumber;
		this.userRole = userRole;
	}

	/**
	 * Returns a string representation of the {@code User} object.
	 *
	 * @return A string containing user information.
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ","
				+ "userEmail=" + userEmail + ",userPassword=" + userPassword + ", userDesignation=" + userDesignation
				+ ", userContactNumber=" + userContactNumber + "]";
	}

}
