
public class Observer extends Node {
	Observer(BlockchainUI bui){
		this.bui = bui;
		this.nodeType = NodeType.Observer;
	}
	
	@Override
	public void work() {
		// observeBlockchain
		bui.observeBlockchain();
	}

}
