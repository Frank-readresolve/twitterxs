package fr.formation.twitterxs.errors;

import java.time.LocalDate;

import javax.validation.*;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate> {

    private int age;

    protected AdultValidator() {
	// Empty
    }

    @Override
    public void initialize(Adult parameters) {
	age = parameters.age();
	if (age < 0) {
	    throw new IllegalArgumentException("age must be positive");
	}
    }

    @SuppressWarnings("unused")
    @Override
    public boolean isValid(LocalDate birthDate,
	    ConstraintValidatorContext constraintValidatorContext) {
	if (null == birthDate) {
	    return true;
	}
	return LocalDate.now().minusYears(age).isAfter(birthDate);
    }
}
