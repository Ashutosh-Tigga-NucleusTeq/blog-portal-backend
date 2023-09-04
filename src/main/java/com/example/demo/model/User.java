package com.example.demo.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

import jakarta.validation.constraints.NotNull;

/**
 * The {@code User} class represents a user entity in the application.
 *
 * @author Ashutosh Tigga.
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
	private Gender userGender;

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
	private Designation userDesignation;

	/**
	 * The contact number of the user.
	 */
	@Indexed(unique = true)
	private String userContactNumber;

	/**
	 * The role of the user.
	 */
	private Role userRole;

	/**
	 * Constructs an empty {@code User} object.
	 */
	public User() {
		super();
	}

	/**
	 * Gets userGender of the user.
	 *
	 * @return userGender.
	 */
	public Gender getUserGender() {
		return userGender;
	}

	/**
	 * Sets the userGenderParam of the user.
	 *
	 * @param userGenderParam gender of user
	 */
	public void setUserGender(final Gender userGenderParam) {
		this.userGender = userGenderParam;
	}

	/**
	 * get the userName of user.
	 *
	 * @return userName returns userName of user.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * sets the userNameParam of user.
	 *
	 * @param userNameParam userName of user.
	 */
	public void setUserName(final String userNameParam) {
		this.userName = userNameParam;
	}

	/**
	 * gets the userFirstName of user.
	 *
	 * @return userFirstName returns userFirstName.
	 */
	public String getUserFirstName() {
		return userFirstName;
	}

	/**
	 * sets the user first name of user.
	 *
	 * @param userFirstNameParam first name of user.
	 */
	public void setUserFirstName(final String userFirstNameParam) {
		this.userFirstName = userFirstNameParam;
	}

	/**
	 * gets the user last name of user.
	 *
	 * @return userLastName last name of user.
	 */
	public String getUserLastName() {
		return userLastName;
	}

	/**
	 * sets the last name of user.
	 *
	 * @param userLastNameParam last name of user.
	 */
	public void setUserLastName(final String userLastNameParam) {
		this.userLastName = userLastNameParam;
	}

	/**
	 * gets the Email of user.
	 *
	 * @return userEmail email of user.
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * sets the Email of user.
	 *
	 * @param userEmailParam email of user.
	 */
	public void setUserEmail(final String userEmailParam) {
		this.userEmail = userEmailParam;
	}

	/**
	 * gets the password of user.
	 *
	 * @return userPassword password of user.
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * sets password of user.
	 *
	 * @param userPasswordParam password of user.
	 */
	public void setUserPassword(final String userPasswordParam) {
		this.userPassword = userPasswordParam;
	}

	/**
	 * gets designation of user.
	 *
	 * @return userDesignation designation of user.
	 */
	public Designation getUserDesignation() {
		return userDesignation;
	}

	/**
	 * gets designation of user.
	 *
	 * @param userDesignationParam designation of user.
	 */
	public void setUserDesignation(final Designation userDesignationParam) {
		this.userDesignation = userDesignationParam;
	}

	/**
	 * gets userContactNumber of user.
	 *
	 * @return userContactNumber contact number of user.
	 */
	public String getUserContactNumber() {
		return userContactNumber;
	}

	/**
	 * sets userContactNumber of user.
	 *
	 *@param userContactNumberParam contact number of user.
	 */
	public void setUserContactNumber(final String userContactNumberParam) {
		this.userContactNumber = userContactNumberParam;
	}

	/**
	 * gets userRole of user.
	 *
	 *@return userRole role of the user.
	 */
	public Role getUserRole() {
		return this.userRole;
	}

	/**
	 * sets userRole of user.
	 *
	 * @param userRoleParam role of user.
	 */
	public void setUserRole(final Role userRoleParam) {
		this.userRole = userRoleParam;
	}

/**
 *
 * @param userNameParam user name of the user.
 * @param userFirstNameParam first name of the user.
 * @param userGenderParam gender of the user.
 * @param userEmailParam email of the user.
 * @param userPasswordParam password of the user.
 * @param userDesignationParam designation of the user.
 * @param userContactNumberParam number of the user.
 * @param userRoleParam role of the user.
 */
	public User(String userFirstNameParam,String userLastNameParam, Gender userGenderParam,
			String userEmailParam,
			String userPasswordParam,
			Designation userDesignationParam,
			String userContactNumberParam,
			Role userRoleParam) {
		super();
		//this.userName = userNameParam;
		this.userFirstName = userFirstNameParam;
		this.userLastName = userLastNameParam;
		this.userGender = userGenderParam;
		this.userEmail = userEmailParam;
		this.userPassword = userPasswordParam;
		this.userDesignation = userDesignationParam;
		this.userContactNumber = userContactNumberParam;
		this.userRole = userRoleParam;
	}
	

/**
 * 
 * @param userFirstName first name of the user.
 * @param userLastName last name of the user.
 * @param userGender gender of the user.
 * @param userEmail email of the user.
 * @param userPassword password of the user.
 * @param userDesignation designation of the user.
 * @param userContactNumber contact number of user.
 */
	public User(String userFirstNameParam, String userLastNameParam,  Gender userGenderParam, String userEmailParam,
		String userPasswordParam, Designation userDesignationParam, String userContactNumberParam) {
	super();
	this.userFirstName = userFirstNameParam;
	this.userLastName = userLastNameParam;
	this.userGender = userGenderParam;
	this.userEmail = userEmailParam;
	this.userPassword = userPasswordParam;
	this.userDesignation = userDesignationParam;
	this.userContactNumber = userContactNumberParam;
}
	
	/**
	 * 2 Args constuctor.
	 * 
	 * @param userEmail email of the user.
	 * @param userPassword password of the user.
	 */
	public User(String userEmail, String userPassword) {
	super();
	this.userEmail = userEmail;
	this.userPassword = userPassword;
}

	/**
	 * {@inheritDoc} hashCode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(userContactNumber, userDesignation, userEmail, userFirstName, userGender, userLastName,
				userName, userPassword, userRole);
	}

	/**
	 *{@inheritDoc} equals.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(userContactNumber, other.userContactNumber)
				&& Objects.equals(userDesignation, other.userDesignation)
				&& Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userFirstName, other.userFirstName)
				&& Objects.equals(userGender, other.userGender)
				&& Objects.equals(userLastName, other.userLastName)
				&& Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword)
				&& Objects.equals(userRole, other.userRole);
	}

	/**
	 *{@inheritDoc} toString.
	 */
	@Override
	public String toString() {
		return "User [userName="
	+ userName
	+ ", userFirstName="
	+ userFirstName
	+ ", userLastName="
	+ userLastName
	+ ", userGender="
	+ userGender
	+ ", userEmail="
	+ userEmail
	+ ", userPassword="
	+ userPassword
	+ ", userDesignation="
	+ userDesignation
	+ ", userContactNumber="
	+ userContactNumber
	+ ", userRole="
	+ userRole
	+ "]";
	}

}
