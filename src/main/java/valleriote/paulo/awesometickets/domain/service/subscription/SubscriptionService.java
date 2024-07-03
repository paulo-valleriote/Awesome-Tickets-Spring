package valleriote.paulo.awesometickets.domain.service.subscription;

import valleriote.paulo.awesometickets.app.handler.exceptions.registration.RegistrationAlreadyExistsException;
import valleriote.paulo.awesometickets.domain.entity.Registration;

import java.util.Set;

public interface SubscriptionService {
    void subscribe(String eventId, String userId) throws RegistrationAlreadyExistsException;
    void unsubscribe(String eventId, String userId);
    Set<Registration> listRegistrations(String userId);
}
