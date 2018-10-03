package magiccards.controllers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import magiccards.controllers.util.IntegrationTestUtil;
import magiccards.entities.Card;

@RunWith(SpringRunner.class)
@WebMvcTest(CardsController.class)
public class CardsControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CardsController cardsController;

	@Test
	public void getCards() throws Exception {
		Card card = new Card();
		card.setGathererId("1");

		Card card2 = new Card();
		card2.setGathererId("2");

		List<Card> allCards = Arrays.asList(card, card2);

		Page<Card> page = new PageImpl<>(allCards);

		given(cardsController.getCards(0, 10)).willReturn(page);

		mvc.perform(get("/cards?page=0&size=10")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(2)))
				.andExpect(jsonPath("$.content[0].gathererId", is(card.getGathererId())))
				.andExpect(jsonPath("$.content[1].gathererId", is(card2.getGathererId())));
	}

	@Test
	public void getCard() throws Exception {
		Card card = new Card();
		card.setGathererId("1");

		given(cardsController.getCardById(card.getGathererId())).willReturn(card);

		mvc.perform(get("/cards/1")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.gathererId", is(card.getGathererId())));
	}

	@Test
	public void createCard() throws Exception {
		Card card = new Card();
		card.setGathererId("1");

		mvc.perform(post("/cards")
				.contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)
				.content(IntegrationTestUtil.convertObjectToJsonBytes(card)))
				.andExpect(status().isOk());
	}

	@Test
	public void updateCard() throws Exception {
		Card card = new Card();
		card.setGathererId("1");

		mvc.perform(put("/cards")
				.contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)
				.content(IntegrationTestUtil.convertObjectToJsonBytes(card)))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteCard() throws Exception {
		Card card = new Card();
		card.setGathererId("1");

		mvc.perform(delete("/cards/1")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
