package magiccards.repositories;

import magiccards.entities.Card;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CardRepository extends PagingAndSortingRepository<Card,String> {

	void deleteByExpansionId(Integer id);
}