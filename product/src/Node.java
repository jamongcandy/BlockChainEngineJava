
public abstract class Node {
	enum NodeType {Miner, TransactionCreator, Observer};
	protected BlockchainUI bui;
	public NodeType nodeType;
	public int id;	// as equal port
	
	public abstract void work();
}
