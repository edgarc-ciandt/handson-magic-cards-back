package magiccards.controllers;

import magiccards.entities.Card;
import magiccards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cards")
public class CardsController {

	@Autowired
	private CardRepository cardRepository;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public Card getCardById(@PathVariable("id") String gathererId) {
		return cardRepository.findOne(gathererId);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Page<Card> getCards(@RequestParam(value="page")int pageNumber, @RequestParam int size) {

		Pageable page = new PageRequest(pageNumber, size);

		return cardRepository.findAll(page);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
	public void create(@RequestBody Card card) {
		cardRepository.save(card);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
	public void update(@RequestBody Card card) {
		cardRepository.save(card);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id")String id) {
		cardRepository.delete(id);
	}
}