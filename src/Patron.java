//Heather comments that the ArrayList data type comes from this library.
import java.util.ArrayList;

/////////////////////////////////////////////////////////////////////////
//File: Patron.java
//
// This file is for a Patron (person) who checks out books from the rental
// library. Each person (Patron) has an ArrayList associated with him. The
// arrayList, called copiesOut, contains a list of books that they have 
// checked out. They should be able to check out more than one (two? 
// See requirements).
//
////////////////////////////////////////////////////////////////////////

public class Patron
{
	private String name;
	private String patronID;
	
	//Heather comments an ArrayList is a dynamic array that can change size whenever we want.
	//      This ArrayList holds a bunch of Copy objects.
	private ArrayList<Copy> copiesOut;
	
	public Patron()
	{
		// Heather wrote this.
		this.name = null;
		this.patronID = null;
		
		//Updated by Temi
		//this.setName("");
		//this.setPatronID("");
		
		//ArrayList help
		//See ArrayList Vs. array: https://www.youtube.com/watch?v=ZVJ7kpEMc7U
		//See https://www.youtube.com/watch?v=L1a8R9nkJ4w
		
		//Allocate some memory Copy objects. This has default capacity 10. It will resize when it reaches capacity.
		this.copiesOut = new ArrayList<Copy>();	
		
	}

	public Patron(String id, String name)
	{
		// Heather wrote this.
		this.name = name;
		this.patronID = id;
		
		//Temi wrote this.
		//this.setName("");
		//this.setPatronID("");
		
		//ArrayList help
		//See ArrayList Vs. array: https://www.youtube.com/watch?v=ZVJ7kpEMc7U
		//See https://www.youtube.com/watch?v=L1a8R9nkJ4w
		
		//Allocate some memory Copy objects. This has default capacity 10. It will resize when it reaches capacity.
		this.copiesOut = new ArrayList<Copy>();	
		
	}
	
// Generate getters and setters using Eclipse Source menu.
	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public String getPatronID() 
	{
		return patronID;
	}


	public void setPatronID(String patronID) 
	{
		this.patronID = patronID;
	}


	public ArrayList<Copy> getCopiesOut() 
	{
		return copiesOut;
	}


	public void setCopiesOut(ArrayList<Copy> copiesOut) 
	{
		this.copiesOut = copiesOut;
	}
	
	///////////////////////////////////////////////////////
	
	//Temi wrote this
	public boolean isInArrayList(Copy c)
	{
		boolean result = false;
		
		if (this.getCopiesOut().contains(c))
			result = true;
		else
			result = false;
		
	return result;
	}

	//What does this mean? See requirements.
	
	//Temi wrote this - question about where a 'master list' of all books should go.
	public boolean checkCopyOut(Copy c)
	{
		// finish this
		boolean bookCheckedOut = false;
		
		//Put book back into inventory at the Rental office
		this.getCopiesOut().add(c);
		
		//set the value of Copy.outTo to the patron variable
		c.setOutTo(this);
		
		//if the book is NOT in Erics arrayList, then return false. Else, 
		//   the test succeeds and returns true, indicating that Eric
		//   got the book from the rental office. It is now stored in his
		//   arrayList of books.

		bookCheckedOut = this.isInArrayList(c);	
		
		return bookCheckedOut;
	}

	//What does this mean? See requirements.
	
	//Temi wrote this.
	public boolean checkCopyIn(Copy c)
	{
		// finish this
		
		boolean bookReturned = false;
		
		//Get the ID of the book that is being returned (checkedIn).
		String book_ID_for_removal = c.getCopyID();
		
		Patron person_checking_in_a_book = null;
		
		//Get the ID of the person that is returning a book to the rental shop (checkingIn).
		String patron_id = c.getOutToID();
		
		//Get the ID of the person object.
		person_checking_in_a_book = FakeDB.getPatron(patron_id);
		
		//Get the ID of the person's name.
		String patron_name_checked_out_to = person_checking_in_a_book.getName();
		
		
		//Put book back into inventory at the Rental office

		
		
		StdOut.println("");
		StdOut.println("" + c.toString());
		//StdOut.println("" + c.getOutToID());
		StdOut.println("This book will be returned to the rental shop by Patron named " + patron_name_checked_out_to + ". His ID # is " + c.getOutToID() + "."  );
		StdOut.println("");
		
		//This method used the wrong paramenter. That was the error.
		//bookReturned = this.getCopiesOut().remove(book_ID_for_removal);
		
		bookReturned = this.getCopiesOut().remove(c);
		
		//set the value of Copy.outTo to null because no one has it checked out.
		c.setOutTo(null);
		
		
		//if the book is still in Erics arrayList, then return false, else 
		//   return true, indicating that Eric gave the book back to the rental office.
	
		bookReturned = this.isInArrayList(c);	
		bookReturned = !(bookReturned);
		
		return bookReturned;
	}

