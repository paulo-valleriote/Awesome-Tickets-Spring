package valleriote.paulo.awesometickets.app.dto.event;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import valleriote.paulo.awesometickets.app.config.formatter.date.DateJsonDeserializer;

import java.time.LocalDateTime;

public record EventUpdateDTO(
        String name,
        @JsonDeserialize(using = DateJsonDeserializer.class) LocalDateTime date
) {
}
