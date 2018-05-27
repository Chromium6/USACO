
import java.io.*;
import java.net.*;

public class SendThread {
	private Socket sOb; // object for server connection
	private PrintWriter out; // write to Socket connection
	
	public SendThread(String tName, Socket connection) {
		try {
			sOb = connection;
			out = new PrintWriter(sOb.getOutputStream(), true);
		}
		catch (IOException ioe) {
			System.err.println("Failed to connect client to output: " + ioe.getMessage());
		}
	}
	
	/** Send a message through the Socket connection
	 * 
	 * @param message
	 * */
	public void send(String message) {
		out.println(message);
	}
	
	public void close() {
		try {
			out.close();
			sOb.close();
		} catch (IOException ioe) {
			System.err.println("Failed to close output resources: " + ioe.getMessage());
		}
	}
	
}
