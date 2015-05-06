import java.util.List;
import java.io.*;
import java.util.Map;
import java.lang.String;
import src.AccountDetail;
import src.AccountType;
import src.DuplicateKeyException; 
import src.ExchangeId; 
import src.InstrumentNotRegistered; 
import src.InstrumentType; 
import src.MarketDataSubscriptionFailedException; 
import src.MarketDataWrapper; 
import src.MarketDepthWrapper; 
import src.MarketSession; 
import src.OptionAttribute; 
import src.OptionMode; 
import src.OrderMode; 
import src.OrderReply; 
import src.OrderStatus; 
import src.OrderType; 
import src.OrderValidity; 
import src.ProductType; 
import src.RiskStatus; 
import src.SecurityType; 
import src.SingleOrder; 
import src.SourceId; 
import src.StrategyComment; 
import src.TransactionType; 
import src.UnknownTypeException; 
public class CustomStrategy {
    static {
        System.out.println("entering Java Static block");
        System.loadLibrary("customHft");
        System.out.println(" loaded customHft in unkown status ");
    }
    /**
     * creates new instrument according to the unique instrument id provided
     * @param InstrumentId unique id of the instrument you want to trade in
     * @param RegisterMktData true for yes and viceversa
     * @param UseSnapshot true for yes and viceversa
     * @param UseOHLC true for yes and viceversa
     * @param tokenId provided by the constructor
     * @exception MarketDataSubscriptionFailedException
     * @return long instrument
     */
    public native long createInstrument(long InstrumentId, boolean RegisterMktData, boolean UseSnapshot, boolean UseOHLC, long tokenId) throws MarketDataSubscriptionFailedException;
    /**
     * Places a new order in the market
     * @param order new single order object
     * @param tokenId
     * @return OrderReply object 
     */
    public native OrderReply reqPlaceNewOrder(SingleOrder order, long tokenId);
    /**
     * Places a replace order in the market
     * @param orderId id of the order you want to replace
     * @param order SingleOrder object for the replace order
     * @return OrderReply object 
     */
    public native OrderReply reqPlaceReplaceOrder(long orderId, SingleOrder order, long tokenId);
    /**
     * Places a cancel order in the market
     * @param orderId id of the order you want to cancel
     * @return OrderReply object
     */
    public native OrderReply reqPlaceCancelOrder(long orderId, long tokenId);
    /**
     * starts algo
     * @param MarketDataEventRequired boolean
     */
    public native void reqStartAlgo(boolean MarketDataEventRequired, long tokenId);
    /**
     * Updates market data for another instrument id
     * @param InstrumentId id of the instrument you want market data for
     */
    public native void reqUpdateMarketData(long InstrumentId, long tokenId);
    /**
     * registers for a periodic timer event
     * @param timerInterval long : in microseconds
     */
    public native void reqRegisterTimerEvent(long timerInterval, long tokenId);
    /**
     * terminates strategy
     * @param cancelOrders boolean
     */
    public native void reqTerminateStrategy(boolean cancelOrders, long tokenId);
    /**
     * terminates strategy with squareoff
     */
    public native void reqTerminateSqOffStrategy(long tokenId);
    /**
     * @param InstrumentId id of the instrument you want price for
     * @param side OrderMode buy or sell 
     * @param position position in order book
     * @return long price
     */
    public native long reqQryPrice(long InstrumentId, int side, short position, long tokenId);
    /**
     * @param InstrumentId id of the instrument you want quantity for
     * @param side OrderMode buy or sell 
     * @param position position in order book
     * @return long quantity
     */
    public native long reqQryQty(long InstrumentId, int side, short position, long tokenId);
    /**
     * @param InstrumentId id of the instrument you want last trade price for
     * @return long LTP
     */
    public native long reqQryLastTradePrice(long InstrumentId, long tokenId);
    /**
     * @param InstrumentId id of the instrument you want last trade quantity for
     * @return long LTQ
     */
    public native long reqQryLastTradeQty(long InstrumentId, long tokenId);
    /**
     * @param InstrumentId id of the instrument you want open price for
     * @return long open price
     */
    public native long reqQryOpenPrice(long InstrumentId, long tokenId);
    /**
     * @param InstrumentId id of the instrument you want high price for
     * @return long high price
     */
    public native long reqQryHighPrice(long InstrumentId, long tokenId);
    /**
     * @param InstrumentId id of the instrument you want low price for
     * @return long low price
     */
    public native long reqQryLowPrice(long InstrumentId, long tokenId);
    /**
     * @param InstrumentId id of the instrument you want close price for
     * @return long close price
     */
    public native long reqQryClosePrice(long InstrumentId, long tokenId);
    /**
     * @param InstrumentId id of the instrument you want volume for
     * @return long volume
     */
    public native long reqQryVolume(long InstrumentId, long tokenId);
    /**
     * @param InstrumentId id of the instrument you want last update time for
     * @return long last update time
     */
    public native long reqQryQuoteLastUpdateTime(long InstrumentId, long tokenId);
    /**
     * @param instrument
     * @return instrument id of the respective instrument
     */
    public native long reqQryInstrumentId(long instrument, long tokenId);
    /**
     * @param instrument
     * @param mode OrderMode buy or sell
     * @return long last quoted price
     */
    public native long reqQryLastQuotedPrice(long Instrument, int mode, long tokenId);
    /**
     * @param instrument
     * @return open quantity of the instrument specified
     */
    public native long reqQryOpenQty(long Instrument, long tokenId);
    /**
     * @param instrument
     * @param mode OrderMode buy or sell
     * @return traded quantity of the instrument specified 
     */
    public native long reqQryTradedQty(long Instrument, int mode, long tokenId);
    /**
     * @param instrument
     * @return open side of the instrument specified
     */
    public native int reqQryOpenSide(long Instrument, long tokenId);
    /**
     * @param instrument 
     * @return booked pnl of the instrument specified
     */
    public native long reqQryBookedPnl(long Instrument, long tokenId);
    /**
     * @param instrument
     * @return mtm pnl of the instrument specified
     */
    public native long reqQryMtmPnl(long Instrument, long tokenId);
    /**
     * @param instrument
     * @param mode OrderMode buy or sel
     * @return average price of the instrument specified taking into account the order mode
     */
    public native long reqQryAvgPrice(long Instrument, int mode, long tokenId);
    /**
     * @param instrument
     * @param mode OrderMode buy or sell
     * @return long pending quantity of the instrument specified taking into account the order mode 
     */
    public native long reqQryPendingQty(long Instrument, int mode, long tokenId);
    /**
     * @return long client id
     */
    public native long reqQryClientId(long tokenId);
    /**
     * @return net booked pl
     */
    public native long reqQryNetBookedPL(long tokenId);
    /**
     * @return net mark to mark pl
     */
    public native long reqQryNetMarkToMarkPL(long tokenId);
    /**
     * not implemented yet
     * @param instrumentid
     * @return list of all instruments of the instrument id
     */
    public native List<Long> reqQryInstrumentList(long InstrumentId, long tokenId);
    /**
     * not implemented yet
     * @return list of all instruments
     */
    public native List<Long> reqQryAllInstruments(long tokenId);
    /**
     * @return strategy id
     */
    public native long reqQryStrategyID(long tokenId);
    /**
     * @param orderID id of the order you want pending qty for
     * @return long pending quantity of the id specified
     */
    public native long reqQryOrderPendingQty(long orderID, long tokenId);
    /**
     * @param instrument
     * @return pending quantity of the instrument specified taking side into account
     */
    public native long reqQryInstrumentPendingQty(long instrument, int side, long tokenId);
    /**
     * @param orderID
     * @return client order id
     */
    public native long reqQryClientOrderID(long orderID, long tokenId);
    /**
     * @param orderID
     * @return status of the order in the market with id : orderID
     */
    public native int reqQryOrderStatus(long orderID, long tokenId);
    /**
     * @param message to be written in the log
     */
    public void reqAddLogMessage(String message, long tokenId) {
    }
    /**
     * flush log buffer to a log file
     */
    public void reqFlushLogMessage(String tokenId) {
    }
    /**
     *
     */
    public void onCMDModifyStrategy() {
    }
    public void onCMDTerminateStrategy() {
    }
    public void onCMDTerminateSqOffStrategy() {
    }
    public void onDefaultEvent() {
    }
    /**
     * strategy's first event
     */
    public void onInitEvent() {
    }
    /**
     * occurs when new market data arrives
     * @param instrument id
     */
    public void onMarketDataEvent(long InstrumentId) {
    }
    /**
     */
    public void onOhlcTimeOutEvent() {
    }
    /**
     * On confirmation of order with orderid specified in it's argument
     * @param OrderId unique id for each order placed
     */
    public void onConfirmed(long orderID) {
    }
    /**
     * brief When request to replace order with id : OrderId is rejected due to reason specified by ErrorCode
     * @param OrderID unique id of the order which was not replaced
     * @param ErrorCode reason for rejection
     */
    public void onReplaceRejected(long orderID, long ErrorCode) {
    }
    /**
     * When the request to cancel an order is rejected
     * @param OrderID unique id of the order to be cancelled
     * @param ErrorCode reason for rejection
     */
    public void onCancelRejected(long orderID, long ErrorCode) {
    }
    /**
     * When the order with unique id : OrderId gets successfully replaced
     * @param OrderID unique id of the order replaced
     */
    public void onReplaced(long orderID) {
    }
    /**
     * when new placed order is rejected by the market
     * @param OrderID id of the new order rejected
     * @param ErrorCode reason of the rejection
     */
    public void onNewReject(long orderID, long ErrorCode) {
    }
    /**
     * When the some quantity of IOC order with id : OrderId was cancelled
     * @param OrderID unique id of the IOC order that was cancelled
     * @param CanceledQty specifies the quantity of order that was canceled
     */
    public void onIOCCanceled(long orderID, long CanceledQty) {
    }
    /**
     * When the order with id : OrderId was completely filled
     * @param OrderID unique id of the order that was filled
     * @param LastFillPrice last price at which your order was filled
     * @param LastFillQty the qty filled wrt LastFillPrice
     */
    public void onFilled(long orderID, long LastFillPrice, long LastFillQty) {
    }
    /**
     * When the order with id : OrderId was partially filled
     * @param OrderID unique id of the order partially filled
     * @param LastFillPrice last price at which your order was filled
     * @param LastFillQty the qty filled wrt LastFillPrice
     */
    public void onPartialFill(long orderID, long LastFillPrice, long LastFillQty) {
    }
    /**
     * order converted from market to limit
     * @param OrderID id of the order converted
     */
    public void onMarketToLimit(long orderID) {
    }
    /**
     * when the order with id : OrderId gets frozen in the exchange
     * @param OrderId iD of the order which is frozen in the market
     */
    public void onFrozen(long orderID) {
    }
    /**
     * occurs after a periodic time interval as asked by the user
     */
    public void onTimerEvent() {
    }
}
