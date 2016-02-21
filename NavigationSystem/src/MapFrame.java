import static java.awt.Color.BLACK;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapFrame extends JFrame{
	public List<String> lightedCities;
	public String startcity;
	public String endcity;
	public locationMapHash hash; 
	public void startWindow(locationMapHash hash) {
		this.hash = hash;
		JFrame mapFrame = new JFrame("Map");
		mapFrame.setResizable(false);
		city cities = new city();
		mapFrame.add(cities);
		mapFrame.setSize(1000, 1000);
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
		try
		{
			BufferedImage image = ImageIO.read(new File("src\\bg.png"));
			g.drawImage(image, 0, 0, this);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(BLACK);
		for(String location: hash.keySet()) {
			mapLocation ml = hash.get(location);
			Ellipse2D.Double Circle = new Ellipse2D.Double(ml.xCoordinate, ml.yCoordinate, 15, 15);
			g2d.setPaint(new Color(3, 210, 0));
			g2d.fill(Circle);
			
			g2d.setPaint(new Color(0));
			g2d.draw(Circle);
			
			g2d.setFont(new Font("Times New Roman", Font.BOLD, 12));
			for(String relation: ml.relations) {
				g2d.drawLine((int) ml.getX() + 5, (int) ml.getY() + 5, (int) hash.get(relation).getX() + 5, (int) hash.get(relation).getY() + 5);
			}
			g2d.drawString(ml.getName(), (int) ml.getX(), (int) ml.getY());
		}
		
		System.out.println(startcity+" "+ endcity+" " + hash);
		
		lightedCities =hash.startingDistance(hash.get(startcity),hash.get(endcity)).subList(1,hash.startingDistance(hash.get(startcity),hash.get(endcity)).size());
		for(String redcities: lightedCities){
			double x = hash.get(redcities).getX();
			double y = hash.get(redcities).getY();
			Ellipse2D.Double Circle2 = new Ellipse2D.Double(x, y, 15, 15);
			for(String relation: lightedCities) {
				g2d.setColor(Color.RED);
				g2d.drawLine((int) x + 5, (int) y + 5, (int) hash.get(relation).getX() + 5, (int) hash.get(relation).getY() + 5);
			}
			g2d.setColor(Color.RED);
			g2d.draw(Circle2);
			g2d.fill(Circle2);
			
		}
		

	
	}

}
}
