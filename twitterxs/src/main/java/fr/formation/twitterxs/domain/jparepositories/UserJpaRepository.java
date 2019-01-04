package fr.formation.twitterxs.domain.jparepositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import fr.formation.twitterxs.domain.entities.User;

/**
 * A JPA repository to deal with {@code User}s.
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {

    /**
     * Returns the number of enabled users.
     *
     * @return the number of enabled users
     */
    public long countBySecurityEnabledTrue();

    public boolean existsBySecurityUsernameIgnoreCase(String username);

    public boolean existsByEmailIgnoreCase(String email);

    @Transactional
    @Modifying
    @Query("update User u set u.security.password = :pwd where u.id = :userId")
    public void updatePassword(@Param("userId") Long userId,
	    @Param("pwd") String pwd);

    @Nullable // Indicates that return can be null
    // select u from User u where u.security.username = :username
    public User findBySecurityUsername(String username);

    @Query("select u.security.password from User u where u.security.username = :username")
    public String findPasswordByUsername(@Param("username") String username);
}
