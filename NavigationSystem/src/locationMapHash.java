import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class locationMapHash extends HashMap<String, mapLocation>
{
    int size;

    public locationMapHash()
    {
        this.size = 0;
    }


    public boolean insert(mapLocation location)
    {
        put(location.getName(), location);
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

    public ArrayList<String> sortByInterest()
    {
        ArrayList<String> arrayListByInterest = new ArrayList<>();
        for (int interestScore = 10; interestScore >= 0; interestScore--)
        {
            for (String locationName : keySet())
            {
                if (get(locationName).interestRating == interestScore)
                    arrayListByInterest.add(locationName);
            }
        }
        return arrayListByInterest;
    }


}
