package valleriote.paulo.awesometickets.domain.repository;

import valleriote.paulo.awesometickets.domain.entity.Event;
import valleriote.paulo.awesometickets.domain.entity.Registration;
import valleriote.paulo.awesometickets.domain.entity.User;

import java.util.Optional;
import java.util.Set;

public interface RegistrationRepository extends CrudRepository<Registration, String> {
    Set<Registration> findByUserId(String id);
    Optional<Registration> findByUserIdAndEventId(String userId, String eventId);
    boolean existsByUserAndEvent(User user, Event event);
}
