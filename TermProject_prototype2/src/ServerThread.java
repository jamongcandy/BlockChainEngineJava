import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
	Node node;

	public ServerThread(Node node) {
		this.node = node;
	}

	public void run() {
		try {
			ServerSocket server = new ServerSocket(node.getNodeID());
			
			while (true) {
				// System.out.println("waiting....");
				Socket client = server.accept();

				ObjectInputStream in = new ObjectInputStream(client.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

				Object received = null;
				while (true) {
					System.out.println();
					received = in.readObject();

					// connection finished
					if (received.toString().equals("done")) {
						System.out.print("Node " + node.getNodeID() + " > ");
						in.close();
						out.close();
						client.close();
						break;
					}

					// connect peer
					else if (received.toString().equals("connect")) {
						System.out.println("peer connected");
						node.addPeer((Integer) in.readObject());
					}

					// send blockchain
					else if (received.toString().equals("requestBlockChain")) {
						System.out.println("send blockchain data");
						out.writeObject(node.getBlockChain());
					}

					// receive transaction
					else if (received.toString().equals("tx")) {
						System.out.println("receive transaction data");
						Transaction tx = (Transaction) in.readObject();
						node.receiveTransaction(tx);
					}

					// receive block
					else if (received.toString().equals("block")) {
						System.out.println("receive block");
						Block block = (Block) in.readObject();
						node.receiveBlock(block);
					}

				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
