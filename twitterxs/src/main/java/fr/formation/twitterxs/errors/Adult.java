package fr.formation.twitterxs.errors;

import java.lang.annotation.*;

import javax.validation.*;

/**
 * Validates a date against majority.
 * <p>
 * Accepted type is {@code LocalDate}.
 * <p>
 * <b>A {@code null} value is considered as valid</b>. Other validation should
 * be used to check against {@code null}.
 *
 * @see AdultValidator
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE,
	ElementType.PARAMETER })
@Constraint(validatedBy = AdultValidator.class)
public @interface Adult {

    int age() default 18;

    String message() default "{E_NOT_ADULT}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
