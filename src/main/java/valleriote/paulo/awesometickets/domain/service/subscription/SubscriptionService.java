package valleriote.paulo.awesometickets.domain.service.subscription;

import valleriote.paulo.awesometickets.domain.entity.Event;

import java.util.List;

public interface SubscriptionService {
    void subscribe(String eventId);
    void unsubscribe(String eventId);
    List<Event> listSubscriptions(String userId);
}
