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

    public int distance(mapLocation startLocation, mapLocation endLocation)
    {
        return -1;
    }

    public int shortestDistanceByCost(mapLocation startLocation, int maxCost)
    {
        return -1;
    }

    public int shortestDistanceByTime(mapLocation startLocation, int maxTime)
    {
        return -1;
    }

    public mapLocation nearestLocationsByCost(mapLocation startLocation, int maxCost)
    {
        return null;
    }

    public mapLocation nearestLocationsByTime(mapLocation startLocation, int maxTime)
    {
        return null;
    }

    public ArrayList<mapLocation> sortByInterest()
    {
        return new ArrayList<>();
    }


}

