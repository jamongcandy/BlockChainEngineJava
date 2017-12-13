
public class Administrator {
	int id;
	BlockchainUI ui;

	public Administrator(int id, BlockchainUI ui) {
		this.id = id;
		this.ui = ui;
	}

	public void createGenesisBlock() {
		Block genesis = new Block(0, null, null);
		ui.addBlock(genesis);
	}
}
