
public class Miner extends Node {

	Miner(BlockchainUI bui){
		this.bui = bui;
		this.nodeType = NodeType.Miner;
	}
	
	@Override
	public void work() {
		// mining
		bui.mining();
	}

}
