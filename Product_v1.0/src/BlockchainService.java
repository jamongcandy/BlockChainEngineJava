import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockchainService {
	private int chainSize;
	private Blockchain blockchain;

	public BlockchainService(int chainSize) {
		this.chainSize = chainSize;
		blockchain = new Blockchain();
	}

	public BlockchainService(int chainSize, Blockchain blockchain) {
		this.chainSize = chainSize;
		this.blockchain = blockchain;
	}

	public boolean addTransaction(Transaction tx) {
		if (!blockchain.isInTxPool(tx)) {
			blockchain.getTxPool().add(tx);
			Collections.sort(blockchain.getTxPool());
			return true;
		}
		return false;
	}

	public void addBlock(Block b) {
		if (b.getPrevBlockHash() == null
				|| b.getPrevBlockHash().equals(blockchain.getChain().getLast().getBlockHash())) {
			blockchain.getChain().add(b);
		}

		// clearing txPool
		if (b.getTxs() != null) {
			for (Transaction tx : b.getTxs()) {
				if (blockchain.getTxPool() != null) {
					blockchain.deleteTxInPool(tx.getHash());
				}
			}
		}

		// simple block chain implemented
		if (chainSize > 0) {
			while (blockchain.getChain().size() > chainSize) {
				blockchain.getChain().removeFirst();
			}
		}

	}

	public void printBlockchain() {
		System.out.println("===========   BLOCK CHAIN   ===========");
		for (Block block : blockchain.getChain()) {
			block.printBlock();
		}
		System.out.println("=======================================");
	}

	public int getTxPoolSize() {
		return blockchain.getTxPool().size();
	}

	public Block createBlock() {
		int lastBlockNumber = blockchain.getChain().getLast().getBlockNumber();
		String lastBlockHash = blockchain.getChain().getLast().getBlockHash();
		List<Transaction> clonedTxPool = new ArrayList<Transaction>();
		for (Transaction tx : blockchain.getTxPool()) {
			clonedTxPool.add((Transaction) tx.clone());
		}
		Collections.sort(clonedTxPool);

		Block newBlock = new Block(lastBlockNumber + 1, lastBlockHash, clonedTxPool);
		return newBlock;
	}

	public List<Transaction> getTxPool() {
		return blockchain.getTxPool();
	}

	public Blockchain getBlockchain() {
		return blockchain;
	}

}
