package fr.formation.twitterxs.dto;

import java.time.LocalDate;

/**
 * A DTO that represents useful data related to a user identity.
 */
public class UserIdentityDto implements Dto {

    private static final long serialVersionUID = -6196036006205925907L;

    private Long id;

    private String lastname;

    private String firstname;

    private String email;

    private String username;

    private LocalDate birthDate;

    private String countryCode;

    public UserIdentityDto() {
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

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public LocalDate getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(LocalDate date) {
	birthDate = date;
    }

    public String getCountryCode() {
	return countryCode;
    }

    public void setCountryCode(String code) {
	countryCode = code;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{id=" + id + ", lastname=" + lastname + ", firstname="
		+ firstname + ", email=" + email + ", username=" + username
		+ ", birthDate=" + birthDate + ", countryCode=" + countryCode
		+ "}";
    }
}
