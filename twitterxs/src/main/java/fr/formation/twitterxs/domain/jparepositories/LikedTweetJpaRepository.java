package fr.formation.twitterxs.domain.jparepositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;

import fr.formation.twitterxs.domain.entities.LikedTweet;

/**
 * A JPA repository to deal with {@code LikedTweet}s.
 */
public interface LikedTweetJpaRepository
	extends JpaRepository<LikedTweet, Long> {

    /**
     * Derived query to delete a {@code LikedTweet} with given liker and tweet
     * ids.
     *
     * @param likerId
     *            the liker id
     * @param tweetId
     *            the tweet id
     */
    @Transactional
    public void deleteByLikerIdAndTweetId(Long likerId, Long tweetId);

    /**
     * Returns the number of liked tweets for a given user (liker).
     *
     * @param id
     *            the id of the liker
     * @return the number of liked tweets
     */
    public long countByLikerId(Long id);

    /**
     * Returns the number of liked tweets.
     *
     * @return the number of liked tweets
     */
    @Query("select count(distinct lt.tweet) from LikedTweet lt")
    public long countAllByDistinctTweet();
}
