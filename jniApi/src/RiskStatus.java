package src;
public class RiskStatus {
	public static final int	RiskStatus_SUCCESS = 0;
	public static final int	RiskStatus_WRONG_QUANTITY = 1;
	public static final int	RiskStatus_NOT_CONFIGURED = 2;
	public static final int	RiskStatus_MAX_SINGLE_ORDER_QTY_VIOLATED = 3;
	public static final int	RiskStatus_MAX_SINGLE_ORDER_VALUE_VIOLATED = 4;
	public static final int	RiskStatus_TOTAL_BUY_QUANTITY_VIOLATED = 5;
	public static final int	RiskStatus_TOTAL_BUY_VALUE_VIOLATED = 6;
	public static final int	RiskStatus_TOTAL_SELL_QUANTITY_VIOLATED = 7;
	public static final int	RiskStatus_TOTAL_SELL_VALUE_VIOLATED = 8;
	public static final int	RiskStatus_MAX_NET_QUANTITY_VIOLATED = 9;
	public static final int	RiskStatus_MAX_NET_VALUE_VIOLATED = 10;
	public static final int	RiskStatus_PRICE_PROTECTION_CHECK_VIOLATED = 11;
	public static final int	RiskStatus_MAX_MTM_LOSS_VIOLATED = 12;
	public static final int	RiskStatus_MAX_ORDERS_PER_SECOND_VIOLATED = 13;
	public static final int	RiskStatus_EXCHANGE_DISCONNECTED = 14;
	public static final int	RiskStatus_OUTSTANDING_TOTAL_BUY_QUANTITY_VIOLATED = 15;
	public static final int	RiskStatus_OUTSTANDING_TOTAL_BUY_VALUE_VIOLATED = 16;
	public static final int	RiskStatus_OUTSTANDING_TOTAL_SELL_QUANTITY_VIOLATED = 17;
	public static final int	RiskStatus_OUTSTANDING_TOTAL_SELL_VALUE_VIOLATED = 18;
	public static final int	RiskStatus_INDEX_PROTECTION_NSE_VIOLATED = 19;
	public static final int	RiskStatus_INDEX_PROTECTION_BSE_VIOLATED = 20;
	public static final int	RiskStatus_SECURITY_LIMITS_VIOLATED_BUY_QTY = 21;
	public static final int	RiskStatus_SECURITY_LIMITS_VIOLATED_BUY_VALUE = 22;
	public static final int	RiskStatus_SECURITY_LIMITS_VIOLATED_SELL_QTY = 23;
	public static final int	RiskStatus_SECURITY_LIMITS_VIOLATED_SELL_VALUE = 24;
	public static final int	RiskStatus_TRADER_OR_CLIENT_MARGIN_INSUFFICIENT = 25;
	public static final int	RiskStatus_MEMBER_NSE_MARGIN_INSUFFICIENT = 26;
	public static final int	RiskStatus_MEMBER_BSE_MARGIN_INSUFFICIENT = 27;
	public static final int	RiskStatus_PRICE_NOT_WITHIN_CIRCUIT_RANGE = 28;
	public static final int	RiskStatus_CLOSE_PRICE_PROTECTION_FAILED = 29;
	public static final int	RiskStatus_BAD_TRADE_PRICE_CHECK_FAILED = 30;
	public static final int	RiskStatus_MARKET_NOT_OPEN = 31;
	public static final int	RiskStatus_MAX = 32;
}
