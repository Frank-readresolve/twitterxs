package fr.formation.twitterxs.dto;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.formation.twitterxs.errors.*;

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
    @CurrentPassword
    private String currentPassword;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String newPassword;

    public UserUpdatePasswordDto() {
	// Default no-arg constructor
    }

    public Long getUserId() {
	return userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public String getCurrentPassword() {
	return currentPassword;
    }

    public void setCurrentPassword(String previousPassword) {
	currentPassword = previousPassword;
    }

    public String getNewPassword() {
	return newPassword;
    }

    public void setNewPassword(String password) {
	newPassword = password;
    }
}
