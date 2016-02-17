import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class test {
	
	@Test
	public void testing() throws IOException{
		
		Reader test = new Reader();
		
		locationMapHash hash = Reader.main();
		
		for(String locationName: hash.keySet()){
			mapLocation mL = hash.get(locationName);
			System.out.println(mL.name);
			System.out.println(mL.xCoordinate);
			System.out.println(mL.yCoordinate);
			System.out.println(mL.interestRating);
			System.out.println(mL.relations);
			System.out.println(" ");
		}
		
		

		
	}
}
