import java.util.*;

class GreetingDriver
{
  // This program conducts a command-loop interaction with the user.  The main
  // method just creates the driver class and calls its run() method, and the run()
  // method conducts the command session.  The driver class
  // makes use of a Greeter class to create random greetings.

   Scanner reader;
   String command;
   Greeter greeter;

   public GreetingDriver()
   {
      reader = new Scanner(System.in);
      command = "";
      greeter = new Greeter();
   }
    
   public void run()
   {
      showMenu();
      command = getCommand();
      while(!command.equals("quit"))
      {
         if (command.equals("greet"))
            System.out.println(greeter.getGreeting(reader.next()));
         else if (command.equals("language"))
            greeter.setLanguage(reader.next());       
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
      System.out.println(" greet <name>       // greet the named person");
      System.out.println(" language <lstring> // change to the specified language");
      System.out.println(" help               // show the menu");
      System.out.println(" quit               // terminate the program");
      System.out.println();
   }

   public static void main(String[] args)
   {
      GreetingDriver driver = new GreetingDriver();
      driver.run();
   }
}
