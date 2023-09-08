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
 * The {@code RegisterInDto} class represents a Data Transfer Object (DTO) for
 * user-related data. It is used to transfer user information between different
 * parts of the application.
 *
 * @author Ashutosh Tigga
 */
public class RegisterInDto {
		/**
		 * The id of the user.
		 */
    private String id;

    /**
     * The minimum size of the name.
     */
    private final int nameMinSize = 4;

    /**
     * The first name of the user.
     */
    @NotBlank(message = "First name is required")
    @Size(min = nameMinSize, message = "First name must be at least 4 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
    private String firstName;

    /**
     * The last name of the user.
     */
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
    @Size(min = nameMinSize, message = "Last name must be at least 3 characters")
    @NotBlank(message = "Last name is required")
    private String lastName;

    /**
     * The gender of the user.
     */
    @NotNull
    private Gender gender;

    /**
     * The email address of the user.
     */
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$", message = "Email is not valid")
    private String email;

    /**
     * Password size defined here.
     */
    private final int passwordSize = 6;

    /**
     * The password of the user.
     */
    @Size(min = passwordSize, message = "Password must be at least 6 characters")
    private String password;

    /**
     * The designation of the user.
     */
    @NotNull
    private Designation designation;

    /**
     * The contact number of the user.
     */
    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be a 10-digit number")
    @NotBlank(message = "Contact number is required")

    private String contactNumber;

    /**
     * The role of the user.
     */
    private Role role;

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
    public void setPassword(String password) {
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
     * Returns a hash code value for the object.
     *
     * @return A hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(contactNumber, designation, email, firstName, gender, lastName, nameMinSize, password,
                passwordSize, role);
    }

    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param obj The object to compare.
     * @return `true` if equal, `false` otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegisterInDto other = (RegisterInDto) obj;
        return Objects.equals(contactNumber, other.contactNumber) && designation == other.designation
                && Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && gender == other.gender
                && Objects.equals(lastName, other.lastName) && nameMinSize == other.nameMinSize
                && Objects.equals(password, other.password) && passwordSize == other.passwordSize && role == other.role;
    }

    /**
     * Returns a string representation of this object.
     *
     * @return A string describing the object.
     */
    @Override
    public String toString() {
        return "RegisterInDto [nameMinSize=" + nameMinSize + ", firstName=" + firstName + ", lastName=" + lastName
                + ", gender=" + gender + ", email=" + email + ", passwordSize=" + passwordSize + ", password=" + password
                + ", designation=" + designation + ", contactNumber=" + contactNumber + ", role=" + role + "]";
    }
}
