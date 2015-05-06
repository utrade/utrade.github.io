"""@package pyApi
"""
import pyApi
import sys
from pyApi import SingleOrder, AccountDetail, MarketDataWrapper, OrderReply

  """
 * !@mainpage
 *
 * <h1> muTrade API Version 2.0.1 </h1>
 *
 * <p>muTrades API 2.0.1 provides algo infrastructure, which allows you to create your own latency sensitive strategies and host them in uTrade's infrastructure in exchange co-location or non co-location environment.</p>
 * <p>New custom strategies can be integrated and run in the platform on the fly with no effect on the already running strategies. They can be run from the same front-end. The user can also use any uTrade's inbuilt arbitrage, market making, and various other strategies through the same platform.</p>
 * <p>Risk Management features is also available, same as the trading platform.</p>
 * <p>Custom strategy can be run with both TBT and snapshot feed. Latest data (order book) is provided to the strategy on request-basis.</p>
 * <h1><a class="anchor" id="External"></a>
 * Links</h1>
 * <p><a href="http://utrade.github.io/muTradeApi2/apiUserManual.pdf">User Manual</a><br/>
 *  <a href="http://utrade.github.io/muTradeApi2/strategyFlow.pdf">Strategy Flow</a><br/>
 *  <a href="https://github.com/utrade/muTradeApi2/tree/master/SampleCode">Sample Strategy</a><br/>
 * <a href="http://utrade.github.io/muTradeApi2/faq.pdf">FAQ</a><br/>
 * </p>
 */
"""



