package valleriote.paulo.awesometickets.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import valleriote.paulo.awesometickets.app.dto.transactions.CreateTransactionDTO;
import valleriote.paulo.awesometickets.app.dto.transactions.TransactionResponseDTO;
import valleriote.paulo.awesometickets.domain.entity.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(precision = 10, scale = 4)
    private BigDecimal amount;


    private String gateway_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreatedDate
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;

    public TransactionResponseDTO toDTO() {
        return new TransactionResponseDTO(
                id,
                status,
                user != null ? user.getId() : "",
                createdAt
        );
    }

}
