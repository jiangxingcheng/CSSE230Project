import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	public static void main(String[] args){
		JFrame myFrame = new JFrame("Navigation System");
		myFrame.setSize(400, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		
		JPanel panel = new JPanel();
		myFrame.add(panel);
		JButton button = new JButton("start");
		panel.add(button);
		//button.addActionListener (new Action1());

		JButton button2 = new JButton("map");
		panel.add(button2);
		//button.addActionListener (new Action2()); 
		
	}

}
