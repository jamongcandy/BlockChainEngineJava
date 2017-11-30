import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void menu(Map<String, Node> nodeMap) {
		System.out.println();
		System.out.println("M E N U");
		System.out.println("1. create new node");
		System.out.println("2. select node");
		System.out.println("3. exit");
		System.out.println("Node List=" + nodeMap.keySet());
	}

	public static void createNode(Map<String, Node> nodeMap, Scanner scanner) {
		System.out.println("Enter node name: ");
		String nodeName = scanner.nextLine();
		System.out.println("Download block chain from which node?(Enter \"no\" if you want to start new chain) : ");
		String downloadfrom = scanner.nextLine();
		while (!nodeMap.containsKey(downloadfrom) && !downloadfrom.equals("no")) {
			System.out.println("invalid Node name");
			downloadfrom = scanner.nextLine();
		}
		if (downloadfrom.equals("no")) {
			nodeMap.put(nodeName, new Node(nodeName, null));
		} else if (nodeMap.containsKey(downloadfrom)) {
			nodeMap.put(nodeName, new Node(nodeName, nodeMap.get(downloadfrom)));
			nodeMap.get(nodeName).addPeer(nodeMap.get(downloadfrom));
		}
	}

	public static void selectNode(Node node, Map<String, Node> nodeMap, Scanner scanner) {
		System.out.println("1. add peer Node");
		System.out.println("2. create Transaction");
		System.out.println("3. update block chain");
		System.out.println("4. show block chain");
		System.out.println("5. BACK to MENU");

		String menuInput = "";
		while (!menuInput.equals("1") && !menuInput.equals("2") && !menuInput.equals("3") && !menuInput.equals("4")
				&& !menuInput.equals("5")) {
			menuInput = scanner.nextLine();
		}

		if (menuInput.equals("1")) {
			System.out.println("Enter peer Node's name(Type \"no\" to cancle): ");
			String peerNodeName = scanner.nextLine();
			while (!nodeMap.containsKey(peerNodeName) && !peerNodeName.equals("no")) {
				System.out.println("invalid Node name");
				peerNodeName = scanner.nextLine();
			}

			if (peerNodeName.equals("no")) {
				System.out.println("cancled");
			} else if (nodeMap.containsKey(peerNodeName)) {
				node.addPeer(nodeMap.get(peerNodeName));
				System.out.println(peerNodeName + " added as peer Node");
			}

		} else if (menuInput.equals("2")) {
			System.out.println("Type in Transaction data: ");
			String txData = scanner.nextLine();
			node.createTransaction(txData);
			System.out.println("Transaction created!");
		} else if (menuInput.equals("3")) {
			node.updateBlockChain();
			System.out.println("block chain updated!");
		} else if (menuInput.equals("4")) {
			node.showBlockChain();
		} else if (menuInput.equals("5")) {

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Node> nodeMap = new HashMap<String, Node>();

		Scanner scanner = new Scanner(System.in);
		String menuInput = "0";
		while (!menuInput.equals("3")) {
			// menu show
			menu(nodeMap);
			while (!menuInput.equals("1") && !menuInput.equals("2") && !menuInput.equals("3")) {
				menuInput = scanner.nextLine();
			}

			// create new node
			if (menuInput.equals("1")) {
				createNode(nodeMap, scanner);
				menuInput = "0";
			}

			// select node
			else if (menuInput.equals("2")) {
				System.out.println("type in Node's name(type \"no\" to cancle): ");
				String nodeName = scanner.nextLine();
				while (!nodeMap.containsKey(nodeName) && !nodeName.equals("no")) {
					System.out.println("invalid node name");
					nodeName = scanner.nextLine();
				}
				if (nodeMap.containsKey(nodeName)) {
					selectNode(nodeMap.get(nodeName), nodeMap, scanner);
				}

				menuInput = "0";
			}

			// exit
			else if (menuInput.equals("3")) {
				System.out.println("fin");
			}
		}

		scanner.close();
		
		

		// // create Node1
		// Node n1 = new Node("node1", null);
		//
		// // create transactions
		// n1.createTransaction("aaaaa");
		// n1.createTransaction("bbbbb");
		// // create block and add it to block chain
		// n1.updateBlockChain();
		// // print block chain
		// n1.showBlockChain();
		//
		// // create another nodes and do things
		// Node n2 = new Node("node2", n1);
		// n2.addPeer(n1);
		//
		// n2.createTransaction("ccccc");
		// n2.updateBlockChain();
		// n2.createTransaction("ddddd");
		//
		// Node n3 = new Node("node3", n2);
		// n3.addPeer(n1);
		// n3.addPeer(n2);
		// n3.deletePeer(n2);
		// n3.createTransaction("eeeee");
		// n3.createTransaction("fffff");
		// n3.updateBlockChain();
		//
		// // print all
		// n1.showBlockChain();
		// n2.showBlockChain();
		// n3.showBlockChain();
		//
		// Node n4 = new Node("node4", n3);
		// n4.showBlockChain();

	}

}
