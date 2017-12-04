
public abstract class Node {
	enum NodeType {Miner, TransactionCreator, Observer};
	protected BlockchainUI bui;
	public NodeType nodeType;
	
	public abstract void work();
}
