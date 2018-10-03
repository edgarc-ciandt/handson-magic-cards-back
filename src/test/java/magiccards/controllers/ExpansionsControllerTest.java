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
import magiccards.entities.Expansion;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpansionsController.class)
public class ExpansionsControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ExpansionsController expansionsController;

	@Test
	public void getExpansions() throws Exception {
		Expansion expansion = new Expansion();
		expansion.setExpansionId(1);

		Expansion expansion2 = new Expansion();
		expansion2.setExpansionId(2);

		List<Expansion> allExpansions = Arrays.asList(expansion, expansion2);

		Page<Expansion> page = new PageImpl<>(allExpansions);

		given(expansionsController.getExpansions(0, 10)).willReturn(page);

		mvc.perform(get("/expansions?page=0&size=10")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(2)))
				.andExpect(jsonPath("$.content[0].expansionId", is(expansion.getExpansionId())))
				.andExpect(jsonPath("$.content[1].expansionId", is(expansion2.getExpansionId())));
	}

	@Test
	public void getExpansion() throws Exception {
		Expansion expansion = new Expansion();
		expansion.setExpansionId(1);

		given(expansionsController.getExpansionById(expansion.getExpansionId())).willReturn(expansion);

		mvc.perform(get("/expansions/1")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.expansionId", is(expansion.getExpansionId())));
	}

	@Test
	public void createExpansion() throws Exception {
		Expansion expansion = new Expansion();
		expansion.setExpansionId(1);

		mvc.perform(post("/expansions")
				.contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)
				.content(IntegrationTestUtil.convertObjectToJsonBytes(expansion)))
				.andExpect(status().isOk());
	}

	@Test
	public void updateExpansion() throws Exception {
		Expansion expansion = new Expansion();
		expansion.setExpansionId(1);

		mvc.perform(put("/expansions")
				.contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)
				.content(IntegrationTestUtil.convertObjectToJsonBytes(expansion)))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteExpansion() throws Exception {
		Expansion expansion = new Expansion();
		expansion.setExpansionId(1);

		mvc.perform(delete("/expansions/1")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
