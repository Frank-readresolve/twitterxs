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

    public UserIdentityDto identity(Long id);

    public UserProfileDto profile(Long id);

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
}
