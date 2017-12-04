import java.util.LinkedList;

public class BigBlockchain extends Blockchain {

	private LinkedList<Block> blockchain;
	
	public BigBlockchain(Block genesisBlock) {
		this.genesisBlock = genesisBlock;
		blockchain = new LinkedList<Block>();
		blockchain.add(genesisBlock);
	}
//	public void replaceChain() {
//		
//	}
//	public void isValidBlocks() {
//		
//	}
	@Override
	public void addBlock(Block newBlock) {
		blockchain.add(newBlock);
	}
	@Override
	public Block getLatestBlock() {
		return blockchain.peekLast();
	}
	@Override
	public Block getBlock(int blockNumber) {
		for (Block block : blockchain) {
			if(block.getBlockNumber() == blockNumber) {
				return block;
			}
		}
		return null;
	}
	

}
