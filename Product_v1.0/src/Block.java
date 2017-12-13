import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class Block implements Serializable {
	// block info
	private int blockNumber;
	private Date timestamp;
	private String prevHash;
	private String merkleRootHash;
	private TreeSet<String> merkleTree;
	private String blockHash;
	// transactions in block
	private List<Transaction> txs;

	// constructor
	public Block(int blockNumber, String prevHash, List<Transaction> txs) {

		this.blockNumber = blockNumber;
		this.prevHash = prevHash;
		this.txs = txs;

		merkleTree = createMerkleTree(txs);
		merkleRootHash = null;
		if (merkleTree != null) {
			merkleRootHash = merkleTree.first();
		}

		timestamp = new Date();
		blockHash = HashUtil.SHA256(Integer.toString(blockNumber) + timestamp.toString() + prevHash + merkleRootHash);
	}

	// getter
	public int getBlockNumber() {
		return blockNumber;
	}

	public String getBlockHash() {
		return blockHash;
	}

	public List<Transaction> getTxs() {
		return txs;
	}

	public String getPrevBlockHash() {
		return prevHash;
	}

	// methods
	private TreeSet<String> createMerkleTree(List<Transaction> txs) {
		//////////////////// HAVE TO FINISH THIS!!!!!!!!!!!!!!!
		return null;
	}

	public void printBlock() {
		System.out.println("--------------   BLOCK   --------------");
		System.out.println("BLOCK NUMBER    : " + blockNumber);
		System.out.println("TIMESTAMP       : " + timestamp);
		System.out.println("PREV BLOCK HASH : " + prevHash);
		System.out.println("MERKLE ROOT HASH: " + merkleRootHash);
		System.out.println("BLOCK HASH      : " + blockHash);
		System.out.println("TRANSACTIONS = { ");
		if (txs != null) {
			for (Transaction tx : txs) {
				tx.printTransaction();
			}
		}
		System.out.println("}");
		System.out.println("---------------------------------------");
	}

}
