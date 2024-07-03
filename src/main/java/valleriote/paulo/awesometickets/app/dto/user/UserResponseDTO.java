package valleriote.paulo.awesometickets.app.dto.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import valleriote.paulo.awesometickets.app.config.formatter.date.DateJsonSerializer;

import java.time.LocalDateTime;

public record UserResponseDTO(
        String id,
        String username,
        String password,
        @JsonSerialize(using = DateJsonSerializer.class) LocalDateTime createdAt
) {
}
