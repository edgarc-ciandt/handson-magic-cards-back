package magiccards.controllers;

import magiccards.entities.Expansion;
import magiccards.repositories.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expansions")
public class ExpansionController {

	@Autowired
	private ExpansionRepository expansionRepository;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public Expansion getExpansionById(@PathVariable("id") String expansionId) {
		return expansionRepository.findOne(expansionId);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Page<Expansion> getExpansions(@RequestParam(value="page")int pageNumber, @RequestParam int size) {

		Pageable page = new PageRequest(pageNumber, size);

		return expansionRepository.findAll(page);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
	public void create(@RequestBody Expansion expansion) {
		expansionRepository.save(expansion);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
	public void update(@RequestBody Expansion expansion) {
		expansionRepository.save(expansion);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id")String id) {
		expansionRepository.delete(id);
	}
}