package fr.formation.twitterxs.dto;

import javax.validation.constraints.*;

import fr.formation.twitterxs.errors.UniqueUsername;

/**
 * A DTO that represents useful security data and validation rules in order to
 * create a user.
 */
public class UserSecurityCreateDto implements Dto {

    private static final long serialVersionUID = -6196036006205925907L;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
    @UniqueUsername
    private String username;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String password;

    public UserSecurityCreateDto() {
	// Default no-arg constructor
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

    @Override
    public String toString() {
	// Keep password secret!
	return "{username=" + username + "}";
    }
}
