import java.util.Scanner;

public class Node {
	private int id;
	private int chainSize;
	private BlockchainUI ui;

	// options
	private Administrator admin;
	private Miner miner;
	private Observer observer;
	private TransactionCreator txCreator;

	// constructor
	public Node(int id, int chainSize) {
		this.id = id;
		this.chainSize = chainSize;
		ui = new BlockchainUI(new BlockchainService(chainSize), new P2PService(this));
	}

	// setter
	public void setTxCreator() {
		txCreator = new TransactionCreator(id, ui);
	}

	public void setAdmin() {
		admin = new Administrator(id, ui);
		admin.createGenesisBlock();
	}

	public void setMiner() {
		miner = new Miner(id, ui);
	}

	public void setObserver() {
		observer = new Observer(id, ui);
	}

	// getter
	public int getID() {
		return id;
	}

	public BlockchainUI getUI() {
		return ui;
	}

	// methods
	public void createTransaction(String txType) {
		if (txCreator == null) {
			System.out.println("error : not transaction creator");
		} else {
			txCreator.createTransaction(txType);
		}
	}

	public void createGenesisBlock() {
		if (admin == null) {
			System.out.println("error : not administrator");
		} else {
			admin.createGenesisBlock();
		}
	}

	public void mining() {
		if (miner == null) {
			System.out.println("error : not miner");
		} else {
			miner.createNewBlock();
		}
	}

	public void show() {
		observer.showBlockchain();
	}

	public void download() {
		System.out.print("Enter node ID to download data from: ");
		Scanner scanner = new Scanner(System.in);
		int peerID = Integer.parseInt(scanner.nextLine());
		ui.downloadBlockchainFrom(peerID, chainSize);
	}

	// main
	public static void main(String[] args) {

		Node node = new Node(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		for (String string : args) {
			if (string.equals("-a")) {
				node.setAdmin();
			} else if (string.equals("-t")) {
				node.setTxCreator();
			} else if (string.equals("-m")) {
				node.setMiner();
			} else if (string.equals("-o")) {
				node.setObserver();
			}
			node.setObserver();
		}

		node.getUI().startP2P();

		CommandThread command = new CommandThread(node);
		command.start();

	}

}
