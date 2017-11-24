import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BlockChain {
	private String name;
	private List<Transaction> txsNotYetAdded;
	private List<Block> chain;
	private Block genesis;
	private Block lastBlock;

	public BlockChain(String blockChainname) {
		name = blockChainname;
		txsNotYetAdded = new ArrayList<Transaction>();
		genesis = new Block(0, "", null);
		chain = new LinkedList<Block>();
		chain.add(genesis);
		lastBlock = genesis;
	}

	public void createTransaction(String data) {
		txsNotYetAdded.add(new Transaction(data));
	}

	public Block createBlock() {
		return new Block(lastBlock.getNumber() + 1, lastBlock.getHash(), txsNotYetAdded);
	}

	public void addBlock(Block newBlock) {
		if (newBlock.getPrevHash().equals(lastBlock.getHash())) {
			chain.add(newBlock);
			lastBlock = newBlock;
			txsNotYetAdded = new ArrayList<Transaction>();
		}
	}

	public String getName() {
		return name;
	}

	public Block getGenesis() {
		return genesis;
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

	public void showBlockChain() {
		System.out.println("===Blocks======================");
		for (int i = 0; i < chain.size(); i++) {
			System.out.println("-----------BLOCK-------------");
			chain.get(i).showBlock();
			System.out.println("-----------------------------");
		}
		System.out.println("===============================");
	}

}
