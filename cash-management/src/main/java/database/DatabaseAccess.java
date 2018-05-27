package database;

import java.sql.*; // database access tools

public class DatabaseAccess {
	private Connection link; // bridge to database (one at a time)
	
	/** Connect to a database
	 * Creates the database if it doesn't exist
	 * 
	 * @param databaseName
	 * - path to database (absolute filepath if not in project)
	 * 
	 * */
	public void connect(String databaseName) {
		try {
			// format the database reference
			databaseName = "jdbc:sqlite:" + databaseName;
			// forge a SQL link to a database, which it'll make if it's missing
			link = DriverManager.getConnection(databaseName);
			// check if there is data in the database
			if (link != null) {
				// extract data from database connection
				DatabaseMetaData extract = link.getMetaData();
				// debugging
				System.out.println("Connected to " + databaseName + " with " +  extract.getDriverName());
			}
		}
		catch(SQLException se) {
			System.err.println("Problem connecting to [" + databaseName + "]: " + se.getLocalizedMessage());
		}
	}
	
	/** Add a table (data section) to this database
	 * 
	 * @param tableName
	 * - Name of the new table being added
	 * @param setup[column]
	 * - formatted parameters for columns (name, type, [setting]) 
	 * */
	public void createTable(String tableName, String setup[]) {
		// create the executable SQL statement
		String makeTable = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
		for (int i = 0; i < setup.length; i ++)
			makeTable += setup[i] + (i < setup.length-1 ? ", " : ""); 
		makeTable += ");";
		
		// execute our SQL command
		try {
			Statement exe = link.createStatement();
			exe.execute(makeTable);
			// debug
			System.out.println("Table creation success for " + tableName);
		}
		catch(SQLException se) {
			System.err.println("Problem creating table [" + tableName + "]: " + se.getLocalizedMessage());
		}
	}
	
	/** Create another loan
	 * @param number
	 * - main contact number
	 * @param name
	 * - owner of the phone number
	 * */
	public void putPhonebook(int number, String name) {
		// create general statement for SQL data insertion
		String insert = "INSERT INTO phonebook(number,name) VALUES(?,?)";
		
		// execute our SQL command
		try {
			PreparedStatement exe = link.prepareStatement(insert);
			// fill in parameters in order (1-indexed numbering)
			exe.setInt(1, number);
			exe.setString(2, name);
			exe.executeUpdate();
		}
		catch(SQLException se) {
			System.err.println("Problem adding content to phonebook: " + se.getLocalizedMessage());
		}
	}
}
