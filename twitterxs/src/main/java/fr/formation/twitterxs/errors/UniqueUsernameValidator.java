package fr.formation.twitterxs.errors;

import javax.validation.*;

import fr.formation.twitterxs.services.UserService;

public class UniqueUsernameValidator
	implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    // @Autowired is optional with one constructor
    protected UniqueUsernameValidator(UserService userService) {
	this.userService = userService;
    }

    @SuppressWarnings("unused")
    @Override
    public boolean isValid(String username,
	    ConstraintValidatorContext constraintValidatorContext) {
	if (null == username || username.isEmpty()) {
	    return true;
	}
	return userService.usernameUnique(username);
    }
}
