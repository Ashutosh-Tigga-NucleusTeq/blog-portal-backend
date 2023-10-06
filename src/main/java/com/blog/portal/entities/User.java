package com.blog.portal.entities;

import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;

/**
 * This class represents a user entity in the application. It stores
 * information about a user, including their first name, last name, gender,
 * email, password, designation, contact number, and role.
 * @author [ Ashutosh Tigga]
 */
@Document(collection = "user")
public final class User {

	/**
	 * The Id of the user.
	 */
	@Id
	private String id;

	/**
	 * The first name of the user.
	 */
	private String firstName;

	/**
	 * The last name of the user.
	 */
	private String lastName;

	/**
	 * The gender of the user.
	 */
	private Gender gender;

	/**
	 * The email address of the user.
	 */
	private String email;

	/**
	 * The password of the user.
	 */
	private String password;

	/**
	 * The designation of the user.
	 */
	private Designation designation;

	/**
	 * The contact number of the user.
	 */
	private String contactNumber;

	/**
	 * The role of the user.
	 */
	private Role role = Role.EMPLOYEE;

	/**
	 * The list of BLOG authored by the user.
	 */
	private List<Blog> blogs;

	/**
	 * Default constructor for the {@code User} class.
	 */
	public User() {
		super();
	}

	/**
	 * Creates a new instance of the  User class with specified parameters.
	 * @param firstName     The first name of the user.
	 * @param lastName      The last name of the user.
	 * @param gender        The gender of the user.
	 * @param email         The email address of the user.
	 * @param password      The password of the user.
	 * @param designation   The designation of the user.
	 * @param contactNumber The contact number of the user.
	 */
	public User(final String firstName,
			final String lastName,
			final Gender gender,
			final String email,
			final String password,
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
	 * Creates a new instance of the User class with specified email and
	 * password.
	 * @param email    The email address of the user.
	 * @param password The password of the user.
	 */
	public User(final String email, final String password) {
		this.email = email;
		this.password = password;
	}

	/**
	 * One arg constructor that copy userId.
	 * @param user
	 */
	public User(final User user) {
		this.id = user.getId();
	}

	/**
	 * Gets the id of the user.
	 * @return The id of the user.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the user.
	 * @param id The id of the user.
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Gets the first name of the user.
	 * @return The first name of the user.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the user.
	 * @param firstName The first name of the user.
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the user.
	 * @return The last name of the user.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the user.
	 * @param lastName The last name of the user.
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the gender of the user.
	 * @return The gender of the user.
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender of the user.
	 * @param gender The gender of the user.
	 */
	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the email of the user.
	 * @return The email of the user.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the user.
	 * @param email The email of the user.
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets the password of the user.
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 * @param password The password of the user.
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Gets the designation of the user.
	 * @return The designation of the user.
	 */
	public Designation getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation of the user.
	 * @param designation The designation of the user.
	 */
	public void setDesignation(final Designation designation) {
		this.designation = designation;
	}

	/**
	 * Gets the contact number of the user.
	 * @return The contact number of the user.
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * Sets the contact number of the user.
	 * @param contactNumber The contact number of the user.
	 */
	public void setContactNumber(final String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * Gets the role of the user.
	 * @return The role of the user.
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role of the user.
	 * @param role The role of the user.
	 */
	public void setRole(final Role role) {
		this.role = role;
	}

	/**
	 * Gets the list of  BLOGS authored by the user.
	 * @return The list of  BLOGS authored by the user.
	 */
	public List<Blog> getPosts() {
		return blogs;
	}

	/**
	 * Sets the list of  blogs authored by the user.
	 * @param newBlogs The list of  blogs authored by the user.
	 */
	public void setPosts(final List<Blog> newBlogs) {
		this.blogs = newBlogs;
	}

	/**
	 * Parameterized Constructor.
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param email
	 * @param password
	 * @param designation
	 * @param contactNumber
	 * @param role
	 * @param blogs
	 */
	public User(final String id,
			final String firstName,
			final String lastName,
			final  Gender gender,
			final String email,
			final String password,
			final Designation designation,
			final String contactNumber,
			final Role role,
			final List<Blog> blogs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.designation = designation;
		this.contactNumber = contactNumber;
		this.role = role;
		this.blogs = blogs;
	}

	/**
	 * Generates a hash code for this User object based on its
	 * contactNumber, designation, email, firstName, gender, id, lastName, password,
	 * blogs, and role.
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, designation, email,
				firstName, gender, id, lastName, password, blogs, role);
	}

	/**
	 * Compares this User object with another object to determine if they
	 * are equal. Two  User objects are considered equal if their
	 * contactNumber, designation, email, firstName, gender, id, lastName, password,
	 * blogs, and role are the same.
	 * @param obj The object to compare with.
	 * @return true if the objects are equal, false otherwise.
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
		User other = (User) obj;
		return Objects.equals(contactNumber, other.contactNumber)
				&& designation == other.designation
				&& Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName)
				&& gender == other.gender
				&& Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password)
				&& Objects.equals(blogs, other.blogs)
				&& role == other.role;
	}

	/**
	 * Generates a string representation of this  User object.
	 * @return The string representation of the  User object.
	 */
	@Override
	public String toString() {
		return "User [id=" + id
				+ ", firstName=" + firstName
				+ ", lastName=" + lastName
				+ ", gender=" + gender
				+ ", email=" + email
				+ ", password=" + password
				+ ", designation=" + designation
				+ ", contactNumber=" + contactNumber
				+ ", role=" + role + ", blogs=" + blogs + "]";
	}
}
