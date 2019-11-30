package gruppe3.todoliste.repos;

import gruppe3.todoliste.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * repository to find a module with the id
 */
@Repository
public interface ListRepository extends
        JpaRepository<List,Integer>, CrudRepository<List,Integer> {
    Optional<List> findById(Long id);
}