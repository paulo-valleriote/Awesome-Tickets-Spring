package valleriote.paulo.awesometickets.domain.service.transaction;

import org.springframework.stereotype.Service;
import valleriote.paulo.awesometickets.app.dto.transactions.CreateTransactionDTO;
import valleriote.paulo.awesometickets.app.dto.transactions.TransactionOperationDTO;
import valleriote.paulo.awesometickets.app.dto.transactions.TransactionResponseDTO;
import valleriote.paulo.awesometickets.app.handler.exceptions.payment.TransactionAlreadyPaid;
import valleriote.paulo.awesometickets.app.handler.exceptions.payment.TransactionNotFound;
import valleriote.paulo.awesometickets.app.handler.exceptions.user.UserNotFoundException;
import valleriote.paulo.awesometickets.domain.entity.Transaction;
import valleriote.paulo.awesometickets.domain.entity.User;
import valleriote.paulo.awesometickets.domain.entity.enums.TransactionStatus;
import valleriote.paulo.awesometickets.domain.repository.TransactionRepository;
import valleriote.paulo.awesometickets.domain.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<TransactionResponseDTO> list() {
        return this.transactionRepository
                .findAll().stream()
                .map(Transaction::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public TransactionResponseDTO findById(String transactionId) {
        return this.transactionRepository.
                findById(transactionId)
                .orElseThrow(TransactionNotFound::new)
                .toDTO();
    }

    @Override
    public TransactionResponseDTO create(CreateTransactionDTO dto) {
        User user = this.userRepository.findById(dto.userId())
                .orElseThrow(UserNotFoundException::new);

        Transaction transaction = new Transaction();
        transaction.setAmount(dto.amount());
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setUser(user);

        transactionRepository.save(transaction);
        return transaction.toDTO();
    }

    @Override
    public void pay(TransactionOperationDTO dto) {
        User user = this.userRepository.findById(dto.userId())
                .orElseThrow(UserNotFoundException::new);

        Transaction transaction = this.transactionRepository.findByIdAndUser(dto.transactionId(), user);

        this.transactionIsPaid(transaction);
        // TODO: IMPLEMENTAR LOGICA DE MENSAGERIA E CONEXAO COM API DE TERCEIROS
        transaction.setStatus(TransactionStatus.CONFIRMED);
        transactionRepository.save(transaction);
    }

    @Override
    public void cancel(TransactionOperationDTO dto) {
        User user = this.userRepository.findById(dto.userId())
                .orElseThrow(UserNotFoundException::new);

        Transaction transaction = this.transactionRepository.findByIdAndUser(dto.transactionId(), user);

        this.transactionIsPaid(transaction);
        // TODO: IMPLEMENTAR LOGICA DE MENSAGERIA E CONEXAO COM API DE TERCEIROS
        transaction.setStatus(TransactionStatus.CONFIRMED);
        transactionRepository.save(transaction);
    }

    @Override
    public void refund(TransactionOperationDTO dto) {
        User user = this.userRepository.findById(dto.userId())
                .orElseThrow(UserNotFoundException::new);

        Transaction transaction = this.transactionRepository.findByIdAndUser(dto.transactionId(), user);

        this.transactionIsPaid(transaction);
        // TODO: IMPLEMENTAR LOGICA DE MENSAGERIA E CONEXAO COM API DE TERCEIROS
        transaction.setStatus(TransactionStatus.CONFIRMED);
        transactionRepository.save(transaction);
    }

    private void transactionIsPaid(Transaction transaction) throws TransactionAlreadyPaid {
        if (transaction.getStatus() == TransactionStatus.CONFIRMED) {
            throw new TransactionAlreadyPaid();
        }
    }
}
