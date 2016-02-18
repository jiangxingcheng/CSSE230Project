import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * 
 * Create a start frame with buttons have actionListener
 *
 * @author Xingcheng Jiang.
 *         Created Feb 10, 2016.
 */
public class startFrame {
	
	public void startWindow() throws IOException{
		JFrame myFrame = new JFrame("Navigation System");

		myFrame.setResizable(false);
		
		myFrame.setSize(500, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creation of Panel

		JPanel panel = new JPanel();
		panel.setSize(500, 250);
		panel.setBackground(Color.DARK_GRAY);

		JPanel panel1 = new JPanel();
		panel1.setSize(500, 250);
		panel1.setBackground(Color.LIGHT_GRAY);

		panel1.setLayout(null);

		myFrame.add(panel);
		myFrame.add(panel1);
		
		// Implementation of Hash
		
		Reader reader = new Reader();
		locationMapHash hash = reader.main();
		
		// Features added to Panel

		JButton button = new JButton("Start");
		button.setBackground(Color.WHITE);
		Font f = new Font(null, Font.PLAIN, 16);
		button.setFont(f);
		panel1.add(button);
		button.setBounds(360, 260, 90, 35);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Let's start");
			}
		});

		JButton button2 = new JButton("Map");
		button2.setBackground(Color.WHITE);
		button2.setFont(f);
		panel1.add(button2);
		button2.setBounds(360, 310, 90, 35);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Show map");
				MapFrame myMap = new MapFrame();
				myMap.startWindow(hash);
			}
		});

		JButton button3 = new JButton("Reset");
		button3.setFont(f);
		button3.setBackground(Color.WHITE);
		panel1.add(button3);
		button3.setBounds(360, 360, 90, 35);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Let's do Reset");
			}
		});

		JButton button4 = new JButton("Exit");
		button4.setFont(f);
		button4.setBackground(Color.WHITE);
		panel1.add(button4);
		button4.setBounds(360, 410, 90, 35);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.exit(0);
			}
		});

		// Defines startLocation drop-down
		
		JComboBox<String> startLocation = new JComboBox<String>();
		startLocation.setBackground(Color.WHITE);
		startLocation.setForeground(Color.BLUE);
		startLocation.setFont(f);
		
		// Defines endLocation drop-down
		
		JComboBox<String> endLocation = new JComboBox<String>();
		endLocation.setForeground(Color.BLUE);
		endLocation.setFont(f);
		endLocation.setBackground(Color.WHITE);
		
		// Adds list of Locations to drop-down menus
		
		for(String locationName: hash.keySet()){
			mapLocation mL = hash.get(locationName);
			startLocation.addItem(mL.getName());
			endLocation.addItem(mL.getName());
		}
		
		panel.add(startLocation);
		startLocation.setBounds(20, 20, 200, 30);

		panel.add(endLocation);
		endLocation.setBounds(260, 20, 200, 30);

		// Defines cost function options drop-down
		
		JComboBox<String> options = new JComboBox<String>();
		options.setForeground(Color.BLUE);
		options.setBackground(Color.WHITE);
		options.setFont(f);
		options.addItem("Cost By Distance");
		options.addItem("Cost By Time");

		panel1.add(options);
		options.setBounds(20, 260, 200, 30);

		myFrame.setVisible(true);

	}

	
	
	

}
