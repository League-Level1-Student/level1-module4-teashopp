package _12_slot_machine;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class slot_machine implements ActionListener {

	// frames and stuff
	JFrame frame = new JFrame();
	JPanel buttonpanel = new JPanel();

	JPanel panel = new JPanel();
	
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();

	JButton spinbutton = new JButton("Spin!");
	
	Random spin = new Random();

	
	// main
	public static void main(String[] args) {

		slot_machine sm = new slot_machine();
		sm.setup();

	}
	

	// set up frame
	public void setup() {
		
		panel.setBounds(0, 100, 300, 300);		
		buttonpanel.setBounds(550, 0, 60, 40);

		frame.setVisible(true);
		frame.setSize(1100, 500);
		frame.add(buttonpanel);
		frame.add(panel);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(spinbutton);
		
		spinbutton.addActionListener(this);

	}

	// clicking button
	public void actionPerformed(ActionEvent e) {

		spin();
		frame.pack();

	}

	// spin
	public void spin() {

		// panel 1
		int newspin = spin.nextInt(3);

		if (newspin == 0) {
			label1.setIcon(createLabelImage("cherry.jpg"));
		}
		
		else if (newspin == 1) {
			label1.setIcon(createLabelImage("lime.jpg"));
		}
		
		else {
			label1.setIcon(createLabelImage("orange.jpg"));
		}
		
		
		// panel 2
		int newspin2 = spin.nextInt(3);
		
		if(newspin2 == 0) {
			label2.setIcon(createLabelImage("cherry.jpg"));
		}
		
		else if (newspin2 == 1) {
			label2.setIcon(createLabelImage("lime.jpg"));
		}
		
		else {
			label2.setIcon(createLabelImage("orange.jpg"));
		}
		
		
		// panel 3
		int newspin3 = spin.nextInt(3);
		
		if(newspin3 == 0) {
			label3.setIcon(createLabelImage("cherry.jpg"));
		}
		
		else if (newspin == 1) {
			label3.setIcon(createLabelImage("lime.jpg"));
		}
		
		else {
			label3.setIcon(createLabelImage("orange.jpg"));
		}
		
		
		// you win message
		if(newspin == 0 && newspin2 == 0 && newspin3 == 0 || newspin == 1 && newspin2 == 1 && newspin3 == 1 || newspin == 2 && newspin2 == 2 && newspin == 2) {
			JOptionPane.showMessageDialog(null, "You win!");
		}

	}

	// preset
	private Icon createLabelImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return icon;
	}

}
