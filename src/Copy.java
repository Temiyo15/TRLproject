///////////////////////////////////////////////////////////////////////////////
//File: Copy.java
//
// This file represents books. 
// These books are contained in the arrayList object in file Patron.java.
// The arrayList holds all the books that each person has checked out.
//
/////////////////////////////////////////////////////////////////////////////

public class Copy
{
	private String copyID;
	private String title;
	private Patron outTo;

	public Copy(String copyID, String title)
	{
		this.copyID = copyID;
		this.title = title;
		
		//Updated by Temi
		//QUESTION: Why don't these work???
		//this.setCopyID("");
		//this.setTitle("");
	}

// Generate getters and setters using Eclipse Source menu.
	//Heather generated getter and setters by clicking Source -> Generate Getters and Setters.

	public String getCopyID() 
	{
		return copyID;
	}

	public void setCopyID(String copyID) 
	{
		this.copyID = copyID;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public Patron getOutTo() 
	{
		if (this.outTo.equals(null))
		{
			return null;
		}
		
		return outTo;
	}
	

	
	public String getOutToID() 
	{
		String id = outTo.getPatronID();
		
		return id;
	}

	public void setOutTo(Patron outTo) 
	{
		this.outTo = outTo;
	}

	// Heather wrote this.
	public String toString()
	{
		
		String book = "";
		
		book = book.concat("\nCOPY TITLE: " + this.getTitle() + "\n" + "COPY ID: " + getCopyID());
		
//		if (!(getOutToID().equals(null)))
//		{
//			book = book.concat("COPY CHECKED OUT TO: " + getOutToID());
//		}
		
		return book; 
	}

	//Heather wrote this.
	@Override
	public boolean equals(Object o)
	{
		// finish this: two are equals iff same copy ID
		
		Copy c = (Copy) o;
		
		if (this.copyID.equals(c.getCopyID()))
		{
			return true;
		}

		return false;
	}

	//NOTE: HE WANTS OUTPUTS LIKE: StdOut.println("c1" );
	public static void main(String[] args)
	{
		Copy c1 = new Copy("C1", "Fun with Objects");
		Patron p1 = new Patron("Eric", "P47");

		//This line print the first output.
		StdOut.println("c1" + "\n" + "---");
		System.out.println(c1);
		
		StdOut.println("");
		
		//This line print the second output.
		StdOut.println("p1" + "\n" + "---");
		System.out.println(p1);
		
		Copy c2 = FakeDB.getCopy("C2");
		
		//Heather wrote this.
		//This line print the second output. We can see that they are almost identical.
		StdOut.println("c1" + "\n" + "---" + "\n" + c1.toString() + "\n");
		
		
		
		
	}
}
