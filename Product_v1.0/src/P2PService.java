import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class P2PService extends Thread {

	private List<Integer> peers;
	private Node node;

	public P2PService(Node node) {
		this.node = node;
		peers = new ArrayList<Integer>();
	}

	public boolean addPeer(int peerID) {
		return peers.add(peerID);
	}

	public void connectPeer(int connectTo) {
		Socket socket;
		try {
			socket = new Socket("localhost", connectTo);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			System.out.println("connect to " + connectTo);
			out.writeObject("connect");
			out.writeObject(node.getID());
			out.writeObject("done");

			out.close();
			in.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("can not connect to " + connectTo);
			System.out.println("delete " + connectTo + " in peer list");
			peers.remove(connectTo);
			e.printStackTrace();
		}
	}

	public Blockchain downloadBlockchain(int srcNodeID) {
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
			Blockchain blockchain = (Blockchain) in.readObject();
			out.writeObject("done");

			out.close();
			in.close();
			socket.close();

			return blockchain;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void receiveTransaction(Transaction tx) {
		if (node.getUI().getBlockchainService().getBlockchain().getTransaction(tx.getHash()) == null) {
			node.getUI().getBlockchainService().addTransaction(tx);

			// broadcast tx
			broadcast(tx);
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
			System.out.println("can not connect to " + receiverID);
			System.out.println("delete " + receiverID + " in peer list");
			peers.remove(receiverID);
			e.printStackTrace();
		}
	}

	public void broadcast(Transaction tx) {
		for (Integer peer : peers) {
			sendTransaction(peer, tx);
		}
	}

	public void receiveBlock(Block b) {
		if (node.getUI().getBlockchainService().getBlockchain().getBlock(b) == null) {
			node.getUI().getBlockchainService().addBlock(b);

			// broadcast block
			broadcast(b);
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
			System.out.println("can not connect to " + receiverID);
			System.out.println("delete " + receiverID + " in peer list");
			peers.remove(receiverID);
			e.printStackTrace();
		}
	}

	public void broadcast(Block b) {
		for (Integer peer : peers) {
			sendBlock(peer, b);
		}
	}

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(node.getID());

			while (true) {
				Socket client = server.accept();

				ObjectInputStream in = new ObjectInputStream(client.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

				Object received = null;
				while (true) {
					System.out.println();
					received = in.readObject();

					// connection finished
					if (received.toString().equals("done")) {
						System.out.print("Node " + node.getID() + " > ");
						in.close();
						out.close();
						client.close();
						break;
					}

					// connect peer
					else if (received.toString().equals("connect")) {
						System.out.println("peer connected");
						addPeer((Integer) in.readObject());
					}

					// send blockchain
					else if (received.toString().equals("requestBlockChain")) {
						System.out.println("send blockchain data");
						out.writeObject(node.getUI().getBlockchainService().getBlockchain());
					}

					// receive transaction
					else if (received.toString().equals("tx")) {
						System.out.println("receive transaction data");
						Transaction tx = (Transaction) in.readObject();
						receiveTransaction(tx);
					}

					// receive block
					else if (received.toString().equals("block")) {
						System.out.println("receive block");
						Block block = (Block) in.readObject();
						receiveBlock(block);
					}

				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
