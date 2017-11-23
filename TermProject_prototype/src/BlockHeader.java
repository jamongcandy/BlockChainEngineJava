
public class BlockHeader {
	private int number;
	private String prevHash;
	private String transactionsHash;
	private String hash;

	public BlockHeader(int number, String prevHash, String transactionsHash) {
		this.number = number;
		this.prevHash = prevHash;
		this.transactionsHash = transactionsHash;

		this.hash = Sha256.SHA256(Integer.toString(number).concat("&").concat(this.prevHash).concat("&").concat(this.transactionsHash));
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
	
	public void showBlockHeader() {
		System.out.println("BlockHeader {");
		System.out.println("  block number     : " + number);
		System.out.println("  prev block hash  : " + prevHash);
		System.out.println("  transactions hash: " + transactionsHash);
		System.out.println("  block hash       : " + hash);
		System.out.println("}");
	}

}
