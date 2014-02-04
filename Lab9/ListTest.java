import java.io.*;
import java.util.*;

class ListTest
{
    StringList slist;
    Scanner reader;
    String command;

    public ListTest  ()
    {
      reader = new Scanner(System.in);
      command = "";
    }
    
   public void run()
   {
      slist = new StringList();
      showMenu();
      command = getCommand();
      while(!command.equals("quit"))
      {
         if (command.equals("insert"))
         {
            String str = reader.next();
            slist.addToFront(str);
         }
         else if (command.equals("append"))
         {
            String str = reader.next();
            slist.addToBack(str);
         }
         else if (command.equals("clear"))
         {
            slist.clear();
         }
         else if (command.equals("delete"))
         {
            String target = reader.next();
            if (slist.delete(target))
               System.out.println(target + " deleted");
            else
               System.out.println(target + " not in the list");
         }
         else if (command.equals("show"))
         {
            slist.printList(System.out);
         }
         else if (command.equals("find"))
         {
            String target = reader.next();
            if (slist.find(target))
               System.out.println(target + " found");
            else
               System.out.println(target + " not in the list");
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

   private void showMenu()
   {
      System.out.println();
      System.out.println("  insert <s>    // add the string <s> to the front of the list");
      System.out.println("  append <s>    // add the string <s> to the back of the list");
      System.out.println("  clear      // reset to empty list");
      System.out.println("  delete <s> // delete string <s> from the list");
      System.out.println("  find <s>   // search for string <s>");
      System.out.println("  show       // show the contents of the list");
      System.out.println("  quit");
      System.out.println();
   }

   public static void main(String[] args)
   {
      ListTest driver = new ListTest();
	   driver.run();
   }
}















