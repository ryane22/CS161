import java.util.*;
public class Greeter
{
   Random randgen;
   String language;

   public Greeter()
   {  // constructor with English language default
      randgen = new Random();
      language = "english";
   }

	public Greeter(String l)
	{	// constructor with string that specifies language

	    randgen = new Random();
	    setLanguage(l);
	}

	public String getGreeting(String name)
	{	// say hello in the current language
	   if (language.equals("french"))
	      return frenchGreeting(name);
	   else if (language.equals("german"))
	      return germanGreeting(name);
           else if (language.equals("spanish"))
              return spanishGreeting(name);
	   else
	      return englishGreeting(name);
	}

   public void setLanguage(String l)
   {
      String lang = l.toLowerCase();
      if (lang.equals("english") || lang.equals("french") || lang.equals("german") || lang.equals("spanish"))
         language = lang;
      else
      {
         System.err.println("Unknown language -- defaulting to English");
         language = "english";
      }
   }

   private String englishGreeting(String n)
   {
      int greetingcode = randgen.nextInt(3);
      switch (greetingcode)
	   {
	      case 0:
	         return new String("Hello, " + n + "!");
	      case 1:
	         return new String("How are you, " + n + "?");
	      default:
	         return new String("Good day, " + n + "!");
	   }
   }
   
   private String frenchGreeting(String n)
   {
      return new String("Bon jour, " + n + "!");
   }
   
   private String germanGreeting(String n)
   {
      int greetingcode = randgen.nextInt(2);
      if (greetingcode == 0)
         return new String("Wie geht's, " + n + "?");
      else
         return new String("Guten tag, " + n + "!");
   }

   private String spanishGreeting(String n)
   {
      int greetingcode = randgen.nextInt(2);
      if (greetingcode == 0)
         return new String("Hola, " + n + "!");
      else
         return new String("Que pasa, " + n + "?");
   }
}