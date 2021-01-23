package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.beans.binding.When;

public class TypingTutor implements KeyListener {

	static char CurrentLetter;
	int score = 0;
	int attempts = 15;
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	Date timeAtStart = new Date();

	public static void main(String[] args) {

		TypingTutor tutor = new TypingTutor();
		tutor.setup();

	}

	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	void setup() {

		frame.setVisible(true);

		CurrentLetter = generateRandomLetter();
		label.setText("" + CurrentLetter);
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);

		frame.addKeyListener(this);
		panel.add(label);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		char keypressed = e.getKeyChar();

		if (keypressed == CurrentLetter) {
			score = score + 1;
			panel.setBackground(Color.GREEN);
		}

		else {
			if (score > 0) {
				score = score - 1;
			}
			
			panel.setBackground(Color.RED);
		}

		CurrentLetter = generateRandomLetter();
		label.setText("" + CurrentLetter);
		attempts = attempts - 1;
		
		if(attempts == 0){
			JOptionPane.showMessageDialog(null, "Your score is: " + score);
			System.exit(0);
		    }

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
		Date timeAtEnd = new Date();
		long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
		long gameInSeconds = (gameDuration / 1000) % 60;
		double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
		int charactersPerMinute = (int) (charactersPerSecond * 60);
		JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	}

}