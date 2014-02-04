import java.io.*;
import java.util.*;

class FileCopier
{
    // This program copies an input file to an output file.  It uses a Scanner
    // object to read the input file and a PrintStream object to write the
    // output file.

    Scanner inreader, filereader;
    PrintStream filewriter;
    String infilename, outfilename;

    public FileCopier(String inname, String outname)
    {
        inreader = new Scanner(System.in);
        infilename = inname;
        outfilename = outname;
    }
   
    public FileCopier(String inname)
    {
        inreader = new Scanner(System.in);
        infilename = inname;
    }
   
    public FileCopier()
    {
        inreader = new Scanner(System.in);
    }
    
    public void run()
    {
        if (infilename == null)
        {
            System.out.print("Input filename: ");
            infilename = inreader.next();
        }
        setUpFileReader();
        if (outfilename == null)
        {
            System.out.print("Output filename: ");
            outfilename = inreader.next();
        }
        if (outfilename.equals("none"))
            filewriter = null;
        else 
            setUpFileWriter();

        // Print and write to file
        System.out.println(infilename + ":");
		  int x = 1;
        while (filereader.hasNextLine())
        {
            String nextline = filereader.nextLine();
            System.out.println(x + ") " + nextline);
            if (filewriter != null)
                filewriter.println(x + ") " + nextline);
				x = x + 1;
        }
        if (filewriter != null)
            filewriter.close();
    }

    private void setUpFileReader()
    {
        File infile = new File(infilename);
        try
        {
            filereader = new Scanner(infile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println
                ("File " + infilename + " cannot be opened for reading");
        }
    }

    private void setUpFileWriter()
    {
        try 
        {
            filewriter = new PrintStream(outfilename);
        }
        catch (IOException e)
        {
            System.out.println
                ("File " + outfilename + " cannot be opened for writing");
        }
    }

    public static void main(String[] args)
    {
        // This main method allows one or two file names to be supplied by the user as
        // command-line arguments.  If only one argument is supplied, it is assumed to be the
        // name of the input file.  The run() method will prompt the user for file names that
        // are not included on the command line.
        FileCopier tester;
        if (args.length == 1)
            tester = new FileCopier(args[0]);
        else if (args.length == 2)
            tester = new FileCopier(args[0], args[1]);
        else
            tester = new FileCopier();
        tester.run();
    }
}















