import java.util.LinkedList;

public class SimpleBlockchain extends Blockchain {

	private int chainSize;
	private LinkedList<Block> simpleBlockchain;

	public SimpleBlockchain(Block genesisBlock, int chainSize) {
		this.genesisBlock = genesisBlock;
		this.chainSize = chainSize;
		simpleBlockchain = new LinkedList<Block>();
	}
	
//	public void replaceChain() {
//
//	}
//
//	public void isValidBlocks() {
//
//	}
	@Override
	public void addBlock(Block newBlock) {
		simpleBlockchain.offer(newBlock);
		if(simpleBlockchain.size() > chainSize) {
			simpleBlockchain.removeFirst();
		}
	}



	@Override
	public Block getLatestBlock() {
		return simpleBlockchain.peekLast();
	}

	@Override
	public Block getBlock(int blockNumber) {
		for (Block block : simpleBlockchain) {
			if(block.getBlockNumber() == blockNumber) {
				return block;
			}
		}
		return null;
	}



}
