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
import java.io.*;
import java.lang.*;

class sampleStgy extends CustomStrategy {

	long TradeInstrument;
	private long tokenId;

	public sampleStgy(long hftTokenId) {
		tokenId = hftTokenId;
        onInitEvent();
	}
	
	@Override
    public void onCMDTerminateStrategy() {
		//System.out.println("onCMDTerminateStrategy");
	}

	@Override
    public void onCMDTerminateSqOffStrategy() {
		//System.out.println("onCMDTerminateSqOffStrategy");
	}

	@Override
    public void onDefaultEvent() {
		//System.out.println("onDefaultEvent");
	}

	@Override
    public void onInitEvent() {
		//System.out.println("onInitEvent");
		try {
		 TradeInstrument = createInstrument(30002885, true, true, false, tokenId);
		}
		catch(Exception x) {
			x.printStackTrace();
    	//System.out.println("error in creating instrument");
			//System.out.println("terminating strategy");
			reqTerminateStrategy(false, tokenId);
			return;
		}
		//System.out.println("new instrument added : ESMNSE RELIANCE");
	}

	@Override
    public void onMarketDataEvent(long instrumentId) {
		//System.out.println("onMarketDataEvent");
		//System.out.println("instrument id : " + instrumentId);
		long sellPrice = reqQryPrice(instrumentId, OrderMode.OrderMode_SELL, (short)1, tokenId);
		//System.out.println("sell price : " + sellPrice);
		long sellQty = reqQryQty(instrumentId, OrderMode.OrderMode_SELL, (short)1, tokenId);
		//System.out.println("sell quantity : " + sellQty);
		SingleOrder order = new SingleOrder(TradeInstrument, sellQty, 0, sellPrice, 0, OrderMode.OrderMode_BUY, OrderType.OrderType_LIMIT, OrderValidity.OrderValidity_DAY);
		OrderReply reply = reqPlaceNewOrder(order, tokenId);
		//if(reply.SendSuccess)
			//System.out.println("success : buy order placed with risk status : " + reply.riskStatus);
		//else
			//System.out.println("failure : order failed with risk status : " + reply.riskStatus);
	}

	@Override
    public void onOhlcTimeOutEvent() {
		//System.out.println("onOhlcTimeEvent");
	}

	@Override
    public void onConfirmed(long orderID) {
		//System.out.println("onConfirmed");
	}

	@Override
    public void onReplaceRejected(long orderID) {
		//System.out.println("onReplaceReject");
	}

	@Override
    public void onCancelRejected(long orderID) {
		//System.out.println("onCancelReject");
	}

	@Override
    public void onReplaced(long orderID) {
		//System.out.println("onReplaced");
	}

	@Override
    public void onNewReject(long orderID) {
		//System.out.println("onNewReject");
	}

	@Override
    public void onIOCCanceled(long orderID) {
		//System.out.println("onIOCCancelled");
	}

	@Override
    public void onFilled(long orderID) {
		//System.out.println("onFilled");
	}

	@Override
    public void onPartialFill(long orderID) {
		//System.out.println("onPartialFill");
	}

	@Override
    public void onMarketToLimit(long orderID) {
		//System.out.println("onMarketToLimit");
	}

	@Override
    public void onFrozen(long orderID) {
		//System.out.println("onFrozen");
	}

	@Override
    public void onTimerEvent() {
		//System.out.println("onTimerEvent");
	}
}
