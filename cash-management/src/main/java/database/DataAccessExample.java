package database;
import java.sql.*; // Database access

public class DataAccessExample {
	public Connection link;
	
	/** Connect to a database
	 * Creates the database if it doesn't exist
	 * 
	 * @param databaseName
	 * - path to database (absolute filepath if not in project)
	 * 
	 * */
	public static Connection connect(String databaseName) {
		try {
			// format the database reference
			databaseName = "jdbc:sqlite:" + databaseName;
			// forge a SQL link to a database, which it'll make if it's missing
			Connection paperClip = DriverManager.getConnection(databaseName);
			// check if there is data in the database
			if (paperClip != null) {
				// extract data from database connection
				DatabaseMetaData extract = paperClip.getMetaData();
				// debugging
				System.out.println("Connected to " + extract.getDriverName());
			}
			return paperClip;
		}
		catch(SQLException se) {
			System.err.println("Problem connecting to [" + databaseName + "]: " + se.getLocalizedMessage());
		}
		return null;
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
			System.out.println("Table creation success");
		}
		catch(SQLException se) {
			System.err.println("Problem creating table [" + tableName + "]: " + se.getLocalizedMessage());
		}
	}
	
	/** Insert data into the phonebook (example) table
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
	
	/** Delete data from the phonebook (example) table
	 * @param name
	 * - primary search term
	 * */
	public void deletePersonPhonebook(String name) {
		// date deletion command
		// safety: requires exact name to prevent accidental deletion
		String removePerson = "DELETE FROM phonebook WHERE name = ?";
		
		// execute command
		try {
			PreparedStatement exe = link.prepareStatement(removePerson);
			// set variables
			exe.setString(1, name);
			exe.executeUpdate();
		}
		catch(SQLException se) {
			System.err.println("Problem reading data from phonebook: " + se.getLocalizedMessage());
		}
	}
	
	/** Search the phonebook (table) by name
	 * 
	 * @param name
	 * - search term
	 * 
	 * @returns ResultSet of relevant data
	 * */
	public ResultSet searchNamePhonebook(String name) {
		// search command
		// search for numerical input: "... WHERE number > ?"
		String search = "SELECT number, name FROM phonebook WHERE CHARINDEX(?, name) > 0";
		
		// execute command
		try {
			PreparedStatement exe = link.prepareStatement(search);
			// set variables
			exe.setString(1, name);
			ResultSet data = exe.executeQuery();
			return data;
		}
		catch(SQLException se) {
			System.err.println("Problem reading data from phonebook: " + se.getLocalizedMessage());
		}
		return null;
	}
	
	/** Get entire contents of phonebook(example) database
	 * 
	 * @returns ResultSet of data
	 * */
	public ResultSet getallPhonebook() {
		// selection command
		String extractAll = "SELECT number, name FROM phonebook";
		
		// execute command
		try {
			Statement exe = link.createStatement();
			ResultSet data = exe.executeQuery(extractAll);
			return data;
		}
		catch(SQLException se) {
			System.err.println("Problem reading data from phonebook: " + se.getLocalizedMessage());
		}
		return null;
	}
	
	/** Update an existing data entry
	 * @param name
	 * - id to search for
	 * @param number
	 * - new number
	 * */
	public void updatePhonebook(String name, int number) {
		String updateItem = "UPDATE phonebook SET number = ? WHERE name = ?";
		try {
			PreparedStatement exe = link.prepareStatement(updateItem);
			// fill in variables
			exe.setInt(1, number);
			exe.setString(2, name);
			exe.executeUpdate();
		}
		catch(SQLException se) {
			System.err.println("Problem updating data to phonebook: " + se.getLocalizedMessage());
		}
	}
	
	/** Close all resources
	 * */
	public void end() {
		try {
			if (link != null) link.close();
		}
		catch (SQLException se) {
			System.err.println("Error closing database connection: "  + se.getMessage());
		}
	}
}
