package magiccards.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import magiccards.entities.Expansion;
import magiccards.repositories.ExpansionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ExpansionRepositoryTest{
	
	@Autowired
	private ExpansionRepository expansionRepository;
	
	@Test
	public void testeSave() {
		criaExpansion();
		Iterable<Expansion> expansions = expansionRepository.findAll();
		
		assertNotNull(expansions);
	}
	
	@Test
	public void testeUpdate() {
		Expansion expansion = criaExpansion();
		Iterable<Expansion> expansions = expansionRepository.findAll();
		
		assertNotNull(expansions);
		
		expansion.setName("expansion 2");
		expansionRepository.save(expansion);
		
		Expansion expansionUpdated = expansionRepository.findOne(expansion.getExpansionId());
		
		assertEquals("expansion 2", expansionUpdated.getName());
	}
	
	@Test
	public void testeDelete() {
		Expansion expansion = criaExpansion();
		
		Iterable<Expansion> expansions = expansionRepository.findAll();
		
		assertNotNull(expansions);
		
		expansionRepository.delete(expansion);
		
		expansions = expansionRepository.findAll();
		
		assertNotNull(expansions);
		
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
		expansionRepository.save(expansion);
		return expansion;
	}

}
