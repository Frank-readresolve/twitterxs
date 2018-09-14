package fr.formation.twitterxs.dto;

import javax.validation.constraints.*;

/**
 * A DTO that represents useful data and validation rules in order to create a
 * region.
 */
public class RegionCreateDto implements Dto {

    private static final long serialVersionUID = 1493981362650233455L;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 4, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String language;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 2, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String country;

    public RegionCreateDto() {
	// Default no-arg constructor
    }

    public String getLanguage() {
	return language;
    }

    public void setLanguage(String code) {
	language = code;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String code) {
	country = code;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{language=" + language + ", country=" + country + "}";
    }
}
