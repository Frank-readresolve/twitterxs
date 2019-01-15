package fr.formation.twitterxs.services;

import javax.validation.Valid;

import fr.formation.twitterxs.dto.*;

/**
 * Service interface to deal with users.
 */
public interface UserService {

    /**
     * Creates a new user with given DTO.
     *
     * @param dto
     *            the DTO to populate the new user with
     */
    public void create(UserCreateDto dto);

    /**
     * Deletes the user with given id.
     *
     * @param id
     *            the id of the user to delete
     */
    public void delete(Long id);

    /**
     * Retrieves the identity of the user with given id.
     *
     * @param id
     *            the id of the user to retrieve identity for
     */
    public UserIdentityDto identity(Long id);

    /**
     * Retrieves the profile of the user with given id.
     *
     * @param id
     *            the id of the user to retrieve profile for
     */
    public UserProfileDto profile(Long id);

    /**
     * Retrieves the global statistics on users ans tweets.
     */
    public GlobalStatsDto stats();

    /**
     * Indicates whether or not same given username already exists (ignoring
     * case).
     *
     * @param username
     *            the username to test against
     * @return {@code true} if not exists; {@code false} otherwise
     */
    public boolean usernameUnique(String username);

    /**
     * Indicates whether or not same given email already exists (ignoring case).
     *
     * @param email
     *            the email to test against
     * @return {@code true} if not exists; {@code false} otherwise
     */
    public boolean emailUnique(String email);

    /**
     * IUpdates the password of a user with given DTO.
     *
     * @param dto
     *            the DTO to update the password with
     */
    public void updatePassword(@Valid UserUpdatePasswordDto dto);

    /**
     * Indicates whether or not given {@code password} matches current password
     * for given {@code username}.
     *
     * @param username
     *            the username to test against
     * @param password
     *            the password to test against
     * @return {@code true} if {@code password} matches current password;
     *         {@code false} otherwise
     */
    public boolean matchesCurrentPassword(String username, String password);

    /**
     * Updates an existing user with given DTO.
     *
     * @param dto
     *            the DTO to populate the existing user with
     */
    public void update(UserUpdateDto user);

    public UserUpdateDto getById(Long id);

    public boolean updateEmailUnique(String email, Long id);
}
