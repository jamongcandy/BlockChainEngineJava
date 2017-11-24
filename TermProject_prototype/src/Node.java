import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
	private String nodeName;
	private Map<String, BlockChain> blockChainMap;
	private List<Node> peers;

	public Node(String nodeName) {
		this.nodeName = nodeName;
		blockChainMap = new HashMap<String, BlockChain>();
		peers = new ArrayList<Node>();
	}

	public String getNodeName() {
		return nodeName;
	}

	public BlockChain getBlockChain(String blockChainName) {
		return blockChainMap.get(blockChainName);
	}

	public void createBlockChain(String blockChainName) {
		if (blockChainMap.containsKey(blockChainName)) {
			System.out.println("already used name");
		} else {
			blockChainMap.put(blockChainName, new BlockChain(blockChainName));
		}
	}

}
