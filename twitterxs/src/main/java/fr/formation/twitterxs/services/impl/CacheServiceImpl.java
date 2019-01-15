package fr.formation.twitterxs.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.twitterxs.domain.repositories.CacheRepository;
import fr.formation.twitterxs.dto.CacheDto;
import fr.formation.twitterxs.services.CacheService;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheRepository repo;

    @Override
    public CacheDto stats() {
	return repo.stats();
    }
}
