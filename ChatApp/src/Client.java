import java.io.*;
import java.net.*;

import javax.swing.SwingUtilities;

public class Client {
	private RecieveThread stdin;
	private SendThread stdout;
	private Socket serverConnect;
	ChatBox gui;
	private String userName;
	
	public Client(String serverIP, int portNum, String username) {
		try {
			System.out.println("Client Started");
			serverConnect = new Socket(serverIP, portNum);
			stdin = new RecieveThread("Incoming Messages Thread", serverConnect);
			stdout = new SendThread("Send Messages Thread", serverConnect);
			System.out.println("Client I/O Setup Success");
			userName = username;
			// start up GUI
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					gui = new ChatBox("Client Chat Window");
				}
			});
		}
		catch (IOException ioe) {
			System.err.println("Failed to initialize client connecting to " + serverIP + ": " + ioe.getMessage());
		}
	}
	
	public void sendText(String message) {
		gui.post(userName + ": " + message);
		stdout.send(message);
	}
	
	public String checkText() {
		try {
			String inMessage = stdin.recieve();
			gui.post(inMessage);
			return inMessage;
		}
		catch (IOException ioe) {
			System.err.println("Failed to check client messages: " + ioe.getMessage());
		}
		return null;
	}
	
	public void close() throws IOException {
		stdin.close();
		stdout.close();
		serverConnect.close();
	}
	
}
