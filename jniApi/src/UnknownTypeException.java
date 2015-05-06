package src;
public class UnknownTypeException extends Exception {
	public String message;
	public UnknownTypeException(String s) {
		this.message = s;
	}
	public UnknownTypeException() {
		this.message = "Exception Occured";
	}
}
