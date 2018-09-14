package fr.formation.twitterxs.errors;

import java.io.Serializable;

/**
 * Represents a message not readable error.
 */
public class MessageNotReadableError implements Serializable {

    private static final long serialVersionUID = -6144595402971494591L;

    private String cause;

    private String error = "{E_MESSAGE_NOT_READABLE}";

    /**
     * Creates a new {@code MessageNotReadableError} with default {@code null}
     * values.
     */
    public MessageNotReadableError() {
	// Default no-arg constructor
    }

    /**
     * Creates a new {@code MessageNotReadableError} with given values.
     *
     * @param cause
     *            the cause
     */
    public MessageNotReadableError(String cause) {
	setCause(cause);
    }

    public String getCause() {
	return cause;
    }

    public void setCause(String cause) {
	this.cause = cause;
    }

    public String getError() {
	return error;
    }

    /**
     * Returns a string representation of this {@code error}.
     *
     * @return a string representation of this {@code error}
     */
    @Override
    public String toString() {
	return "{cause=" + cause + ", error=" + error + "}";
    }
}
