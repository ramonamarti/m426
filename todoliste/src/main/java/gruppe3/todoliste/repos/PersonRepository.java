package gruppe3.todoliste.repos;

import gruppe3.todoliste.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * repository to find a person with the id or login name
 */
@Repository
public interface PersonRepository extends
        JpaRepository<Person,Integer>, CrudRepository<Person,Integer> {
    Optional<Person> findById(Long id);
//    Optional<Person> findByLogin(String login);

}
