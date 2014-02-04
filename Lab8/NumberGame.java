import java.util.*;

class NumberGame
{
   OrderedIntList numberlist;
   Scanner reader;

   public NumberGame()
   {
      reader = new Scanner(System.in);
      numberlist = new OrderedIntList();
   }
    
   public void run()
   {
      String command;
      showMenu();
      command = getCommand();
      while(!command.equals("quit"))
      {
         if (command.equals("make"))
            numberlist.reset(reader.nextInt());
         else if (command.equals("show"))
            System.out.println(numberlist.toString());
         else if (command.equals("fill"))
            numberlist.randomFill(reader.nextInt());
         else if (command.equals("add"))
            numberlist.add(reader.nextInt());
         else if (command.equals("delete"))
            numberlist.delete(reader.nextInt());
         else if (command.equals("size"))            
            System.out.println("The list contains " + numberlist.size() + " items");
         else if (command.equals("find"))
         {
            int value = reader.nextInt();
            boolean result = numberlist.find(value);
            if (result)
               System.out.println("" + value + " found");
            else
               System.out.println("" + value + " not in the list");
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
      System.out.println("    make <n>    // create an empty list for <n> numbers");
      System.out.println("    fill <m>    // fill with random numbers less than <m>");
      System.out.println("    add <n>     // insert the specified number in the list");
      System.out.println("    delete <n>  // delete the specified number from the list");
      System.out.println("    size        // display the number of integers in the list");
      System.out.println("    show        // show the contents of the list");
      System.out.println("    find <n>    // search for <n> in the list");
      System.out.println("    quit        // terminate the program");
   }

   public static void main(String[] args)
   {
      NumberGame game = new NumberGame();
      game.run();
   }
}















