package valleriote.paulo.awesometickets.app.handler.exceptions.payment;

public class TransactionAlreadyPaid extends RuntimeException {
    public TransactionAlreadyPaid() {
        super("Transaction is already paid");
    }

    public TransactionAlreadyPaid(String message) {
        super(message);
    }
}
