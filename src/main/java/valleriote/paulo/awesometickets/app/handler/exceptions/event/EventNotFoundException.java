package valleriote.paulo.awesometickets.app.handler.exceptions.event;

import java.util.NoSuchElementException;

public class EventNotFound extends NoSuchElementException  {
    public EventNotFound() {
        super("None event can be found");
    }

    public EventNotFound(String message) {
        super(message);
    }
}
