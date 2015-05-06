package src;
public class OrderReply {
	public int riskStatus;
	public long orderID;
	public boolean SendSuccess;
	public OrderReply(int riskStatus, long orderID, boolean SendSuccess) {
		this.riskStatus = riskStatus;
		this.orderID = orderID;
		this.SendSuccess = SendSuccess;
	}
}
