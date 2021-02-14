package _12_slot_machine;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class slot_machine {

	// frames and stuff
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton spinbutton = new JButton();
	static Random spin = new Random();

	// main
	public static void main(String[] args) {

		slot_machine sm = new slot_machine();
		sm.setup();

	}

	// set up frame
	public void setup() {
		
		frame.setVisible(true);
		frame.setSize(500, 300);

		frame.add(panel);
		panel.add(spinbutton);
		spinbutton.addActionListener((ActionListener) this);

	}

	// clicking button
	void actionPerformed(ActionEvent e) {
		
		spin();
		
	}

	// spin
	public void spin() {

		int newspin = spin.nextInt(3);
		
		if (newspin == 0) {
			
			
		}

	}

	// preset
	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

}
