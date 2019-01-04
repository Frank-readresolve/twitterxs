package fr.formation.twitterxs.domain.entities;

import javax.persistence.*;

@Entity
public class Country {

    @Id
    private Long id;

    @Column
    private String iso;

    public Country() {
    }

    public Long getId() {
	return id;
    }

    public String getIso() {
	return iso;
    }
}
