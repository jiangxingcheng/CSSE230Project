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
		
//		for(String locationName: hash.keySet()){
//			mapLocation mL = hash.get(locationName);
//			System.out.println(mL.name);
//			System.out.println(mL.xCoordinate);
//			System.out.println(mL.yCoordinate);
//			System.out.println(mL.interestRating);
//			System.out.println(mL.relations);
//			System.out.println(" ");
//		}
		
		System.out.println(hash.startingDistance(hash.get("Atlantis"),hash.get("Atlantis")));
		System.out.println(hash.startingDistance(hash.get("Self Made Robot"),hash.get("Atlantis")));
		System.out.println(hash.startingDistance(hash.get("Self Made Robot"),hash.get("Better Canyon")));
		System.out.println(hash.get("Self Made Robot").distance(hash.get("Okay Canyon")) + hash.get("Okay Canyon").distance(hash.get("Better Canyon")));
		System.out.println(" ");

		System.out.println(hash.startingDistance(hash.get("Atlantis"),hash.get("Knew York")));
		System.out.println(hash.get("Atlantis").distance(hash.get("Springfield")) + hash.get("Springfield").distance(hash.get("Panomnom Canal")) + hash.get("Panomnom Canal").distance(hash.get("Knew York")));

		
	}
}
