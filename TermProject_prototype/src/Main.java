
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create Node1
		Node n1 = new Node("node1", null);

		// create transactions
		n1.createTransaction("aaaaa");
		n1.createTransaction("bbbbb");
		// create block and add it to block chain
		n1.updateBlockChain();
		// print block chain
		n1.showBlockChain();

		// create another nodes and do things
		Node n2 = new Node("node2", n1);
		n2.addPeer(n1);

		n2.createTransaction("ccccc");
		n2.updateBlockChain();
		n2.createTransaction("ddddd");

		Node n3 = new Node("node3", n2);
		n3.addPeer(n1);
		n3.addPeer(n2);
		n3.deletePeer(n2);
		n3.createTransaction("eeeee");
		n3.createTransaction("fffff");
		n3.updateBlockChain();

		// print all
		n1.showBlockChain();
		n2.showBlockChain();
		n3.showBlockChain();

		Node n4 = new Node("node4", n3);
		n4.showBlockChain();

	}

}
