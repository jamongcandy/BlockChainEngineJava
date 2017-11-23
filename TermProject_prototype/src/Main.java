
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create blockchain
		BlockChain bc = new BlockChain();

		// create transactions
		bc.createTransaction("aaaa");
		bc.createTransaction("bbbb");

		// create new block
		Block newBlock = bc.createBlock();

		// add created block to blockchain
		bc.addBlock(newBlock);

		// print block chain status to console
		bc.showBlockChain();

		// let's create another block!

		// create transaction
		bc.createTransaction("daehyun");
		bc.createTransaction("beomkyung");
		bc.createTransaction("jeonghwan");
		
		// create new block
		newBlock = bc.createBlock();
		// add created block to blockchain
		bc.addBlock(newBlock);
		// print block chain status to console
		bc.showBlockChain();

		
	}

}
