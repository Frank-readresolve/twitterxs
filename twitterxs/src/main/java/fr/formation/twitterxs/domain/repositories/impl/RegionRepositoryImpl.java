package fr.formation.twitterxs.domain.repositories.impl;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.twitterxs.domain.entities.Region;
import fr.formation.twitterxs.domain.repositories.RegionRepository;

@Repository
public class RegionRepositoryImpl implements RegionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Long save(Region region) {
	System.out.println("## Before persist: " + region.getId());
	em.persist(region);
	System.out.println("## After persist: " + region.getId());
	return region.getId();
    }
}
