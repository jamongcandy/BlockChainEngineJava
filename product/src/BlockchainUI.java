
public class BlockchainUI {
	private BlockchainService bls;
	
	public BlockchainUI(BlockchainService bls) {
		this.bls = bls;
	}

	public void mining() {

	}

	public Transaction makeTransaction(TransactionCreator txcreator, Object data) {
		return bls.createTransaction(txcreator, data);
	}

	public void observeBlockchain() {

	}

	public void createGenesisBlock() {

	}
}
