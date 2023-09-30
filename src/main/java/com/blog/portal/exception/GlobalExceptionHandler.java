package com.blog.portal.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.portal.responseMessage.ApiResponse;

/**
 * The {@code GlobalExceptionHandler} class is responsible
 * for handling exceptions globally and returning appropriate API responses.
 *
 * @author Ashutosh Tigga
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Exception handler for {@link ResourceNotFoundException}.
     *
     * @param ex The exception of type {@link ResourceNotFoundException}.
     * @return A {@link ResponseEntity} containing an {@link ApiResponse}
     * with an error message and
     * status code.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(
            final ResourceNotFoundException ex
    ) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Exception handler for {@link IllegalArgumentException}.
     *
     * @param ex The exception of type {@link IllegalArgumentException}.
     * @return A {@link ResponseEntity} containing an {@link ApiResponse}
     * with an error message and
     * status code.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(
            final IllegalArgumentException ex
    ) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Exception handler for {@link HttpMessageNotReadableException}.
     *
     * @param ex The exception of type {@link HttpMessageNotReadableException}.
     * @return A {@link ResponseEntity} containing an {@link ApiResponse}
     * with an error message and
     * status code.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(
            final HttpMessageNotReadableException ex
    ) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception handler for {@link MethodArgumentNotValidException}.
     *
     * @param ex The exception of type {@link MethodArgumentNotValidException}.
     * @return A {@link ResponseEntity} containing a {@link Map} of field
     * errors and their respective
     * error messages along with a status code.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(
            final MethodArgumentNotValidException ex
    ) {
        Map<String, String> res = new HashMap<>();
        ex
                .getBindingResult()
                .getAllErrors()
                .forEach(
                        error -> {
                            String fieldName = ((FieldError) error).getField();
                            String message = error.getDefaultMessage();
                            res.put(fieldName, message);
                        }
                );
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception handler for {@link UserRegistrationException}.
     *
     * @param ex The exception of type {@link UserRegistrationException}.
     * @return A {@link ResponseEntity} containing an {@link ApiResponse}
     * with an error message and status code.
     */
    @ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity<ApiResponse> handleRegistrationException(
            final UserRegistrationException ex
    ) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }

    /**
     * Exception handler for {@link NullPointerException}.
     *
     * @param ex The exception of type {@link NullPointerException}.
     * @return A {@link ResponseEntity} containing an {@link ApiResponse}
     * with an error message and status code.
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse> handleRegistrationException(
            final NullPointerException ex
    ) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Exception handler for {@link UnauthorizedUserExeption}.
     *
     * @param ex The exception of type {@link UnauthorizedUserExeption}.
     * @return A {@link ResponseEntity} containing an {@link ApiResponse}
     * with an error message and status code.
     */
    @ExceptionHandler(UnauthorizedUserExeption.class)
    public ResponseEntity<ApiResponse> handleUnauthorizedUserException(
            final UnauthorizedUserExeption ex
    ) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
    }
}
