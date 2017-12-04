import java.util.LinkedList;

public abstract class Blockchain {
	protected Block genesisBlock;
	
	public abstract void addBlock(Block newBlock);
	public abstract LinkedList<Block> getBlockchain();
	public abstract Block getLatestBlock();
	public abstract Block getBlock(int blockNumber);
	public Block getFirstBlock() {
		return genesisBlock;
	}
//	public boolean isValidNewBlock() {
//		
//	}
	
}
