import java.io.*;
import java.util.*;
import java.util.regex.*;

class WordReader
{
    // This program reads and displays an input file in a specified number of columns,
    // as specified by the user.

    Scanner inreader, filereader;
    File infile;
 
    public WordReader()
    {
        inreader = new Scanner(System.in);
    }

    public void run()
    {
        String command;
        showMenu();
        command = getCommand();
        while(!command.equals("quit"))
        {
            if (command.equals("open"))
                infile = new File(inreader.next());
            else if (command.equals("display"))
                display(inreader.nextInt());
				else if (command.equals("wordLength"))
					 wordlength(inreader.nextInt());
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

	private void wordlength(int n) //n is the length entered by the user
	{
		setUpReader();
		int wordcount = 0;
		while(filereader != null && filereader.hasNext())
		{
			String nextWord = "";
			nextWord = filereader.next();
			if (nextWord.length() >= n)
			{
				System.out.println(nextWord);
				wordcount++;
			}
		}
		System.out.println();
		System.out.println("Word Count: " + wordcount);
	}

    private void display(int maxlinewidth)
    {
        String space = "";
        int wordcount = 0;
        int width = 0;  // the current width of the current output line
        setUpReader();
        while (filereader != null && filereader.hasNext())
        {
            // This loop reads one word in each iteration.  If the word will not fit on
            // the current output line, a new line is printed before the word is printed.
				String nextWord = "";
				nextWord = filereader.next();
				width = width + nextWord.length() + 1;
				wordcount ++;
				if (width < maxlinewidth)
				{
					System.out.print(nextWord + " ");
				}
				else if (width == maxlinewidth)
				{
					System.out.println(nextWord);
					width = 0;
				}
				else
				{
					width = 0;
					System.out.println();
					System.out.print(nextWord + " ");
					width = nextWord.length() +1;
				}
        }
        System.out.println();
        System.out.println();
        System.out.println("Word count: " + wordcount);
    }   

    private String getCommand()
    {
        System.out.print("? ");
        return inreader.next();
    }

    private void showMenu()
    {
        System.out.println("    open <file>    // open the specified file");
        System.out.println("    display <n>    // display the current text in <n> columns");
		  System.out.println("    wordLength <n> // display all words in the file with length >=n");
        System.out.println("    help           // show the menu");
        System.out.println("    quit           // terminate the program");
    }

    private void setUpReader()
    {
        if (infile == null)
        {
            System.out.println("You must open a file before it can be displayed");
            return;
        }
        try
        {
            filereader = new Scanner(infile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println
                ("File " + infile.getName() + " cannot be opened for reading");
        }
    }
    
    public static void main(String[] args)
    {
        WordReader tester = new WordReader();
        tester.run();
    }
}

