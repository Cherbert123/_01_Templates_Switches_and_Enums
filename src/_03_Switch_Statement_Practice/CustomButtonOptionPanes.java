package _03_Switch_Statement_Practice;

import javax.swing.JOptionPane;

public class CustomButtonOptionPanes {
	public static void main(String[] args) {
		String[] options = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];
		
		//use a switch statement to do something cool for each option
		CustomButtonOptionPanes run = new CustomButtonOptionPanes();
		switch(choice) {
		
		case "Sunday":
			JOptionPane.showMessageDialog(null, "Saturday is better");
			run.main(args);
			break;
		case "Saturday":
			JOptionPane.showMessageDialog(null, "Invaild Choice - All Days Are Saturday");
			run.Saturday(args);
			break;
		case "Friday":
			JOptionPane.showMessageDialog(null, "Choose Sunday");
			run.main(args);
			break;
		case "Tuesday":
			JOptionPane.showMessageDialog(null, "Tacos!");
			run.Taco(args);
			break;
		case "Monday":
			JOptionPane.showMessageDialog(null, "Why?");
			run.main(args);
			break;
		case "Wednesday":
			JOptionPane.showMessageDialog(null, "Tacos! Again! Cause.. reasons... not a lack of creativity");
			run.Taco(args);
			break;
		case "Thursday":
			JOptionPane.showMessageDialog(null, "Its A Half Day.");
			run.main(args);
			break;
		}
	}
	public static void Saturday(String[] args) {
		String[] options = { "Saturday", "Saturday", "Saturday", "Saturday", "Saturday", "Saturday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];
		
		//use a switch statement to do something cool for each option
		switch(choice) {
		case "Saturday":
			JOptionPane.showMessageDialog(null, "Correct");
			CustomButtonOptionPanes run = new CustomButtonOptionPanes();
			run.main(args);
			break;
		}
	}
	public static void Taco(String[] args) {
		String[] options = { "Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco","Taco" };

		int input = JOptionPane.showOptionDialog(null, "Choose a Food of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];
		
		//use a switch statement to do something cool for each option
		switch(choice) {
		case "Taco":
			JOptionPane.showMessageDialog(null, "Tasty..?");
			CustomButtonOptionPanes run = new CustomButtonOptionPanes();
			run.main(args);
			break;
		}
	}
}
