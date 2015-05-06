package src;
public class InstrumentNotRegistered extends Exception {
	public String message;
	public InstrumentNotRegistered(String s) {
		this.message = s;
	}
	public InstrumentNotRegistered() {
		this.message = "Exception Occured";
	}
}
