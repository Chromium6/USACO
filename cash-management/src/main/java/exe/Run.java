package exe;
import database.*;

public class Run {

	public static void main(String[] args) {
		// establish connection
		DatabaseAccess stdin = new DatabaseAccess();
		stdin.connect("bank.db");
		
		// create the data tables:
		// 1) Current: active loans
		// 2) Resolved: payed loans
		stdin.createTable("current", new String[] {
				"name text NOT NULL"
		});
		stdin.createTable("resolved", new String[] {
				""
		});
	}

}
