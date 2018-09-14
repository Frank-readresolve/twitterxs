package fr.formation.twitterxs.errors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * This class represents some validation errors.
 */
public final class ApiErrors<T> implements Serializable {

    private static final long serialVersionUID = 7277092767926099434L;

    private final List<T> errors;

    private final int errorCount;

    private final LocalDateTime timestamp = LocalDateTime.now();

    private final int status;

    private final String path;

    /**
     * Creates a new {@code ErrorDetails} with given validation errors.
     *
     * @param the
     *            validation errors
     * @throws NullPointerException
     *             if {@code errors} is {@code null}
     */
    public ApiErrors(List<T> errors, int status, String path) {
	this.errors = Collections.unmodifiableList(errors);
	errorCount = errors.size();
	this.status = status;
	this.path = path;
    }

    /**
     * Returns an immutable list of {@code ValidationError}s.
     *
     * @return an immutable list of {@code ValidationError}s; never
     *         {@code null}, may be empty
     */
    public List<T> getErrors() {
	return errors;
    }

    /**
     * Returns the number of validation errors contained in this
     * {@code error details}.
     *
     * @return the number of validation errors
     */
    public int getErrorCount() {
	return errorCount;
    }

    /**
     * Returns the time this {@code error details} was constructed.
     *
     * @return the time this {@code error details} was constructed
     */
    public LocalDateTime getTimestamp() {
	return timestamp;
    }

    /**
     * Returns the HTTP status code for this {@code error details}.
     *
     * @return the HTTP status code
     */
    public int getStatus() {
	return status;
    }

    /**
     * Returns the requested path which produced this {@code error details}.
     *
     * @return the requested path
     */
    public String getPath() {
	return path;
    }

    /**
     * Returns a string representation of this {@code error details}.
     *
     * @return a string representation of this {@code error details}
     */
    @Override
    public String toString() {
	return "{errorCount=" + errorCount + ", timestamp=" + timestamp
		+ ", status=" + status + ", path=" + path + "}";
    }
}
