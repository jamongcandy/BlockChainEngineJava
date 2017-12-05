import java.util.TreeSet;

public class BlockchainService {

	private Blockchain blockchain;
	private TransactionFactory txFactory;

	public BlockchainService(TransactionFactory txFactory) {
		this.txFactory = txFactory;
	}

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

	public AbstractTransaction createTransaction(TransactionCreator from, Object data) {
		return new
	}

	public TreeSet<Hash> getMerkleTree() {
		return null;

	}
}
