import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Blockchain implements Serializable {
	private List<Transaction> txPool;
	private LinkedList<Block> chain;

	public Blockchain() {
		txPool = new ArrayList<Transaction>();
		chain = new LinkedList<Block>();
	}

	// getter
	public LinkedList<Block> getChain() {
		return chain;
	}

	public List<Transaction> getTxPool() {
		return txPool;
	}

	// methods
	public void deleteTxInPool(String txHash) {
		for (Transaction tx : txPool) {
			if (tx.getHash().equals(txHash)) {
				txPool.remove(tx);
				break;
			}
		}
	}

	public boolean isInTxPool(Transaction tx) {
		for (Transaction txInPool : txPool) {
			if (txInPool.getHash().equals(tx.getHash())) {
				return true;
			}
		}
		return false;
	}

	public Transaction getTransaction(String txHash) {
		for (Transaction txInPool : txPool) {
			if (txInPool.getHash().equals(txHash)) {
				return txInPool;
			}
		}
		return null;
	}

	public Block getBlock(Block b) {
		for (Block block : chain) {
			if (block.getBlockHash().equals(b.getBlockHash())) {
				return block;
			}
		}
		return null;
	}

}
