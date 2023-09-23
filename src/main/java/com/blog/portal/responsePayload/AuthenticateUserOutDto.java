package com.blog.portal.responsePayload;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.Role;

/**
 * Represents a Data Transfer Object (DTO) used for sending user authentication
 * data. It contains information about the user's first name, last name, gender,
 * email, designation, and contact number.
 * @author [ Ashutosh Tigga]
 */
public class AuthenticateUserOutDto {
    /**
     * Id of the user.
     */
    private String id;

    /**
     * The first name of the user.
     */
    @NotBlank(message = "First name is required") // Ensures that the first name is not blank
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
    // Validates that the name contains only alphabets.
    private String firstName;

    /**
     * The last name of the user.
     */
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
    // Validates that the name contains only alphabets.
    @NotBlank(message = "Last name is required") // Ensures that the last name is not blank
    private String lastName;

    /**
     * The gender of the user.
     */
    @NotNull
    private Gender gender;

    /**
     * The email address of the user.
     */
    @Email(message = "Invalid email format") // Validates the email format
    @NotBlank(message = "Email is required") // Ensures that the email is not blank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$", message = "Email is not Valid")
    // Applies a custom regular expression pattern for email validation.
    private String email;

    /**
     * The designation of the user.
     */
    @NotNull
    private Designation designation;

    /**
     * The contact number of the user.
     */
    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be a 10-digit number")
    // Validates that the contact number is a 10-digit number.
    @NotBlank(message = "Contact number is required") // Ensures that the contact number is not blank
    private String contactNumber;

    /**
     * The role of the user.
     */
    @NotNull
    private Role role;

    /**
     * Constructor for creating an `AuthenticateOutDto` object.
     *
     * @param id            The id of the user.
     * @param firstName     The first name of the user.
     * @param lastName      The last name of the user.
     * @param gender        The gender of the user.
     * @param email         The email address of the user.
     * @param designation   The designation of the user.
     * @param contactNumber The contact number of the user.
     * @param role          The role of the user.
     */
    public AuthenticateUserOutDto(String id, String firstName, String lastName, Gender gender, String email,
                              Designation designation, String contactNumber, Role role) {
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
    public AuthenticateUserOutDto() {
        super();
    }

    /**
     * Gets the id of the user.
     *
     * @return id id of the user.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the user.
     *
     * @param id The id to set.
     */
    public void setId(String id) {
        this.id = id;
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
    public void setFirstName(String firstName) {
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
    public void setLastName(String lastName) {
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
    public void setGender(Gender gender) {
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
    public void setEmail(String email) {
        this.email = email;
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
    public void setDesignation(Designation designation) {
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
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Gets the role of the user.
     *
     * @return The user's role.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role The role to set.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Compares this object to another object to check for equality.
     *
     * @param obj The object to compare to.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
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
        AuthenticateUserOutDto other = (AuthenticateUserOutDto) obj;
        return Objects.equals(contactNumber, other.contactNumber) && designation == other.designation
                && Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && gender == other.gender
                && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName) && role == other.role;
    }

    /**
     * Generates a hash code value for this object based on its attributes.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(contactNumber, designation, email, firstName, gender, id, lastName, role);
    }

    /**
     * Converts this object into a string representation for debugging and logging purposes.
     *
     * @return The string representation of this object.
     */
    @Override
    public String toString() {
        return "AuthenticateOutDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
                + ", email=" + email + ", designation=" + designation + ", contactNumber=" + contactNumber + ", role=" + role
                + "]";
    }
}
