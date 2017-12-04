
public class TransactionCreator extends Node {
	private BlockchainUI bui;

	public TransactionCreator(BlockchainUI bui){
		this.bui = bui;
	}

	@Override
	public void work() {
		// makeTransaction
		Object data = null;
		bui.makeTransaction(this, data);
	}

}
