package magiccards.controllers;

import magiccards.entities.Expansion;
import magiccards.repositories.ExpansionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpansionController.class)
public class ExpansionControllerTest {

    public static final String EXPANSION1_ID = "ID1";
    public static final String EXPANSION1_NAME = "Expansion 1";
    public static final int EXPANSION1_YEAR = 1999;

    public static final String EXPANSION2_ID = "ID2";
    public static final String EXPANSION2_NAME = "Expansion 2";
    public static final int EXPANSION2_YEAR = 1995;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExpansionRepository expansionRepository;

    private Expansion expansion1;
    private Expansion expansion2;

    @Before
    public void setUp() {
        expansion1 = new Expansion();
        expansion1.setName(EXPANSION1_NAME);
        expansion1.setExpansionId(EXPANSION1_ID);

        expansion2 = new Expansion();
        expansion2.setName(EXPANSION1_NAME);
        expansion2.setExpansionId(EXPANSION1_ID);
    }

    @Test
    public void testGetExpansionById() throws Exception {
        when(expansionRepository.findOne(EXPANSION1_ID)).thenReturn(expansion1);

        mockMvc.perform(get("/expansions/" + EXPANSION1_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.expansionId", is(EXPANSION1_ID)))
                .andExpect(jsonPath("$.name", is(EXPANSION1_NAME)))
                .andReturn();
    }

    @Test
    public void testGetAllExpansions_withAnyPageSize() throws Exception {
        List<Expansion> list = new ArrayList<>();
        list.add(expansion1);
        list.add(expansion2);

        Page<Expansion> page = new PageImpl<>(list, new PageRequest(0, 10), list.size());

        when(expansionRepository.findAll(any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/expansions")
                .contentType(MediaType.APPLICATION_JSON)
                .param("page", "1")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andReturn();
    }

}