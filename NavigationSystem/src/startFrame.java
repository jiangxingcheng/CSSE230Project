import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

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
		myFrame.getContentPane().setLayout(new BoxLayout(myFrame.getContentPane(),
				BoxLayout.Y_AXIS));
		myFrame.setResizable(false);
		myFrame.pack();

		myFrame.setSize(500, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		
		// Creation of Panel

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(500, 100));
		panel.setMaximumSize(new Dimension(500, 100));
		panel.setMaximumSize(new Dimension(500, 100));
		panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new CompoundBorder(new BevelBorder(BevelBorder.LOWERED), new EmptyBorder(2, 2, 2, 2))));
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new GridLayout(2, 2));


		JPanel panel1 = new JPanel();
		panel1.setMaximumSize(new Dimension(500, 330));
		panel1.setMaximumSize(new Dimension(500, 330));
		panel1.setMaximumSize(new Dimension(500, 330));
		panel1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new CompoundBorder(new BevelBorder(BevelBorder.LOWERED), new TitledBorder("Trip Planner"))));
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setLayout(new GridLayout(4, 4));

		JPanel panel2 = new JPanel();
		panel2.setMaximumSize(new Dimension(500, 90));
		panel2.setMaximumSize(new Dimension(500, 90));
		panel2.setMaximumSize(new Dimension(500, 90));
		panel2.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new CompoundBorder(new BevelBorder(BevelBorder.LOWERED), new TitledBorder("Options"))));
		panel2.setBackground(Color.DARK_GRAY);
		panel2.setLayout(new FlowLayout());

		
		// Implementation of Hash
		
		Reader reader = new Reader();
		locationMapHash hash = reader.main();
		System.out.println(hash);
		
		// Features added to Panel

		JButton button = new JButton("Start");
		button.setBackground(Color.WHITE);
		Font f = new Font(null, Font.PLAIN, 16);
		button.setFont(f);
		panel2.add(button);
		//button.setBounds(360, 260, 90, 35);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Let's start");
			}
		});

		JButton button1 = new JButton("Sort by Interest");
		button1.setFont(f);
		button1.setBackground(Color.WHITE);
		panel2.add(button1);
		//button4.setBounds(360, 410, 90, 35);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println(hash.sortByInterest());
				RatingFrame rateFrame = new RatingFrame(hash);
				// System.exit(0);
			}
		});

		JButton button2 = new JButton("Map");
		button2.setBackground(Color.WHITE);
		button2.setFont(f);
		panel2.add(button2);
		//button2.setBounds(360, 310, 90, 35);
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
		panel2.add(button3);
		//button3.setBounds(360, 360, 90, 35);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("Let's do Reset");
			}
		});

		JButton button4 = new JButton("Exit");
		button4.setFont(f);
		button4.setBackground(Color.WHITE);
		panel2.add(button4);
		//button4.setBounds(360, 410, 90, 35);
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

		JLabel startText = new JLabel("Start Location", SwingConstants.CENTER);
		startText.setBackground(null);
		startText.setBorder(BorderFactory.createCompoundBorder(new BevelBorder(BevelBorder.RAISED), new BevelBorder(BevelBorder.LOWERED)));
		startText.setForeground(Color.WHITE);

		JLabel endText = new JLabel("Final Destination", SwingConstants.CENTER);
		endText.setBackground(null);
		endText.setBorder(BorderFactory.createCompoundBorder(new BevelBorder(BevelBorder.RAISED), new BevelBorder(BevelBorder.LOWERED)));
		endText.setForeground(Color.WHITE);


		panel.add(startText);

		panel.add(startLocation);

		panel.add(endText);

		panel.add(endLocation);

		// Defines cost function options drop-down
		
		JComboBox<String> options = new JComboBox<String>();
		options.setForeground(Color.BLUE);
		options.setBackground(Color.WHITE);
		options.setFont(f);
		options.addItem("Cost By Distance");
		options.addItem("Cost By Time");


		panel1.add(options);

		myFrame.add(panel);
		myFrame.add(panel1);
		myFrame.add(panel2);

		myFrame.setVisible(true);

	}

	
	
	

}
