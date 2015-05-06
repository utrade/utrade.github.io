package src;
import src.MarketDepthWrapper;
import java.util.ArrayList;
public class MarketDataWrapper {
	public int No;
	public long OpenPrice;
	public long HighPrice;
	public long LowPrice;
	public long ClosePrice;
	public long Volume;
	public long LastTradeQty;
	public long LastTradePrice;
	public ArrayList<MarketDepthWrapper> MarketDepth;
	public MarketDataWrapper(int No, long OpenPrice, long HighPrice, long LowPrice, long ClosePrice, long Volume, long LastTradeQty, long LastTradePrice, ArrayList<MarketDepthWrapper> MarketDepth) {
		this.No = No;
		this.OpenPrice = OpenPrice;
		this.HighPrice = HighPrice;
		this.LowPrice = LowPrice;
		this.ClosePrice = ClosePrice;
		this.Volume = Volume;
		this.LastTradeQty = LastTradeQty;
		this.LastTradePrice = LastTradePrice;
		this.MarketDepth = MarketDepth;
	}
}
