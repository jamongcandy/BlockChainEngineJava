
public class Observer extends Node {
	private BlockchainUI bui;

	Observer(BlockchainUI bui){
		this.bui = bui;
	}
	
	@Override
	public void work() {
		// observeBlockchain
		bui.observeBlockchain();
	}

}
