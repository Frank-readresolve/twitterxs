package fr.formation.twitterxs.services.impl;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import fr.formation.twitterxs.domain.entities.*;
import fr.formation.twitterxs.domain.jparepositories.*;
import fr.formation.twitterxs.dto.*;
import fr.formation.twitterxs.services.TweetService;

@Service
public class TweetServiceImpl implements TweetService {

    private final TweetJpaRepository tweetJpaRepo;

    private final LikedTweetJpaRepository likedTweetJpaRepo;

    private final UserJpaRepository userJpaRepo;

    // @Autowired is optional with one constructor
    protected TweetServiceImpl(TweetJpaRepository tweetJpaRepo,
	    LikedTweetJpaRepository likedTweetJpaRepo,
	    UserJpaRepository userJpaRepo) {
	this.tweetJpaRepo = tweetJpaRepo;
	this.likedTweetJpaRepo = likedTweetJpaRepo;
	this.userJpaRepo = userJpaRepo;
    }

    @Override
    public void post(TweetCreateDto dto) {
	User author = userJpaRepo.findById(dto.getAuthorId()).get();
	Tweet tweet = EntityHelper.asTweet(dto, author);
	tweetJpaRepo.save(tweet); // Do not return saved entity
    }

    @Override
    public void like(LikedTweetCrudDto dto) {
	User liker = userJpaRepo.findById(dto.getLikerId()).get();
	Tweet tweet = tweetJpaRepo.findById(dto.getTweetId()).get();
	LikedTweet likedTweet = EntityHelper.asLikedTweet(liker, tweet);
	likedTweetJpaRepo.save(likedTweet); // Do not return saved entity
    }

    @Override
    public void unlike(LikedTweetCrudDto dto) {
	Long likerId = dto.getLikerId();
	Long tweetId = dto.getTweetId();
	likedTweetJpaRepo.deleteByLikerIdAndTweetId(likerId, tweetId);
    }

    @Override
    public StatsDto stats(Long userId) {
	// Hand-made DTO
	long tweets = tweetJpaRepo.countByAuthorId(userId);
	long likedTweets = likedTweetJpaRepo.countByLikerId(userId);
	return new StatsDto(tweets, likedTweets);
    }

    @Override
    public StatsDto stats() {
	long tweets = tweetJpaRepo.count();
	long likedTweets = likedTweetJpaRepo.countAllByDistinctTweet();
	return new StatsDto(tweets, likedTweets);
    }

    @Override
    public SearchResultDto<TweetDto> feed(TweetSearchDto dto) {
	Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize());
	Page<TweetDto> page = tweetJpaRepo.findByUsername(dto.getUsername(),
		pageable);
	return new SearchResultDto<>(page.getContent(),
		page.getTotalElements());
    }
}
