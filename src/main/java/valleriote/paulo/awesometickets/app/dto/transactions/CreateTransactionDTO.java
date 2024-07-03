package valleriote.paulo.awesometickets.app.dto.transactions;

import java.math.BigDecimal;

public record CreateTransactionDTO(String userId, BigDecimal amount) {
}
