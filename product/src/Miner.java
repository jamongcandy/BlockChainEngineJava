
public class Miner extends Node {
	private BlockchainUI bui;
	
	Miner(BlockchainUI bui){
		this.bui = bui;
	}
	
	@Override
	public void work() {
		// mining
		bui.mining();
	}

}
