import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FakeDBTest 
{

	@Test
	public void testGetPatronStore() 
	{//fail("Not yet implemented");
		
//		public static Map<String, Patron> getPatronStore() {
//			return patronStore;
//		}
		
		//How do I test that this actually returns a certain object????
		
		Textbook t1 = new Textbook("Technical Communications", "Apress",32, 60501, 75.00, LocalDate.now());
		Textbook t2  = new Textbook("Designing SQl", "Wiley",22, 63002, 123.55, LocalDate.now());
		Patron Yazeed = new Patron("P4", "Yazeed", "6514444444", "129 St thomas blvd.", "789 st tommy street", "eng@stthomas.edu", "Summer17", t1);
		
		Map<String,Patron> patronStore;
		
		patronStore = new HashMap<String,Patron>();	
		patronStore.put("P1", new Patron("P1", "Eric"));
		//There's an error with this one. It wont set to have a hold.
		patronStore.put("P2", new Patron("P2", "Heather"));
		patronStore.put("P3", new Patron("P3", "Temi", "6513333333", "123 St thomas blvd.", "456 st tommy street", "akin@stthomas.edu", "Summer17", t2));
		patronStore.put("P4", Yazeed);
		
        //1. Test size
		assertTrue(patronStore.size()==4);
		
		
		assertTrue(patronStore.containsKey("P1") && patronStore.get("Eric") != null);
		assertTrue(patronStore.containsKey("P2") && patronStore.get("Heather") != null);
		assertTrue(patronStore.containsKey("P3") && patronStore.get("Temi") != null);
		assertTrue(patronStore.containsKey("P4") && patronStore.get("Yazeed") != null);
		
		


//        //3. Test map entry, best!
//        assertThat(patronStore, IsMapContaining.hasEntry("n", "node"));
//
//        assertThat(patronStore, not(IsMapContaining.hasEntry("r", "ruby")));
//
//        //4. Test map key
//        assertThat(patronStore, IsMapContaining.hasKey("j"));
//
//        //5. Test map value
//        assertThat(patronStore, IsMapContaining.hasValue("node"));
	}

	@Test
	public void testSetPatronStore() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInventory() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetInventory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTextbookStore() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTextbookStore() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClassStore() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetClassStore() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetText() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutPatron() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutCopy() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
