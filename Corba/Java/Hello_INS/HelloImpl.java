public class HelloImpl extends ServicePOA
{
	public void ping()
	{
		System.out.println("PingService.ping called...");
	}
	
	public String hello(String param)
	{
		System.out.println("Received \"" + param + "\" from client....");
		return param;
	}
}