package fr.formation.twitterxs.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

/**
 * This class represents a tweet liked by a user. It defines the domain model
 * and its mapping strategy for liked tweets.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "liker_id",
	"tweet_id" }))
public class LikedTweet implements BusinessEntity {

    private static final long serialVersionUID = 6448049008652345321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(nullable = false)
    private LocalDateTime optLock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User liker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Tweet tweet;

    @Column(nullable = false, updatable = false)
    private LocalDateTime likedDate;

    /**
     * Creates a new {@code LikedTweet} with default values.
     */
    public LikedTweet() {
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

    public User getLiker() {
	return liker;
    }

    public void setLiker(User liker) {
	this.liker = liker;
    }

    public Tweet getTweet() {
	return tweet;
    }

    public void setTweet(Tweet tweet) {
	this.tweet = tweet;
    }

    public LocalDateTime getLikedDate() {
	return likedDate;
    }

    public void setLikedDate(LocalDateTime date) {
	likedDate = date;
    }

    /**
     * Indicates whether some other object is "equal to" this
     * {@code liked tweet}.
     * <p>
     * Two {@code LikedTweet} objects are considered equal if their
     * {@code liker} and {@code tweet} are equal.
     *
     * @param an
     *            object to test equality against
     * @return {@code true} if this {@code liked tweet} is the same as
     *         {@code obj}; {@code false} otherwise
     * @see User#equals(Object)
     * @see Tweet#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof LikedTweet)) {
	    return false;
	}
	LikedTweet other = (LikedTweet) obj;
	return liker.equals(other.liker) && tweet.equals(other.tweet);
    }

    /**
     * Returns a hash code value for this {@code liked tweet}.
     * <p>
     * This implementation is consistent with {@link #equals(Object)}.
     *
     * @return a hash code value for this {@code liked tweet}
     */
    @Override
    public int hashCode() {
	return Objects.hash(liker, tweet);
    }
}
