package valleriote.paulo.awesometickets.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valleriote.paulo.awesometickets.domain.entity.Transaction;
import valleriote.paulo.awesometickets.domain.entity.User;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Transaction findByIdAndUser(String id, User user);
}
