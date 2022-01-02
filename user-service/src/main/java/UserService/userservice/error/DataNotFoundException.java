package UserService.userservice.error;

public class DataNotFoundException extends RuntimeException{

	public DataNotFoundException(String message) {
		super(message);
	}

}
