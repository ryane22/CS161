import java.util.*;
import java.io.*;

class WordCounter
{
	WordStore wordbag;
	Scanner reader;

	public WordCounter()
	{
		wordbag = new WordStore();
		reader = new Scanner(System.in);
	}
    
	public void run()
	{
		String command;
		showMenu();
		command = getCommand();
		while(!command.equals("quit"))
		{
			if (command.equals("read"))
			{
				String filename = reader.next();
				processFile(filename);
			}
			else if (command.equals("show"))
			{
				wordbag.showWordList();
			}
			else if (command.equals("find"))
			{
				String target = reader.next();
				System.out.println(target+" occurs "+
						wordbag.getCount(target)+" times");
			}
			else if (command.equals("high"))
			{
				wordbag.findHighest();
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

	private void processFile(String filename)
	{
		Scanner filereader;
		File infile = new File(filename);
		try {
			filereader = new Scanner(infile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Can't open file "+filename);
			return;
		}
		while (filereader.hasNext())
			wordbag.addWord(filereader.next());
	}

	private void showMenu()
	{
		System.out.println();
		System.out.println(" read <filename> // read and store the words in specified text file");
		System.out.println(" show            // show the entire word list");
		System.out.println(" find <string>   // show the frequency of the specified string");
		System.out.println(" high            // show the word with the highest frequency");
		System.out.println(" help            // display the menu");
		System.out.println(" quit            // terminate the program");
		System.out.println();
	}

	public static void main(String[] args)
	{
	    WordCounter driver = new WordCounter();
	    driver.run();
	}
}















