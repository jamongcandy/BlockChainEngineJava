
public class Transaction {
	private String data;
	private String hash;

	public Transaction(String data) {
		this.data = data;
		hash = Sha256.SHA256(data);
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
		System.out.println("  data: " + data);
		System.out.println("  hash: " + hash);
	}

}
