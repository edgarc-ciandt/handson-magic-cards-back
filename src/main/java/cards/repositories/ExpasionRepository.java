package cards.repositories;

import cards.entities.Expansion;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExpasionRepository extends PagingAndSortingRepository<Expansion,String> {
}