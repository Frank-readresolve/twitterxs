package fr.formation.twitterxs.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

/**
 * This class represents a tweet. It defines the domain model and its mapping
 * strategy for tweets.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "author_id",
	"postDate" }))
public class Tweet implements BusinessEntity {

    private static final long serialVersionUID = 1140413763101124326L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(nullable = false)
    private LocalDateTime optLock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User author;

    @Column(nullable = false, updatable = false)
    private LocalDateTime postDate;

    @Column(nullable = false)
    private LocalDateTime editDate;

    @Column(length = 280, nullable = false)
    private String content;

    /**
     * Creates a new {@code Tweet} with default values.
     */
    public Tweet() {
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

    public LocalDateTime getPostDate() {
	return postDate;
    }

    public void setPostDate(LocalDateTime date) {
	postDate = date;
    }

    public LocalDateTime getEditDate() {
	return editDate;
    }

    public void setEditDate(LocalDateTime date) {
	editDate = date;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public User getAuthor() {
	return author;
    }

    public void setAuthor(User author) {
	this.author = author;
    }

    /**
     * Indicates whether some other object is "equal to" this {@code tweet}.
     * <p>
     * Two {@code Tweet} objects are considered equal if their {@code author}
     * and {@code postDate} are equal.
     *
     * @param an
     *            object to test equality against
     * @return {@code true} if this {@code tweet} is the same as {@code obj};
     *         {@code false} otherwise
     * @see String#equals(Object)
     * @see LocalDateTime#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof Tweet)) {
	    return false;
	}
	Tweet other = (Tweet) obj;
	return author.equals(other.author) && postDate.equals(other.postDate);
    }

    /**
     * Returns a hash code value for this {@code tweet}.
     * <p>
     * This implementation is consistent with {@link #equals(Object)}.
     *
     * @return a hash code value for this {@code tweet}
     */
    @Override
    public int hashCode() {
	return Objects.hash(author, postDate);
    }

    /**
     * Returns a string representation of this {@code tweet}.
     *
     * @return a string representation of this {@code tweet}
     */
    @Override
    public String toString() {
	return "{id=" + id + ", author=" + author + ", postDate=" + postDate
		+ ", editDate=" + editDate + "}";
    }
}
