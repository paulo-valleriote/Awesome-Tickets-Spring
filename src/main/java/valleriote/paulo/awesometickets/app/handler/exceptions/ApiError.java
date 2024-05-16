package valleriote.paulo.awesometickets.app.handler.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String message;
    private String debugMessage;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(@NonNull HttpStatus status) {
        this();
        this.status = status;
    }

    public ApiError(@NonNull HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ApiError(@NonNull HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
