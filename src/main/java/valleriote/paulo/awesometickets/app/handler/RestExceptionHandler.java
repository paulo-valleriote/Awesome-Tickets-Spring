package valleriote.paulo.awesometickets.app.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import valleriote.paulo.awesometickets.app.dto.http.ResponseDTO;
import valleriote.paulo.awesometickets.app.handler.exceptions.ApiError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler {
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    protected ResponseEntity<ResponseDTO> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseHandler.generateErrorResponse(
                new ApiError(HttpStatus.METHOD_NOT_ALLOWED, "HTTP method not supported", ex)
        );
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    protected ResponseEntity<ResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseHandler.generateErrorResponse(
                new ApiError(HttpStatus.METHOD_NOT_ALLOWED, "HTTP method argument not valid", ex)
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ResponseDTO> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseHandler.generateErrorResponse(
                new ApiError(HttpStatus.BAD_REQUEST, "HTTP message cannot be read", ex)
        );
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<ResponseDTO> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return ResponseHandler.generateErrorResponse(
                new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Something internal went wrong", ex)
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<ResponseDTO> handleNoResourceFoundException(NoResourceFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseHandler.generateErrorResponse(
                new ApiError(HttpStatus.NOT_FOUND, "HTTP route not found", ex)
        );
    }
}
