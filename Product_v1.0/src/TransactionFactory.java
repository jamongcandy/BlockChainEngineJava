import java.util.Scanner;

public class TransactionFactory {

	public Transaction createTransaction(int id, String txType) {
		if (txType.equals("Vote")) {
			// create Vote Transaction
			System.out.print("Enter voter name: ");
			Scanner scanner = new Scanner(System.in);
			String voter = scanner.nextLine();
			System.out.print("Enter candidate name: ");
			String candidate = scanner.nextLine();
			Vote v = new Vote(id, voter, candidate);

			return v;
		}

		return null;
	}
}
