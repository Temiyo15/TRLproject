
public class Worker 
{
	String worker_ID;

	public String getWorker_ID() 
	{
		String id = "" + 0;
		StdOut.println( "Hello, TRL system Worker." + "\n" + "Please enter your Worker ID#: " + "\n" );
		id = StdIn.readLine();
		return id;
	}

	public void setWorker_ID(String worker_ID) 
	{
		this.worker_ID = worker_ID;
	}

	public Worker() 
	{
		worker_ID = "";
	}
	
	

}
