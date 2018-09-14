package fr.formation.twitterxs.dto;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.formation.twitterxs.errors.Passwords;

/**
 * A DTO that represents useful data and validation rules in order to update the
 * password of a user.
 */
@Passwords
public class UserUpdatePasswordDto implements Dto {

    private static final long serialVersionUID = 4783916072620526182L;

    @JsonIgnore
    private Long userId;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String previousPassword;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String password;

    public UserUpdatePasswordDto() {
	// Default no-arg constructor
    }

    public Long getUserId() {
	return userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public String getPreviousPassword() {
	return previousPassword;
    }

    public void setPreviousPassword(String previousPassword) {
	this.previousPassword = previousPassword;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	// Keep passwords secret!
	return "{userId=" + userId + "}";
    }
}
