import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Node {
	private int id;
	private BlockChain blockChain;
	private List<Integer> peersID;

	public Node(int id) {
		this.id = id;
		blockChain = new BlockChain();
		peersID = new ArrayList<Integer>();
	}

	public Node(int id, int srcNodePort) {
		this.id = id;
		peersID = new ArrayList<Integer>();
		downloadBlockchain(srcNodePort);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodeID = Integer.parseInt(args[0]);
		System.out.println("Node id : " + nodeID);

		Node node = null;
		if (args.length == 1) {
			node = new Node(nodeID);
		} else if (args.length == 2) {
			node = new Node(nodeID, Integer.parseInt(args[1]));
		}

		CommandThread command = new CommandThread(node);
		command.start();

		ServerThread server = new ServerThread(node);
		server.start();

	}
	
	public void setPort(int id) {
		this.id = id;
	}

	public int getNodeID() {
		return id;
	}

	public BlockChain getBlockChain() {
		return blockChain;
	}

	public List<Integer> getPeersID() {
		return peersID;
	}

	public void downloadBlockchain(int srcNodeID) {
		addPeer(srcNodeID);
		connectPeer(srcNodeID);

		Socket socket;
		try {
			socket = new Socket("localhost", srcNodeID);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			System.out.println("request blockchain");
			out.writeObject("requestBlockChain");

			System.out.println("receive blockchain");
			blockChain = (BlockChain) in.readObject();
			out.writeObject("done");

			out.close();
			in.close();
			socket.close();

		} catch (Exception e) {
			blockChain = new BlockChain();
			e.printStackTrace();
		}
	}

	public void createTransaction(String data) {
		Transaction tx = blockChain.createTransaction(data);

		// broadcast tx
		for (Integer peer : peersID) {
			sendTransaction(peer, tx);

		}
	}

	public void receiveTransaction(Transaction tx) {
		if (blockChain.getTransaction(tx.getHash()) == null) {
			blockChain.addTransaction(tx);

			// broadcast tx
			for (Integer peer : peersID) {
				sendTransaction(peer, tx);
			}
		}

	}

	public void sendTransaction(int receiverID, Transaction tx) {
		Socket socket;
		try {
			socket = new Socket("localhost", receiverID);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			System.out.println("send tx to " + receiverID);
			out.writeObject("tx");
			out.writeObject(tx);
			out.writeObject("done");

			out.close();
			in.close();
			socket.close();

		} catch (Exception e) {
			blockChain = new BlockChain();
			e.printStackTrace();
		}
	}

	public Block createBlock() {
		return blockChain.createBlock();
	}

	public void addBlock(Block newBlock) {
		blockChain.addBlock(newBlock);
	}

	public void showBlockChain() {
		System.out.println();
		System.out.println("node ID : " + id);
		blockChain.showBlockChain();
	}

	public void updateBlockChain() {
		if (blockChain.getTxsNotYetAddedSize() > 0) {
			Block newBlock = createBlock();
			addBlock(newBlock);
			sendBlock(peersID.get(0), newBlock);
			// broadcast!!!!!! not included
		}
	}

	public void sendBlock(int receiverID, Block block) {
		Socket socket;
		try {
			socket = new Socket("localhost", receiverID);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			System.out.println("send block to " + receiverID);
			out.writeObject("block");
			out.writeObject(block);
			out.writeObject("done");

			out.close();
			in.close();
			socket.close();

		} catch (Exception e) {
			blockChain = new BlockChain();
			e.printStackTrace();
		}
	}

	public void connectPeer(int connectTo) {
		Socket socket;
		try {
			socket = new Socket("localhost", connectTo);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			System.out.println("connect to " + connectTo);
			out.writeObject("connect");
			out.writeObject(id);
			out.writeObject("done");

			out.close();
			in.close();
			socket.close();

		} catch (Exception e) {
			blockChain = new BlockChain();
			e.printStackTrace();
		}
	}

	public void addPeer(int peerID) {
		peersID.add(peerID);
	}

}
