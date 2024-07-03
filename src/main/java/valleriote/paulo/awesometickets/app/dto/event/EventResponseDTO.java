package valleriote.paulo.awesometickets.app.dto.event;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import valleriote.paulo.awesometickets.app.config.formatter.date.DateJsonSerializer;

import java.time.LocalDateTime;

public record EventResponseDTO(
        String id,
        String name,
        @JsonSerialize(using = DateJsonSerializer.class) LocalDateTime date,
        @JsonSerialize(using = DateJsonSerializer.class) LocalDateTime createdAt
) {
}
