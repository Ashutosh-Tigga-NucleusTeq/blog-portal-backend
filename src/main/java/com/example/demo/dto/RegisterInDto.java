package com.example.demo.dto;

import java.util.Objects;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * The {@code RegisterInDto} class represents a Data Transfer Object (DTO) for
 * user-related data. It is used to transfer user information between different
 * parts of the application.
 *
 * @author [ Ashutosh Tigga]
 */
public class RegisterInDto {
    /**
     * The minimum size of the name.
     */
    private static final int NAMEMINSIZE = 2;

    /**
     * The first name of the user.
     */
    @NotBlank(message = "First name is required")
    @Size(min = NAMEMINSIZE, message = "First name must be at least 4 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
    private String firstName;

    /**
     * The last name of the user.
     */
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
    @Size(min = NAMEMINSIZE, message = "Last name must be at least 3 characters")
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
    private static final int PASSWORDSIZE = 6;

    /**
     * The password of the user.
     */
    @Size(min = PASSWORDSIZE, message = "Password must be at least 6 characters")
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
     * Constructs a new instance of the {@code RegisterInDto} class with the specified parameters.
     *
     * @param firstName     The first name of the user.
     * @param lastName      The last name of the user.
     * @param gender        The gender of the user.
     * @param email         The email address of the user.
     * @param password      The password of the user.
     * @param designation   The designation of the user.
     * @param contactNumber The contact number of the user.
     */
    public RegisterInDto(String firstName, String lastName, Gender gender, String email, String password,
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
     * Default constructor for the `PostInDto` class.
     */
    public RegisterInDto() {
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegisterInDto other = (RegisterInDto) obj;
        return Objects.equals(contactNumber, other.contactNumber) && designation == other.designation
                && Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
                && gender == other.gender && Objects.equals(lastName, other.lastName)
                && Objects.equals(password, other.password);
    }

    /**
     * Converts this object into a string representation for debugging and logging purposes.
     *
     * @return The string representation of this object.
     */
    @Override
    public String toString() {
        return "RegisterInDto [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
                + ", email=" + email + ", password=" + password + ", designation=" + designation
                + ", contactNumber=" + contactNumber + "]";
    }
}
