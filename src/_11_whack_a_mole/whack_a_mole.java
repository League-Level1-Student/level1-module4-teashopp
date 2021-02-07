package _11_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.media.jfxmedia.AudioClip;

public class whack_a_mole implements ActionListener {

	JFrame frame = new JFrame("Whack a Button for Fame and Glory!");
	JPanel panel = new JPanel();
	JButton mole = new JButton();
	JButton buttonpressed;

	int rand;
	int buttonCount = 0;
	int score = 0;
	int wrong = 0;

	public static void main(String[] args) {

		whack_a_mole wam = new whack_a_mole();
		wam.setup();

	}

	public void drawButtons(int rand) {

		for (int i = 0; i < 8; i++) {

			if (i == rand) {
				mole = new JButton("Mole!");
				mole.addActionListener(this);
				panel.add(mole);
			}

			else {
				JButton throwaway = new JButton();
				throwaway.addActionListener(this);
				panel.add(throwaway);
			}

		}

	}

	public void setup() {

		frame.add(panel);

		frame.setSize(500, 700);
		frame.setVisible(true);

		drawButtons(rand = new Random().nextInt(8));

	}

	public void actionPerformed(ActionEvent e) {

		if (mole == e.getSource()) {
			frame.dispose();
			int newscore = score + 1;
			score = newscore;
			System.out.println(score);
			
			if (score == 10) {
				endGame();
			}
			
		}

		else {
			frame.dispose();
			int newwrong = wrong + 1;
			wrong = newwrong;
			speak("Oh man");
			
			if (wrong == 1) {
				System.out.println("Aw man!");
			} 
			else {
				System.out.println("Not again!");
			}

		}

	}

	static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
        
        
        private void endGame(Date timeAtStart, int molesWhacked) { 
            Date timeAtEnd = new Date();
            JOptionPane.showMessageDialog(null, "Your whack rate is "
                    + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
                          + " moles per second.");
        }
        
        
        private void playSound(String fileName) { 
            AudioClip sound = (AudioClip) JApplet.newAudioClip(getClass().getResource(fileName));
            sound.play();
        }
        
    }

}