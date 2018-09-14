package fr.formation.twitterxs.domain.entities;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

/**
 * This class represents a {@code Region} entity. It defines the domain model
 * and its mapping strategy for regions.
 * <p>
 * Note that the class provides a {@linkplain #asLocale() convenient method} to
 * get the corresponding {@code java.util.Locale}.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "language",
	"country" }))
public class Region implements BusinessEntity {

    private static final long serialVersionUID = -985830316443490964L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(nullable = false)
    private LocalDateTime optLock;

    @Column(length = 4, nullable = false)
    private String language;

    @Column(length = 2, nullable = false)
    private String country;

    /**
     * Creates a new {@code Region} with default values.
     */
    public Region() {
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

    /**
     * Returns the ISO 639 2-to-4-letter lowercase language code.
     *
     * @return the ISO 639 2-to-4-letter lowercase language code; never
     *         {@code null}
     */
    public String getLanguage() {
	return language;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

    /**
     * Returns the ISO 3166 2-letter uppercase country code.
     *
     * @return the ISO 3166 2-letter uppercase country code; never {@code null}
     */
    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    /**
     * Convenient method returning the {@code Locale} instance for this
     * {@code region}.
     *
     * @return the {@code Locale} for this {@code region}; never {@code null}
     */
    public final Locale asLocale() {
	return new Locale(language, country);
    }

    /**
     * Indicates whether some other object is "equal to" this {@code region}.
     * <p>
     * Two {@code Region} objects are considered equal if their {@code language}
     * and {@code country} codes are equal case-sensitively.
     *
     * @param an
     *            object to test equality against
     * @return {@code true} if this {@code region} is the same as {@code obj};
     *         {@code false} otherwise
     * @see String#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof Region)) {
	    return false;
	}
	Region other = (Region) obj;
	return language.equals(other.language) && country.equals(other.country);
    }

    /**
     * Returns a hash code value for this {@code region}.
     * <p>
     * This implementation is consistent with {@link #equals(Object)}.
     *
     * @return a hash code value for this {@code region}
     */
    @Override
    public int hashCode() {
	return Objects.hash(language, country);
    }

    /**
     * Returns a string representation of this {@code region}.
     *
     * @return a string representation of this {@code region}
     */
    @Override
    public String toString() {
	return "{id=" + id + ", language=" + language + ", country=" + country
		+ "}";
    }
}
