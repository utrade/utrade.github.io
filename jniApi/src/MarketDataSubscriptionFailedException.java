package src;
public class MarketDataSubscriptionFailedException extends Exception {
	public String message;
	public MarketDataSubscriptionFailedException(String s) {
		this.message = s;
	}
	public MarketDataSubscriptionFailedException() {
		this.message = "Exception Occured";
	}
}
