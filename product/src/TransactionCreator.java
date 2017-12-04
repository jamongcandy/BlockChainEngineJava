
public class TransactionCreator extends Node {

	public TransactionCreator(BlockchainUI bui){
		this.bui = bui;
		this.nodeType =  NodeType.TransactionCreator;
	}

	@Override
	public void work() {
		// makeTransaction
		Object data = null;
		bui.makeTransaction(this, data);
	}

}
