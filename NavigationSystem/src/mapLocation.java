import java.util.ArrayList;


public class mapLocation {
	
	String name;
	int xCoordinate;
	int yCoordinate;
	int rating;
	ArrayList<String> relations;
	
	public mapLocation(String name, int x, int y, int rating, ArrayList<String> relations) {
		this.name = name;
		this.rating = rating;
		xCoordinate = x;
		yCoordinate = y;
		this.rating = rating;
		this.relations = relations;
	}
	
	public void addRelation(String location) {
		this.relations.add(location);
	}
		
	
	public String getName() {
		return name;
	}
	
	public int getX() {
		return xCoordinate;
	}
	
	public int getY() {
		return yCoordinate;
	}
	
	public int getRating() {
		return rating;
	}
	
	public ArrayList<String> getRelations() {
		return relations;
	}
}