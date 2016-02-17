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
	locationMapHash hash;
	
	public void startWindow(locationMapHash hash) {
		this.hash = hash;
		JFrame mapFrame = new JFrame("Map");
		city cities = new city();
		mapFrame.add(cities);
		mapFrame.setSize(1000, 1000);
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
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		for(String location: hash.keySet()) {
			mapLocation ml = hash.get(location);
			Ellipse2D.Double Circle = new Ellipse2D.Double(ml.xCoordinate, ml.yCoordinate, 10, 10);
			g2d.draw(Circle);
			for(String relation: ml.relations) {
				g2d.drawLine((int) ml.getX() + 5, (int) ml.getY() + 5, (int) hash.get(relation).getX() + 5, (int) hash.get(relation).getY() + 5);
			}
			g2d.drawString(ml.getName(), (int) ml.getX(), (int) ml.getY());
		}

	
	}

}
}
