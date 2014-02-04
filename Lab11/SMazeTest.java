import java.util.*;

class SMazeTest
{
   SMaze maze;
   Scanner reader;

   public SMazeTest()
   {
      reader = new Scanner(System.in);
   }
   
   public void run()
   {
      String command;
      showMenu();
      command = getCommand();
      while(!command.equals("quit"))
      {
         if (command.equals("make"))
         {
            int rows = reader.nextInt();
            int cols = reader.nextInt();
            maze = new SMaze(rows, cols);
         }
         else if (command.equals("read"))
         {
            String filename = reader.next();
            maze = new SMaze(filename);
         }
         else if (command.equals("search"))
         {
            maze.findPath();
         }
         else if (command.equals("show"))
         {
            maze.show();
         }
         else if (command.equals("help"))
         {
            showMenu();
         }
         else
         {
            System.out.println("Unrecognized command");
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

    private void showMenu()
    {
	System.out.println("    make <r> <c> // make an <r>x<c> maze");
	System.out.println("    read <f>     // read a maze from file <f>");
	System.out.println("    search       // find a path through the maze");
	System.out.println("    show         // show the maze");
	System.out.println("    help         // show the menu");
	System.out.println("    quit         // terminate the program");
    }

    public static void main(String[] args)
    {
	    SMazeTest mtest = new SMazeTest();
	    mtest.run();
    }
}















