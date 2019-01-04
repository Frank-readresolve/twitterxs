package fr.formation.twitterxs.errors;

import javax.validation.*;

import fr.formation.twitterxs.security.SpringSecurityHelper;
import fr.formation.twitterxs.services.UserService;

public class CurrentPasswordValidator
	implements ConstraintValidator<CurrentPassword, String> {

    private final UserService userService;

    protected CurrentPasswordValidator(UserService userService) {
	this.userService = userService;
    }

    @SuppressWarnings("unused")
    @Override
    public boolean isValid(String password,
	    ConstraintValidatorContext constraintValidatorContext) {
	if (null == password || password.isEmpty()) {
	    return true;
	}
	String username = SpringSecurityHelper.getUsername();
	return userService.matchesCurrentPassword(username, password);
    }
}
