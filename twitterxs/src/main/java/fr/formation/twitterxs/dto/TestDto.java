package fr.formation.twitterxs.dto;

public class TestDto {

    private String abbr;

    public TestDto() {
    }

    public String getAbbr() {
	return abbr;
    }

    public void setAbbr(String abbr) {
	this.abbr = abbr;
    }

    @Override
    public String toString() {
	return "{abbr=" + abbr + "}";
    }
}
