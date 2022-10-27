package lesson09;

public class ARException extends Exception {
	
	
	public ARException() {
		super("AR's dvision by Zero is thrown");
	}

	public ARException(String message) {
		super(message);
	}
}
