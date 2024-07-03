package valleriote.paulo.awesometickets.infra.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import valleriote.paulo.awesometickets.app.dto.event.EventCreateDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventResponseDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventUpdateDTO;
import valleriote.paulo.awesometickets.app.dto.http.ResponseDTO;
import valleriote.paulo.awesometickets.app.dto.registration.EventRegistrationDTO;
import valleriote.paulo.awesometickets.app.dto.registration.RegistrationListDTO;
import valleriote.paulo.awesometickets.app.handler.exceptions.registration.RegistrationAlreadyExistsException;
import valleriote.paulo.awesometickets.app.handler.exceptions.registration.RegistrationAlreadyPaid;
import valleriote.paulo.awesometickets.domain.service.subscription.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/{userId}")
    public ResponseDTO list(@PathVariable("userId") String userId) {
        RegistrationListDTO registrations = this.subscriptionService.listRegistrations(userId);
        return new ResponseDTO(null, HttpStatus.OK, registrations);
    }

    @PostMapping
    public ResponseDTO subscribe(@RequestParam("event") String eventId, @RequestParam("user") String userId) {
        try {
            this.subscriptionService.subscribe(eventId, userId);
            return new ResponseDTO("Subscribed sucessfuly", HttpStatus.OK, null);
        } catch (RegistrationAlreadyExistsException ex) {
            return new ResponseDTO("Registration already exists", HttpStatus.BAD_REQUEST, ex);
        }
    }

    @DeleteMapping
    public ResponseDTO unsubscribe(@RequestParam("event") String eventId, @RequestParam("user") String userId) {
        try {
            this.subscriptionService.unsubscribe(eventId, userId);
            return new ResponseDTO("Event removed", HttpStatus.OK, null);
        } catch (RegistrationAlreadyPaid ex) {
            return new ResponseDTO("Registration already paid", HttpStatus.BAD_REQUEST, null);
        }
    }
}
