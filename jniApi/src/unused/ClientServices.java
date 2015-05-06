package src;
public class ClientServices {
	public void onCMDModifyStrategy();
	public void onCMDTerminateStrategy();
	public void onCMDTerminateSqOffStrategy();
	public void onDefaultEvent();
	public void onInitEvent();
	public void onMarketDataEvent(long instrumentId);
	public void onOhlcTimeOutEvent();
	public void onConfirmed(long orderID);
	public void onReplaceRejected(long orderID);
	public void onCancelRejected(long orderID);
	public void onReplaced(long orderID);
	public void onNewReject(long orderID);
	public void onIOCCanceled(long orderID);
	public void onFilled(long orderID);
	public void onPartialFill(long orderID);
	public void onMarketToLimit(long orderID);
	public void onFrozen(long orderID);
	public void onTimerEvent();
}
