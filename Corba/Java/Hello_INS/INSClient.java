import org.omg.CORBA.ORB;

public class INSClient
{
	public static void main(String args[])
	{
		try
		{
			ORB orb = ORB.init(args, null);
			
			org.omg.CORBA.Object object = orb.resolve_initial_references("PingService");
			
			Service insService = ServiceHelper.narrow(object);
			
			//insService.ping();
			//System.out.println("The server has been pinged");
			System.out.println(insService.hello("Hello World from java!"));
		}
		catch(Exception e)
		{
			System.err.println("Exception in INSClient " + e);
			e.printStackTrace();
		}
	}
}