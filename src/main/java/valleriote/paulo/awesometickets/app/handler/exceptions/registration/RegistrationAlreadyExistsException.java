package valleriote.paulo.awesometickets.app.handler.exceptions.registration;

import org.apache.coyote.BadRequestException;

public class RegistrationAlreadyExistsException extends BadRequestException {
    public RegistrationAlreadyExistsException() {
        super("User already subscribed");
    }

    public RegistrationAlreadyExistsException(String message) {
        super(message);
    }
}
