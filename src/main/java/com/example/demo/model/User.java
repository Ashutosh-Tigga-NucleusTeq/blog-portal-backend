package com.example.demo.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
		 *The Id of the user.
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
    @NotNull
    private Gender gender;

    /**
     * The email address of the user.
     */
    @Indexed(unique = true)
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
    @Indexed(unique = true)
    private String contactNumber;

    /**
     * The role of the user.
     */
    private Role role;

    /**
     * The list of blog posts authored by the user.
     */
    @DBRef
    private List<Post> posts;

    /**
     * Default constructor for the {@code User} class.
     */
    public User() {
			super();
			// TODO Auto-generated constructor stub
		}

    /**
     * Creates a new instance of the {@code User} class with specified parameters.
     *
     * @param firstName      The first name of the user.
     * @param lastName       The last name of the user.
     * @param gender         The gender of the user.
     * @param email          The email address of the user.
     * @param password       The password of the user.
     * @param designation    The designation of the user.
     * @param contactNumber  The contact number of the user.
     * @param role           The role of the user.
     */
		public User(String firstName, String lastName, Gender gender, String email, String password,
  			Designation designation, String contactNumber, Role role) {
  		// TODO Auto-generated constructor stub
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.gender = gender;
    	this.email = email;
    	this.password = password;
    	this.designation = designation;
    	this.contactNumber = contactNumber;
    	this.role = role;
  	}

	  /**
     * Creates a new instance of the {@code User} class with specified email and password.
     *
     * @param email    The email address of the user.
     * @param password The password of the user.
     */
		public User(String email, String password) {
			this.email = email;
			this.password = password;
		}

		/**
		 * Gets the id of the user.

		 * @return id The id of the user.
		 */
		public String getId() {
			return id;
		}

		/**
		 * Sets the id of the user.
		 *
		 * @param id The id of the user.
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * Gets the first name of the user.
		 *
		 * @return firstName The first name of the user.
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * Sets the first name of the user.
		 *
		 * @param firstName The first name of the user.
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * Sets the last name of the user.
		 *
		 * @return lastName The last name of the user.
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * Sets the last name of the user.
		 *
		 * @param lastName The last name of the user.
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * Gets the gender of the user.
		 * @return gender The gender of the user.
		 */
		public Gender getGender() {
			return gender;
		}

		/**
		 * Sets the gender of the user.
		 * @param gender The gender of the user
		 */
		public void setGender(Gender gender) {
			this.gender = gender;
		}

		/**
		 * Gets the email of the user.
		 *
		 * @return email of the user.
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * Sets the email of the user.
		 *
		 * @param email The email of the user.
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * Gets the password of the user.
		 *
		 * @return password the password of the user.
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * Sets the password of the user.
		 *
		 * @param password The password of the user.
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * Gets the designation of the user.
		 *
		 * @return designation The designation of the user.
		 */
		public Designation getDesignation() {
			return designation;
		}

		/**
		 * Sets the designation of the user.
		 *
		 * @param designation The designation of the user.
		 */
		public void setDesignation(Designation designation) {
			this.designation = designation;
		}

		/**
		 *Gets the contact number of the user.
		 *
		 * @return contactNumber The contact number of the user.
		 */
		public String getContactNumber() {
			return contactNumber;
		}

		/**
		 * Sets the contact number of the user.
		 *
		 * @param contactNumber The contact number of the user.
		 */
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		/**
		 * Gets the role of the user.
		 *
		 * @return The role of the user.
		 */
		public Role getRole() {
			return role;
		}

		/**
		 * Sets the role of the user.
		 *
		 * @param role The role of the user.
		 */
		public void setRole(Role role) {
			this.role = role;
		}

		/**
		 * Gets the post posted by user.
		 *
		 * @return posts The post posted by user.
		 */
		public List<Post> getPosts() {
			return posts;
		}

		/**
		 * Sets the posts.
		 * @param posts .
		 */
		public void setPosts(List<Post> posts) {
			this.posts = posts;
		}

}
