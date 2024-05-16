package valleriote.paulo.awesometickets.app.handler.exceptions.user;

import java.util.NoSuchElementException;

public class UserNotFound extends NoSuchElementException {
    public UserNotFound() {
        super("None user can be found");
    }

    public UserNotFound(String message) {
        super(message);
    }
}
