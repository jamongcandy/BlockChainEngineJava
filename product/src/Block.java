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
	private Hash merkleRootHash;
	private TreeSet<Hash> merkleTree;
	//block blockHash
	private Hash blockHash;
	//transactions in block
	private List<Transaction> txs;
	
	public Block() {
		timestamp = null;
		this.miner = null;
		prevHash = null;
		merkleRootHash = null;
		merkleTree = null;
		blockHash = null;
		txs = new ArrayList<Transaction>();
	}

	//set of getter and setter
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
	public Hash getMerkleRootHash() {
		return merkleRootHash;
	}
	public void setMerkleRootHash(Hash merkleRootHash) {
		this.merkleRootHash = merkleRootHash;
	}
	public Hash getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(Hash blockHash) {
		this.blockHash = blockHash;
	}
	
	public List<Transaction> getTxs(){
		return txs;
	}

	public void createTransaction(TxFormat data) {

	}
	
}
