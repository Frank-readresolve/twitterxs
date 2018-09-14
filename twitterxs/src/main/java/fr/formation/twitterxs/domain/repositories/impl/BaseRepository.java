package fr.formation.twitterxs.domain.repositories.impl;

import javax.persistence.*;

public abstract class BaseRepository {

    @PersistenceContext
    protected EntityManager em;

    protected BaseRepository() {
	//
    }
}
