import java.util.Scanner;

public class CommandThread extends Thread {
	private Node node;

	public CommandThread(Node node) {
		this.node = node;
	}

	private void printCommandList() {
		System.out.println("COMMANDS");
		System.out.println(" \"download\": download data");
		System.out.println(" \"tx\"      : create tx");
		System.out.println(" \"mining\"  : create new block");
		System.out.println(" \"show\"    : print blockchain");
		System.out.println(" \"addPeer\" : add peer");
		System.out.println(" \"exit\"    : exit program");
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);

		String str = "";
		while (true) {
			System.out.print("Node " + node.getID() + " > ");
			str = scanner.nextLine();
			if (str.equals("exit")) {
				scanner.close();
				System.exit(0);
			} else if (str.equals("download")) {
				node.download();
			} else if (str.equals("tx")) {
				System.out.print("Enter tx Type (ex.\"Vote\") : ");
				String txType = scanner.nextLine();

				while (!txType.equals("Vote")) {
					System.out.println("invalid tx Type");
					System.out.print("Enter tx Type (ex.\"Vote\") : ");
					txType = scanner.nextLine();
				}

				node.createTransaction(txType);
			} else if (str.equals("mining")) {
				node.mining();
				System.out.println("mined a block!");
			} else if (str.equals("show")) {
				node.show();
			} else if (str.equals("help")) {
				printCommandList();
			} else if (str.equals("addPeer")) {
				System.out.print("Enter peer id : ");
				int peerID = Integer.parseInt(scanner.nextLine());
				node.getUI().getP2PService().addPeer(peerID);
				node.getUI().getP2PService().connectPeer(peerID);
			}

		}

	}
}
