import java.util.ArrayList;


public class mapLocation
{

    String name;
    public static int xCoordinate;
    public static int yCoordinate;
    int interestRating; // Takes values 0 to 10, depending on how interesting a certain location is.
    ArrayList<String> relations;

    public mapLocation(String name, int x, int y, int interestRating, ArrayList<String> relations)
    {
        this.name = name;
        this.interestRating = interestRating;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.relations = relations;
    }
	public void addRelation(String location)
    {
        this.relations.add(location);
    }


    public String getName()
    {
        return name;
    }

    public int getX()
    {
        return xCoordinate;
    }

    public int getY()
    {
        return yCoordinate;
    }

    public int getinterestRating()
    {
        return interestRating;
    }

    public ArrayList<String> getRelations()
    {
        return relations;
    }
}
