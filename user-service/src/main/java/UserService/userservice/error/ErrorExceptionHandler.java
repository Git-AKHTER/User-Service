package UserService.userservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorExceptionHandler {
	 
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(DataNotFoundException ex)
	{
		
		ErrorResponse err = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception ex)
	{

		ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
}
