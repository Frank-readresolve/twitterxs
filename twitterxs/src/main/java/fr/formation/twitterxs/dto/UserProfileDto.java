package fr.formation.twitterxs.dto;

/**
 * A DTO that represents useful data related to a user profile.
 */
public class UserProfileDto implements Dto {

    private static final long serialVersionUID = 7841165912821341724L;

    private UserIdentityDto identity = new UserIdentityDto();

    private StatsDto stats = new StatsDto();

    public UserProfileDto() {
	// Default no-arg constructor
    }

    public UserIdentityDto getIdentity() {
	return identity;
    }

    public void setIdentity(UserIdentityDto identity) {
	this.identity = identity;
    }

    public StatsDto getStats() {
	return stats;
    }

    public void setStats(StatsDto stats) {
	this.stats = stats;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{identity=" + identity + ", stats=" + stats + "}";
    }
}
