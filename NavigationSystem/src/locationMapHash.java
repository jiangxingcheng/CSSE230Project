import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;


public class locationMapHash extends HashMap<String, mapLocation>
{
    int size;
    Double LOW_SPEED = 25.0;
    Double MEDIUM_SPEED = 50.0;
    Double HIGH_SPEED = 100.0;
    
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
    
    

    public ArrayList<Object> startingDistance(mapLocation startLocation, mapLocation endLocation)
    {
        paths = new HashMap<>();
        ArrayList<Object> result = new ArrayList<>();
        
        int nodesTraveled = 0;
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
                distance(relation, locationsTraveled, distanceTraveled, endLocation, nodesTraveled);
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
//                  System.out.println(min);
                }
            }
        }
        result.add(min);
        result.add(paths.get(min));
        return result;
    }

    public void distance(String currentLocation, ArrayList<String> locationsTraveled, double distanceTraveled, mapLocation endLocation, int nodesTraveled)
    {
        locationsTraveled.add(currentLocation);
        mapLocation currMapLocation = this.get(currentLocation);
        nodesTraveled++;
        
        for (String relation: currMapLocation.getRelations())
        {
            if (!locationsTraveled.contains(relation))
            {
                double newDistanceTraveled = distanceTraveled;

                ArrayList<String> newLocationsTraveled = new ArrayList<String>();
                for(String location: locationsTraveled) {
                	newLocationsTraveled.add(location);
                }
                
                newDistanceTraveled += currMapLocation.distance(this.get(relation));
                if (this.get(relation) == endLocation)
                {
                	nodesTraveled++;
                	newLocationsTraveled.add(relation);
//                	System.out.println(nodesTraveled);
//                	System.out.println(this.get(relation).getName());
                    paths.put(newDistanceTraveled, newLocationsTraveled);
//                  System.out.println(locationsTraveled);
//                  System.out.println(newDistanceTraveled);
                    return;
                }
                else
                {
                    distance(relation, newLocationsTraveled, newDistanceTraveled, endLocation, nodesTraveled);
                }
            }
        }
    }

    public ArrayList<Object> startingTime(mapLocation startLocation, mapLocation endLocation)
    {
        paths = new HashMap<>();
        ArrayList<Object> result = new ArrayList<>();
        
        int nodesTraveled = 0;
        for (String relation: startLocation.getRelations())
        {
            double timeTraveled = 0;
            double distanceTraveled = 0;
            ArrayList<String> locationsTraveled = new ArrayList<>();
            locationsTraveled.add(startLocation.getName());
            timeTraveled += startLocation.distance(this.get(relation));
            if (this.get(relation) == endLocation)
            {
                paths.put(timeTraveled, locationsTraveled);
            }
            else
            {
                time(relation, locationsTraveled, distanceTraveled, timeTraveled, endLocation, nodesTraveled);
            }
        }
        double min = 0;
        if (paths.size() != 0)
        {
            for (double time : paths.keySet())
            {
                if (min == 0)
                {
                    min = time;
                }
                if (time < min)
                {
                    min = time;
//                  System.out.println(min);
                }
            }
        }
        result.add(min);
        result.add(paths.get(min));
        return result;
    }

    public void time(String currentLocation, ArrayList<String> locationsTraveled, double distanceTraveled , double timeTraveled, mapLocation endLocation, int nodesTraveled)
    {
    	locationsTraveled.add(currentLocation);
        mapLocation currMapLocation = this.get(currentLocation);
        nodesTraveled++;
        
        for (String relation: currMapLocation.getRelations())
        {
            if (!locationsTraveled.contains(relation))
            {
                double newTimeTraveled = timeTraveled;
                double newDistanceTraveled = distanceTraveled;

                ArrayList<String> newLocationsTraveled = new ArrayList<String>();
                for(String location: locationsTraveled) {
                	newLocationsTraveled.add(location);
                }
                
                double nextDistance = currMapLocation.distance(this.get(relation));
                
                if(nextDistance < 100.0)
                {
                	newTimeTraveled += nextDistance / LOW_SPEED;
                }
                if(nextDistance >= 100.0 && nextDistance <= 300)
                {
                	newTimeTraveled += nextDistance / MEDIUM_SPEED;
                }
                if(nextDistance > 300.0)
                {
                	newTimeTraveled += nextDistance / HIGH_SPEED;
                }
                
                newDistanceTraveled += nextDistance;
                
                if (this.get(relation) == endLocation)
                {
                	nodesTraveled++;
                	newLocationsTraveled.add(relation);
//                	System.out.println(nodesTraveled);
//                	System.out.println(this.get(relation).getName());
                    paths.put(newTimeTraveled, newLocationsTraveled);
//                  System.out.println(locationsTraveled);
//                  System.out.println(newDistanceTraveled);
                    return;
                }
                else
                {
                    time(relation, newLocationsTraveled, newDistanceTraveled, newTimeTraveled, endLocation, nodesTraveled);
                }
            }
        }
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
