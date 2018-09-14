package fr.formation.twitterxs.controllers;

import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import fr.formation.twitterxs.security.*;

/**
 * A controller to deal with API accesses.
 */
@RestController
@RequestMapping("/security")
public class SecurityController extends BaseController {

    private final static Logger LOGGER = LoggerFactory
	    .getLogger(SecurityController.class);

    protected SecurityController() {
	// Default no-arg constructor
    }

    /**
     * Returns a view of the authenticated user.
     *
     * @return the principal; never {@code null}
     */
    @GetMapping("/me")
    @AnyRole
    protected Principal me() {
	return getPrincipal();
    }

    /**
     * Redirecting endpoint for authentication flow. Invoked in case of bad
     * credentials provided.
     *
     * @return a Json serialized {@code BadCredentialsError}; never {@code null}
     */
    @RequestMapping("/authError")
    protected ResponseEntity<Object> authError() {
	HttpStatus status = HttpStatus.BAD_REQUEST;
	return new ResponseEntity<>(SecurityError.of(status, "Bad credentials"),
		status);
    }

    /**
     * Redirecting endpoint for authentication flow. Invoked after logout.
     * <p>
     * This implementation does nothing.
     */
    @RequestMapping("/logout")
    protected ResponseEntity<Object> logout() {
	return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Redirecting endpoint for authentication flow.
     * <p>
     * Erases the default login form.
     * <p>
     * This implementation does nothing.
     */
    @RequestMapping("/login")
    protected ResponseEntity<Object> login() {
	if (LOGGER.isDebugEnabled()) {
	    LOGGER.debug("Some debug log message");
	}
	HttpStatus status = HttpStatus.UNAUTHORIZED;
	return new ResponseEntity<>(SecurityError.of(status, "Unauthorized"),
		status);
    }
}
