package valleriote.paulo.awesometickets.domain.service.subscription;

import org.springframework.stereotype.Service;
import valleriote.paulo.awesometickets.app.dto.registration.EventRegistrationDTO;
import valleriote.paulo.awesometickets.app.dto.registration.RegistrationListDTO;
import valleriote.paulo.awesometickets.app.handler.exceptions.event.EventNotFoundException;
import valleriote.paulo.awesometickets.app.handler.exceptions.registration.RegistrationAlreadyExistsException;
import valleriote.paulo.awesometickets.app.handler.exceptions.registration.RegistrationAlreadyPaid;
import valleriote.paulo.awesometickets.app.handler.exceptions.registration.RegistrationNotFoundException;
import valleriote.paulo.awesometickets.app.handler.exceptions.user.UserNotFoundException;
import valleriote.paulo.awesometickets.domain.entity.Event;
import valleriote.paulo.awesometickets.domain.entity.Registration;
import valleriote.paulo.awesometickets.domain.entity.enums.RegistrationStatus;
import valleriote.paulo.awesometickets.domain.entity.User;
import valleriote.paulo.awesometickets.domain.repository.EventRepository;
import valleriote.paulo.awesometickets.domain.repository.RegistrationRepository;
import valleriote.paulo.awesometickets.domain.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final RegistrationRepository registrationRepository;

    public SubscriptionServiceImpl(RegistrationRepository registrationRepository, EventRepository eventRepository, UserRepository userRepository) {
        this.registrationRepository = registrationRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void subscribe(String eventId, String userId) throws RegistrationAlreadyExistsException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(EventNotFoundException::new);

        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);


        if (registrationRepository.existsByUserAndEvent(user, event)) {
            throw new RegistrationAlreadyExistsException();
        }

        Registration newRegistration = new Registration();
        newRegistration.setEvent(event);
        newRegistration.setUser(user);

        userRepository.save(user);
        registrationRepository.save(newRegistration);
    }

    @Override
    public void unsubscribe(String eventId, String userId) throws RegistrationAlreadyPaid {
        Registration registration = registrationRepository.findByUserIdAndEventId(userId, eventId)
                .orElseThrow(RegistrationNotFoundException::new);

        if (registration.getStatus() == RegistrationStatus.CONFIRMED) {
            throw new RegistrationAlreadyPaid();
        }

        registration.setStatus(RegistrationStatus.CANCELLED);
        registrationRepository.save(registration);
    }

    @Override
    public RegistrationListDTO listRegistrations(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        Set<Registration> registrations = registrationRepository.findByUser(user);

        Set<EventRegistrationDTO> eventRegistrationDTOS = registrations.stream()
                .map(registration ->
                        new EventRegistrationDTO(
                                registration.getId(),
                                registration.getEvent().toDTO()
                        )
                ).collect(Collectors.toSet());

        return new RegistrationListDTO(user.toDTO(), eventRegistrationDTOS);
    }
}
