package magiccards.repositories;

import magiccards.entities.Expansion;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExpansionRepository extends PagingAndSortingRepository<Expansion,Integer> {
}