package fr.formation.twitterxs.domain.jparepositories;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import fr.formation.twitterxs.domain.entities.Tweet;
import fr.formation.twitterxs.dto.TweetDto;

/**
 * A JPA repository to deal with {@code Tweet}s.
 */
public interface TweetJpaRepository extends JpaRepository<Tweet, Long> {

    /**
     * Returns the number of tweets for a given user (liker).
     *
     * @param id
     *            the id of the user
     * @return the number of tweets
     */
    public long countByAuthorId(Long userId);

    /**
     * Returns a page of twwets for given username and pageable information.
     *
     * @param username
     *            the username
     * @param pageable
     *            the pageable information
     * @return a page of twwets
     */
    @Query("select new fr.formation.twitterxs.dto.TweetDto(t.id, t.postDate, t.content) "
	    + "from Tweet t where t.author.security.username = :username order by t.postDate desc")
    public Page<TweetDto> findByUsername(@Param("username") String username,
	    Pageable pageable);
    // Positioned param version:
    // @Query("select new fr.formation.twitterxs.dto.TweetDto(t.id, t.postDate,
    // t.content) from Tweet t where t.author.security.username = ?1 order by
    // t.postDate
    // desc")
    // public Page<TweetDto> findByUsername(String username,
    // Pageable pageable);
}
