package valleriote.paulo.awesometickets.app.handler.exceptions.event;

import java.util.NoSuchElementException;

public class EventNotFoundException extends NoSuchElementException  {
    public EventNotFoundException() {
        super("None event can be found");
    }

    public EventNotFoundException(String message) {
        super(message);
    }
}
