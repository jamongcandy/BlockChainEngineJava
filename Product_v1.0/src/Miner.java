
public class Miner {
	int id;
	BlockchainUI ui;

	public Miner(int id, BlockchainUI ui) {
		this.id = id;
		this.ui = ui;
	}

	public void createNewBlock() {
		ui.createNewBlock();
	}

}
