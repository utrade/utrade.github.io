package src;
import java.util.ArrayList;
public class MarketDepthWrapper {
	public short No;
	public long BidPrice;
	public long BidQty;
	public long AskPrice;
	public long AskQty;
	public MarketDepthWrapper(short No, long BidPrice, long BidQty, long AskPrice, long AskQty) {
		this.No = No;
		this.BidPrice = BidPrice;
		this.BidQty = BidQty;
		this.AskPrice = AskPrice;
		this.AskQty = AskQty;
	}
}
