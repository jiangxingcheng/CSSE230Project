import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;


public class locationMapHash extends HashMap<String, mapLocation>
{
    int size;
    HashMap<Double, ArrayList<String>> paths;

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

    public double startingDistance(mapLocation startLocation, mapLocation endLocation)
    {
        paths = new HashMap<>();
        for (String relation: startLocation.getRelations())
        {
            double distanceTraveled = 0;
            ArrayList<String> locationsTraveled = new ArrayList<>();
            locationsTraveled.add(startLocation.getName());
            distanceTraveled += startLocation.distance(this.get(relation));
            if (this.get(relation) == endLocation)
            {
                paths.put(distanceTraveled, locationsTraveled);
            }
            else
            {
                distance(relation, locationsTraveled, distanceTraveled, endLocation);
            }
        }
        double min = 0;
        if (paths.size() != 0)
        {
            for (double distance : paths.keySet())
            {
                if (min == 0)
                {
                    min = distance;
                }
                if (distance < min)
                {
                    min = distance;
                }
            }
        }
        return min;
    }

    public void distance(String currentLocation, ArrayList<String> locationsTraveled, double distanceTraveled, mapLocation endLocation)
    {
        locationsTraveled.add(currentLocation);
        mapLocation currMapLocation = this.get(currentLocation);
        for (String relation: currMapLocation.getRelations())
        {
            if (!locationsTraveled.contains(relation))
            {
                double newDistanceTraveled = distanceTraveled;
                ArrayList<String> newLocationsTraveled;
                newLocationsTraveled = locationsTraveled;
                newDistanceTraveled += currMapLocation.distance(this.get(relation));
                if (this.get(relation) == endLocation)
                {
                    paths.put(newDistanceTraveled, newLocationsTraveled);
                }
                else
                {
                    distance(relation, newLocationsTraveled, newDistanceTraveled, endLocation);
                }
            }
        }
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
