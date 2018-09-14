package fr.formation.twitterxs.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LikedTweetCrudDto implements Dto {

    private static final long serialVersionUID = -1208248717781789610L;

    @JsonIgnore
    private Long likerId;

    @NotNull(message = "{E_NOT_NULL}")
    private Long tweetId;

    public LikedTweetCrudDto() {
	// Default no-arg constructor
    }

    public Long getLikerId() {
	return likerId;
    }

    public void setLikerId(Long likerId) {
	this.likerId = likerId;
    }

    public Long getTweetId() {
	return tweetId;
    }

    public void setTweetId(Long tweetId) {
	this.tweetId = tweetId;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{likerId=" + likerId + ", tweetId=" + tweetId + "}";
    }
}
