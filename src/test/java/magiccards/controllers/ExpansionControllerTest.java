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
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;
import magiccards.entities.Expansion;
import magiccards.repositories.CardRepository;
import magiccards.repositories.ExpansionRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpansionsController.class)
public class ExpansionControllerTest extends TestCase{
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private ExpansionRepository mockExpansionRepository;
	
	@MockBean
	private CardRepository mockCardRepository;
	
	@Test
	public void getExpansionById() throws Exception {
		Expansion expansion = criaExpansion();

		given(mockExpansionRepository.findOne(1)).willReturn(expansion);

		mvc.perform(get("/expansions/1")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.expansionId", is(expansion.getExpansionId())))
				.andExpect(jsonPath("$.name", is(expansion.getName())));
	}
	
	@Test
	public void getExpansions() throws Exception {
		Expansion expansion = criaExpansion();

		List<Expansion> expansions = Arrays.asList(expansion);
		Page<Expansion> pageMock = new PageImpl<>(expansions);
		
		given(mockExpansionRepository.findAll(new PageRequest(0, 1))).willReturn(pageMock);

		mvc.perform(get("/expansions?page=0&size=1")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(1)))
				.andExpect(jsonPath("$.content[0].expansionId", is(expansion.getExpansionId())));
	}
	
	@Test
	public void create() throws Exception {
		Expansion expansion = criaExpansion();
		
		given(mockExpansionRepository.save(expansion)).willReturn(null);
		
		mvc.perform(post("/expansions")
				.content(serializaEntrada(expansion))
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void update() throws Exception {
		Expansion expansion = criaExpansion();
		
		given(mockExpansionRepository.save(expansion)).willReturn(null);
		
		mvc.perform(put("/expansions")
				.content(serializaEntrada(expansion))
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void excluiExpansion() throws Exception {
		mvc.perform(delete("/expansions/1")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	private byte[] serializaEntrada(Expansion expansion) throws JsonProcessingException {
		return new ObjectMapper()
				     .setSerializationInclusion(JsonInclude.Include.NON_NULL)
				     .writeValueAsBytes(expansion);
	}

	private Expansion criaExpansion() {
		Expansion expansion = new Expansion();
		expansion.setExpansionId(1);
		expansion.setName("expansion 1");
		expansion.setCode("ME4");
		expansion.setExpansionCategoryId(400);
		expansion.setLaunchDate(new Date());
		expansion.setLinkName("teste");
		expansion.setPortugueseName("teste");
		return expansion;
	}

}
