import java.util.ArrayList;
import java.util.HashMap;


public class mapTree extends HashMap
{
    int size;

    public mapTree()
    {
        this.size = 0;
    }


    public boolean insert(mapLocation location)
    {
        this.put(location.getName(), location);

        this.size++;

        return true;
    }

    public int shortestDistanceByCost(int maxCost)
    {
        return -1;
    }

    public int shortestDistanceByTime(int maxTime)
    {
        return -1;
    }

    public mapLocation searchByCost(int maxCost)
    {

    }

    public mapLocation searchByTime(int maxTime)
    {

    }

    public ArrayList<mapLocation> sortByInterest()
    {
        return new ArrayList<>();
    }


}

