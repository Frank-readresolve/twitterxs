package fr.formation.twitterxs.services;

import java.util.List;

import fr.formation.twitterxs.dto.*;

/**
 * Service interface to deal with regions.
 */
public interface RegionService {

    /**
     * Creates a new region with given DTO.
     *
     * @param dto
     *            the DTO to populate the new region with
     */
    public void create(RegionCreateDto dto);

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
    public List<ValueLabelDto> findAll();
}
