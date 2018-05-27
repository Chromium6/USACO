import java.io.IOException;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class ClientRun {

	public static void main(String[] args) throws IOException {
		// PAUSD IP: 10.245.29.110
		// Home IP: 192.168.1.66
		Client usr = new Client("192.168.1.66", 8867, "Michael");
		Scanner usrIn = new Scanner(System.in);
		String toSend;
		
		while ((toSend = usrIn.nextLine()) != null) {
			usr.sendText(toSend);
			System.out.println(usr.checkText());
			// exit condition
			if (toSend.equals("Close")) {
				usrIn.close();
				usr.close();
				break;
			}
		}
	}

}
