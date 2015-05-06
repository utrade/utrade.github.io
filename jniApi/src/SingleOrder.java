package src;
public class SingleOrder {
	public long Instrument;
	public long Qty;
	public long DiscQty;
	public long Price;
	public long StopPrice;
	public int Side;//OrderMode Side;
	public int Type;//OrderType Type;
	public int Validity;//OrderValidity Validity;
	public SingleOrder(long Instrument, long Qty, long DiscQty, long Price, long StopPrice, int Side, int Type, int Validity) {
		this.Instrument = Instrument;
		this.Qty = Qty;
		this.DiscQty = DiscQty;
		this.Price = Price;
		this.StopPrice = StopPrice;
		this.Side = Side;
		this.Type = Type;
		this.Validity = Validity;
	}
}
