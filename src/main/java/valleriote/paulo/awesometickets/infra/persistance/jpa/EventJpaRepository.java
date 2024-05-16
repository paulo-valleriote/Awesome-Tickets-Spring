package valleriote.paulo.awesometickets.infra.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import valleriote.paulo.awesometickets.domain.entity.Event;

@Component
public interface EventJpaRepository extends JpaRepository<Event, String> {
}
