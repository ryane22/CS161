import java.io.*;
import java.util.*;

class OrdSetTest
{
   OrderedObjectSet <String> slist;
   Scanner reader;

   public OrdSetTest()
   {
      reader = new Scanner(System.in);
   }
    
   public void run()
   {
      slist = new OrderedObjectSet<String>();
      showMenu();
      String command = getCommand();
      while(!command.equals("quit"))
      {
         if (command.equals("add"))
            slist.add(reader.next());
         else if (command.equals("clear"))
            slist.clear();
         else if (command.equals("delete"))
         {
            String target = reader.next();
            if (slist.delete(target))
               System.out.println(target + " deleted");
            else
               System.out.println(target + " not in the list");
         }
         else if (command.equals("show"))
            printList();
         else if (command.equals("find"))
         {
            String target = reader.next();
            if (slist.contains(target))
               System.out.println(target + " found");
            else
               System.out.println(target + " not in the list");
         }
         else if (command.equals("size"))
            System.out.println("The list contains " + slist.size() + " elements.");
         else if (command.equals("help"))
            showMenu();
         else
         {
            System.out.println("Unrecognized command");
            reader.nextLine();
            showMenu();
         }
         command = getCommand();
      }
   }

   private void printList()
   {
      for (String nextstring: slist)
         System.out.println(nextstring);
   }

   private String getCommand()
   {
      System.out.print("? ");
      return reader.next();
   }

   private void showMenu()
   {
      System.out.println();
      System.out.println("  add <s>    // add the string <s> to the list");
      System.out.println("  clear      // reset to empty list");
      System.out.println("  delete <s> // delete string <s> from the list");
      System.out.println("  find <s>   // search for string <s>");
      System.out.println("  size       // show the number of elements in the list");
      System.out.println("  show       // show the contents of the list");
      System.out.println("  quit");
      System.out.println();
   }

   public static void main(String[] args)
   {
      OrdSetTest driver = new OrdSetTest();
      driver.run();
   }
}















