package _08_calculator;

import javax.swing.JOptionPane;

public class Calculator {

	String numm1 = JOptionPane.showInputDialog("Put in a number:");
	int num1 = Integer.parseInt(numm1);

	String numm2 = JOptionPane.showInputDialog("Put in a second number:");
	int num2 = Integer.parseInt(numm2);
	
	int num3;

	public void calculation() {

		Object[] options = { "add", "subtract", "multiply", "divide" };
		int op = JOptionPane.showOptionDialog(null, "Select you operation:", null, JOptionPane.DEFAULT_OPTION,
				JOptionPane.ERROR_MESSAGE, null, options, options[0]);

		if (op == 0) {
			add();
			JOptionPane.showMessageDialog(null, "Your answer is: " + num3);
		}

		else if (op == 1) {
			subtract();
			JOptionPane.showMessageDialog(null, "Your answer is: " + num3);
		}

		else if (op == 2) {
			multiply();
			JOptionPane.showMessageDialog(null, "Your answer is: " + num3);
		}
		
		else {
			divide();
			JOptionPane.showMessageDialog(null, "Your answer is: " + num3);
		}
		
	}

	private void add() {
		num3 = num1 + num2;
	}

	private void subtract() {
		num3 = num1 - num2;
	}

	private void multiply() {
		num3 = num1 * num2;
	}

	private void divide() {
		num3 = num1 / num2;
	}

}
