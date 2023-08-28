package com.example.demo.dto;

import java.util.Objects;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * The {@code UserDto} class represents a Data Transfer Object (DTO) for
 * user-related data. It is used to transfer user information between different
 * parts of the application.
 *
 * @author Ashutosh Tigga
 */
public class UserDto {
	/**
	 * The username of the user.
	 */
	@NotBlank(message = "User Name is compulsory")
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
	private Gender userGender;

	/**
	 * The email address of the user.
	 */
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$", message = "Email is not Valid")
	private String userEmail;

	/**
	 * password size defind here.
	 */
	private final int passwordSize = 6;
	/**
	 * The password of the user.
	 */
	@Size(min = passwordSize, message = "Password must be at least 6 characters")
	private String userPassword;

	/**
	 * The designation of the user.
	 */
	@NotNull
	private Designation userDesignation;

	/**
	 * The contact number of the user.
	 */
	@Pattern(regexp = "^\\d{10}$", message = "Contact number " + "must be a 10-digit number")
	@NotBlank(message = "Contact number is required")
	private String userContactNumber;

	/**
	 * The user role of the user.
	 */
	@NotNull
	private Role userRole;

	/**
	 * Constructs a new {@code UserDto} with the specified user details.
	 *
	 * @param userNameParam          The username of the user.
	 * @param userFirstNameParam     The first name of the user.
	 * @param userLastNameParam      The last name of the user.
	 * @param userGenderParam        The gender of the user.
	 * @param userEmailParam         The email address of the user.
	 * @param userPasswordParam      The password of the user.
	 * @param userDesignationParam   The designation of the user.
	 * @param userContactNumberParam The contact number of the user.
	 * @param userRoleParam               The role of the user
	 */
	public UserDto(final String userNameParam, final String userFirstNameParam, final String userLastNameParam,
			final Gender userGenderParam, final String userEmailParam, final String userPasswordParam,
			final Designation userDesignationParam, final String userContactNumberParam, final  Role userRoleParam) {
		this.userName = userNameParam;
		this.userFirstName = userFirstNameParam;
		this.userLastName = userLastNameParam;
		this.userGender = userGenderParam;
		this.userEmail = userEmailParam;
		this.userPassword = userPasswordParam;
		this.userDesignation = userDesignationParam;
		this.userContactNumber = userContactNumberParam;
		this.userRole = userRoleParam;
	}



	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * Retrieves the gender of the user.
	 *
	 * @return userGender The gender of the user.
	 */
	public Gender getUserGender() {
		return userGender;
	}

	/**
	 * Sets the gender of the user.
	 *
	 * @param userGenderParam The gender of the user.
	 */
	public void setUserGender(final Gender userGenderParam) {
		this.userGender = userGenderParam;
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
	public Designation getUserDesignation() {
		return userDesignation;
	}

	/**
	 * Sets the designation of the user.
	 *
	 * @param userDesignationParam The designation of the user.
	 */
	public void setUserDesignation(final Designation userDesignationParam) {
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
	 * Gets userRole of the user.
	 *
	 *@return userRole role of the user.
	 */
	public  Role getUserRole() {
		return userRole;
	}

	/**
	 *Sets userRole of the user.
	 *
	 * @param string role of the user.
	 */
	public void setUserRole(  Role userRoleParam) {
		this.userRole = userRoleParam;
	}


	/**
	 * Generate hashcode of UserDto.
	 *
	 * @return returns data in numeric format.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(userContactNumber, userDesignation, userEmail, userFirstName, userGender, userLastName,
				userName, userPassword, userRole);
	}

	/**
	 * Implemented equals method that checks if two object are equal or not.
	 *
	 * return true if equal or else false.
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
		UserDto other = (UserDto) obj;
		return Objects.equals(userContactNumber, other.userContactNumber)
				&& Objects.equals(userDesignation, other.userDesignation) && Objects.equals(userEmail,
						other.userEmail)
				&& Objects.equals(userFirstName, other.userFirstName) && Objects.equals(userGender,
						other.userGender)
				&& Objects.equals(userLastName, other.userLastName) && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword) && Objects.equals(userRole, other.userRole);
	}


	@Override
	public String toString() {
		return "UserDto [userName="
	+ userName
	+ ", userFirstName="
	+ userFirstName
	+ ", userLastName="
	+ userLastName
	+ ", userGender="
	+ userGender
	+ ", userEmail="
	+ userEmail
	+ ", passwordSize="
	+ passwordSize
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
