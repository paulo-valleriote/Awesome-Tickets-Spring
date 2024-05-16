package valleriote.paulo.awesometickets.infra.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import valleriote.paulo.awesometickets.domain.entity.User;

import java.util.Optional;

@Component
public interface UserJpaRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
