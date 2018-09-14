package fr.formation.twitterxs.services.impl;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.twitterxs.domain.entities.*;
import fr.formation.twitterxs.domain.jparepositories.*;
import fr.formation.twitterxs.dto.*;
import fr.formation.twitterxs.services.*;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;

    private final UserJpaRepository userJpaRepo;

    private final RegionJpaRepository regionJpaRepo;

    private final TweetService tweetService; // Reuse for user stats!

    // @Autowired is optional with one constructor
    protected UserServiceImpl(PasswordEncoder encoder,
	    UserJpaRepository userJpaRepo, RegionJpaRepository regionJpaRepo,
	    TweetService tweetService) {
	this.encoder = encoder;
	this.userJpaRepo = userJpaRepo;
	this.regionJpaRepo = regionJpaRepo;
	this.tweetService = tweetService;
    }

    @Override
    public void create(UserCreateDto dto) {
	Region region = regionJpaRepo.findById(dto.getRegionId()).get();
	User user = EntityHelper.asUser(dto, region);
	String pwd = user.getSecurity().getPassword();
	String encoded = encoder.encode(pwd);
	user.getSecurity().setPassword(encoded);
	userJpaRepo.save(user); // Do not return saved entity
    }

    @Override
    public void delete(Long id) {
	userJpaRepo.deleteById(id);
    }

    @Override
    public UserIdentityDto identity(Long id) {
	User user = userJpaRepo.findById(id).get();
	return DtoHelper.asUserIdentityDto(user);
    }

    @Override
    public UserProfileDto profile(Long id) {
	User user = userJpaRepo.findById(id).get();
	StatsDto stats = tweetService.stats(id);
	return DtoHelper.asUserProfileDto(user, stats);
    }

    @Override
    public GlobalStatsDto stats() {
	StatsDto tweetStats = tweetService.stats();
	long users = userJpaRepo.countBySecurityEnabledTrue();
	return DtoHelper.asGlobalStatsDto(tweetStats, users);
    }

    @Override
    public boolean usernameUnique(String username) {
	return !userJpaRepo.existsBySecurityUsernameIgnoreCase(username);
    }

    // Example jpa repo vs custom repo:
    // @Autowired
    // private UserRepository userRepository;
    @Override
    public boolean emailUnique(String email) {
	// Example jpa repos vs custom repo:
	// return !userRepository.existsByEmailIgnoreCase(email);
	return !userJpaRepo.existsByEmailIgnoreCase(email);
    }

    @Override
    public void updatePassword(@Valid UserUpdatePasswordDto dto) {
	String encoded = encoder.encode(dto.getPassword());
	userJpaRepo.updatePassword(dto.getUserId(), encoded);
    }
}
