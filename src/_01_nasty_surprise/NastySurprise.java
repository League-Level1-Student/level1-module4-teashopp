package _01_nasty_surprise;

import javax.swing.JOptionPane;

public class NastySurprise {

	public static void main(String[] args) {

		Object[] options = { "Trick", "Treat" };
		JOptionPane.showOptionDialog(null, "Trick or Treat?", "Make a choice!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

		
		
	}
	
}

