package fr.formation.twitterxs.dto;

/**
 * A base DTO to represents some statistics.
 */
public class StatsDto implements Dto {

    private static final long serialVersionUID = 5191079476820303160L;

    private long tweets;

    private long likedTweets;

    public StatsDto() {
	// Default no-arg constructor
    }

    public StatsDto(long tweets, long likedTweets) {
	setTweets(tweets);
	setLikedTweets(likedTweets);
    }

    public long getTweets() {
	return tweets;
    }

    public void setTweets(long tweets) {
	this.tweets = tweets;
    }

    public long getLikedTweets() {
	return likedTweets;
    }

    public void setLikedTweets(long likedTweets) {
	this.likedTweets = likedTweets;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{tweets=" + tweets + ", likedTweets=" + likedTweets + "}";
    }
}
