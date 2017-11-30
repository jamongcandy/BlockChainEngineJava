import java.util.Date;

public class BlockHeader {
	private int number;
	private Date time;
	private String prevHash;
	private String transactionsHash;
	private String hash;

	public BlockHeader(int number, String prevHash, String transactionsHash) {
		time = new Date();
		this.number = number;
		this.prevHash = prevHash;
		this.transactionsHash = transactionsHash;

		this.hash = Sha256.SHA256(Integer.toString(number).concat("&").concat(time.toString()).concat("&")
				.concat(this.prevHash).concat("&").concat(this.transactionsHash));
	}

	public int getNumber() {
		return number;
	}

	public String getHash() {
		return hash;
	}

	public String getPrevHash() {
		return prevHash;
	}

	public String getTransactionsHash() {
		return transactionsHash;
	}

	public Date getTime() {
		return time;
	}

	public void showBlockHeader() {
		System.out.println("BlockHeader {");
		System.out.println("  block number     : " + number);
		System.out.println("  time             : " + time);
		System.out.println("  prev block hash  : " + prevHash);
		System.out.println("  transactions hash: " + transactionsHash);
		System.out.println("  block hash       : " + hash);
		System.out.println("}");
	}

}
