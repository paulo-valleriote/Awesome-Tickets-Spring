package valleriote.paulo.awesometickets.app.handler.exceptions.payment;

import java.util.NoSuchElementException;

public class TransactionNotFound extends NoSuchElementException {
    public TransactionNotFound() {
        super("Transaction not found");
    }

    public TransactionNotFound(String message) {
        super(message);
    }
}
