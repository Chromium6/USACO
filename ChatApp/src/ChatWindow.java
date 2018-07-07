import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChatWindow implements ActionListener{
	JFrame f;
	JLabel debug;
	JTextField usrIn;

	public ChatWindow(String name) {
		// setup the frame
		f = new JFrame(name);
		f.setLayout(new FlowLayout());
		f.setSize(500, 750);
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
		debug = new JLabel("JLabel is working!");
		
		usrIn = new JTextField(25); // input number of columns wide
		usrIn.setActionCommand("user"); // code passed to action listener
		
		JButton testButton = new JButton("Press");
		
		// instigate action listeners
		testButton.addActionListener(this); // listen for button press
		// use a lambda expression for event listener
		usrIn.addActionListener((a) -> debug.setText("Enter was pressed when entering: " + usrIn.getText()));
		
		f.add(debug);
		f.add(testButton);
		f.add(usrIn);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if button pressed
		if (e.getActionCommand().equals("Press")) {
			String originalText = usrIn.getText();
			debug.setText(originalText.toLowerCase());
		}
		// if enter was pressed while in text box
		//else if (e.getActionCommand().equals("user")){
		//}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ChatWindow("Button Test");
			}
			
		});
	}

}
