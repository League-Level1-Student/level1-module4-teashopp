package _04_chuckle_clicker;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chuckle_clicker {
	
	static JButton buttonPressed;

	public static void main(String[] args) {
		
		makeButtons();
		
	}
	
	
	
	static void makeButtons(){
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(500,500);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JButton button1 = new JButton();
		button1.setText("Joke");
		panel.add(button1);
		
		JButton button2 = new JButton();
		button2.setText("Punchline");
		panel.add(button2);
		
		if (buttonPressed == button1) {
			JOptionPane.showMessageDialog(null, "What did the duck say at the end of the meal?");
		}
		
		else if (buttonPressed == button2) {
			JOptionPane.showMessageDialog(null, "Put it on my Bill!");
		}
		
	}
	
}
