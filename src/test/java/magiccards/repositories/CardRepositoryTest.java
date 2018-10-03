package magiccards.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import magiccards.entities.Card;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class CardRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CardRepository cardRepository;

	@Test
	public void should_find_no_cards_if_repository_is_empty() {
		Iterable<Card> cards = cardRepository.findAll();

		assertThat(cards).isEmpty();
	}

}