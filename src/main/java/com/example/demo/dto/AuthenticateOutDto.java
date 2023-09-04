
package com.example.demo.dto;

import java.util.Objects;
import com.example.demo.enumResource.Designation;
import com.example.demo.enumResource.Gender;
import com.example.demo.enumResource.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * This class represents a Data Transfer Object (DTO) used for sending user authentication data.
 * It contains information about the user's first name, last name, gender, email, designation, and contact number.
 */
public class AuthenticateOutDto {
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
     * The designation of the user.
     */
    @NotNull
    private Designation userDesgination;

    /**
     * The contact number of the user.
     */
    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be a 10-digit number")
    @NotBlank(message = "Contact number is required")
    private String userContactNumber;
    
    /**
     * The role of the user.
     */
    @NotNull
    private Role userRole;

    /**
     * Constructs a new AuthenticateOutDto object.
     *
     * @param userFirstNameParam     The user's first name.
     * @param userLastNameParam      The user's last name.
     * @param userGenderParam        The user's gender.
     * @param userEmailParam         The user's email address.
     * @param userDesginationParam   The user's designation.
     * @param userContactNumberParam The user's contact number.
     * @param userRoleParam 				 The user's role.
     */
    public AuthenticateOutDto(String userFirstNameParam,String userLastNameParam,
            Gender userGenderParam,String userEmailParam,
            Designation userDesginationParam,String userContactNumberParam,Role userRoleParam) {
        super();
        this.userFirstName = userFirstNameParam;
        this.userLastName = userLastNameParam;
        this.userGender = userGenderParam;
        this.userEmail = userEmailParam;
        this.userDesgination = userDesginationParam;
        this.userContactNumber = userContactNumberParam;
        this.userRole = userRoleParam;
    }

    public Role getUserRole() {
			return userRole;
		}

		public void setUserRole(Role userRole) {
			this.userRole = userRole;
		}

		/**
     * Get the user's first name.
     *
     * @return The user's first name.
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * Set the user's first name.
     *
     * @param userFirstNameParam The user's first name to set.
     */
    public void setUserFirstName(String userFirstNameParam) {
        this.userFirstName = userFirstNameParam;
    }

    /**
     * Get the user's last name.
     *
     * @return The user's last name.
     */
    public String getUserLastName() {
        return userLastName;
    }

    /**
     * Set the user's last name.
     *
     * @param userLastNameParam The user's last name to set.
     */
    public void setUserLastName(String userLastNameParam) {
        this.userLastName = userLastNameParam;
    }

    /**
     * Get the user's gender.
     *
     * @return The user's gender.
     */
    public Gender getUserGender() {
        return userGender;
    }

    /**
     * Set the user's gender.
     *
     * @param userGenderParam The user's gender to set.
     */
    public void setUserGender(Gender userGenderParam) {
        this.userGender = userGenderParam;
    }

    /**
     * Get the user's email address.
     *
     * @return The user's email address.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Set the user's email address.
     *
     * @param userEmailParam The user's email address to set.
     */
    public void setUserEmail(String userEmailParam) {
        this.userEmail = userEmailParam;
    }

    /**
     * Get the user's designation.
     *
     * @return The user's designation.
     */
    public Designation getUserDesgination() {
        return userDesgination;
    }

    /**
     * Set the user's designation.
     *
     * @param userDesginationParam The user's designation to set.
     */
    public void setUserDesgination(Designation userDesginationParam) {
        this.userDesgination = userDesginationParam;
    }

    /**
     * Get the user's contact number.
     *
     * @return The user's contact number.
     */
    public String getUserContactNumber() {
        return userContactNumber;
    }

    /**
     * Set the user's contact number.
     *
     * @param userContactNumberParam The user's contact number to set.
     */
    public void setUserContactNumber(String userContactNumberParam) {
        this.userContactNumber = userContactNumberParam;
    }

    /**
     * {@inheritDoc} hashCode override.
     */
    @Override
		public int hashCode() {
			return Objects.hash(userContactNumber, userDesgination, userEmail, userFirstName, userGender, userLastName,
					userRole);
		}
    
    /**
     * {@inheritDoc} equals override.
     */
    @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AuthenticateOutDto other = (AuthenticateOutDto) obj;
			return Objects.equals(userContactNumber, other.userContactNumber) && userDesgination == other.userDesgination
					&& Objects.equals(userEmail, other.userEmail) && Objects.equals(userFirstName, other.userFirstName)
					&& userGender == other.userGender && Objects.equals(userLastName, other.userLastName)
					&& userRole == other.userRole;
		}

    /**
     * {@inheritDoc} toString override.
     */
		@Override
		public String toString() {
			return "AuthenticateOutDto [userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userGender="
					+ userGender + ", userEmail=" + userEmail + ", userDesgination=" + userDesgination + ", userContactNumber="
					+ userContactNumber + ", userRole=" + userRole + "]";
		}
}
