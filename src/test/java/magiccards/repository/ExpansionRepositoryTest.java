package magiccards.repository;

import static org.junit.Assert.assertNull;

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
	public void teste() {
		Iterable<Expansion> expansions = expansionRepository.findAll();
		
		assertNull(expansions);
		
	}

}
