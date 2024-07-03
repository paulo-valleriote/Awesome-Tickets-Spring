package valleriote.paulo.awesometickets.domain.service.event;

import org.springframework.stereotype.Service;
import valleriote.paulo.awesometickets.app.dto.event.EventResponseDTO;
import valleriote.paulo.awesometickets.domain.utils.AppObjectMapper;
import valleriote.paulo.awesometickets.app.dto.event.EventCreateDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventUpdateDTO;
import valleriote.paulo.awesometickets.app.handler.exceptions.event.EventNotFound;
import valleriote.paulo.awesometickets.domain.entity.Event;
import valleriote.paulo.awesometickets.domain.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final AppObjectMapper mapper;

    public EventServiceImpl(EventRepository eventRepository, AppObjectMapper mapper) {
        this.eventRepository = eventRepository;
        this.mapper = mapper;
    }

    @Override
    public EventResponseDTO findById(String id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.map(Event::toDTO).orElse(null);

    }

    @Override
    public List<EventResponseDTO> list() {
        return eventRepository.find().stream().map(Event::toDTO).toList();
    }

    @Override
    public EventResponseDTO create(EventCreateDTO dto) {
        Event newEvent = new Event(dto);
        eventRepository.save(newEvent);
        return newEvent.toDTO();
    }

    @Override
    public void update(String id, EventUpdateDTO dto) {
        Event event = eventRepository.findById(id).orElseThrow(EventNotFound::new);
        mapper.updateEvent(event, dto);
        eventRepository.save(event);
    }

    @Override
    public void delete(String id) {
        eventRepository.delete(id);
    }
}
