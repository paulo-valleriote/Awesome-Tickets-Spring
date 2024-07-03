package valleriote.paulo.awesometickets.app.handler.exceptions.registration;

import java.util.NoSuchElementException;

public class RegistrationNotFoundException extends NoSuchElementException {
    public RegistrationNotFoundException() {
        super("None registration has been found for this user and event");
    }

    public RegistrationNotFoundException(String message) {
        super(message);
    }
}
