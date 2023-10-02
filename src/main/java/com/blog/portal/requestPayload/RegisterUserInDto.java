package com.blog.portal.requestPayload;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;

/**
 * The class represents a Request DTO for user-related data. It is used to
 * transfer user information between different parts of the application.
 *
 * @author [Ashutosh Tigga]
 */
public class RegisterUserInDto {
	/**
	 * The MINIMUM size of the name.
	 */
	private static final int MIN_SIZE = 2;

	/**
	 * The MAXIMUM size of the name.
	 */
	private static final int MAX_SIZE = 10;

	/**
	 * The First Name of the USER.
	 */
	@NotBlank(message = "First name is required")
	@Size(min = MIN_SIZE, max = MAX_SIZE, message = "First name length must be between [" + MIN_SIZE + "-" + MAX_SIZE
			+ "]")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
	private String firstName;

	/**
	 * The Last Name of the USER.
	 */
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain alphabets only")
	@Size(min = MIN_SIZE, max = MAX_SIZE, message = "Last name length must be between [" + MIN_SIZE + "-" + MAX_SIZE
			+ "]")
	@NotBlank(message = "Last name is required")
	private String lastName;

	/**
	 * The Gender of the USER.
	 */
	private Gender gender;

	/**
	 * The Email address of the USER.
	 */
	@NotBlank(message = "Email is required")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$", message = "Email is not valid")
	private String email;

	/**
	 * The Password of the USER.
	 */
	private String password;

	/**
	 * The Designation of the USER.
	 */
	private Designation designation;

	/**
	 * The Contact Number of the USER.
	 */
	@Pattern(regexp = "^\\d{10}$", message = "Contact number must be a 10-digit number")
	@NotBlank(message = "Contact number is required")
	private String contactNumber;

	/**
	 * Constructs a new instance of the {@code RegisterInDto} class with the
	 * specified parameters.
	 *
	 * @param firstName     The first name of the user.
	 * @param lastName      The last name of the user.
	 * @param gender        The gender of the user.
	 * @param email         The email address of the user.
	 * @param password      The password of the user.
	 * @param designation   The designation of the user.
	 * @param contactNumber The contact number of the user.
	 */
	public RegisterUserInDto(final String firstName, final String lastName, final Gender gender,
			final String email, final String password,
			final Designation designation,
			final String contactNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.designation = designation;
		this.contactNumber = contactNumber;
	}

	/**
	 * Default constructor for the `PostInDto` class.
	 */
	public RegisterUserInDto() {
		super();
	}

	/**
	 * Gets the first name of the user.
	 *
	 * @return The user's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the user.
	 *
	 * @param firstName The first name to set.
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the user.
	 *
	 * @return The user's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the user.
	 *
	 * @param lastName The last name to set.
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the gender of the user.
	 *
	 * @return The user's gender.
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender of the user.
	 *
	 * @param gender The gender to set.
	 */
	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the email address of the user.
	 *
	 * @return The user's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 *
	 * @param email The email address to set.
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets the password of the user.
	 *
	 * @return The user's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 *
	 * @param password The password to set.
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Gets the designation of the user.
	 *
	 * @return The user's designation.
	 */
	public Designation getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation of the user.
	 *
	 * @param designation The designation to set.
	 */
	public void setDesignation(final Designation designation) {
		this.designation = designation;
	}

	/**
	 * Gets the contact number of the user.
	 *
	 * @return The user's contact number.
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * Sets the contact number of the user.
	 *
	 * @param contactNumber The contact number to set.
	 */
	public void setContactNumber(final String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * Computes the hash code of this object based on its attributes.
	 *
	 * @return The hash code value.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, designation, email, firstName, gender, lastName, password);
	}

	/**
	 * Compares this object to another object to check for equality.
	 *
	 * @param obj The object to compare to.
	 * @return {@code true} if the objects are equal, {@code false} otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		RegisterUserInDto other = (RegisterUserInDto) obj;
		return Objects.equals(contactNumber, other.contactNumber)
				&& designation == other.designation
				&& Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName)
				&& gender == other.gender
				&& Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}

	/**
	 * Converts this object into a string representation for debugging and logging
	 * purposes.
	 *
	 * @return The string representation of this object.
	 */
	@Override
	public String toString() {
		return "RegisterInDto [firstName=" + firstName
				+ ", lastName=" + lastName
				+ ", gender=" + gender
				+ ", email=" + email
				+ ", password=" + password
				+ ", designation=" + designation
				+ ", contactNumber=" + contactNumber + "]";
	}
}
