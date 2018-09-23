package magiccards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import magiccards.entities.Expansion;
import magiccards.repositories.CardRepository;
import magiccards.repositories.ExpansionRepository;

@RestController
@RequestMapping("expansions")
public class ExpansionController {

	@Autowired
	private ExpansionRepository expansionRepository;

	@Autowired
	private CardRepository cardRepository;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public Expansion getexpansionById(@PathVariable("id") Integer id) {

		return expansionRepository.findOne(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Page<Expansion> getexpansions(@RequestParam(value = "page") int pageNumber, @RequestParam int size) {

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
	@Transactional
	public void delete(@PathVariable("id") Integer id) {
		cardRepository.deleteByExpansionExpansionId(id);
		expansionRepository.delete(id);
	}

}
