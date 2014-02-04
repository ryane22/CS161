import java.util.*;

class CatchTest
{
   MethodChain mchain;
   Scanner reader;

   public CatchTest()
   {
	   reader = new Scanner(System.in);
	   mchain = new MethodChain();
   }
    
   public void run() throws Exception
   {
   	String command;
   	showMenu();
   	command = getCommand();
   	while(!command.equals("quit"))
   	{
         if (command.equals("call"))
            mchain.method1(getInt());
         else if (command.equals("try"))
         {  // replace this call with a try-catch block
				try
				{
            	mchain.method1(getInt());
				}
				catch (DepthException d)
				{
					System.out.println(d);
				}
         }
         else if (command.equals("help"))
         {
            showMenu();
         }
         else
         {
            System.out.println("Unrecognized command");
            reader.nextLine();
            showMenu();
         }
         command = getCommand();
      }
   }

   private String getCommand()
   {
      System.out.print("? ");
      return reader.next();
   }

   private int getInt()
   {
      // replace this code with a more robust version
		int i = -1;
		while (i < 0)
		{
			try
			{
      		i = reader.nextInt();
				break;
			}
			catch (InputMismatchException m)
			{
				System.out.println("Please enter an integer: ");
				reader.next();
			}
		}
		return i;
   }

   private void showMenu()
   {
      System.out.println();
      System.out.println("  call <n>  // make a method call with depth <n>");
      System.out.println("  try <n>   // safely call method with depth <n>");
      System.out.println("  help      // print the menu"); 
      System.out.println("  quit      // terminate the program");
      System.out.println();
   }

   public static void main(String[] args) throws Exception
   {
      CatchTest driver = new CatchTest();
      driver.run();
   }
}















