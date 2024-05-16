package valleriote.paulo.awesometickets.domain.service.event;

import valleriote.paulo.awesometickets.app.dto.event.EventCreateDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventUpdateDTO;
import valleriote.paulo.awesometickets.domain.entity.Event;

import java.util.List;

public interface EventService {
    Event findById(String id);
    List<Event> list();
    Event create(EventCreateDTO dto);
    void update(String id, EventUpdateDTO dto);
    void delete(String id);
}
