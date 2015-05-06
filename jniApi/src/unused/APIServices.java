package src;
import java.util.ArrayList;
import java.util.Map;
import src.SingleOrder;
import src.OrderMode;
import src.OrderReply;
import src.OrderStatus;
import src.MarketDataSubscriptionFailedException;
public class APIServices {
	public long createInstrument(string InstrumentId,
			boolean RegisterMktData,
			boolean UseSnapshot,
			boolean UseOHLC) throws MarketDataSubscriptionFailedException;
	public long createInstrumentFromSymbolFormat(string InstrumentField,
			boolean RegisterMktData,
			boolean UseSnapshot,
			boolean UseOHLC)
		throws MarketDataSubscriptionFailedException;
	public OrderReply reqPlaceNewOrder(SingleOrder order);
	public OrderReply reqPlaceReplaceOrder(long orderId, SingleOrder order);
	public OrderReply reqPlaceCancelOrder(long orderId);
	public void reqStartAlgo(bool MarketDataEventRequired);
	public void reqUpdateMarketData(string SymbolId);
	public void reqRegisterTimerEvent(long timerInterval);
	public void reqTerminateStrategy(boolean cancelOrders);
	public void reqTerminateSqOffStrategy();
	public long reqQryPrice(string instrumentId, OrderMode side, short position);
	public long reqQryQty(string instrumentId, OrderMode side, short position);
	public long reqQryLastTradePrice(string instrumentId);
	public long reqQryLastTradeQty(string instrumentId);
	public long reqQryOpenPrice(string instrumentId);
	public long reqQryHighPrice(string instrumentId);
	public long reqQryLowPrice(string instrumentId);
	public long reqQryClosePrice(string instrumentId);
	public long reqQryVolume(string instrumentId);
	public long reqQryQuoteLastUpdateTime(string InstrumentID);
	public string reqQryInstrumentId(long instrument);
	public long reqQryLastQuotedPrice(long Instrument, OrderMode mode);
	public long reqQryOpenQty(long Instrument);
	public long reqQryTradedQty(long Instrument, OrderMode mode);
	public OrderMode reqQryOpenSide(long Instrument );
	public long reqQryBookedPnl(long Instrument);
	public long reqQryMtmPnl(long Instrument);
	public long reqQryAvgPrice(long Instrument, OrderMode mode);
	public long reqQryPendingQty(long Instrument, OrderMode mode);
	public long reqQryClientId();
	public long reqQryNetBookedPL();
	public long reqQryNetMarkToMarkPL();
	public string reqQrySymbolId(string InstrumentFormat);
	public ArrayList<long> reqQryInstrumentList(string instrument);
	public ArrayList<long> reqQryAllInstruments();
	public string reqQryExchangeOrderId(long orderId);
	public void reqAddLogMessage(string message);
	public void reqFlushLogMessage();
	public long reqQryStrategyID();
	public long reqQryOrderPendingQty(long orderID);
	public long reqQryInstrumentPendingQty(long instrument, OrderMode side);
	public long reqQryClientOrderID(long orderID);
	public OrderStatus reqQryOrderStatus(long orderID);
	public string reqQryExchangeOrderID(long orderID);
	public Map<String, String> reqQryOriginalParameters();
	public Map<String, String> reqQryLatestParameters();
	public bool registerClient(long socketID);
}
