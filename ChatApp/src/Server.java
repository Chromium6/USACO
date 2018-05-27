import java.io.*;
import java.net.*;

public class Server {
	private ServerSocket serverOb; // allows for client connections
	private Socket clientOb; // used to connect to clients 
	private RecieveThread stdin; // Socket I/O
	private SendThread stdout;
	
	public Server(int portNumber) {
		try {
			System.out.println("Server has started");
			serverOb = new ServerSocket(portNumber); // initialize connection to specified ports
			clientOb = serverOb.accept(); // accept new connections
			System.out.println("Recieved a new connection");
			stdin = new RecieveThread("Server Inputs", clientOb);
			System.out.println("Successfully established server input");
			stdout = new SendThread("Server Output", clientOb);
			System.out.println("Successfully established server output");
		}
		catch (IOException ioe) {
			System.err.println("Failed to setup server: " + ioe.getMessage());
		}
	}
	
	public String scan() {
		try {
			String in = stdin.recieve();
			System.out.println(clientOb.getLocalAddress() + ": " + in);
			return in;
		} catch (IOException e) {
			System.err.println("Problem getting input from server side: " + e.getMessage());
		}
		return null;
	}
	
	public void respond(String reponse) {
		stdout.send(reponse);
	}
	
	public void close() throws IOException {
		stdin.close();
		stdout.close();
		clientOb.close();
		serverOb.close();
	}
}
