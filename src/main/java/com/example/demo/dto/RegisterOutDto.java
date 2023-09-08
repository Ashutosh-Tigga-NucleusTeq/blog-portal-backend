package com.example.demo.dto;

import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * The {@code RegisterOutDto} class represents a Data Transfer Object (DTO) for
 * user-related data used to transfer user information between different parts
 * of the application.
 * @author [Author Name]
 */
public class RegisterOutDto {

    /**
     * The first name of the user.
     */
    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
    private String firstName;

    /**
     * The last name of the user.
     */
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain alphabets only")
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
    @NotNull
    private Role role;

    /**
     * Constructor for the RegisterOutDto class.
     *
     * @param firstName     The first name of the user.
     * @param lastName      The last name of the user.
     * @param gender        The gender of the user.
     * @param email         The email address of the user.
     * @param designation   The designation of the user.
     * @param contactNumber The contact number of the user.
     * @param role          The role of the user.
     */
    public RegisterOutDto(String firstName, String lastName, Gender gender, String email, Designation designation,
            String contactNumber, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.designation = designation;
        this.contactNumber = contactNumber;
        this.role = role;
    }
    /**
     * non parameterized constructor.
     */
    public RegisterOutDto() {
			// TODO Auto-generated constructor stub
		}

		/**
     * Retrieves the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The new first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The new last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the gender of the user.
     *
     * @return The gender of the user.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the user.
     *
     * @param gender The new gender to set.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The new email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the designation of the user.
     *
     * @return The designation of the user.
     */
    public Designation getDesignation() {
        return designation;
    }

    /**
     * Sets the designation of the user.
     *
     * @param designation The new designation to set.
     */
    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    /**
     * Retrieves the contact number of the user.
     *
     * @return The contact number of the user.
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the contact number of the user.
     *
     * @param contactNumber The new contact number to set.
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Retrieves the role of the user.
     *
     * @return The role of the user.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role The new role to set.
     */
    public void setRole(Role role) {
        this.role = role;
    }

}
