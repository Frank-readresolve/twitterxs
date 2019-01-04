package fr.formation.twitterxs.services.impl;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import fr.formation.twitterxs.domain.entities.User;
import fr.formation.twitterxs.domain.jparepositories.UserJpaRepository;
import fr.formation.twitterxs.security.Principal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserJpaRepository userJpaRepo;

    // @Autowired is optional with one constructor
    protected UserDetailsServiceImpl(UserJpaRepository userJpaRepo) {
	this.userJpaRepo = userJpaRepo;
    }

    // Principal is-a UserDetails => covariant return
    @Override
    public Principal loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	User user = userJpaRepo.findBySecurityUsername(username);
	if (null == user) {
	    throw new UsernameNotFoundException(
		    "No user found with username: " + username);
	}
	return new Principal(user);
    }
}
