package valleriote.paulo.awesometickets.app.dto.http;

import org.springframework.http.HttpStatus;

public record ResponseDTO(String message, HttpStatus status, Object data) {
}
