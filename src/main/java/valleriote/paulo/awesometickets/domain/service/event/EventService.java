package valleriote.paulo.awesometickets.domain.service.event;

import valleriote.paulo.awesometickets.app.dto.event.EventCreateDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventResponseDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventUpdateDTO;
import valleriote.paulo.awesometickets.domain.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    EventResponseDTO findById(String id);
    List<EventResponseDTO> list();
    EventResponseDTO create(EventCreateDTO dto);
    void update(String id, EventUpdateDTO dto);
    void delete(String id);
}
