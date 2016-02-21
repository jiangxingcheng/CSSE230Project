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
    
    // Used for recursive shortest path finding
    HashMap<Double, ArrayList<String>> paths;
    
    // Used for recursive time/distance specified path finding
    ArrayList<ArrayList<String>> costPaths;

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
    
    

    public ArrayList<String> startingDistance(mapLocation startLocation, mapLocation endLocation)
    {
        paths = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        
        int nodesTraveled = 0;
        for (String relation: startLocation.getRelations())
        {
            Double distanceTraveled = 0.0;
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
        Double min = 0.0;
        if (paths.size() != 0)
        {
            for (Double distance : paths.keySet())
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
            result.add(min.toString());
	        for(String location: paths.get(min))
	        {
	        	result.add(location);
	        }
	        return result;
        }
        else
        {
	        result.add(min.toString());
	        
	        return result;
        }
    }

    public void distance(String currentLocation, ArrayList<String> locationsTraveled, Double distanceTraveled, mapLocation endLocation, int nodesTraveled)
    {
        locationsTraveled.add(currentLocation);
        mapLocation currMapLocation = this.get(currentLocation);
        nodesTraveled++;
        
        for (String relation: currMapLocation.getRelations())
        {
            if (!locationsTraveled.contains(relation))
            {
                Double newDistanceTraveled = distanceTraveled;

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

    public ArrayList<String> startingTime(mapLocation startLocation, mapLocation endLocation)
    {
        paths = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        
        int nodesTraveled = 0;
        for (String relation: startLocation.getRelations())
        {
            Double timeTraveled = 0.0;
            Double distanceTraveled = 0.0;
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
        Double min = 0.0;
        
        if (paths.size() != 0)
        {
            for (Double time : paths.keySet())
            {
                if (min == 0)
                {
                    min = time;
                }
                if (time < min)
                {
                    min = time;
                }
            }
            result.add(min.toString());
            for(String location: paths.get(min))
            {
            	result.add(location);
            }
            return result;
        }
        else
        {
	        result.add(min.toString());
	        
	        return result;
        }
    }

    public void time(String currentLocation, ArrayList<String> locationsTraveled, Double distanceTraveled , Double timeTraveled, mapLocation endLocation, int nodesTraveled)
    {
    	locationsTraveled.add(currentLocation);
        mapLocation currMapLocation = this.get(currentLocation);
        nodesTraveled++;
        
        for (String relation: currMapLocation.getRelations())
        {
            if (!locationsTraveled.contains(relation))
            {
                Double newTimeTraveled = timeTraveled;
                Double newDistanceTraveled = distanceTraveled;

                ArrayList<String> newLocationsTraveled = new ArrayList<String>();
                for(String location: locationsTraveled) {
                	newLocationsTraveled.add(location);
                }
                
                Double nextDistance = currMapLocation.distance(this.get(relation));
                
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

    public ArrayList<ArrayList<String>> tripTimePlanner(mapLocation startLocation, Double timeToTravel)
    {
    	costPaths = new ArrayList<ArrayList<String>>();
        
        int nodesTraveled = 0;
        for (String relation: startLocation.getRelations())
        {
            Double timeTraveled = 0.0;
            Double distanceTraveled = 0.0;
            
            ArrayList<String> locationsTraveled = new ArrayList<>();
            locationsTraveled.add(startLocation.getName());
            timeTraveled += startLocation.distance(this.get(relation));
            if (timeToTravel == 0)
            {
                costPaths.add(locationsTraveled);
            }
            else
            {
                timePlannerRecurse(relation, locationsTraveled, distanceTraveled, timeTraveled, nodesTraveled, timeToTravel);
            }
        }
        return costPaths;
    }
    
    public void timePlannerRecurse(String currentLocation, ArrayList<String> locationsTraveled, Double distanceTraveled, Double timeTraveled, int nodesTraveled, Double timeLimit)
    {
    	locationsTraveled.add(currentLocation);
        mapLocation currMapLocation = this.get(currentLocation);
        nodesTraveled++;
        
        for (String relation: currMapLocation.getRelations())
        {
            if (!locationsTraveled.contains(relation))
            {
                Double newTimeTraveled = timeTraveled;
                Double newDistanceTraveled = distanceTraveled;

                ArrayList<String> newLocationsTraveled = new ArrayList<String>();
                for(String location: locationsTraveled) {
                	newLocationsTraveled.add(location);
                }
                
                Double nextDistance = currMapLocation.distance(this.get(relation));
                
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
                
                if (newTimeTraveled > timeLimit)
                {
//                	System.out.println(nodesTraveled);
//                	System.out.println(this.get(relation).getName());
                    costPaths.add(newLocationsTraveled);
//                  System.out.println(locationsTraveled);
//                  System.out.println(newDistanceTraveled);
                    return;
                }
                else
                {
                    timePlannerRecurse(relation, newLocationsTraveled, newDistanceTraveled, newTimeTraveled, nodesTraveled, timeLimit);
                }
            }
        }
    }
    
    public ArrayList<ArrayList<String>> tripDistancePlanner(mapLocation startLocation, Double distanceToTravel)
    {
    	costPaths = new ArrayList<ArrayList<String>>();
	        
        int nodesTraveled = 0;
        for (String relation: startLocation.getRelations())
        {
            Double distanceTraveled = 0.0;
            ArrayList<String> locationsTraveled = new ArrayList<>();
            locationsTraveled.add(startLocation.getName());
            
            if (distanceToTravel == 0)
            {
                costPaths.add(locationsTraveled);
            }
            else
            {
                distancePlannerRecurse(relation, locationsTraveled, distanceTraveled, nodesTraveled, distanceToTravel);
            }
        }
        
        return costPaths;
    }
    
    public void distancePlannerRecurse(String currentLocation, ArrayList<String> locationsTraveled, Double distanceTraveled, int nodesTraveled, Double distanceLimit)
    {
    	locationsTraveled.add(currentLocation);
        mapLocation currMapLocation = this.get(currentLocation);
        nodesTraveled++;
        
        for (String relation: currMapLocation.getRelations())
        {
            if (!locationsTraveled.contains(relation))
            {
                Double newDistanceTraveled = distanceTraveled;

                ArrayList<String> newLocationsTraveled = new ArrayList<String>();
                for(String location: locationsTraveled) {
                	newLocationsTraveled.add(location);
                }
                
                Double nextDistance = currMapLocation.distance(this.get(relation));

                newDistanceTraveled += nextDistance;
                
                if (newDistanceTraveled > distanceLimit)
                {
//                	System.out.println(nodesTraveled);
//                	System.out.println(this.get(relation).getName());
                    costPaths.add(newLocationsTraveled);
//                  System.out.println(locationsTraveled);
//                  System.out.println(newDistanceTraveled);
                    return;
                }
                else
                {
                    distancePlannerRecurse(relation, newLocationsTraveled, newDistanceTraveled, nodesTraveled, distanceLimit);
                }
            }
        }
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
