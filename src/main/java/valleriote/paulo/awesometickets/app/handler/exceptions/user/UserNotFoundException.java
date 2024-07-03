package valleriote.paulo.awesometickets.app.handler.exceptions.user;

import java.util.NoSuchElementException;

public class UserNotFoundException extends NoSuchElementException {
    public UserNotFoundException() {
        super("None user can be found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
