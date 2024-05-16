package valleriote.paulo.awesometickets.infra.persistance.repository;

import org.springframework.stereotype.Repository;
import valleriote.paulo.awesometickets.app.dto.event.EventCreateDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventUpdateDTO;
import valleriote.paulo.awesometickets.domain.entity.Event;
import valleriote.paulo.awesometickets.domain.repository.EventRepository;
import valleriote.paulo.awesometickets.infra.persistance.jpa.EventJpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventRepositoryImplementation implements EventRepository {
    private final EventJpaRepository repository;

    public EventRepositoryImplementation(EventJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Event> find() {
        return repository.findAll();
    }

    @Override
    public Optional<Event> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void save(Event newEvent) {
        repository.saveAndFlush(newEvent);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
