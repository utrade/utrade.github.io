package src;
public class DuplicateKeyException extends Exception {
	public String message;
	public DuplicateKeyException(String s) {
		this.message = s;
	}
	public DuplicateKeyException() {
		this.message = "Exception Occured";
	}
}
