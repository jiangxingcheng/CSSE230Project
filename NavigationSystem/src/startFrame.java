import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		panel.setBackground(Color.BLUE);
		myFrame.add(panel);

		JButton button = new JButton("start");
		button.setBackground(Color.WHITE);
		Font f = new Font(null, Font.ITALIC,16);
		button.setFont(f);
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
		button2.setBackground(Color.WHITE);
		button2.setFont(f);
		panel.add(button2);
		button2.setBounds(300, 300, 70, 35);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Show map");
				MapFrame myMap = new MapFrame();
				myMap.startWindow();
			}
		});

		JButton button3 = new JButton("Reset");
		button3.setFont(f);
		button3.setBackground(Color.WHITE);
		panel.add(button3);
		button3.setBounds(300, 350, 70, 35);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Let's do Reset");
			}
		});

		JButton button4 = new JButton("Exit");
		button4.setFont(f);
		button4.setBackground(Color.WHITE);
		panel.add(button4);
		button4.setBounds(300, 400, 70, 35);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.exit(0);
			}
		});

		JComboBox startlocation = new JComboBox();
		startlocation.setBackground(Color.WHITE);
		startlocation.setForeground(Color.BLUE);
		startlocation.setFont(f);
		startlocation.addItem("Prdoo");
		startlocation.addItem("Rose-Hulmanistan");
		startlocation.addItem("Chiberia");
		startlocation.addItem("Los Devilenes");
		startlocation.addItem("Cashville");
		startlocation.addItem("China Garden");
		startlocation.addItem("Fish Girl Statue");
		startlocation.addItem("Wacdonal's");
		startlocation.addItem("Maj Tahal");
		startlocation.addItem("Red Black Tree Park");
		startlocation.addItem("ARA");
		panel.add(startlocation);
		startlocation.setBounds(20, 20, 150, 30);

		JComboBox endLocation = new JComboBox();
		endLocation.setForeground(Color.BLUE);
		endLocation.setFont(f);
		endLocation.setBackground(Color.WHITE);
		endLocation.addItem("Prdoo");
		endLocation.addItem("Rose-Hulmanistan");
		endLocation.addItem("Chiberia");
		endLocation.addItem("Los Devilenes");
		endLocation.addItem("Cashville");
		endLocation.addItem("China Garden");
		endLocation.addItem("Fish Girl Statue");
		endLocation.addItem("Wacdonal's");
		endLocation.addItem("Maj Tahal");
		endLocation.addItem("Red Black Tree Park");
		endLocation.addItem("ARA");
		panel.add(endLocation);
		endLocation.setBounds(200, 20, 150, 30);

		JComboBox options = new JComboBox();
		options.setForeground(Color.BLUE);
		options.setBackground(Color.WHITE);
		options.setFont(f);
		options.addItem("Cost By Distance");
		options.addItem("Cost By Time");
		panel.add(options);
		options.setBounds(20, 250, 150, 30);

		myFrame.setVisible(true);

	}

	
	
	

}
