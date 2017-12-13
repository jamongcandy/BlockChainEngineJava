
public class BlockchainUI {
	private BlockchainService blockchainService;
	private P2PService p2pService;

	public BlockchainUI(BlockchainService blockchainService, P2PService p2pService) {
		this.blockchainService = blockchainService;
		this.p2pService = p2pService;
	}

	public boolean addPeer(int peerID) {
		return p2pService.addPeer(peerID);
	}

	public void addTransaction(Transaction tx) {
		blockchainService.addTransaction(tx);

		// broadcast tx
		p2pService.broadcast(tx);
	}

	public void addBlock(Block b) {
		blockchainService.addBlock(b);

		// broadcast block
		p2pService.broadcast(b);
	}

	public boolean isTxPoolFull(int max) {
		return max <= blockchainService.getTxPoolSize();
	}

	public void createNewBlock() {
		Block newBlock = blockchainService.createBlock();
		addBlock(newBlock);
	}

	public void showBlockchain() {
		blockchainService.printBlockchain();
	}

	public void downloadBlockchainFrom(int peerID, int chainSize) {
		// download blockchain from peerID
		blockchainService = new BlockchainService(chainSize, p2pService.downloadBlockchain(peerID));
	}

	public void startP2P() {
		p2pService.start();
	}

	public void connectPeer(int connectTo) {
		p2pService.connectPeer(connectTo);
	}

	public Blockchain getBlockchain() {
		return blockchainService.getBlockchain();
	}

	public BlockchainService getBlockchainService() {
		return blockchainService;
	}

	public P2PService getP2PService() {
		return p2pService;
	}

}
