

import java.io.*;
import java.net.*;

public class RecieveThread{
	private Socket sOb; // object for server connection
	private BufferedReader in; // read from Socket connection
	
	public RecieveThread(String tName, Socket connection) {
		try {
			sOb = connection;
			in = new BufferedReader(new InputStreamReader(sOb.getInputStream()));
		}
		catch (IOException ioe) {
			System.err.println("Failed to initialize client connecting to input: " + ioe.getMessage());
		}
	}
	
	public String recieve() throws IOException {
		return in.readLine();
	}
	
	public void close() {
		try {
			in.close();
			sOb.close();
		} catch (IOException ioe) {
			System.err.println("Failed to close input resources: " + ioe.getMessage());
		}
	}
}
