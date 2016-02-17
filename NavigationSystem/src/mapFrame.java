import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapFrame extends JFrame{
	
	public void startWindow() {
		JFrame mapFrame = new JFrame("Map");
		city cities = new city();
		mapFrame.add(cities);
		mapFrame.setSize(400, 500);
		mapFrame.setBackground(Color.WHITE);
		mapFrame.setVisible(true);
		mapFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mapFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				mapFrame.dispose();
			}
		});
	}
	public class city extends JPanel{
		locationMapHash hash;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		Reader a = new Reader();
		
		try {
			hash = a.main();
		} catch (IOException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		
		g2d.setColor(Color.BLACK);
		for(String locationb: hash.keySet()){
			mapLocation ml = hash.get(locationb);
			Ellipse2D.Double Circle = new Ellipse2D.Double(ml.xCoordinate, ml.yCoordinate, 10, 10);
//			Ellipse2D.Double Circle2 = new Ellipse2D.Double(200,200, 10, 10);
//			g2d.draw(Circle2);
			g2d.draw(Circle);
			System.out.println(ml.name);
			System.out.println(ml.xCoordinate);
			System.out.println(ml.yCoordinate);
			System.out.println(ml.interestRating);
			System.out.println(ml.relations);
			System.out.println(" ");
		}

	
	}

}
}
