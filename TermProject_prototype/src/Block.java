import java.util.ArrayList;
import java.util.List;

public class Block {
	private BlockHeader header;
	private List<Transaction> transactions;

	public Block(int number, String prevHash, List<Transaction> txs) {

		String transactionsHash;
		if (txs == null) {
			transactionsHash = "";
		} else {
			if (txs.size() > 0) {
				transactionsHash = txs.get(0).getHash();
				for (int i = 1; i < txs.size(); i++) {
					transactionsHash = transactionsHash.concat("&").concat(txs.get(i).getHash());
				}
				transactionsHash = Sha256.SHA256(transactionsHash);
			} else {
				transactionsHash = Sha256.SHA256("");
			}
		}

		BlockHeader header = new BlockHeader(number, prevHash, transactionsHash);

		this.header = header;
		this.transactions = txs;
	}

	public Block(Block src) {
		transactions = new ArrayList<Transaction>();
		for (int i = 0; i < src.getTransactions().size(); i++) {
			transactions.add(new Transaction(src.getTransactions().get(i)));
		}
		header = new BlockHeader(src.getHeader());
	}

	public BlockHeader getHeader() {
		return header;
	}

	public int getNumber() {
		return header.getNumber();
	}

	public String getHash() {
		return header.getHash();
	}

	public String getPrevHash() {
		return header.getPrevHash();
	}

	public String getTransactionsHash() {
		return header.getTransactionsHash();
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void showBlock() {
		header.showBlockHeader();

		System.out.println("Transactions {");

		if (transactions == null) {
			System.out.println("  null");
		} else {
			for (int i = 0; i < transactions.size(); i++) {
				System.out.print("  ");
				transactions.get(i).showTransaction();
			}
		}
		System.out.println("}");

	}

}
