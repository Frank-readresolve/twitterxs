package fr.formation.twitterxs.dto;

import java.time.LocalDateTime;

/**
 * A DTO that represents useful data related to a tweet.
 */
public class TweetDto implements Dto {

    private static final long serialVersionUID = 1166510866456370560L;

    private Long tweetId;

    private LocalDateTime postDate;

    private String content;

    private long likedTimes;

    /**
     * Creates a new {@code TweetDto} with default values.
     */
    public TweetDto() {
	// Default no-arg constructor
    }

    public TweetDto(Long tweetId, LocalDateTime postDate, String content,
	    long likedTimes) {
	setTweetId(tweetId);
	setPostDate(postDate);
	setContent(content);
	setLikedTimes(likedTimes);
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

    public long getLikedTimes() {
	return likedTimes;
    }

    public void setLikedTimes(long likedTimes) {
	this.likedTimes = likedTimes;
    }

    @Override
    public String toString() {
	return "{tweetId=" + tweetId + ", postDate=" + postDate + ", content="
		+ content + ", likedTimes=" + likedTimes + "}";
    }
}
