package fr.formation.twitterxs.errors;

import java.lang.annotation.*;

import javax.validation.*;

/**
 * Validates if a password is the current one for an authenticated user.
 * <p>
 * Accepted type is {@code String}.
 * <p>
 * <b>{@code null} or empty values are considered as valid</b>. Other validation
 * should be used to check against {@code null} and empty values.
 *
 * @see String#isEmpty()
 * @see CurrentPasswordValidator
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = CurrentPasswordValidator.class)
public @interface CurrentPassword {

    String message() default "{E_CURRENT_PWD_BAD}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
