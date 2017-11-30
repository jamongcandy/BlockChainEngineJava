import java.util.ArrayList;
import java.util.List;

public class Node {
	private String nodeName;
	private BlockChain blockChain;
	private List<Node> peers;

	public Node(String nodeName, Node downloadFrom) {
		this.nodeName = nodeName;
		blockChain = new BlockChain();
		if (downloadFrom != null) {
			blockChain.downloadBlockChain(downloadFrom.getBlockChain());
		}
		peers = new ArrayList<Node>();
	}

	public String getNodeName() {
		return nodeName;
	}

	public BlockChain getBlockChain() {
		return blockChain;
	}

	public List<Node> getPeers() {
		return peers;
	}

	public void createTransaction(String data) {
		Transaction tx = blockChain.createTransaction(data);
		for (int i = 0; i < peers.size(); i++) {
			peers.get(i).receiveTransaction(this, tx);
		}
	}

	private void receiveTransaction(Node senderNode, Transaction tx) {
		if (blockChain.getTransaction(tx.getHash()) == null) {
			blockChain.addTransaction(tx);
			for (int i = 0; i < peers.size(); i++) {
				if (peers.get(i) != senderNode) {
					peers.get(i).receiveTransaction(this, tx);
				}
			}
		}
	}

	private Block createBlock() {
		return blockChain.createBlock();
	}

	private void addBlock(Block newBlock) {
		blockChain.addBlock(newBlock);

		for (int i = 0; i < peers.size(); i++) {
			peers.get(i).receiveBlock(this, new Block(newBlock));
		}
	}

	private void receiveBlock(Node senderNode, Block newBlock) {
		if (blockChain.getBlock(newBlock.getHash()) == null) {
			blockChain.addBlock(newBlock);

			for (int i = 0; i < peers.size(); i++) {
				if (peers.get(i) != senderNode) {
					peers.get(i).receiveBlock(this, newBlock);
				}
			}
		}
	}

	public void showBlockChain() {
		System.out.println();
		System.out.println(nodeName);
		blockChain.showBlockChain();
	}

	public void updateBlockChain() {
		if (blockChain.getTxsNotYetAddedSize() > 0) {
			this.addBlock(this.createBlock());
		}
	}

	public void addPeer(Node peer) {
		if (!peers.contains(peer)) {
			peers.add(peer);
			peer.addPeer(this);
		}
	}

	public boolean deletePeer(Node peer) {
		peer.getPeers().remove(this);
		return peers.remove(peer);
	}
}
