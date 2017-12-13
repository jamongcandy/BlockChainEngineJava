
public class TransactionCreator {
	int id;
	BlockchainUI ui;
	TransactionFactory factory;

	public TransactionCreator(int id, BlockchainUI ui) {
		this.id = id;
		this.ui = ui;
		this.factory = new TransactionFactory();
	}

	public void createTransaction(String txType) {
		// create transaction
		Transaction tx = factory.createTransaction(id, txType);

		// add created transaction to txPool and broadcast
		ui.addTransaction(tx);

	}

}
