import java.io.Serializable;
import java.util.Date;

public abstract class Transaction implements Comparable<Transaction>, Cloneable, Serializable {
	protected int txCreatorID;
	protected Date timestamp;
	protected String hash;

	public int getCreatorID() {
		return txCreatorID;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getHash() {
		return hash;
	}

	@Override
	public int compareTo(Transaction tx) {
		return timestamp.compareTo(tx.getTimestamp());
	}

	public abstract void printTransaction();

	@Override
	public abstract Object clone();
}
