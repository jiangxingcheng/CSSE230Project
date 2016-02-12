import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// This class returns an ArrayList of mapLocations which we can will use to build the tree.
// The Read functionality is based on the layout below:
// - name of location
// - xCoordinate
// - yCoordinate
// - Rating (0-10)
// - Relations (ArrayList<String>)

public class Reader {
	ArrayList<mapLocation> locations;
	
	public ArrayList<mapLocation> reader() {
		BufferedReader levelFile = null;
	
		int numberOfLines = 78;
		String[] line = new String[numberOfLines];
		try
		{
			levelFile = new BufferedReader(new FileReader("src\\LocationsList.txt"));
			
			
			for (int i = 1; i < numberOfLines; i++)
			{
				line[i] = levelFile.readLine();
				System.out.println(line[i]);
			}
			levelFile.close();
			
		} catch (IOException exception)
		{
			exception.printStackTrace();
		}
		
		// Location Creation Loop
		
		for(int i = 1; i < numberOfLines;) {
			
			String name = line[i];
			int x = Integer.parseInt(line[i+1]);
			int y = Integer.parseInt(line[i+2]);
			int rating = Integer.parseInt(line[i+3]);
			
			ArrayList<String> relation = new ArrayList<String>();
			
			int j = 0;
			int k = 0;
			int counterBegin = 1;
			int counterEnd = 0;
			
			
			counterEnd = j;
			while(j < line[i+4].length() && line[i+4].charAt(j) != ']' ) {
//					System.out.println(line[i+4].charAt(j));
				
				while(line[i+4].charAt(j) != ']' && line[i+4].charAt(j) != ',') {
					counterEnd++;
					j++;
				}
				if(line[i+4].charAt(j) == ',' || line[i+4].charAt(j) == ']') {
					relation.add(line[i+4].substring(counterBegin, counterEnd));
					System.out.println(relation.get(k));
					k++;
					counterBegin = counterBegin + 2;
					counterEnd = counterEnd + 1;
					j++;
				}
			}
			
			this.locations.add(new mapLocation(name, x, y, rating, relation));
			
			i = i + 6;

		}
		return locations;
		
	}
}
