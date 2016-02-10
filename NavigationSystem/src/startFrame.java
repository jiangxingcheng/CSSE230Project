import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * Create a start frame with buttons have actionListener
 *
 * @author Xingcheng Jiang.
 *         Created Feb 10, 2016.
 */
public class startFrame {
	
	public void startWindow() {
		JFrame myFrame = new JFrame("Navigation System");
		
		
		myFrame.setSize(400, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		myFrame.add(panel);

		JButton button = new JButton("start");
		panel.setLayout(null);
		panel.add(button);
		button.setBounds(300, 250, 70, 35);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Let's start");
			}
		});

		JButton button2 = new JButton("map");
		panel.add(button2);
		button2.setBounds(300, 300, 70, 35);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Show map");
				JFrame mapFrame = new JFrame("Map");
				mapFrame.setSize(400, 500);
				mapFrame.setVisible(true);
				mapFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		        mapFrame.addWindowListener(new WindowAdapter() {
		       	public void windowClosing(WindowEvent e) {
		       		mapFrame.dispose();
		       	}
				});

			}
		});

		JButton button3 = new JButton("Reset");
		panel.add(button3);
		button3.setBounds(300, 350, 70, 35);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Let's do Reset");
			}
		});

		JButton button4 = new JButton("Exit");
		panel.add(button4);
		button4.setBounds(300, 400, 70, 35);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.exit(0);
			}
		});

		JComboBox startlocation = new JComboBox();
		startlocation.addItem("a");
		startlocation.addItem("b");
		startlocation.addItem("c");
		startlocation.addItem("d");
		panel.add(startlocation);
		startlocation.setBounds(20, 20, 150, 30);

		JComboBox endLocation = new JComboBox();
		endLocation.addItem("a");
		endLocation.addItem("b");
		endLocation.addItem("c");
		endLocation.addItem("d");
		panel.add(endLocation);
		endLocation.setBounds(200, 20, 150, 30);

		JComboBox options = new JComboBox();
		options.addItem("a");
		options.addItem("b");
		options.addItem("c");
		options.addItem("d");
		panel.add(options);
		options.setBounds(20, 250, 150, 30);

		myFrame.setVisible(true);

	}

	
	
	

}
