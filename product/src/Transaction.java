import java.util.Date;

public class Transaction {
	private Date time;
	private String data;
	private String hash;

	public Transaction(String data) {
		this.data = data;
		time = new Date();
		hash = Sha256.SHA256(time.toString().concat("&").concat(data));
	}

	public Transaction(Transaction src) {
		time = (Date) src.getTime().clone();
		data = new String(src.getData());
		hash = new String(src.getHash());
	}

	public Date getTime() {
		return time;
	}

	public String getData() {
		return data;
	}

	public String getHash() {
		if (hash == null) {
			hash = Sha256.SHA256(data);
		}
		return hash;
	}

	public void showTransaction() {
		System.out.println("tx");
		System.out.println("  time: " + time);
		System.out.println("  data: " + data);
		System.out.println("  hash: " + hash);
	}

}