class CustomStrategy:
    def __init__(self, tokenId):
        """The constructor"""
        self.tokenId = tokenId
        self.f = open('testLogs.txt','w')

    def onInitEvent(self):
        """!@brief Strategy's first event
        """
        pass

    def onCMDModifyStrategy(self):
        """!@brief no
        """
        pass

    def onCMDTerminateStartegy(self):
        """!@brief no
        """
        pass

    def onCMDTerminateSqOffStrategy(self):
        """!@brief no
        """
        pass

    def onDefaultEvent(self):
        """!@brief Default periodic event
        """
        print "something ode"
        #pass

    def onMarketDataEvent(self, InstrumentId):
        """!@brief Event when new market data is received
        @param InstrumentId symbolic representation of the instrument being traded
        """
        pass

    def onOhlcTimeOutEvent(self):
        """
        """
        pass

    def onConfirmed(self, OrderId):
        """!@brief On confirmation of order with orderid specified in it's argument
        @param OrderId unique id for each order placed
        """
        pass

    def onReplaced(self, OrderId):
        """!@brief When the order with unique id : OrderId gets successfully replaced
        @param OrderId unique id of the order replaced
        """
        pass

    def onReplaceRejected(self, OrderId, ErrorCode):
        """!@brief When request to replace order with id : OrderId is rejected due to reason specified by ErrorCode
        @param OrderId unique id of the order which was not replaced
        @param ErrorCode reason for rejection
        """
        pass

    def onCancelRejected(self, OrderId, ErrorCode):
        """!@brief When the request to cancel an order is rejected
        @param OrderId unique id of the order to be cancelled
        @param ErrorCode reason for rejection
        """
        pass

    def onCanceled(self, OrderId):
        """!@brief When order with id : OrderId gets cancelled
        @param OrderId unique id of the order that was cancelled
        """
        pass

    def onNewRejected(self, OrderId, ErrorCode):
        """!@brief when new placed order is rejected by the market
        @param OrderId id of the new order rejected
        @param ErrorCode reason of the rejection
        """
        pass

    def onIOCCanceled(self, OrderId, CanceledQty):
        """!@brief When the some quantity of IOC order with id : OrderId was cancelled
        @param OrderId unique id of the IOC order that was cancelled
        @param CanceledQty specifies the quantity of order that was cancelled
        """
        pass

    def onFilled(self, OrderId, LastFillPrice, LastFillQty):
        """!@brief When the order with id : OrderId was completely filled
        @param OrderId unique id of the order that was filled
        @param LastFillPrice last price at which your order was filled
        @param LastFillQty the qty filled wrt LastFillPrice
        """
        pass

    def onPartialFill(self, OrderId, LastFillPrice, LastFillQty):
        """!@brief When the order with id : OrderId was partially filled
        @param OrderId unique id of the order partially filled
        @param LastFillPrice last price at which your order was filled
        @param LastFillQty the qty filled wrt LastFillPrice

        """
        pass

    def onMarketToLimit(self, OrderId):
        """!@brief order converted from market to limit
        @param OrderId id of the order converted
        """
        pass

    def onFrozen(self, OrderId):
        """!@brief when the order with id : OrderId gets frozen in the exchange
        @param OrderId id of the order which is frozen in the market
        """
        pass

    def onTimerEvent(self):
        """!@brief occurs after a periodic time interval as asked by the user
        """
        pass

    def createInstrument(self, InstrumentId, RegisterMktData, UseSnapshot, UseOHCL):
    	"""!@brief createNewInstrument To add a new Instrument in the strategy.
    	The Pointer to the added Instrument is set in instrument passed as reference
    	@param symbolId System Unique ID for the Instrument as API2::DATA_TYPES::SYMBOL_ID
        @param regMktData set True to register for Market Data for the Instrument
        @param useSnapShot Set True if Snapshot Feed is to be used and False to use TBT-Feed
        @param useOhlc Set True if OHLC Heed is also required
        @throw MarketDataSubscriptionFailedException
        @return COMMON::Instrument Pointer
        """
        Instrument = pyApi.createInstrument(InstrumentId, RegisterMktData, UseSnapshot, UseOHCL, self.tokenId);
        return Instrument

    def createInstrumentFromSymbolFormat(self, InstrumentId, RegisterMktData, UseSnapshot, UseOHCL):
    	"""!@brief createNewInstrument To add a new Instrument in the strategy.
    	The Pointer to the added Instrument is set in instrument passed as reference
        @param instrumentName Instrument Name
               Format:
               [ExchangeName] [Symbol] [Expiry(YYYYMMDD)] [StrikePrice] [C/P(For Call/Put)]
               Example:
               Cash Segment: NSE RELIANCE
               Futures Segment: NSE RELIANCE 20140828
               Options Segment: NSE RELIANCE 20140828 980.00 C
        @param regMktData set True to register for Market Data for the Instrument
        @param useSnapShot Set True if Snapshot Feed is to be used and False to use TBT-Feed
        @param useOhlc Set True if OHLC Heed is also required
        @return long Instrument
        @throw MarketDataSubscriptionFailedException
       	"""
        Instrument = pyApi.createInstrumentFromSymbolFormat(InstrumentId, RegisterMktData, UseSnapshot, UseOHCL, self.tokenId)
        return Instrument

    def reqPlaceNewOrder(self, singleOrder):
    	"""!@brief places a new single order
    	@param SingleOrder single order object
        @return order reply object
    	"""
        orderReply = pyApi.reqPlaceNewOrder(singleOrder, self.tokenId)
        return orderReply

    def reqPlaceReplaceNewOrder(self, orderId, singleOrder):
    	"""!@brief replaces an existing order with id : orderId by a new single order
    	@param orderId id of the order to be replaced
    	@param SingleOrder single order object
        @return order reply object
    	"""
        orderReply = reqPlaceReplaceNewOrder(orderId, singleOrder, self.tokenId)
        return orderReply

    def reqPlaceCancelOrder(self, orderId, singleOrder):
    	"""!@brief cancels an existing single order with id : orderId
    	@param orderId id of the order to be canceled
    	@param SingleOrder single order to be canceled
        @return order reply object
    	"""
        orderReply = pyApi.reqPlaceCancelOrder(orderId, singleOrder, self.tokenId)
        return orderReply

    def reqStartAlgo(self, MarketDataEventRequired):
    	"""!@brief function call to Start the Strategy listening to OHLC update events
    	@param MarketDataEventRequired true or false if user needs the market data event
    	"""
        pyApi.reqStartAlgo(MarketDataEventRequired, self.tokenId)
        return

    def reqUpdateMarketData(self, InstrumentId):
    	"""!@brief reqUpdateMarketData To manually update Market Feed for all registered Instruments.
        @return True if there is a new updation in Market Data. False if no new updation.
        """
        pyApi.reqUpdateMarketData(InstrumentId, self.tokenId)
        return

    def reqRegisterTimerEvent(self, timeInterval):
    	"""!@brief To request for a Timer-Based event, The event to be called back in time duration passed as argument in microseconds
    	@param timeInterval periodic interval after which the timer event is required
    	"""
        pyApi.reqRegisterTimerEvent(timeInterval, self.tokenId)
        return

    def reqTerminateStrategy(self, cancelOrders):
    	"""!@brief reqTerminateStrategy Called to Terminate Strategy.
    	@param cancelOrders if set true cancels all pending orders
       """
        pyApi.reqTerminateStrategy(cancelOrders, self.tokenId)
        return

    def reqTerminateSqOffStrategy(self):
    	"""!@brief Called to Terminate strategy and Square-Off all  Positions
    	"""
        pyApi.reqTerminateSqOffStrategy(self.tokenId)
        return

    def reqQryPrice(self, InstrumentId, side, position):
    	"""!@param InstrumentId instrument id of the instrument you want the price for
    	@param side buy or sell
    	@param position position of the book
    	@return price of an instrument according to the side and position specified
    	"""
        price = pyApi.reqQryPrice(InstrumentId, side, position, self.tokenId)
        return price

    def reqQryQty(self, InstrumentId, side, position):
    	"""!@param InstrumentId instrument id of the instrument you want the quantity for
    	@param side buy or sell
    	@param position position of the book
    	@return quantity of an instrument according to the side and position specified
    	"""
        quantity = pyApi.reqQryQty(InstrumentId, side, position, self.tokenId)
        return quantity

    def reqQryLastTradePrice(self, InstrumentId):
    	"""!@param InstrumentId InstrumentId of the Instrument you want the ltp for
    	@return last traded price of the instrument specified by the instrumentid
    	"""
        tradeprice = pyApi.reqQryLastTradePrice(InstrumentId, self.tokenId)
        return tradeprice

    def reqQryLastTradeQty(self, InstrumentId):
    	"""!@param InstrumentId InstrumentId of the Instrument you want the last traded quantity for
    	@return last traded quantity of the instrument specified by the instrumentid
    	"""
        tradequantity = pyApi.reqQryLastTradeQty(InstrumentId, self.tokenId)
        return tradequantity

    def reqQryOpenPrice(self, InstrumentId):
    	"""!@param InstrumentId InstrumentId of the Instrument you want the open price for
    	@return open price of the instrument specified by the instrumentid
    	"""
        openprice = pyApi.reqQryOpenPrice(InstrumentId, self.tokenId)
        return openprice

    def reqQryHighPrice(self, InstrumentId):
    	"""!@param InstrumentId InstrumentId of the Instrument you want the high price for
    	@return high price of the instrument specified by the instrumentid
    	"""
        highprice = pyApi.reqQryHighPrice(InstrumentId, self.tokenId)
        return highprice

    def reqQryLowPrice(self, InstrumentId):
    	"""!@param InstrumentId InstrumentId of the Instrument you want the low price for
    	@return low price of the instrument specified by the instrumentid
    	"""
        lowprice = pyApi.reqQryLowPrice(InstrumentId, self.tokenId)
        return lowprice

    def reqQryClosePrice(self, InstrumentId):
    	"""!@param InstrumentId InstrumentId of the Instrument you want the close price for
    	@return close price of the instrument specified by the instrumentid
    	"""
        closeprice = pyApi.reqQryClosePrice(InstrumentId, self.tokenId)
        return closeprice

    def reqQryVolume(self, InstrumentId):
    	"""!@param InstrumentId InstrumentId of the Instrument you want the volume for
    	@return volume of the instrument specified by the instrumentid
    	"""
        volume = pyApi.reqQryVolume(InstrumentId, self.tokenId)
        return volume

    def reqQryQuoteLastUpdateTime(self, InstrumentId):
    	"""!@param InstrumentId InstrumentId of the Instrument you want the last update time for
    	@return last update time of the instrument specified by the instrumentid
    	"""
        quotelastupdatetime = pyApi.reqQryQuoteLastUpdateTime(InstrumentId, self.tokenId)
        return quotelastupdatetime

    def reqQryInstrumentId(self, Instrument):
    	"""!@param Instrument instrument you want the instrument id for
    	@return instrumentid of the corresponding instrument
    	"""
        instrumentid = pyApi.reqQryInstrumentId(Instrument, self.tokenId)
        return instrumentid

    def reqQryLastQuotedPrice(self, Instrument, mode):
    	"""!@param InstrumentId InstrumentId of the Instrument you want the last update time for
    	@return last update time of the instrument specified by the instrumentid
    	"""
        lastquotedprice = pyApi.reqQryLastQuotedPrice(Instrument, mode, self.tokenId)
        return lastquotedprice

    def reqQryOpenQty(self, Instrument):
    	"""!@param Instrument instrument for which you need the open quantity
    	@return open quantity for the respective instrument
    	"""
        openquantity = pyApi.reqQryOpenQty(Instrument, self.tokenId)
        return openquantity

    def reqQryTradedQty(self, Instrument, mode):
    	"""!@param Instrument instrument for which you need the traded quantity
    	@return traded quantity for the respective instrument
    	"""
        tradedquantity = pyApi.reqQryTradedQty(Instrument, mode, self.tokenId)
        return tradedquantity

    def reqQryOpenSide(self, Instrument):
    	"""!@param Instrument instrument for which you need the open side
    	@return open side for the respective instrument
    	"""
        openside = pyApi.reqQryOpenSide(Instrument, self.tokenId)
        return openside

    def reqQryBookedPnl(self, Instrument):
    	"""!@param Instrument instrument for which you need the booked pnl
    	@return booked pnl for the respective instrument
    	"""
        bookenpnl = pyApi.reqQryBookedPnl(Instrument, self.tokenId)
        return bookedpnl

    def reqQryMtmPnl(self, Instrument):
    	"""!@param Instrument instrument for which you need the mtm pnl
    	@return mtm pnl for the respective instrument
    	"""
        mtmpnl = pyApi.reqQryMtmPnl(Instrument, self.tokenId)
        return mtmpnl

    def reqQryAvgPrice(self, Instrument, mode):
    	"""!@param Instrument instrument for which you need the average price
    	@return average price for the respective instrument
    	"""
        averageprice = pyApi.reqQryAvgPrice(Instrument, mode, self.tokenId)
        return averageprice

    def reqQryPendingQty(self, Instrument, mode):
    	"""!@param Instrument instrument for which you need the pending quantity
    	@return pending quantity for the respective instrument
    	"""
        pendingquantity = pyApi.reqQryPendingQty(Instrument, mode, self.tokenId)
        return pendingquantity

    def reqQryClientId(self):
    	"""!@return clientid
    	"""
        clientid = pyApi.reqQryClientId(self.tokenId)
        return clientid

    def reqQryNetBookedPL(self):
    	"""!@return NetBookedPL
    	"""
        netbookedpnl = pyApi.reqQryNetBookedPL(self.tokenId)
        return netbookedpnl

    def reqQryNetMarkToMarkPL(self ):
    	"""!@return NetMarkToMarkPL
    	"""
        netmarktomarkpl = pyApi.reqQryNetMarkToMarkPL(self.tokenId)
        return netmarktomarkpl

    def reqQrySymbolId(self, InstrumentFormat):
    	"""!@param InstrumentFormat instrument format you need the instrumentid for
    	@return instrumentid corresponding to the InstrumentFormat given
    	"""
        symbolid = pyApi.reqQrySymbolId(InstrumentFormat, self.tokenId)
        return symbolid

    def reqQryInstrumentList(self, InstrumentId):
        """!@brief function not available yet
        @param InstrumentId instrumentid you want all instruments for
        @returns list from InstrumentId
        """
        instrumentlist = pyApi.reqQryInstrumentList(Instrument, self.tokenId)
        return instrumentlist

    def reqQryAllInstruments(self):
        """!@brief function not available yet
        @return all instruments irrespective of instrument id
        """
        allinstruments = pyApi.reqQryAllInstruments(self.tokenId)
        return allinstruments

    def reqQryExchangeOrderId(self, orderId):
        """!@param orderId unique id of the order you want the exchange order id for
        @return exchangeorderid corresponding to the orderId
        """
        exchangeorderid = pyApi.reqQryExchangeOrderId(orderId, self.tokenId)
        return exchangeorderid

    def reqAddLogMessage(self, message):
    	"""!@brief can add messages to logs
    	@param message message you want to add to logs
    	"""
        self.f.write("[LOG_MESSAGE], "+message+ "\n")
        pyApi.reqAddLogMessage(message, self.tokenId)
        return

    def reqFlushLogMessage(self):
    	"""!@brief flushes messages into a file
    	"""
        pyApi.reqFlushLogMessage(self.tokenId)
        return

    def reqQryStrategyID(self):
    	"""!@return strategyid
    	"""
        strategyid = pyApi.reqQryStrategyID(self.tokenId)
        return strategyid

    def reqQryOrderPendingQty(self, orderId):
    	"""!@param orderId id of the order you want pending quantity for
    	@return pending quantity corresponding to the orderId specified
    	"""
        orderpendingquantity = pyApi.reqQryOrderPendingQty(orderId, self.tokenId)
        return orderpendingquantity

    def reqQryInstrumentPendingQty(self, Instrument, side):
    	"""!@param Instrument instrument you want pending quantity for
    	@param side buy or sell
    	@return pending quantity for an instrument of a particular side
    	"""
        instrumentpendingquantity = pyApi.reqQryInstrumentPendingQty(Instrument, side, self.tokenId)
        return instrumentpendingquantity

    def reqQryClientOrderID(self, orderId):
    	"""!@param orderid id of the order you want clientorderid for
    	@return clientorderid corresponding to the orderId
    	"""
        clientorderid = pyApi.reqQryClientOrderID(orderId, self.tokenId)
        return clientorderid

    def reqQryOrderStatus(self, orderId):
    	"""!@param orderId id of the order you want status for
    	@return order status corresponding to an orderId
    	"""
        orderstatus = pyApi.reqQryOrderStatus(orderId, self.tokenId)
        return orderstatus

    def getMarketDataEventRequired(self):
        """!@return market data event flag
        """
        return self.MarketDataEventRequired;

    def getOHLCDataEventRequired(self):
        """!@return OHLC flag
        """
        return self.OHLCDataEventRequired;

