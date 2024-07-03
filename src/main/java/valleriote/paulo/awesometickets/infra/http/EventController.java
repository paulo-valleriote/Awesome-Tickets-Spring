package valleriote.paulo.awesometickets.infra.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import valleriote.paulo.awesometickets.app.dto.event.EventCreateDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventResponseDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventUpdateDTO;
import valleriote.paulo.awesometickets.app.dto.http.ResponseDTO;
import valleriote.paulo.awesometickets.domain.entity.Event;
import valleriote.paulo.awesometickets.domain.service.event.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public ResponseDTO find(@PathVariable("id") String id) {
        EventResponseDTO event = this.eventService.findById(id);

        if (event == null) {
            return new ResponseDTO("Event not found", HttpStatus.OK, null);
        }

        return new ResponseDTO(null, HttpStatus.OK, event);
    }

    @GetMapping("/all")
    public ResponseDTO list() {
        List<EventResponseDTO> eventList = this.eventService.list();
        return new ResponseDTO(null, HttpStatus.OK, eventList);
    }

    @PostMapping
    public ResponseDTO create(@RequestBody EventCreateDTO eventDTO) {
        EventResponseDTO event = this.eventService.create(eventDTO);
        return new ResponseDTO(null, HttpStatus.CREATED, event);
    }

    @PutMapping("/{id}")
    public ResponseDTO update(@PathVariable("id") String id, @RequestBody EventUpdateDTO eventDTO) {
        this.eventService.update(id, eventDTO);
        return new ResponseDTO("Event updated", HttpStatus.OK, null);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO delete(@PathVariable("id") String id) {
        this.eventService.delete(id);
        return new ResponseDTO("Event removed", HttpStatus.OK, null);
    }
}
