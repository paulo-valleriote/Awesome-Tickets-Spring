package valleriote.paulo.awesometickets.app.dto.event;

import java.time.LocalDateTime;

public record EventCreateDTO(
        String id,
        String name,
        LocalDateTime date
) {
}
