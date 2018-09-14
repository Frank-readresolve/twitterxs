package fr.formation.twitterxs.errors;

import javax.validation.*;

import fr.formation.twitterxs.dto.UserUpdatePasswordDto;

public class PasswordsValidator
	implements ConstraintValidator<Passwords, UserUpdatePasswordDto> {

    public PasswordsValidator() {
	// Empty
    }

    @SuppressWarnings("unused")
    @Override
    public boolean isValid(UserUpdatePasswordDto value,
	    ConstraintValidatorContext context) {
	String previousPassword = value.getPreviousPassword();
	String password = value.getPassword();
	if (null == previousPassword || null == password
		|| previousPassword.isEmpty() || password.isEmpty()) {
	    return true;
	}
	return !password.equals(previousPassword);
    }
}
