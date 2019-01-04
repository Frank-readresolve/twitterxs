package fr.formation.twitterxs.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.twitterxs.domain.entities.Region;
import fr.formation.twitterxs.domain.jparepositories.RegionJpaRepository;
import fr.formation.twitterxs.domain.repositories.RegionRepository;
import fr.formation.twitterxs.dto.*;
import fr.formation.twitterxs.services.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionJpaRepository jpaRepo;

    private final RegionRepository repo;

    // @Autowired is optional with one constructor
    protected RegionServiceImpl(RegionJpaRepository jpaRepo,
	    RegionRepository repo) {
	this.jpaRepo = jpaRepo;
	this.repo = repo;
    }

    @Override
    public void create(RegionCreateDto dto) {
	Region region = EntityHelper.asRegion(dto);
	jpaRepo.save(region); // Do not return saved entity
    }

    @Override
    public List<ValueLabelDto> findAll() {
	return jpaRepo.findAllAsDto();
    }

    @Override
    public Long save(Region region) {
	return repo.save(region);
    }

    @Override
    public List<Region> list() {
	return jpaRepo.findAll();
    }
}
