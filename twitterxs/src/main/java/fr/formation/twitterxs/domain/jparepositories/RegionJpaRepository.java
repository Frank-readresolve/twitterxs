package fr.formation.twitterxs.domain.jparepositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import fr.formation.twitterxs.domain.entities.Region;
import fr.formation.twitterxs.dto.ValueLabelDto;

/**
 * A JPA repository to deal with {@code Region}s.
 */
public interface RegionJpaRepository extends JpaRepository<Region, Long> {

    /**
     * Returns all the regions as instances of {@code ValueLabelDto}.
     * <p>
     * The id of the region is set as the value and the concatenation of the
     * language and country as the label ({@code fr_FR}).
     * <p>
     * Elements are ordered by country then language.
     *
     * @return a view of all the regions
     */
    @Query("select new fr.formation.twitterxs.dto.ValueLabelDto(r.id, r.language || '_' || r.country) "
	    + "from Region r order by r.country, r.language")
    public List<ValueLabelDto> findAllAsDto();
}
