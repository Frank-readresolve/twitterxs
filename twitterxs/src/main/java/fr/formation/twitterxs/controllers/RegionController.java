package fr.formation.twitterxs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import fr.formation.twitterxs.dto.*;
import fr.formation.twitterxs.security.AdminOrUser;
import fr.formation.twitterxs.services.RegionService;

/**
 * A Rest controller to deal with regions.
 */
@RestController
@RequestMapping("/regions")
@AdminOrUser
public class RegionController extends BaseController {

	@Autowired
    private RegionService service;

    /**
     * Endpoint returning all the regions as instances of {@code ValueLabelDto}.
     * <p>
     * The id of the region is set as the value and the concatenation of the
     * language and country as the label ({@code fr_FR}).
     * <p>
     * Elements are ordered by country then language.
     *
     * @return a view of all the regions
     */
    @GetMapping("/list")
    protected List<ValueLabelDto> list() {
	return service.findAll();
    }

    /**
     * Endpoint to create a new region with given inputs.
     *
     * @param dto
     *            the inputs related to a region to create
     */
    @PostMapping("/create")
    @Secured("ROLE_ADMIN")
    protected void createRegion(@Valid @RequestBody RegionCreateDto dto) {
	service.create(dto);
    }
}
