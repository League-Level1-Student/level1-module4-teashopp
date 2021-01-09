package _01_nasty_surprise;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class NastySurprise {

	public static void main(String[] args) {

		Object[] options = { "Trick", "Treat" };
		int choice = JOptionPane.showOptionDialog(null, "Trick or Treat?", "Make a choice!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

		if (choice == 0) {
			showPictureFromTheInternet("boojava.png");
		}
		
		else if (choice == 1) {
			showPictureFromTheInternet("cutedogjavva.jpg");
		}

	}
	

	private static void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame = new JFrame();
	        frame.add(imageLabel);
	        frame.setVisible(true);
	        frame.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}

}
