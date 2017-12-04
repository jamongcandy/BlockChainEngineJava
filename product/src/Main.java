
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockchainService service = new BlockchainService();
		BlockchainUI bui = new BlockchainUI(service);
		
		Miner m1 = new Miner(bui);
		
		System.out.println(m1);
	}

}
