import java.io.Serializable;
import java.util.Date;

public class Vote extends Transaction implements Cloneable, Serializable {
	private String voter;
	private String candidate;

	public Vote(int txCreatorID, String voter, String candidate) {
		this.txCreatorID = txCreatorID;
		this.timestamp = new Date();
		this.voter = voter;
		this.candidate = candidate;
		this.hash = HashUtil.SHA256(Integer.toString(this.txCreatorID) + timestamp.toString() + voter + candidate);
	}

	public Vote(Vote v) {
		txCreatorID = v.getCreatorID();
		timestamp = (Date) v.timestamp.clone();
		voter = new String(v.getVoter());
		candidate = new String(v.getCandidate());
		hash = new String(v.getHash());
	}

	public String getVoter() {
		return voter;
	}

	public String getCandidate() {
		return candidate;
	}

	@Override
	public String toString() {
		return voter + " voted for " + candidate;
	}

	@Override
	public void printTransaction() {
		System.out.println("tx");
		System.out.println("  creator id: " + txCreatorID);
		System.out.println("  timestamp : " + timestamp);
		System.out.println("  voter     : " + voter);
		System.out.println("  candidate : " + candidate);
		System.out.println("  hash      : " + hash);
	}

	@Override
	public Object clone() {
		return new Vote(this);
	}

}
