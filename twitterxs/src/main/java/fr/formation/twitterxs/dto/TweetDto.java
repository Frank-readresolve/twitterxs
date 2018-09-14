package fr.formation.twitterxs.dto;

import java.time.LocalDateTime;

/**
 * A DTO that represents useful data related to a tweet.
 */
public class TweetDto implements Dto {

    private static final long serialVersionUID = -3736260207382890449L;

    private Long tweetId;

    private LocalDateTime postDate;

    private String content;

    /**
     * Creates a new {@code TweetDto} with default values.
     */
    public TweetDto() {
	// Default no-arg constructor
    }

    public TweetDto(Long tweetId, LocalDateTime postDate, String content) {
	setTweetId(tweetId);
	setPostDate(postDate);
	setContent(content);
    }

    public Long getTweetId() {
	return tweetId;
    }

    public void setTweetId(Long tweetId) {
	this.tweetId = tweetId;
    }

    public LocalDateTime getPostDate() {
	return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
	this.postDate = postDate;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    @Override
    public String toString() {
	return "{tweetId=" + tweetId + ", postDate=" + postDate + ", content="
		+ content + "}";
    }
}
