package fr.formation.twitterxs.errors;

import javax.validation.*;

import fr.formation.twitterxs.dto.UserUpdateDto;
import fr.formation.twitterxs.services.UserService;

public class UniqueUpdateEmailValidator
	implements ConstraintValidator<UniqueUpdateEmail, UserUpdateDto> {

    private final UserService userService;

    protected UniqueUpdateEmailValidator(UserService userService) {
	this.userService = userService;
    }

    @SuppressWarnings("unused")
    @Override
    public boolean isValid(UserUpdateDto dto,
	    ConstraintValidatorContext constraintValidatorContext) {
	String email = dto.getEmail();
	if (null == email || email.isEmpty()) {
	    return true;
	}
	Long id = dto.getId();
	if (null == id) {
	    throw new IllegalArgumentException("id should not be null");
	}
	return userService.updateEmailUnique(email, id);
    }
}
