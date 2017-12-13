
public class Observer {
	int id;
	BlockchainUI ui;

	public Observer(int id, BlockchainUI ui) {
		this.id = id;
		this.ui = ui;
	}

	public void showBlockchain() {
		ui.showBlockchain();
	}

}
