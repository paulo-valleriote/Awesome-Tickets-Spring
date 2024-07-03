package valleriote.paulo.awesometickets.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valleriote.paulo.awesometickets.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
