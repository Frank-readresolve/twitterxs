package fr.formation.twitterxs.domain.jparepositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TweetJpaRepositoryTest {

    @Autowired
    private TweetJpaRepository repo;

    @Test
    void shouldCountPositive() {
	Long actual = repo.countByAuthorId(15L);
	assertTrue(actual > 0);
    }
}
