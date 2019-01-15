package fr.formation.twitterxs.domain.repositories.impl;

import org.hibernate.cache.internal.EnabledCaching;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.stat.CacheRegionStatistics;
import org.hibernate.stat.spi.StatisticsImplementor;
import org.springframework.stereotype.Repository;

import fr.formation.twitterxs.domain.repositories.CacheRepository;
import fr.formation.twitterxs.dto.CacheDto;

@Repository
public class CacheRepositoryImpl extends BaseRepository
	implements CacheRepository {

    @SuppressWarnings("resource")
    @Override
    public CacheDto stats() {
	EnabledCaching cache = (EnabledCaching) em.getEntityManagerFactory()
		.getCache();
	SessionFactoryImplementor factory = cache.getSessionFactory();
	StatisticsImplementor stats = factory.getStatistics();
	CacheRegionStatistics regionStats = stats.getDomainDataRegionStatistics(
		"fr.formation.twitterxs.domain.entities.User");
	CacheDto result = new CacheDto();
	result.setPutCount(regionStats.getPutCount());
	result.setHitCount(regionStats.getHitCount());
	result.setMissCount(regionStats.getMissCount());
	return result;
    }
}
