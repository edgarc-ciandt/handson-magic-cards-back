package magiccards.controllers;

import magiccards.entities.Expansion;
import magiccards.repositories.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expansions")
public class ExpansionsController {

	private ExpansionRepository expansionRepository;

	@Autowired
	public ExpansionsController(ExpansionRepository expansionRepository) {
		this.expansionRepository = expansionRepository;
	}

	@GetMapping("{id}")
	public Expansion getExpansionById(@PathVariable("id") Integer expansionId) {
		return expansionRepository.findOne(expansionId);
	}

	@GetMapping
	public Page<Expansion> getExpansions(Pageable page) {
		return expansionRepository.findAll(page);
	}

	@PostMapping
	public void create(@RequestBody Expansion expansion) {
		expansionRepository.save(expansion);
	}

	@PutMapping
	public void update(@RequestBody Expansion expansion) {
		expansionRepository.save(expansion);
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable("id") Integer id) {
		expansionRepository.delete(id);
	}
}