package fr.formation.twitterxs.errors;

import java.lang.annotation.*;

import javax.validation.*;

/**
 * Validates if a pair of passwords are different and that current password
 * really is.
 * <p>
 * Accepted type is {@code String}.
 * <p>
 * <b>{@code null} or empty values are considered as valid</b>. Other validation
 * should be used to check against {@code null} and empty values.
 *
 * @see String#isEmpty()
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = PasswordsValidator.class)
public @interface Passwords {

    String message() default "{E_PWDS_NOT_DIFF}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
