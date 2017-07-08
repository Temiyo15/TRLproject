import java.util.ArrayList;

public class Gui 
{

	public Gui() 
	{
	
	}

	public String enterPatronID()
	{
		String patron_id = "";
		
		StdOut.println( "--- Please enter the Patron's ID number ----");
		StdOut.println( "    Enter either 'P1' or 'P2' or 'P3' or 'P4' >> ");
		
		patron_id = StdIn.readLine();
	
		return patron_id;
	}
	public void outputWorkerID(String workerID)
	{
		String worker_id = "";
		
		StdOut.print( "--- Worker " + workerID + " begins checkout ----" + "\n");
	
	}
	
	public String outputHolds(boolean has_holds, ArrayList<Copy> copiesOut)
	{
		String holds = " has no holds on account.";
		
		if (has_holds == true)
		{
		
			holds = (" HAS Holds on account for textbook(s):");
			holds = holds.concat("\n---------------------------------------------");
			
			for (int i = 0; i < copiesOut.size(); i++) 
			{
				if (copiesOut.get(i).isOverdue())
				{
					holds = holds.concat("" + copiesOut.get(i));

				}
			}	
		}
		else
			holds =  " has no holds on account.";

		return holds;
	}
	public String getCopyWithHolds(boolean has_holds, ArrayList<Copy> copiesOut)
	{
		String holds = "";
		Copy hold = null;
		
		if (has_holds == true)
		{
			for (int i = 0; i < copiesOut.size(); i++) 
			{
				if (copiesOut.get(i).isOverdue())
				{
					hold = copiesOut.get(i);
					holds = hold.getCopyID();
				}
			}	
		}
		
		else
			holds =  "";

		return holds;
	}
	
	public double getFines(Patron p)
	{
		
		double value = 0;
		
		for (int i = 0; i < p.getCopiesOut().size(); i++) 
		{
		
			Copy c = p.getCopiesOut().get(i);
		
			if (c.hasHold())
			{
				value = c.getPrice_if_lost();
	
		
				StdOut.println( "-------------------------");
				StdOut.println( "Patron Fines = $" + value);
				StdOut.println( "-------------------------");
	
			}
		}
		
		return value;
	}
	public boolean pay(double fines)
	{
		boolean pay = false;
		StdOut.println( "-------------------------");
		StdOut.println( "Does patron want to pay fines? " );
		StdOut.println( "Y - Yes");
		StdOut.println( "N - No");
		
		char c = StdIn.readChar();
		
		if ((c == 'y')||(c=='Y'))
		{
			StdOut.println( "Please enter payment amount");
			double payment = StdIn.readDouble();
			StdOut.println( "Change = $ " + (payment - fines));
			
			//REmove hold here
			if ((payment - fines) > 0)
			{
				//remove hold here 
				pay = true;
				
			}
		}
		else
		{
				pay = false;
				
		}
	return pay;	
	}
	
	public int enterNumberOfBooks()
	{
		int num = 0;
		
		StdOut.println( "--- Please enter the # of books brought to the counter by Patron ----");
		StdOut.println( "    Enter an integer value >> ");
		
		num = StdIn.readInt();
		
		return num;
	}
	
}
