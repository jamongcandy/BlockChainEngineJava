import java.util.TreeSet;

public class BlockchainService {

	private Blockchain blockchain;

	public Block generateNewBlock() {
		return new Block();
	}

	public Blockchain createNewBlockchain() {

		return blockchain;
	}
	public Blockchain createNewBlockchain(Block genesisBlock, int chainSize) {
		blockchain = new SimpleBlockchain(genesisBlock,chainSize);
		return blockchain;
	}

	public Blockchain getBlockchain() {
		return blockchain;
	}

	public Block mining() {
		return null;
		
	}

	public boolean successMining() {
		return false;

	}

	public Transaction createTransaction(TransactionCreator txcreator, Object data) {
		return new Transaction(txcreator, data);
	}

	public TreeSet<Hash> getMerkleTree() {
		return null;

	}
}
