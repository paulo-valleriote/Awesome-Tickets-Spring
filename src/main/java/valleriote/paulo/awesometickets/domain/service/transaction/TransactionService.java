package valleriote.paulo.awesometickets.domain.service.transaction;

import valleriote.paulo.awesometickets.app.dto.transactions.CreateTransactionDTO;
import valleriote.paulo.awesometickets.app.dto.transactions.TransactionOperationDTO;
import valleriote.paulo.awesometickets.app.dto.transactions.TransactionResponseDTO;

import java.util.Set;

public interface TransactionService {
    Set<TransactionResponseDTO> list();
    TransactionResponseDTO findById(String transactionId);
    TransactionResponseDTO create(CreateTransactionDTO dto);
    void pay(TransactionOperationDTO dto);
    void cancel(TransactionOperationDTO dto);
    void refund(TransactionOperationDTO dto);
}
