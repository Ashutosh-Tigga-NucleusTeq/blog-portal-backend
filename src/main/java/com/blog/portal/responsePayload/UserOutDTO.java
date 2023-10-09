package com.blog.portal.responsePayload;

import java.util.Objects;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;

/**
 * Represents a Data Transfer Object (DTO) used for sending user authentication
 * data. It contains information about the user's first name, last name, gender,
 * email, designation, and contact number.
 * @author [ Ashutosh Tigga]
 */
public class UserOutDTO {
	/**
	 * ID of the USER.
	 */
	private String id;

	/**
	 * The First name of the USER.
	 */
	private String firstName;

	/**
	 * The Last name of the USER.
	 */
	private String lastName;

	/**
	 * The Gender of the USER.
	 */
	private Gender gender;

	/**
	 * The Email address of the USER.
	 */
	private String email;

	/**
	 * The Designation of the user.
	 */
	private Designation designation;

	/**
	 * The Contact number of the user.
	 */
	private String contactNumber;

	/**
	 * The Role of the user.
	 */
	private Role role;

	/**
	 * Constructor for creating an `AuthenticateOutDto` object.
	 * @param id            The id of the user.
	 * @param firstName     The first name of the user.
	 * @param lastName      The last name of the user.
	 * @param gender        The gender of the user.
	 * @param email         The email address of the user.
	 * @param designation   The designation of the user.
	 * @param contactNumber The contact number of the user.
	 * @param role          The role of the user.
	 */
	public UserOutDTO(final String id, final String firstName, final String lastName,
			final Gender gender,
			final String email,
			final Designation designation,
			final String contactNumber,
			final Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.designation = designation;
		this.contactNumber = contactNumber;
		this.role = role;
	}

	/**
	 * Default constructor for the `AuthenticateOutDto` class.
	 */
	public UserOutDTO() {
		super();
	}

	/**
	 * Gets the id of the user.
	 * @return id id of the user.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the user.
	 * @param id The id to set.
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Gets the first name of the user.
	 * @return The user's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the user.
	 * @param firstName The first name to set.
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the user.
	 * @return The user's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the user.
	 * @param lastName The last name to set.
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the gender of the user.
	 * @return The user's gender.
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender of the user.
	 * @param gender The gender to set.
	 */
	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the email address of the user.
	 * @return The user's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 * @param email The email address to set.
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets the designation of the user.
	 * @return The user's designation.
	 */
	public Designation getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation of the user.
	 * @param designation The designation to set.
	 */
	public void setDesignation(final Designation designation) {
		this.designation = designation;
	}

	/**
	 * Gets the contact number of the user.
	 * @return The user's contact number.
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * Sets the contact number of the user.
	 * @param contactNumber The contact number to set.
	 */
	public void setContactNumber(final String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * Gets the role of the user.
	 * @return The user's role.
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role of the user.
	 * @param role The role to set.
	 */
	public void setRole(final Role role) {
		this.role = role;
	}

	/**
	 * Compares this object to another object to check for equality.
	 * @param obj The object to compare to.
	 * @return {@code true} if the objects are equal, {@code false} otherwise.
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
		UserOutDTO other = (UserOutDTO) obj;
		return Objects.equals(contactNumber, other.contactNumber)
				&& designation == other.designation
				&& Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName)
				&& gender == other.gender
				&& Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName)
				&& role == other.role;
	}

	/**
	 * Generates a hash code value for this object based on its attributes.
	 * @return The hash code value.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, designation, email, firstName, gender, id, lastName, role);
	}

	/**
	 * Converts this object into a string representation for debugging and logging
	 * purposes.
	 * @return The string representation of this object.
	 */
	@Override
	public String toString() {
		return "AuthenticateOutDto [id=" + id
				+ ", firstName=" + firstName
				+ ", lastName=" + lastName
				+ ", gender=" + gender
				+ ", email=" + email
				+ ", designation=" + designation
				+ ", contactNumber=" + contactNumber
				+ ", role=" + role
				+ "]";
	}
}
