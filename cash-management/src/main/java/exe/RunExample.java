package exe;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.*;

public class RunExample {

	public static void main(String[] args) {
		DataAccessExample k = new DataAccessExample();
		k.link = DataAccessExample.connect("exampleDatabase.db");
		k.createTable("phonebook", new String[] {
				"number int NOT NULL",
				"name text PRIMARY KEY",
		});
		//k.putPhonebook(101, "Michael Zhang");
		//k.putPhonebook(789, "Lauren Zhang");
		//k.putPhonebook(456, "John Zhang");
		//k.putPhonebook(123, "Ting Shen");
		//k.deletePersonPhonebook("Michael Zhang");
		k.updatePhonebook("Michael Zhang", 96);
		ResultSet info = k.searchNamePhonebook("Zhang");
		// print results from query
		try {
			while (info.next()) {
				System.out.println(info.getString("name") + ": \t" + info.getInt("number"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		k.end();
	}

}
