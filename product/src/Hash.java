import java.security.MessageDigest;

public class Hash {
	private String hash;

	public Hash() {
		hash = null;
	}
	
	public Hash(String base) {
		hash = SHA256(base);
	}
	
	public Hash(Transaction tx) {
		hash = SHA256(tx.getData().toString().concat(tx.getData().toString()));
	}
	public Hash(Block block) {
		hash = SHA256(Integer.toString(block.getBlockNumber()).
				concat(block.getTimestamp().toString()).
				concat(block.getPrevHash().getHash()).
				concat(block.getMerkleRootHash().getHash())
				);
	}
	
	public String getHash() {
		return hash;
	}

	private String SHA256(String base) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
