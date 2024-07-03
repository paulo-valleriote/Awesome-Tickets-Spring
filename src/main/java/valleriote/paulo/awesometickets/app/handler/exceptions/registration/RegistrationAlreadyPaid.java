package valleriote.paulo.awesometickets.app.handler.exceptions.registration;

public class RegistrationAlreadyPaid extends IllegalAccessException {
    public RegistrationAlreadyPaid() {
        super("Event ticket already paid");
    }

    public RegistrationAlreadyPaid(String message) {
        super(message);
    }
}
