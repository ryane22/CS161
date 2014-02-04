import java.util.*;

class TreeTest
{
   SearchTree tree;
   Scanner reader;
   String command;

   public TreeTest()
   {
      reader = new Scanner(System.in);
      command = "";
    }
    
   public void run()
   {
      tree = new SearchTree();
      showMenu();
      command = getCommand();
      while(!command.equals("quit"))
      {
         if (command.equals("add"))
         {
            int val = reader.nextInt();
            tree.add(val);
         }
         else if (command.equals("clear"))
            tree.clear();
         else if (command.equals("find"))
         {
            int val = reader.nextInt();
            if (tree.find(val))
               System.out.println("Found "+val);
            else
               System.out.println(""+val+" not in tree");
         }
         else if (command.equals("delete"))
         {
            int val = reader.nextInt();
            if (tree.delete(val))
               System.out.println("Deleted "+val);
            else
               System.out.println(""+val+" not in tree");
         }
         else if (command.equals("size"))
            System.out.println("Tree contains "+tree.size()+" items");
         else if (command.equals("tree"))
            System.out.println(tree.toString());
         else if (command.equals("height"))
            System.out.println("Tree height is "+tree.height());
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
      System.out.println();
      System.out.println(" add <n>    // add the number <n> to the tree");
      System.out.println(" delete <n> // remove <n> from the tree");
      System.out.println(" clear      // reset to empty tree");
      System.out.println(" find <n>   // report whether <n> is in the tree");
      System.out.println(" size       // show the size of the tree");
      System.out.println(" height     // show the height of the tree");
      System.out.println(" tree       // show the tree as a parenthesized string");
      System.out.println(" quit");
      System.out.println();
   }

   public static void main(String[] args)
   {
      TreeTest driver = new TreeTest();
      driver.run();
   }
}















