import java.util.Properties;
import org.omg.CORBA.Object;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Policy;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.*;
import org.omg.PortableServer.Servant;

public class INSServer
{
	public static void main(String args[])
	{
		try
		{
			Properties properties = System.getProperties();
			properties.put("com.sun.CORBA.POA.ORBPersistentServerPort",Integer.toString(1050));
			
			ORB orb = ORB.init(args,properties);
			
			HelloImpl servant = new HelloImpl();
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();
			rootPOA.activate_object(servant);
			
			((com.sun.corba.se.impl.orb.ORBImpl)orb).register_initial_reference("PingService",rootPOA.servant_to_reference(servant));
			
			System.out.println("INS server is ready....");
			
			orb.run();
		}
		catch(Exception e)
		{
			System.err.println("Error in setup: " + e);
		}
	}
}