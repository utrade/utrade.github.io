from muTradePyBase import *
import sys


class sample(CustomStrategy):
    def __init__(self, tokenId):
        CustomStrategy.__init__(self,tokenId)


    def onInitEvent(self):
        self.f = open("logFile.txt", "w")
        self.reqAddLogMessage("Test Message")
        try:
            self.TradeInstrument = self.createInstrumentFromSymbolFormat("ESMNSE INFY", True, True, False)
        except:
            print "error in creating instrument: ", sys.exc_info()[0]
            print "terminating strategy"
            self.reqTerminateStrategy(false);
            return
        print "new instrument added : ESMNSE RELIANCE", self.TradeInstrument;

    def onCMDModifyStrategy(self):
        pass

    def onCMDTerminateStartegy(self):
        pass

    def onCMDTerminateSqOffStrategy(self):
        pass

    def onMarketDataEvent(self, InstrumentId):
        print "something mde", type(InstrumentId), InstrumentId
        print InstrumentId
        self.reqAddLogMessage("Market Data Event for " + str(InstrumentId))
        #print str(self.reqQryLastTradePrice(InstrumentId))
        self.reqAddLogMessage("LTP: "+ str(self.reqQryLastTradePrice(InstrumentId)))
        #pass


    def onOhlcTimeOutEvent(self):
        pass

    def onConfirmed(self, OrderId):
        pass

    def onReplaced(self, OrderId):
        pass

    def onReplaceRejected(self, OrderId):
        pass

    def onCancelRejected(self, OrderId):
        pass

    def onNewRejected(self, OrderId):
        pass

    def onIOCCancelled(self, OrderId):
        pass

    def onFilled(self, OrderId):
        pass

    def onPartialFill(self, OrderId):
        pass

    def onMarketToLimit(self, OrderId):
        pass

    def onFrozen(self, OrderId):
        pass

    def onTimerEvent(self):
        pass

