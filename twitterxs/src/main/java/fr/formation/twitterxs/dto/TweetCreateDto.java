package fr.formation.twitterxs.dto;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TweetCreateDto implements Dto {

    private static final long serialVersionUID = -3398239220863468125L;

    @JsonIgnore
    private Long authorId;

    @NotEmpty(message = "{E_NOT_EMPTY}")
    @Size(max = 280, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String content;

    public TweetCreateDto() {
	// Default no-arg constructor
    }

    public Long getAuthorId() {
	return authorId;
    }

    public void setAuthorId(Long authorId) {
	this.authorId = authorId;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{authorId=" + authorId + ", content=" + content + "}";
    }
}
