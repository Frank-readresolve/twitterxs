package fr.formation.twitterxs.errors;

import java.lang.annotation.*;

import javax.validation.*;

/**
 * Validates if an email is unique or not ignoring update case.
 * <p>
 * Accepted type is {@code String}.
 * <p>
 * Uniquness is tested if and only if the value is neither {@code null} nor
 * empty. That said <b>a {@code null} or empty value is considered as valid</b>.
 * Other validation should be used to check against {@code null} and empty
 * values.
 *
 * @see String#isEmpty()
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = UniqueUpdateEmailValidator.class)
public @interface UniqueUpdateEmail {

    String message() default "{E_NOT_UNIQUE}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
