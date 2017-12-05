
public class BlockchainUI {
	private BlockchainService bls;
	
	public BlockchainUI(BlockchainService bls) {
		this.bls = bls;
	}

	public void mining() {

	}

	public AbstractTransaction makeTransaction(TransactionCreator txCreator, Object data) {
		return bls.createTransaction(txCreator, data);
	}

	public void observeBlockchain() {

	}

	public void createGenesisBlock() {

	}
}
