package util;

public class AppDataException extends Exception{
	private Throwable innerException;
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public AppDataException(Throwable e, String message){
		this.innerException=e;
		this.setMessage(message);
	}

	public AppDataException(String e) {
		this.setMessage(message);
	}

}
