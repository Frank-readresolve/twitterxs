package fr.formation.twitterxs.domain.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import fr.formation.twitterxs.domain.BooleanConverter;
import fr.formation.twitterxs.domain.entities.User.Role;

/**
 * This class represents user security info. It defines the domain model and its
 * mapping strategy for user security.
 */
@Embeddable
public class UserSecurity implements Serializable {

    private static final long serialVersionUID = 193956612997173231L;

    @Column(length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 13, nullable = false)
    private Role role = Role.getDefault();

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean accountNonExpired = true;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean accountNonLocked = true;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean credentialsNonExpired = true;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean enabled = true;

    /**
     * Creates a new {@code UserSecurity} with default values.
     */
    public UserSecurity() {
	// Default no-arg constructor
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public boolean isAccountNonExpired() {
	return accountNonExpired;
    }

    public void setAccountNonExpired(boolean flag) {
	accountNonExpired = flag;
    }

    public boolean isAccountNonLocked() {
	return accountNonLocked;
    }

    public void setAccountNonLocked(boolean flag) {
	accountNonLocked = flag;
    }

    public boolean isCredentialsNonExpired() {
	return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean flag) {
	credentialsNonExpired = flag;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean flag) {
	enabled = flag;
    }

    /**
     * Indicates whether some other object is "equal to" this
     * {@code user security}.
     * <p>
     * Two {@code User} objects are considered equal if their {@code username}
     * are equal case-sensitively.
     *
     * @param an
     *            object to test equality against
     * @return {@code true} if this {@code user security} is the same as
     *         {@code obj}; {@code false} otherwise
     * @see String#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof UserSecurity)) {
	    return false;
	}
	UserSecurity other = (UserSecurity) obj;
	return username.equals(other.username);
    }

    /**
     * Returns a hash code value for this {@code user security}.
     * <p>
     * This implementation is consistent with {@link #equals(Object)}.
     *
     * @return a hash code value for this {@code user security}
     */
    @Override
    public int hashCode() {
	return Objects.hash(username);
    }

    /**
     * Returns a string representation of this {@code user security}.
     *
     * @return a string representation of this {@code user security}
     */
    @Override
    public String toString() {
	// Keep password secret!
	return "{username=" + username + ", role=" + role
		+ ", accountNonExpired=" + accountNonExpired
		+ ", accountNonLocked=" + accountNonLocked
		+ ", credentialsNonExpired=" + credentialsNonExpired
		+ ", enabled=" + enabled + "}";
    }
}
