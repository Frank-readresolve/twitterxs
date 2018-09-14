package fr.formation.twitterxs.domain.repositories;

public interface UserRepository {

    public boolean existsByEmailIgnoreCase(String email);
}
