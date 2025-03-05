package myAPI.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handle(IllegalArgumentException businessException) {
		return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNotFoundException(NoSuchElementException noFoundException) {
		return new ResponseEntity<>("Resource ID not found", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleunexpectedException(Throwable unexpectedException) {
		var mensage = "expect server Error";
		logger.error(mensage, unexpectedException);
		return new ResponseEntity<>("unexpect server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
