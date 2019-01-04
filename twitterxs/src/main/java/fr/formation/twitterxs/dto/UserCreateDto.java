package fr.formation.twitterxs.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import fr.formation.twitterxs.errors.*;

/**
 * A composed DTO that represents useful data and validation rules in order to
 * create a user.
 */
public class UserCreateDto implements Dto {

    private static final long serialVersionUID = 1273071586018268596L;

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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "{E_NOT_NULL}")
    @Adult
    private LocalDate birthDate;

    @NotNull(message = "{E_NOT_NULL}")
    private Long regionId;

    @Valid // Cascade validation
    private UserSecurityCreateDto security;

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

    public Long getRegionId() {
	return regionId;
    }

    public void setRegionId(Long id) {
	regionId = id;
    }

    public UserSecurityCreateDto getSecurity() {
	return security;
    }

    public void setSecurity(UserSecurityCreateDto security) {
	this.security = security;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{lastname=" + lastname + ", firstname=" + firstname + ", email="
		+ email + ", birthDate=" + birthDate + ", security=" + security
		+ "regionId=" + regionId + "}";
    }
}
