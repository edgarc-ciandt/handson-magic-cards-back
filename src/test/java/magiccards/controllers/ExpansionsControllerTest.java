package magiccards.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import magiccards.entities.Expansion;
import magiccards.repositories.ExpansionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpansionsController.class)
@EnableSpringDataWebSupport
public class ExpansionsControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean ExpansionRepository expansionRepository;
	@Autowired ObjectMapper mapper;


	@Test
	public void shouldQueryForUserWithTheExpecifiedId() throws Exception {
		Integer id = 1;
		when(expansionRepository.findOne(id)).thenReturn(new Expansion());

		mockMvc.perform(get("/expansions/" + id) )
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("expansionId").isEmpty())
				.andExpect(jsonPath("name").isEmpty())
				.andExpect(jsonPath("portugueseName").isEmpty())
				.andExpect(jsonPath("linkName").isEmpty())
				.andExpect(jsonPath("launchDate").isEmpty())
				.andExpect(jsonPath("expansionCategoryId").isEmpty())
				.andExpect(jsonPath("promo").value(false))
				.andExpect(jsonPath("legal").value(false));
		verify(expansionRepository).findOne(id);
	}

	@Test
	public void shouldDeleteItem() throws Exception {
		Integer id = 1;

		mockMvc.perform(delete("/expansions/" + id) )
				.andExpect(status().isOk());
		verify(expansionRepository).delete(id);
	}

	@Test
	public void shouldReturnAPageOfResults() throws Exception {
		when(expansionRepository.findAll(any(Pageable.class)))
				.thenReturn(new PageImpl<Expansion>(Collections.EMPTY_LIST));

		mockMvc.perform(get("/expansions")
				.param("page" , "0")
				.param("size" , "10") )
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("content").isArray())
				.andExpect(jsonPath("totalPages").value(1))
				.andExpect(jsonPath("totalElements").value(0))
				.andExpect(jsonPath("numberOfElements").value(0))
				.andExpect(jsonPath("size").value(0))
				.andExpect(jsonPath("first").value(true))
				.andExpect(jsonPath("last").value(true));
	}

	@Test
	public void shouldCallCreteWithTheExpansion() throws Exception {
		ArgumentCaptor<Expansion> captor = ArgumentCaptor.forClass(Expansion.class);
		Date launchDate = Date.from(Instant.now());
		Expansion expansion = Expansion.builder()
				.expansionId(1)
				.name("TestName")
				.expansionCategoryId(1)
				.launchDate(launchDate)
				.build();

		mockMvc.perform(post("/expansions")
				.content(mapper.writeValueAsString(expansion))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		verify(expansionRepository).save(captor.capture());
		Expansion value = captor.getValue();
		assertThat(value).isNotNull();
		assertThat(value.getExpansionId()).isEqualTo(1);
		assertThat(value.getName()).isEqualTo("TestName");
		assertThat(value.getPortugueseName()).isNull();
		assertThat(value.getLinkName()).isNull();
		assertThat(value.getLaunchDate()).isEqualTo(launchDate);
		assertThat(value.getExpansionCategoryId()).isEqualTo(1);
		assertThat(value.isPromo()).isFalse();
		assertThat(value.isLegal()).isFalse();
	}

	@Test
	public void shouldCallSaveWithTheExpansion() throws Exception {
		ArgumentCaptor<Expansion> captor = ArgumentCaptor.forClass(Expansion.class);
		Date launchDate = Date.from(Instant.now());
		Expansion expansion = Expansion.builder()
				.expansionId(1)
				.name("TestName")
				.expansionCategoryId(1)
				.launchDate(launchDate)
				.build();

		mockMvc.perform(put("/expansions")
				.content(mapper.writeValueAsString(expansion))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		verify(expansionRepository).save(captor.capture());
		Expansion value = captor.getValue();
		assertThat(value).isNotNull();
		assertThat(value.getExpansionId()).isEqualTo(1);
		assertThat(value.getName()).isEqualTo("TestName");
		assertThat(value.getPortugueseName()).isNull();
		assertThat(value.getLinkName()).isNull();
		assertThat(value.getLaunchDate()).isEqualTo(launchDate);
		assertThat(value.getExpansionCategoryId()).isEqualTo(1);
		assertThat(value.isPromo()).isFalse();
		assertThat(value.isLegal()).isFalse();
	}

}