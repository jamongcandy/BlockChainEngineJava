
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create Node1
		Node n1 = new Node("node1");
		// create blockchain
		n1.createBlockChain("testChain");
		// create transactions
		n1.getBlockChain("testChain").createTransaction("aaaa");
		n1.getBlockChain("testChain").createTransaction("bbbb");
		// create new block
		Block newBlock = n1.getBlockChain("testChain").createBlock();
		// add created block to blockchain
		n1.getBlockChain("testChain").addBlock(newBlock);
		// print blockchain status to console
		n1.getBlockChain("testChain").showBlockChain();

		// create transactions
		n1.getBlockChain("testChain").createTransaction("tx123");
		n1.getBlockChain("testChain").createTransaction("tx567");
		// create new block and add created block to blockchain
		n1.getBlockChain("testChain").addBlock(n1.getBlockChain("testChain").createBlock());
		// print blockchain status to console
		n1.getBlockChain("testChain").showBlockChain();

	}

}
