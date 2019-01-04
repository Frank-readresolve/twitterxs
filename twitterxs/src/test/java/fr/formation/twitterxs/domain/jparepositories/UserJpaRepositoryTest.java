package fr.formation.twitterxs.domain.jparepositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.formation.twitterxs.domain.entities.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository repo;

    @Test
    void shouldFindBySecurityUsername() {
	User actual = repo.findBySecurityUsername("fm9");
	assertNotNull(actual);
    }

    @Test
    void shouldCountPositive() {
	Long actual = repo.count();
	assertTrue(actual > 0);
    }

    @Test
    void shouldFindPasswordByUsername() {
	String actual = repo.findPasswordByUsername("fm9");
	assertNotNull(actual);
    }
}
