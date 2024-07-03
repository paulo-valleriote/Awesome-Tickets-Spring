package valleriote.paulo.awesometickets.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valleriote.paulo.awesometickets.domain.entity.Event;
import valleriote.paulo.awesometickets.domain.entity.Registration;
import valleriote.paulo.awesometickets.domain.entity.User;

import java.util.Optional;
import java.util.Set;

public interface RegistrationRepository extends JpaRepository<Registration, String> {
    Set<Registration> findByUser(User user);
    Optional<Registration> findByUserIdAndEventId(String userId, String eventId);
    boolean existsByUserAndEvent(User user, Event event);
}