	//Heather wrote this.
	@Override
	public boolean equals(Object o)
	{
		// finish this: two are equals iff same patron ID
		
		Patron p = (Patron) o;
		
		if (this.patronID.equals(p.getPatronID()))
		{
			return true;
		}
		else
		return false;
	}

	//Heather wrote this
	public String toString()
	{
		// finish this: return basic Patron info as String
		
		String p = "";
		
		p = p.concat("PATRON ID: " + this.getPatronID() + "\n" + "PATRON NAME: " + this.getName() + "\n" + "PATRON'S CHECKED OUT BOOKS: " + this.getCopiesOut() + "\n");
		
		// Heather says test p1.toString() in main.
		
		return p;
	}
	
	//NOTE: Level WANTS OUTPUTS LIKE: StdOut.println("c1" );
	public static void main(String[] args)
	{
		Patron p3 = new Patron("P3", "EricLevel");
		
		//Can I put p3 into the hashmap here....
	
		
		//OUTPUTTING TO THE SCREEN.....
		
		//This is how Ali Navqui liked output:
		//System.out.println("Hello.");
		
		//This is how Eric level wants us to output:
		//StdOut.println("Hello.");
		
		
		//1st output
		//System.out.println("We created a Patron object using the Patron constructor. \n");
		StdOut.println("We created a Patron object using the Patron constructor. \n");
		
		//2nd output - confirms that toString() works
		//System.out.println("" + p3);
		

		StdOut.println("----------------------------------------");
		StdOut.println("" + p3);
		
		//Patron p1 = new Patron();

		//3rd output 
		//System.out.println("getPatron() from FakeDB " + "\n" +  "----------------------" + "\n" + p1);
		//System.out.println("");
		
		
		FakeDB database = new FakeDB();
		//p1 = database.getPatron("P1");
		
		Patron p1 = database.getPatron("P1");
		
		p1.toString();
		
		StdOut.println("getPatron() from FakeDB " + "\n" +  "------------------------" + "\n" + p1.toString());
		//StdOut.println("");
		
		//4th output 
		Copy c1 = FakeDB.getCopy("C1");
		//System.out.println("getCopy() from FakeDB " + "\n" +  "----------------------" + "\n" + c1);
		//System.out.println("");
		StdOut.println("getCopy() of book from FakeDB " + "\n" +  "-----------------------------" + "\n" + c1);
		StdOut.println("");
		
		//5th output - Get a second book from the database
		Copy c2 = FakeDB.getCopy("C2");
		StdOut.println("getCopy() of a second book from FakeDB " + "\n" +  "--------------------------------------" + "\n" + c2);
		StdOut.println("");
		
		//Build tests????
		
		//Note on refractoring:
		//Before refractoring, build a solid test suite. They must be self checking. (Fowler, p8)
	
		///////////////////////////////////////////////////////////
		//	REQUIREMENTS TEST
		//////////////////////////////////////////////////////////
		
		//test #1. Eric has no books in his arrayList.
		StdOut.println("");
		
		StdOut.println("Eric goes to the rental office to checkout a book." );
		StdOut.println("This is Eric's list of books before checkout ...");
		StdOut.println("");

		StdOut.println("--------------------------");
		StdOut.println("BEFORE CHECKOUT OF TEXTBOOK: ");
		StdOut.println("--------------------------");
		StdOut.println("" + p1.toString());
		
		//CHECKOUT METHODS HERE - Checkout 2 books
		
		//test #2. Eric has ONE book in his arrayList.
		StdOut.println("---------------------------------");
		StdOut.println("AFTER CHECKOUT OF FIRST TEXTBOOK:");
		StdOut.println("---------------------------------");
		//StdOut.println("" + p1.getName() + "'s checked out books: " + p1.getCopiesOut());
		StdOut.println("A book was checked out: " + p1.checkCopyOut(c1));
		StdOut.println("");
		StdOut.println("" + p1.toString());
		StdOut.println("");
		
		//test #3. Eric has two bookS in his arrayList.
		StdOut.println("------------------------------------");
		StdOut.println("AFTER CHECKOUT OF A SECOND TEXTBOOK:");
		StdOut.println("------------------------------------");
		//StdOut.println("" + p1.getName() + "'s checked out books: " + p1.getCopiesOut());
		StdOut.println("A book was checked out: " + p1.checkCopyOut(c2));
		StdOut.println("");
		StdOut.println("" + p1.toString());
		
		//CHECKOUT METHODS HERE - Return (checkIn) 1 book to the rental office.
		
		StdOut.println("------------------------------------");
		StdOut.println("AFTER RETURNING THE SECOND TEXTBOOK:");
		StdOut.println("------------------------------------");
		StdOut.println("A book was checked in: " + p1.checkCopyIn(c2));
		StdOut.println("");
		StdOut.println("" + p1.toString());
		
		
		
	}	

}
