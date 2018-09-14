package fr.formation.twitterxs.domain.repositories.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.twitterxs.domain.repositories.UserRepository;

@Repository
public class UserRepositoryImpl extends BaseRepository
	implements UserRepository {

    /*
     * Same as UserJpaRepository.existsByEmailIgnoreCase(String)
     */
    @Override
    public boolean existsByEmailIgnoreCase(String email) {
	String jpql = "select count(u) from User u where upper(u.email) = upper(:email)";
	Query query = em.createQuery(jpql); // Query object from EntityManager
	query.setParameter("email", email);
	Long count = (Long) query.getSingleResult();
	return count > 0;
    }
}
