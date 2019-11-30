package gruppe3.todoliste.repos;

import gruppe3.todoliste.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * repository to find a login with the id or login name
 */
@Repository
public interface LoginRepository extends
        JpaRepository<Login,Integer>, CrudRepository<Login,Integer> {
    Optional<Login> findById(Long id);
    Optional<Login> findByUsername(String username);
}
