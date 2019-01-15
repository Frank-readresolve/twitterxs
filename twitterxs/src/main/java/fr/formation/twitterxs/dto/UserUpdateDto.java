package fr.formation.twitterxs.dto;

import java.time.LocalDate;

import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import fr.formation.twitterxs.errors.*;

/**
 * A composed DTO that represents useful data and validation rules in order to
 * update a user.
 */
@UniqueUpdateEmail
public class UserUpdateDto implements Dto {

    private static final long serialVersionUID = 8266231180593881946L;

    @NotNull(message = "{E_NOT_NULL}")
    private Long id;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String lastname;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String firstname;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 255, message = "{E_MAX_LENGTH_EXCEEDED}")
    @Email(message = "{E_EMAIL_MALFORMED}")
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "{E_NOT_NULL}")
    @Adult
    private LocalDate birthDate;

    @NotNull(message = "{E_NOT_NULL}")
    private Long regionId;

    public UserUpdateDto() {
	// Default no-arg constructor
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{lastname=" + lastname + ", firstname=" + firstname + ", email="
		+ email + ", birthDate=" + birthDate + ", regionId=" + regionId
		+ "}";
    }
}
