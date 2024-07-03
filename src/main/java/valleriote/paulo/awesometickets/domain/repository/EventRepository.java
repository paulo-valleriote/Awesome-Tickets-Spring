package valleriote.paulo.awesometickets.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valleriote.paulo.awesometickets.domain.entity.Event;

public interface EventRepository extends JpaRepository<Event, String> {
}
