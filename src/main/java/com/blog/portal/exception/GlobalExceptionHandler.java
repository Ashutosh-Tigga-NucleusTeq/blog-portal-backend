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

import com.blog.portal.responsePayload.ResponseOutDTO;

/**
 * This class is responsible for handling exceptions globally and returning
 * appropriate API responses.
 * @author Ashutosh Tigga
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Exception handler for ResourceNotFoundException.
	 * @param ex The exception of type ResourceNotFoundException.
	 * @return ResponseEntity containing an ResponseOutDTO]
	 *         with an error message and
	 *         status code.
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseOutDTO> resourceNotFoundExceptionHandler(final ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ResponseOutDTO responseOutDTO = new ResponseOutDTO(message, false);
		return new ResponseEntity<>(responseOutDTO, HttpStatus.NOT_FOUND);
	}

	/**
	 * Exception handler for IllegalArgumentException.
	 * @param ex The exception of type IllegalArgumentException.
	 * @return A ResponseEntity containing an ResponseOutDTO
	 *         with an error message and
	 *         status code.
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ResponseOutDTO> resourceNotFoundExceptionHandler(final IllegalArgumentException ex) {
		String message = ex.getMessage();
		ResponseOutDTO responseOutDTO = new ResponseOutDTO(message, false);
		return new ResponseEntity<>(responseOutDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Exception handler for HttpMessageNotReadableException.
	 * @param ex The exception of type HttpMessageNotReadableException.
	 * @return A ResponseEntity containing an ResponseOutDTO
	 *         with an error message and
	 *         status code.
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseOutDTO> resourceNotFoundExceptionHandler(
			final HttpMessageNotReadableException ex) {
		String message = ex.getMessage();
		ResponseOutDTO responseOutDTO = new ResponseOutDTO(message, false);
		return new ResponseEntity<>(responseOutDTO, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Exception handler for MethodArgumentNotValidException.
	 * @param ex The exception of type MethodArgumentNotValidException.
	 * @return A ResponseEntity containing a Map of field
	 *         errors and their respective
	 *         error messages along with a status code.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(
			final MethodArgumentNotValidException ex) {
		Map<String, String> res = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			res.put(fieldName, message);
		});
		return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Exception handler for BadRequestException.
	 * @param ex The exception of type BadRequestException.
	 * @return A ResponseEntity containing an ResponseOutDTO
	 *         with an error message and status code.
	 */
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ResponseOutDTO> handleRegistrationException(final BadRequestException ex) {
		String message = ex.getMessage();
		ResponseOutDTO responseOutDTO = new ResponseOutDTO(message, false);
		return new ResponseEntity<>(responseOutDTO, HttpStatus.CONFLICT);
	}

	/**
	 * Exception handler for UnauthorizedUserExeption.
	 * @param ex The exception of type UnauthorizedUserExeption.
	 * @return A ResponseEntity containing an ResponseOutDTO
	 *         with an error message and status code.
	 */
	@ExceptionHandler(UnauthorizedUserExeption.class)
	public ResponseEntity<ResponseOutDTO> handleUnauthorizedUserException(final UnauthorizedUserExeption ex) {
		String message = ex.getMessage();
		ResponseOutDTO responseOutDTO = new ResponseOutDTO(message, false);
		return new ResponseEntity<>(responseOutDTO, HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Exception Handler for EmptyDataException.
	 * @param ex The Exception of Type EmptyDataException.
	 * @return A ResponseEntity containing an ResponseOutDto with error message.
	 */
	@ExceptionHandler(EmptyDataException.class)
	public ResponseEntity<ResponseOutDTO> handleEmptyDataException(final EmptyDataException ex) {
		String message = ex.getMessage();
		ResponseOutDTO responseOutDTO = new ResponseOutDTO(message, false);
		return new ResponseEntity<>(responseOutDTO, HttpStatus.NO_CONTENT);
	}


}
