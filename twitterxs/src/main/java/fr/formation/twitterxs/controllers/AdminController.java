package fr.formation.twitterxs.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import fr.formation.twitterxs.dto.*;
import fr.formation.twitterxs.services.*;

/**
 * A Rest controller dedicated to an admin user.
 */
@RestController
@RequestMapping("/admin")
// @PreAuthorize("hasRole('ROLE_ADMIN')")
@Secured("ROLE_ADMIN")
public class AdminController extends BaseController {

    private final UserService userService;

    private final CacheService cacheService;

    // @Autowired is optional with one constructor
    protected AdminController(UserService userService,
	    CacheService cacheService) {
	this.userService = userService;
	this.cacheService = cacheService;
    }

    /**
     * Endpoint to retrieve the identity of a user with given id.
     *
     * @param id
     *            the id of the user identity to retrieve
     * @return the identity of a user with given id
     */
    @GetMapping("/users/identity/{id}")
    protected UserIdentityDto identity(@PathVariable("id") Long id) {
	return userService.identity(id);
    }

    /**
     * Endpoint to retrieve the profile of a user with given id.
     *
     * @param id
     *            the id of the user profile to retrieve
     * @return the profile of a user with given id
     */
    @GetMapping("/users/profile/{id}")
    protected UserProfileDto profile(@PathVariable("id") Long id) {
	return userService.profile(id);
    }

    /**
     * Endpoint to delete a user with given id.
     *
     * @param id
     *            the id of the user to delete
     */
    @DeleteMapping("/users/delete/{id}")
    protected void deleteUser(@PathVariable("id") Long id) {
	userService.delete(id);
    }

    /**
     * Endpoint to retrieve the global stats.
     *
     * @return the global stats
     */
    @GetMapping("/stats")
    protected GlobalStatsDto stats() {
	return userService.stats();
    }

    /**
     * Returns a JSON representation of an object of the given type.
     *
     * @param className
     *            the fully qualified name of the desired JSON representation
     * @throws Exception
     *             if it was not possible to locate or instantiate the class
     */
    @GetMapping("/template/{className}")
    protected Object template(@PathVariable("className") String className)
	    throws Exception {
	return Class.forName(className).newInstance();
    }

    /**
     * Endpoint to retrieve the cache stats.
     *
     * @return the cache stats
     */
    @GetMapping("/cache")
    protected CacheDto cache() {
	return cacheService.stats();
    }
}
