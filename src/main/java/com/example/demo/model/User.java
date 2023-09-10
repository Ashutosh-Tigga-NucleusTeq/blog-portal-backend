package com.example.demo.model;

import java.util.List;
import java.util.Objects;

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
 * It stores information about a user, including their first name, last name, gender, email, password,
 * designation, contact number, and role.
 *
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
    private Role role = Role.Employee;

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
     */
    public User(String firstName, String lastName, Gender gender, String email, String password,
                Designation designation, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.designation = designation;
        this.contactNumber = contactNumber;
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
     *
     * @return The id of the user.
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
     * @return The first name of the user.
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
     * Gets the last name of the user.
     *
     * @return The last name of the user.
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
     *
     * @return The gender of the user.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the user.
     *
     * @param gender The gender of the user.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Gets the email of the user.
     *
     * @return The email of the user.
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
     * @return The password of the user.
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
     * @return The designation of the user.
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
     * Gets the contact number of the user.
     *
     * @return The contact number of the user.
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
     * Gets the list of blog posts authored by the user.
     *
     * @return The list of blog posts authored by the user.
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Sets the list of blog posts authored by the user.
     *
     * @param posts The list of blog posts authored by the user.
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Generates a hash code for this {@code User} object based on its contactNumber, designation, email,
     * firstName, gender, id, lastName, password, posts, and role.
     *
     * @return The generated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(contactNumber, designation, email, firstName, gender, id, lastName, password, posts, role);
    }

    /**
     * Compares this {@code User} object with another object to determine if they are equal.
     * Two {@code User} objects are considered equal if their contactNumber, designation, email, firstName, gender, id,
     * lastName, password, posts, and role are the same.
     *
     * @param obj The object to compare with.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
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
        return Objects.equals(contactNumber, other.contactNumber) && designation == other.designation
                && Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
                && gender == other.gender && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
                && Objects.equals(password, other.password) && Objects.equals(posts, other.posts) && role == other.role;
    }

    /**
     * Generates a string representation of this {@code User} object.
     *
     * @return The string representation of the {@code User} object.
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
                + ", gender=" + gender + ", email=" + email + ", password=" + password
                + ", designation=" + designation + ", contactNumber=" + contactNumber
                + ", role=" + role + ", posts=" + posts + "]";
    }
}
