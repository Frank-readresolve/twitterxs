package fr.formation.twitterxs.dto;

/**
 * A DTO to represents some global statistics.
 */
public class GlobalStatsDto implements Dto {

    private static final long serialVersionUID = -7949332915981532264L;

    private StatsDto tweetStats = new StatsDto();

    private long users;

    public GlobalStatsDto() {
	// Default no-arg constructor
    }

    public StatsDto getTweetStats() {
	return tweetStats;
    }

    public void setTweetStats(StatsDto stats) {
	tweetStats = stats;
    }

    public long getUsers() {
	return users;
    }

    public void setUsers(long users) {
	this.users = users;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{tweetStats=" + tweetStats + ", users=" + users + "}";
    }
}
