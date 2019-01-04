package fr.formation.twitterxs.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import fr.formation.twitterxs.dto.*;
import fr.formation.twitterxs.security.AnyRole;
import fr.formation.twitterxs.services.UserService;

/**
 * A Rest controller to deal with users.
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserService userService;

    // @Autowired is optional with one constructor
    protected UserController(UserService userService) {
	this.userService = userService;
    }

    /**
     * Endpoint to create a new user with given inputs.
     *
     * @param dto
     *            the inputs related to a user to create
     */
    @PostMapping("/create")
    // No security, anybody can create an account (see SecurityConfig)
    protected void create(@Valid @RequestBody UserCreateDto dto) {
	userService.create(dto);
    }

    /**
     * Endpoint to retrieve the identity of an authenticated user.
     *
     * @return the identity of an authenticated user
     */
    @GetMapping("/identity")
    @AnyRole
    protected UserIdentityDto identity() {
	Long userId = getUserId();
	return userService.identity(userId);
    }

    /**
     * Endpoint to retrieve the profile of an authenticated user.
     *
     * @return the profile of an authenticated user
     */
    @GetMapping("/profile")
    @AnyRole
    protected UserProfileDto profile() {
	Long userId = getUserId();
	return userService.profile(userId);
    }

    /**
     * Endpoint to update the password of an authenticated user.
     *
     * @param dto
     *            the inputs related to a password to update
     */
    @PostMapping("/update/password")
    @AnyRole
    protected void
	    updatePassword(@Valid @RequestBody UserUpdatePasswordDto dto) {
	Long userId = getUserId(); // Enforce self-update
	dto.setUserId(userId);
	userService.updatePassword(dto);
    }
}
