package fr.formation.twitterxs.controllers;

import javax.validation.Valid;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import fr.formation.twitterxs.dto.*;
import fr.formation.twitterxs.services.TweetService;

/**
 * A Rest controller to deal with tweets.
 */
@RestController
@RequestMapping("/tweets")
@Secured("ROLE_USER")
public class TweetController extends BaseController {

    private final TweetService service;

    // @Autowired is optional with one constructor
    protected TweetController(TweetService service) {
	this.service = service;
    }

    /**
     * Endpoint to post a new tweet with given inputs for an authenticated user.
     *
     * @param dto
     *            the inputs related to a tweet to post for an authenticated
     *            user
     */
    @PostMapping("/post")
    protected void post(@Valid @RequestBody TweetCreateDto dto) {
	dto.setAuthorId(getUserId());
	service.post(dto);
    }

    /**
     * Endpoint to like a tweet with given inputs for an authenticated user.
     *
     * @param dto
     *            the inputs related to a tweet to like for an authenticated
     *            user
     */
    @PostMapping("/like")
    protected void like(@Valid @RequestBody LikedTweetCrudDto dto) {
	dto.setLikerId(getUserId());
	service.like(dto);
    }

    /**
     * Endpoint to unlike a tweet with given inputs.
     *
     * @param dto
     *            the inputs related to a tweet to unlike
     */
    @PostMapping("/unlike")
    protected void unlike(@Valid @RequestBody LikedTweetCrudDto dto) {
	dto.setLikerId(getUserId());
	service.unlike(dto);
    }

    /**
     * Endpoint to retrieve the stats for an authenticated user.
     *
     * @return the stats for an authenticated user
     */
    @GetMapping("/stats")
    protected StatsDto stats() {
	return service.stats(getUserId());
    }

    /**
     * Endpoint to retrieve the feed for an optional given username.
     * <p>
     * If the username is not provided; authenticated user's feed is returned.
     *
     * @return the feed for a username
     */
    @GetMapping("/feed/{username}")
    protected SearchResultDto<TweetDto> feed(
	    @PathVariable(name = "username", required = false) String username,
	    @RequestParam(name = "p", required = false) Integer p,
	    @RequestParam(name = "s", required = false) Integer s) {
	String authorUsername = username;
	if (null == authorUsername) {
	    authorUsername = getPrincipal().getUsername();
	}
	int page = null == p ? 0 : Integer.max(0, p);
	int size = null == s ? 5 : Integer.max(1, s);
	TweetSearchDto dto = new TweetSearchDto(authorUsername, page, size);
	return service.feed(dto);
    }
}
