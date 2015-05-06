package src;
public class AccountDetail {
	public String Account;
	public long TraderId;
	public long LocationId;
	public String Type;
	public AccountDetail(String Account, long TraderId, long LocationId, String Type) {
		this.Account = Account;
		this.TraderId = TraderId;
		this.LocationId = LocationId;
		this.Type = Type;
	}
}
