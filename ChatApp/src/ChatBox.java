import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.*;

import javax.swing.*; // GUI frameworks

public class ChatBox {
	private JFrame f;
	private JTextField userIn;
	private JTextArea chatDisplay;
	
	public ChatBox(String name) {
		// frame setup
		f = new JFrame(name);
		f.setSize(550, 700);
		f.setLayout(new FlowLayout());
		f.addWindowListener( new WindowAdapter() { // confirmation dialogue
		    public void windowClosing(WindowEvent e) {
		        JFrame frame = (JFrame)e.getSource();
		 
		        int result = JOptionPane.showConfirmDialog(
		            frame,
		            "Are you sure you want to exit the application?",
		            "Exit Application",
		            JOptionPane.YES_NO_OPTION);
		 
		        if (result == JOptionPane.YES_OPTION)
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        else if (result == JOptionPane.NO_OPTION)
		        	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		    }
		});
		
		// component settings
		userIn = new JTextField(45);
		userIn.setActionCommand("User Input");
		userIn.addActionListener((ae ->{
			String message = userIn.getText();
			chatDisplay.append("Michael: " + message + "\n");
			userIn.setText("");
		}));  
		
		chatDisplay = new JTextArea(40, 45);
		chatDisplay.setEditable(false);
		
		// add components
		f.add(chatDisplay);
		f.add(userIn);
		f.setVisible(true);
	}
	
	public void post(String text) {
		chatDisplay.append(text + "\n");
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ChatBox("Gui Test");
			}
		});
	}
}
