package fr.formation.twitterxs.services;

import fr.formation.twitterxs.dto.*;

/**
 * Service interface to deal with tweets and liked tweets.
 */
public interface TweetService {

    /**
     * Creates a new tweet with given DTO.
     *
     * @param dto
     *            the DTO to populate the new tweet with
     */
    public void post(TweetCreateDto dto);

    public void like(LikedTweetCrudDto dto);

    public void unlike(LikedTweetCrudDto dto);

    public StatsDto stats(Long userId);

    public StatsDto stats();

    public SearchResultDto<TweetDto> feed(TweetSearchDto dto);
}
