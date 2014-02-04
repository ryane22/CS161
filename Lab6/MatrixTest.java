
import java.util.*;

class MatrixTest
{
   NumberMatrix matrix;
   int rowcount;
   int colcount;

   Scanner reader;

   public MatrixTest()
   {
      rowcount = 0; 
      colcount = 0;
      reader = new Scanner(System.in);
      matrix = new NumberMatrix();
   }
   
   public void run()
   {
      String command;
      showMenu();
      command = getCommand();
      while(!command.equals("quit"))
      {
         if (command.equals("make"))
            matrix.initMatrix(reader.nextInt(), reader.nextInt());
         else if (command.equals("show"))
            matrix.showMatrix();
         else if (command.equals("find"))
         {
            int value = reader.nextInt();
            Index2D result = matrix.find(value);
            if (result != null)
               System.out.println("" + value + " found at " + result.toString());
            else
               System.out.println("" + value + " not in the matrix");
         }
         else if (command.equals("help"))
            showMenu();
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
      System.out.println("    make <n> <m> // create a new n X m matrix");
      System.out.println("    show        // show the contents of the matrix");
      System.out.println("    find <n>    // search for <n> in the matrix");
      System.out.println("    help        // show the menu");
      System.out.println("    quit        // terminate the program");
   }

   private boolean userSaysYes()
   {
      System.out.println();
      System.out.print("Build a new matrix? (y/n) ");
      String answer = reader.next();
      if (answer.equals("y") || answer.equals("Y"))
         return true;
      else
         return false;
   }

   public static void main(String[] args)
   {
      MatrixTest mtest = new MatrixTest();
      mtest.run();
   }
}















