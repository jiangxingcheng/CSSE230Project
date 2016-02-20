import java.util.ArrayList;


public class mapLocation
{

    String name;
    double xCoordinate;
    double yCoordinate;
    int interestRating; // Takes values 0 to 10, depending on how interesting a certain location is.
    ArrayList<String> relations;

    public mapLocation(String name, double x, double y, int interestRating, ArrayList<String> relations)
    {
        this.name = name;
        this.interestRating = interestRating;
        xCoordinate = x;
        yCoordinate = y;
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

    public double getX()
    {
        return xCoordinate;
    }

    public double getY()
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

    public double distance(mapLocation end)
    {
        double differenceBetweenX = this.xCoordinate - end.xCoordinate;
        double differenceBetweenY = this.yCoordinate - end.yCoordinate;

        double result = Math.sqrt(Math.pow(differenceBetweenX, 2) + Math.pow(differenceBetweenY, 2));

        return result;
    }
}
