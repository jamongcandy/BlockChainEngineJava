import java.util.Date;

public class Transaction {
	private Date timestamp;
	private Object data;
	private TransactionCreator creator;
	
	public Transaction(TransactionCreator creator, Object data) {
		this.creator = creator;
		timestamp = new Date();
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public TransactionCreator getCreator() {
		return creator;
	}
}
