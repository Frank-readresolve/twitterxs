package fr.formation.twitterxs.security;

import java.util.*;

import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.formation.twitterxs.domain.entities.*;

public class Principal implements UserDetails, CredentialsContainer {

    private static final long serialVersionUID = -2102099438108566361L;

    private final Long userId;

    private String password;

    private final String username;

    private final Set<GrantedAuthority> authorities;

    private final boolean accountNonExpired;

    private final boolean accountNonLocked;

    private final boolean credentialsNonExpired;

    private final boolean enabled;

    public Principal(User user) { // Could be a DTO
	userId = user.getId();
	UserSecurity userSecurity = user.getSecurity();
	username = userSecurity.getUsername();
	password = userSecurity.getPassword();
	enabled = userSecurity.isEnabled();
	accountNonExpired = userSecurity.isAccountNonExpired();
	credentialsNonExpired = userSecurity.isCredentialsNonExpired();
	accountNonLocked = userSecurity.isAccountNonLocked();
	authorities = buildAuthorities(userSecurity);
    }

    private static Set<GrantedAuthority>
	    buildAuthorities(UserSecurity userSecurity) {
	String roleName = userSecurity.getRole().name();
	GrantedAuthority auth = new SimpleGrantedAuthority(roleName);
	Set<GrantedAuthority> auths = new HashSet<>(1);
	auths.add(auth);
	return Collections.unmodifiableSet(auths);
    }

    public Long getUserId() {
	return userId;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
	return authorities;
    }

    @Override
    public String getPassword() {
	return password;
    }

    @Override
    public String getUsername() {
	return username;
    }

    @Override
    public boolean isAccountNonExpired() {
	return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
	return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
	return enabled;
    }

    @Override
    public void eraseCredentials() {
	password = null;
    }

    /**
     * Indicates whether some other object is "equal to" this {@code principal}.
     * <p>
     * Two {@code Principal} objects are considered equal if their
     * {@code username} are equal case-sensitively.
     *
     * @param an
     *            object to test equality against
     * @return {@code true} if this {@code principal} is the same as
     *         {@code obj}; {@code false} otherwise
     * @see String#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof User)) {
	    return false;
	}
	Principal other = (Principal) obj;
	return username.equals(other.username);
    }

    /**
     * Returns a hash code value for this {@code principal}.
     * <p>
     * This implementation is consistent with {@link #equals(Object)}.
     *
     * @return a hash code value for this {@code principal}
     */
    @Override
    public int hashCode() {
	return Objects.hash(username);
    }
}
