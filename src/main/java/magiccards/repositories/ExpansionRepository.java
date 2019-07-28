package magiccards.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import magiccards.entities.Expansion;

public interface ExpansionRepository extends PagingAndSortingRepository<Expansion,Integer> {
}