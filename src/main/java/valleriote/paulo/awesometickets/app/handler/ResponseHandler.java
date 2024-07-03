package valleriote.paulo.awesometickets.app.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import valleriote.paulo.awesometickets.app.dto.http.ResponseDTO;
import valleriote.paulo.awesometickets.app.handler.exceptions.ApiError;

public class ResponseHandler {
    public static ResponseEntity<ResponseDTO> generateResponse(String message, HttpStatus status, Object data) {
        ResponseDTO newResponse = new ResponseDTO(message, status, data);
        return new ResponseEntity<>(newResponse, newResponse.status());
    }

    public static ResponseEntity<ResponseDTO> generateErrorResponse(HttpStatus status, String message,  Throwable data) {
        ResponseDTO newResponse = new ResponseDTO(null, status, new ApiError(status, message, data));
        return new ResponseEntity<>(newResponse, newResponse.status());
    }
}
