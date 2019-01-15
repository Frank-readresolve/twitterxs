package fr.formation.twitterxs.domain.entities;

import java.time.*;
import java.util.*;

import javax.persistence.*;

/**
 * This class represents a user entity. It defines the domain model and its
 * mapping strategy for users.
 */
@Entity
@Cacheable
public class User implements BusinessEntity {

    private static final long serialVersionUID = -1890491345830999462L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(nullable = false)
    private LocalDateTime optLock;

    @Column(length = 100, nullable = false)
    private String lastname;

    @Column(length = 100, nullable = false)
    private String firstname;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime subscriptionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Region region;

    @Embedded
    private UserSecurity security;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Tweet> tweets;

    @OneToMany(mappedBy = "liker", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<LikedTweet> likedTweets;

    /**
     * Creates a new {@code User} with default values.
     */
    public User() {
	// Default no-arg constructor
    }

    /**
     * Keep private for security and consistency.
     */
    @SuppressWarnings("unused")
    private LocalDateTime getOptLock() {
	return optLock;
    }

    /**
     * Keep private for security and consistency.
     */
    @SuppressWarnings("unused")
    private void setOptLock(LocalDateTime lock) {
	optLock = lock;
    }

    public Long getId() {
	return id;
    }

    /**
     * Keep private for security and consistency.
     */
    @SuppressWarnings("unused")
    private void setId(Long id) {
	this.id = id;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public LocalDate getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    public LocalDateTime getSubscriptionDate() {
	return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
	this.subscriptionDate = subscriptionDate;
    }

    public Region getRegion() {
	return region;
    }

    public void setRegion(Region region) {
	this.region = region;
    }

    public UserSecurity getSecurity() {
	return security;
    }

    public void setSecurity(UserSecurity security) {
	this.security = security;
    }

    public Set<Tweet> getTweets() {
	return tweets;
    }

    public void setTweets(Set<Tweet> tweets) {
	this.tweets = tweets;
    }

    public Set<LikedTweet> getLikedTweets() {
	return likedTweets;
    }

    public void setLikedTweets(Set<LikedTweet> likedTweets) {
	this.likedTweets = likedTweets;
    }

    /**
     * Indicates whether some other object is "equal to" this {@code user}.
     * <p>
     * Two {@code User} objects are considered equal if their {@code email} are
     * equal case-sensitively.
     *
     * @param an
     *            object to test equality against
     * @return {@code true} if this {@code user} is the same as {@code obj};
     *         {@code false} otherwise
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
	User other = (User) obj;
	return email.equals(other.email);
    }

    /**
     * Returns a hash code value for this {@code user}.
     * <p>
     * This implementation is consistent with {@link #equals(Object)}.
     *
     * @return a hash code value for this {@code user}
     */
    @Override
    public int hashCode() {
	return Objects.hash(email);
    }

    /**
     * Returns a string representation of this {@code user}.
     *
     * @return a string representation of this {@code user}
     */
    @Override
    public String toString() {
	// Do not print collections!
	return "{id=" + id + ", lastname=" + lastname + ", firstname="
		+ firstname + ", email=" + email + ", birthDate=" + birthDate
		+ ", subscriptionDate=" + subscriptionDate + ", region="
		+ region + "}";
    }

    /**
     * Enumeration of roles.
     * <p>
     * Enumeration order is not meaningful.
     */
    public enum Role {
	/** The ROLE_USER role. */
	ROLE_USER("USER"),
	/** The ROLE_ADMIN role. */
	ROLE_ADMIN("ADMIN"),
	/** The ROLE_ADMIN role. */
	ROLE_ACTUATOR("ACTUATOR");

	private final String notPrefixed;

	private Role(String notPrefixed) {
	    this.notPrefixed = notPrefixed;
	}

	/**
	 * Returns the default role.
	 *
	 * @return the default role; {@code ROLE_USER}
	 */
	public static Role getDefault() {
	    return ROLE_USER;
	}

	public boolean isUser() {
	    return equals(ROLE_USER);
	}

	public boolean isAdmin() {
	    return equals(ROLE_ADMIN);
	}

	public boolean isActuator() {
	    return equals(ROLE_ACTUATOR);
	}

	/**
	 * Returns the name of this {@code role} without its prefix
	 * {@code "ROLE_"}.
	 *
	 * @return the name without its prefix
	 */
	public String withoutPrefix() {
	    return notPrefixed;
	}
    }
}
