package cards.repositories;

import cards.entities.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface CardRepository extends PagingAndSortingRepository<Card,String> {
}