package valleriote.paulo.awesometickets.app.handler.exceptions.event;

public class EventAlreadyDoneException extends RuntimeException {
    public EventAlreadyDoneException() {
        super("This event already happened");
    }

    public EventAlreadyDoneException(String message) {
        super(message);
    }
}
