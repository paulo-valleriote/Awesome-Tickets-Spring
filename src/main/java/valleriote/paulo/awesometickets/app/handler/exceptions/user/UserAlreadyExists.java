package valleriote.paulo.awesometickets.app.handler.exceptions.user;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists() {
        super("User not available");
    }

    public UserAlreadyExists(String message) {
        super(message);
    }
}
