package valleriote.paulo.awesometickets.app.handler.exceptions.payment;

public class TransactionLocked extends RuntimeException {
    public TransactionLocked() {
        super("You cant pay this transaction, check status for more information");
    }

    public TransactionLocked(String message) {
        super(message);
    }
}
