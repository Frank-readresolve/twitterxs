package fr.formation.twitterxs.security;

import java.util.Collection;

import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Helper class to access the Spring security context.
 * <p>
 * Provides convenient methods to deal with the currently authenticated
 * {@link Principal}.
 */
public final class SpringSecurityHelper {

    private SpringSecurityHelper() {
	// Ensure non-instantiability
    }

    /**
     * Returns the currently authenticated user identifier.
     *
     * @return the authenticated user identifier
     * @see #getPrincipal()
     * @see Principal#getUserId()
     */
    public static Long getUserId() {
	return getPrincipal().getUserId();
    }

    /**
     * Returns the currently authenticated user username.
     *
     * @return the authenticated user username
     * @see #getPrincipal()
     * @see Principal#getUsername()
     */
    public static String getUsername() {
	return getPrincipal().getUsername();
    }

    /**
     * Returns the currently authenticated principal.
     *
     * @throws NullPointerException
     *             if {@link #getAuthentication()} returns {@code null}
     */
    public static Principal getPrincipal() {
	return (Principal) getAuthentication().getPrincipal();
    }

    /**
     * Returns the authorities for the authenticated user.
     *
     * @return the authorities for the authenticated user
     * @throws NullPointerException
     *             if {@link #getAuthentication()} returns {@code null}
     */
    public static Collection<? extends GrantedAuthority> getAuthorities() {
	return getAuthentication().getAuthorities();
    }

    /**
     * Returns the {@code Authentication} object associated to the currently
     * authenticated principal, or an authentication request token.
     *
     * @return the Authentication or {@code null} if no
     *         authenticationinformation is available
     */
    public static Authentication getAuthentication() {
	return SecurityContextHolder.getContext().getAuthentication();
    }
}
