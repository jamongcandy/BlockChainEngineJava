
public class Vote {
	String candidate;
	String voter;
	
	public Vote(String candidate, String voter) {
		this.candidate = candidate;
		this.voter = voter;
	}
	
	@Override
	public String toString() {
		return "'" + voter + "'" + " voted " + "'" + candidate + "'";
	}
	
}
