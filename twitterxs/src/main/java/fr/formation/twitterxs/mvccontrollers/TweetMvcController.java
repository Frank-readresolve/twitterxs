package fr.formation.twitterxs.mvccontrollers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.formation.twitterxs.dto.*;
import fr.formation.twitterxs.services.TweetService;

/**
 * A MVC controller to deal with tweets.
 */
@Controller
@RequestMapping("/mvc/tweets")
public class TweetMvcController {

    private final TweetService service;

    protected TweetMvcController(TweetService service) {
	this.service = service;
    }

    @GetMapping("/feed/{username}")
    public String feed(@PathVariable("username") String username, Model model) {
	TweetSearchDto dto = new TweetSearchDto(username, 0, 100);
	SearchResultDto<TweetDto> tweets = service.feed(dto);
	model.addAttribute("tweets", tweets);
	return "feed";
    }

    @SuppressWarnings("unused")
    @GetMapping("/create")
    public String create(@ModelAttribute("tweet") TweetCreateDto tweet,
	    Model model) {
	return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("tweet") TweetCreateDto tweet,
	    BindingResult result, Model model) {
	if (!result.hasErrors()) { // No annotation-like validation errors
	    service.post(tweet);
	    model.addAttribute("tweet", new TweetCreateDto()); // Reset form
	}
	return "create";
    }
}
