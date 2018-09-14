package fr.formation.twitterxs.errors;

import javax.validation.*;

import fr.formation.twitterxs.services.UserService;

public class UniqueEmailValidator
	implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    // @Autowired is optional with one constructor
    protected UniqueEmailValidator(UserService userService) {
	this.userService = userService;
    }

    @SuppressWarnings("unused")
    @Override
    public boolean isValid(String email,
	    ConstraintValidatorContext constraintValidatorContext) {
	if (null == email || email.isEmpty()) {
	    return true;
	}
	return userService.emailUnique(email);
    }
}
