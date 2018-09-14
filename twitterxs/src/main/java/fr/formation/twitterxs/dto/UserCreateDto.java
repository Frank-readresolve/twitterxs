package fr.formation.twitterxs.dto;

import java.time.LocalDate;

import javax.validation.constraints.*;

import fr.formation.twitterxs.errors.*;

/**
 * A DTO that represents useful data and validation rules in order to create a
 * user.
 */
public class UserCreateDto implements Dto {

    private static final long serialVersionUID = -1646395640156122791L;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String lastname;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String firstname;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 255, message = "{E_MAX_LENGTH_EXCEEDED}")
    @Email(message = "{E_EMAIL_MALFORMED}")
    @UniqueEmail
    private String email;

    @NotNull(message = "{E_NOT_NULL}")
    @Adult
    private LocalDate birthDate;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
    @UniqueUsername
    private String username;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String password;

    @NotNull(message = "{E_NOT_NULL}")
    private Long regionId;

    public UserCreateDto() {
	// Default no-arg constructor
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public LocalDate getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Long getRegionId() {
	return regionId;
    }

    public void setRegionId(Long id) {
	regionId = id;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	// Keep password secret!
	return "{lastname=" + lastname + ", firstname=" + firstname + ", email="
		+ email + ", birthDate=" + birthDate + ", username=" + username
		+ "regionId=" + regionId + "}";
    }
}
