import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class BlockChain implements Serializable {
	private List<Transaction> txsNotYetAdded;
	private List<Block> chain;
	private Block genesis;
	private Block lastBlock;

	public BlockChain() {
		txsNotYetAdded = new ArrayList<Transaction>();
		genesis = new Block(0, "", null);
		chain = new LinkedList<Block>();
		chain.add(genesis);
		lastBlock = genesis;
	}

	public void downloadBlockChain(BlockChain src) {
		txsNotYetAdded.clear();
		for (int i = 0; i < src.getTxsNotYetAdded().size(); i++) {
			txsNotYetAdded.add(new Transaction(src.getTxsNotYetAdded().get(i)));
		}

		chain.clear();
		for (int i = 0; i < src.getChain().size(); i++) {
			chain.add(new Block(src.getChain().get(i)));
		}

		genesis = chain.get(0);

		lastBlock = chain.get(chain.size() - 1);
	}

	public Transaction createTransaction(String data) {
		Transaction t = new Transaction(data);
		txsNotYetAdded.add(t);
		return t;
	}

	public void addTransaction(Transaction tx) {
		txsNotYetAdded.add(tx);
	}

	private Transaction deleteTransaction(String hash) {
		if (txsNotYetAdded.size() > 0) {
			int i;
			for (i = 0; i < txsNotYetAdded.size(); i++) {
				if (txsNotYetAdded.get(i).getHash().equals(hash)) {
					return txsNotYetAdded.remove(i);
				}
			}
		}
		return null;
	}

	public Block createBlock() {
		List<Transaction> t = new ArrayList<Transaction>();

		t.addAll(txsNotYetAdded);

		return new Block(lastBlock.getNumber() + 1, lastBlock.getHash(), t);
	}

	public void addBlock(Block newBlock) {
		if (newBlock.getPrevHash().equals(lastBlock.getHash())) {
			for (int i = 0; i < newBlock.getTransactions().size(); i++) {
				deleteTransaction(newBlock.getTransactions().get(i).getHash());
			}
			chain.add(newBlock);
			lastBlock = newBlock;
		}
	}

	public Block getGenesis() {
		return genesis;
	}

	public Block getLastBlock() {
		return lastBlock;
	}

	public List<Block> getChain() {
		return chain;
	}

	public List<Transaction> getTxsNotYetAdded() {
		return txsNotYetAdded;
	}

	public Block getBlock(int blockNumber) {
		for (int i = 0; i < chain.size(); i++) {
			if (chain.get(i).getNumber() == blockNumber) {
				return chain.get(i);
			}
		}
		return null;
	}

	public Block getBlock(String blockHash) {
		for (int i = 0; i < chain.size(); i++) {
			if (chain.get(i).getHash().equals(blockHash)) {
				return chain.get(i);
			}
		}
		return null;
	}

	public Transaction getTransaction(String txHash) {
		for (int i = 0; i < txsNotYetAdded.size(); i++) {
			if (txsNotYetAdded.get(i).getHash().equals(txHash)) {
				return txsNotYetAdded.get(i);
			}
		}
		return null;
	}

	public void showBlockChain() {
		System.out.println("===Blocks======================");
		for (int i = 0; i < chain.size(); i++) {
			System.out.println("-----------BLOCK-------------");
			chain.get(i).showBlock();
			System.out.println("-----------------------------");
		}
		System.out.println("===============================");
	}

	public int getTxsNotYetAddedSize() {
		return txsNotYetAdded.size();
	}

}
