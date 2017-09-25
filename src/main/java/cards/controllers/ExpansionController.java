package cards.controllers;

import cards.entities.Expansion;
import cards.repositories.ExpasionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

//
@RestController
@RequestMapping("expansions")
public class ExpansionController {

	@Autowired
	private ExpasionRepository expasionRepository;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public Expansion getExpansionById(@PathVariable("id") String expansionId) {
		return expasionRepository.findOne(expansionId);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Page<Expansion> getExpansion(@RequestParam(value="page")int pageNumber, @RequestParam int size) {

		Pageable page = new PageRequest(pageNumber, size);

		return expasionRepository.findAll(page);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
	public void create(@RequestBody Expansion expansion) {
		expasionRepository.save(expansion);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
	public void update(@RequestBody Expansion expansion) {
		expasionRepository.save(expansion);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id")String id) {
		expasionRepository.delete(id);
	}
}