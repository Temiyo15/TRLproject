import java.util.HashMap;
import java.util.Map;

/////////////////////////////////////////////////////////////////////////
//File: FakeDB.java
//
// This file is a database that holds all the data for people (Patron's) and 
// textbooks (Copy's). 
//
// The data is stored in a HashMap.
//
// Each HashMap is like a table in a database.
//
// There is one hashMap for people (Patrons). It stores all the data for people 
//      who check out textbooks. It is called patronStore.
//
// There is a second hashMap for textbooks (Copies). It stores all the data for
//      textbooks. It is called copyStore.
//
// HashMaps have a key, which is a String, associated with each person or book. 
//
// Keys MUST be unique.
//
// Equals() and HashCode() methods should be defined in order to use the HashMap.
//
// References
// -----------
// HashMaps : https://www.youtube.com/watch?v=hgawTLk0o3Y
// See page 561 on HashCode: https://zimslifeintcs.files.wordpress.com/2011/12/head-first-java-2nd-edition.pdf
// HashCodes: https://www.youtube.com/watch?v=DSTpMWv0IlA
//
//
//
////////////////////////////////////////////////////////////////////////

public class FakeDB
{
	private static Map<String,Patron> patronStore;
	private static Map<String,Copy> copyStore;
	
	static // the following runs once when class is loaded: "static initializer"
	{
		patronStore = new HashMap<String,Patron>();
		copyStore = new HashMap<String,Copy>();
		
		patronStore.put("P1", new Patron("P1", "Eric"));
		//Heather added this line.
		patronStore.put("P2", new Patron("P2", "Heather"));
		
		copyStore.put("C1", new Copy("C1", "Fun with Objects"));
		copyStore.put("C2", new Copy("C2", "More Fun with Objects"));
		
	}

	public static Patron getPatron(String patronID)
	{
		return patronStore.get(patronID);
	}
	
	
	//Heather wrote this. It isn't exactly right. P13 should count the number of elements in the hashmap and increment.
	public static void putPatron(Object patron)
	{
		Patron p = (Patron) patron;
				
		patronStore.put("" + p.getPatronID(), new Patron("" + p.getPatronID(), p.getName()));	
		
	}
	
	public static Copy getCopy(String copyID)
	{
		return copyStore.get(copyID);
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	

}
