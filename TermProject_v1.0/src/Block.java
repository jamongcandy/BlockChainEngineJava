import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class Block {
	//block info
	private int blockNumber;
	private Date timestamp;
	private Miner miner;
	private Hash prevHash;
	private Hash merkleRoot;
	private TreeSet<Hash> merkleTree;
	//block hash
	private Hash hash;
	//transactions in block
	private List<Transaction> txs;
	
	public Block() {
		timestamp = null;
		this.miner = null;
		prevHash = null;
		merkleRoot = null;
		merkleTree = null;
		hash = null;
		txs = new ArrayList<Transaction>();
	}
	
	public int getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Miner getMiner() {
		return miner;
	}
	public void setMiner(Miner miner) {
		this.miner = miner;
	}
	public Hash getPrevHash() {
		return prevHash;
	}
	public void setPrevHash(Hash prevHash) {
		this.prevHash = prevHash;
	}
	public TreeSet<Hash> getMerkleTree(){
		return merkleTree;
	}
	public Hash getMerkleRoot() {
		return merkleRoot;
	}
	public void setMerkleRoot(Hash merkleRoot) {
		this.merkleRoot = merkleRoot;
	}
	public Hash getHash() {
		return hash;
	}
	public void setHash(Hash hash) {
		this.hash = hash;
	}
	
	public List<Transaction> getTxs(){
		return txs;
	}
	
}
