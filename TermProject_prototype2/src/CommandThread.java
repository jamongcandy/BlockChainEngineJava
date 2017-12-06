import java.util.Scanner;

public class CommandThread extends Thread {
	private Node node;

	public CommandThread(Node node) {
		this.node = node;
	}

	private void printCommandList() {
		System.out.println("COMMANDS");
		System.out.println(" \"tx\"     : create tx");
		System.out.println(" \"update\" : update blockchain");
		System.out.println(" \"show\"   : print blockchain");
		System.out.println(" \"addPeer\": add peer");
		System.out.println(" \"exit\"   : exit program");
	}

	public void run() {

		Scanner scanner = new Scanner(System.in);

		String str = "";
		while (true) {
			System.out.print("Node " + node.getNodeID() + " > ");
			str = scanner.nextLine();
			if (str.equals("exit")) {
				scanner.close();
				System.exit(0);
			} else if (str.equals("tx")) {
				System.out.print("Enter data : ");
				String data = scanner.nextLine();
				node.createTransaction(data);
			} else if (str.equals("update")) {
				node.updateBlockChain();
			} else if (str.equals("show")) {
				node.showBlockChain();
			} else if (str.equals("help")) {
				printCommandList();
			} else if (str.equals("addPeer")) {
				System.out.print("Enter peer id : ");
				int peerID = Integer.parseInt(scanner.nextLine());
				node.addPeer(peerID);
				node.connectPeer(peerID);
			}

		}

	}
}
