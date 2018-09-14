package fr.formation.twitterxs.services.impl;

import java.time.LocalDateTime;

import fr.formation.twitterxs.domain.entities.*;
import fr.formation.twitterxs.dto.*;

/**
 * An helper class to build business entities from DTO and other entities.
 */
final class EntityHelper {

    private EntityHelper() {
	// Utility class
    }

    static User asUser(UserCreateDto dto, Region region) {
	User entity = new User();
	entity.setBirthDate(dto.getBirthDate());
	entity.setEmail(dto.getEmail());
	entity.setFirstname(dto.getFirstname());
	entity.setLastname(dto.getLastname());
	entity.setSubscriptionDate(LocalDateTime.now());
	entity.setRegion(region);
	UserSecurity security = new UserSecurity();
	security.setUsername(dto.getUsername());
	security.setPassword(dto.getPassword());
	entity.setSecurity(security);
	return entity;
    }

    static Tweet asTweet(TweetCreateDto dto, User author) {
	Tweet entity = new Tweet();
	entity.setContent(dto.getContent());
	LocalDateTime now = LocalDateTime.now();
	entity.setPostDate(now);
	entity.setEditDate(now);
	entity.setAuthor(author);
	return entity;
    }

    static LikedTweet asLikedTweet(User liker, Tweet tweet) {
	LikedTweet entity = new LikedTweet();
	entity.setLiker(liker);
	entity.setTweet(tweet);
	entity.setLikedDate(LocalDateTime.now());
	return entity;
    }

    static Region asRegion(RegionCreateDto dto) {
	Region entity = new Region();
	entity.setLanguage(dto.getLanguage());
	entity.setCountry(dto.getCountry());
	return entity;
    }
}
