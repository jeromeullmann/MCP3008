package myMcp3008;

public class MainMCP3008Sample {

	
	private final static boolean DEBUG = false;
	
	  private static boolean go = true;
	  private static int ADC_CHANNEL = MCP3008Reader.MCP3008_input_channels.CH0.ch();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    MCP3008Reader.initMCP3008();
		    Runtime.getRuntime().addShutdownHook(new Thread()
		                                         {
		                                           public void run()
		                                           {
		                                             System.out.println("Shutting down.");
		                                             go = false;
		                                             synchronized (Thread.currentThread())
		                                             {
		                                               Thread.currentThread().notify();
		                                             }
		                                           }
		                                         });
		    int lastRead  = 0;
		    int tolerance = 5;
		    while (go)
		    {
		      int adc = MCP3008Reader.readMCP3008(ADC_CHANNEL);
		      System.out.println("adc :" + adc);
		      try 
		      { 
		        synchronized (Thread.currentThread()) 
		        {
		          Thread.currentThread().wait(1000L); 
		        }
		      } catch (InterruptedException ie) { ie.printStackTrace(); }
		    }
		    System.out.println("Bye, freeing resources.");
		    MCP3008Reader.shutdownMCP3008();
	}
	
}
