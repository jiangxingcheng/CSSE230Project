import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

//This class returns an ArrayList of mapLocations which we can will use to build the tree.
//The Read functionality is based on the layout below:
//- name of location
//- xCoordinate
//- yCoordinate
//- Rating (0-10)
//- Relations (ArrayList<String>)

public class Reader {
	ArrayList<mapLocation> locations;
	
	public static locationMapHash main() throws IOException {
		ArrayList<mapLocation> mapLocations = reader();
		
		locationMapHash hash = new locationMapHash();
		
		for(mapLocation place: mapLocations) {
			hash.insert(place);
		}
		return hash;
	}
	
	public static ArrayList<mapLocation> reader() throws IOException {
		BufferedReader levelFile = null;
	
		int numberOfLines = getTextFileLines();
		
		String[] line = new String[numberOfLines];
		try
		{
			levelFile = new BufferedReader(new FileReader("./src/LocationsList.txt"));
			
			
			for (int i = 1; i < numberOfLines; i++)
			{
				line[i] = levelFile.readLine();
//				System.out.println(line[i]);
			}
			levelFile.close();
			
		} catch (IOException exception)
		{
			exception.printStackTrace();
		}
		
		// Location Creation Loop
		
		ArrayList<mapLocation> locations = new ArrayList<mapLocation>();
		
		for(int i = 1; i < numberOfLines;) {
			
			String name = line[i];
			double x = Double.parseDouble(line[i+1]);
			double y = Double.parseDouble(line[i+2]);
			int rating = Integer.parseInt(line[i+3]);
			
			ArrayList<String> relation = new ArrayList<String>();
			
			int j = 0;
			int k = 0;
			int counterBegin = 1;
			int counterEnd = 0;
			
			
			counterEnd = j;
			while(j < line[i+4].length() && line[i+4].charAt(j) != ']' ) {
				
				while(line[i+4].charAt(j) != ']' && line[i+4].charAt(j) != ',') {
					counterEnd++;
					j++;
				}
				if(line[i+4].charAt(j) == ',' || line[i+4].charAt(j) == ']') {
					relation.add(line[i+4].substring(counterBegin, counterEnd));
					k++;
					counterBegin = counterEnd + 1;
					counterEnd = counterEnd + 1;
					j++;
				}
			}
//			System.out.println(relation.toString());  // Check for proper Relation ArrayList
			locations.add(new mapLocation(name, x, y, rating, relation));
			i = i + 6;

		}
		return locations;
		
	}

	private static int getTextFileLines() throws IOException {
		LineNumberReader  lnr = new LineNumberReader(new FileReader(new File("./src/LocationsList.txt")));
		lnr.skip(Long.MAX_VALUE);
		int numReturn = lnr.getLineNumber() + 1;
		lnr.close();
		return numReturn;
	}
	
}
