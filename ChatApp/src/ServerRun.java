import java.io.IOException;

public class ServerRun {

	public static void main(String[] args) throws IOException {
		Server echoServer = new Server(8867);
		String text;
		
		while ((text = echoServer.scan()) != null) {
			echoServer.respond(text.toUpperCase());
			if (text.equals("Close")) {
				echoServer.close();
				break;
			}
		}
	}

}
