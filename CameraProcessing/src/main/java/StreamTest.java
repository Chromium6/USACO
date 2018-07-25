import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class StreamTest {
    private JPanel panel1;
    private JButton takePictureButton;
    private JLabel pictureShowLabel;
    private Webcam cam;

    public StreamTest() {
        takePictureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Le Button Presso! Presto!");
                Image take = (Image) (cam.getImage());
                try {
                    ImageIO.write((BufferedImage)take, "JPG", new File("new.JPG"));
                }
                catch (IOException ioe) {}
                pictureShowLabel.setIcon(new ImageIcon(take));
            }
        });

        // setup the webcam
        cam = Webcam.getDefault();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("StreamTest");
        f.setContentPane(new StreamTest().panel1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private void createUIComponents() {
        pictureShowLabel = new JLabel("Place Stuff Here");
    }
}
