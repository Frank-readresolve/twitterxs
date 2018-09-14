package fr.formation.twitterxs.services.impl;

import fr.formation.twitterxs.domain.entities.User;
import fr.formation.twitterxs.dto.*;

/**
 * An helper class to build DTO from business entities and other DTO.
 */
final class DtoHelper {

    private DtoHelper() {
	// Utility class
    }

    static UserIdentityDto asUserIdentityDto(User user) {
	UserIdentityDto dto = new UserIdentityDto();
	dto.setBirthDate(user.getBirthDate());
	dto.setCountryCode(user.getRegion().getCountry());
	dto.setEmail(user.getEmail());
	dto.setFirstname(user.getFirstname());
	dto.setLastname(user.getLastname());
	dto.setUsername(user.getSecurity().getUsername());
	return dto;
    }

    static UserProfileDto asUserProfileDto(User user, StatsDto stats) {
	UserProfileDto dto = new UserProfileDto();
	UserIdentityDto identity = asUserIdentityDto(user);
	dto.setIdentity(identity);
	dto.setStats(stats);
	return dto;
    }

    static GlobalStatsDto asGlobalStatsDto(StatsDto tweetStats, long users) {
	GlobalStatsDto dto = new GlobalStatsDto();
	dto.setTweetStats(tweetStats);
	dto.setUsers(users);
	return dto;
    }
}
