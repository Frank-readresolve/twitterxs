package fr.formation.twitterxs.mvccontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.formation.twitterxs.dto.*;
import fr.formation.twitterxs.services.*;

@Controller
@RequestMapping("/mvc/users")
public class UserMvcController {

    private final UserService userService;

    private final RegionService regionService;

    protected UserMvcController(UserService userService,
	    RegionService regionService) {
	this.userService = userService;
	this.regionService = regionService;
    }

    @SuppressWarnings("unused")
    @GetMapping("/create")
    public String create(@ModelAttribute("user") UserCreateDto user,
	    Model model) {
	populateModel(model);
	return "userCreate";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("user") UserCreateDto user,
	    BindingResult result, Model model) {
	if (!result.hasErrors()) {
	    userService.create(user);
	    model.addAttribute("user", new UserCreateDto());
	}
	populateModel(model);
	return "userCreate";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
	UserUpdateDto user = userService.getById(id);
	model.addAttribute("user", user);
	populateModel(model);
	return "userUpdate";
    }

    @PostMapping("/update/save")
    public String saveExisting(
	    @Valid @ModelAttribute("user") UserUpdateDto user,
	    BindingResult result, Model model) {
	if (!result.hasErrors()) {
	    userService.update(user);
	    model.addAttribute("user", new UserUpdateDto());
	}
	populateModel(model);
	return "userUpdate";
    }

    private void populateModel(Model model) {
	List<ValueLabelDto> regions = regionService.findAll();
	model.addAttribute("regions", regions);
    }
}
