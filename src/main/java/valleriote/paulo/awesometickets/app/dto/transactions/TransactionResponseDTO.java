package valleriote.paulo.awesometickets.app.dto.transactions;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import valleriote.paulo.awesometickets.app.config.formatter.date.DateJsonSerializer;
import valleriote.paulo.awesometickets.domain.entity.enums.TransactionStatus;

import java.time.LocalDateTime;

public record TransactionResponseDTO(
        String id,
        TransactionStatus status,
        String userId,
        @JsonSerialize(using = DateJsonSerializer.class) LocalDateTime createdAt
) {
}
