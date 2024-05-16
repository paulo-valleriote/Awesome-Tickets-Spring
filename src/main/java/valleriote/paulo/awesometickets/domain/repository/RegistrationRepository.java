package valleriote.paulo.awesometickets.domain.repository;

import valleriote.paulo.awesometickets.domain.entity.Registration;

import java.util.Set;

public interface RegistrationRepository {
    Set<Registration> listSubscribedByUser(String id);
    Set<Registration> findByUserAndEvent(String userId, String eventId);
    void create();
    void delete();
}
