import java.util.*;
import java.io.*;

/**
 * This class is an extension of BufferedReader that provides methods for
 * reading strings, integers, and fixed point numbers from a text file. It is
 * designed for convenient extraction of strings and numbers from a file where
 * white space characters (spaces, tabs, and newline characters) serve as
 * delimiters between data items.
 * @author Thomas E. O'Neil
 * @version 1.1
 */
public class TextReader extends BufferedReader
{
    /**
     * This field stores the last character that was read from the system's
     * input buffer.
     * @since 1.0
     */
    int prevchar;

    /**
     * This constructor creates a new TextReader for the file that is supplied
     * as a parameter.  
     * @param file a reference to a File object.
     * @throws FileNotFoundException if, for some reason, the file cannot be
     * opened for reading
     * @since 1.0
     */
    public TextReader(File file) throws FileNotFoundException
    {
	super(new FileReader(file));
	prevchar = ' ';
    }

    /**
     * This constructor creates a new TextReader for the InputStream object
     * (such as System.in) that is supplied as a parameter.
     * @param in a reference to an InputStream object.
     * @since 1.0
     */
    public TextReader(InputStream in)
    {
	super(new InputStreamReader(in));
	prevchar = ' ';
    }

    /**
     * This method reads the next character from the input file or stream.
     * @return the next character from the input stream.
     * @throws IOException if an I/O error occurs
     * @throws EOFException if there are no more characters in the stream.
     * @since 1.1
     */
    public char readChar() throws IOException, EOFException
    {
        int nextchar = super.read();
	prevchar = nextchar;
	if (nextchar == -1)
	    throw new EOFException();
	return (char) nextchar;
    }

    /**
     * This method returns the next line of characters from the input stream
     * as a string.  Its behavior is consistent with BufferedReader.readLine(),
     * which returns null when there are no more lines to read (rather than
     * throwing EOFException).
     * @see java.io.BufferedReader#readLine
     * @return the next line of characters from the input stream.
     * @throws IOException if an I/O error occurs
     * @since 1.1
     */
    public String readLine() throws IOException
    {
	String s = super.readLine();
	if (s == null)
	    prevchar = -1;
	else
	    prevchar = '\n';
	return s;
    }

    /**
     * This method reads the next string of non-transparent characters from the
     * input file or stream.  It skips over leading transparent characters
     * (such as spaces, tabs, or newlines),
     * reads a sequence of non-transparent characters, and stops reading when
     * it reaches the next transparent character.
     * @return a string of non-transparent characters.
     * @throws IOException if an I/O error occurs.
     * @throws EOFException if the end of file is reached before a 
     * non-transparent character can be found.
     * @since 1.0
     */
    public String readString() throws IOException, EOFException
    {
	int inchar;
	String instring = "";
	char [] charstring = new char[1];

	skipSpace();
	inchar = prevchar;
	while (!isTransparent(inchar) && inchar != -1)
	{
	    charstring[0] = (char)inchar;
	    instring = instring.concat(new String(charstring));
	    inchar = super.read();
	}
	prevchar = inchar;
	return instring;
    }

    /**
     * This method reads the next string of characters from the
     * input file or stream that is enclosed in double quote marks.
     * It skips over leading transparent characters
     * (such as spaces, tabs, or newlines) till it finds a double quote,
     * reads a sequence of characters, and stops reading when
     * it reaches the second double quote character.
     * @return a string of characters.
     * @throws IOException if the next non-transparent character is not a 
     * double quote.
     * @throws EOFException if the end of file is reached before the closing
     * double quote character can be found.
     * @since 1.0
     */
    public String readQuotedString() throws IOException, EOFException
    {
	int inchar;
	String instring = "";
	char [] charstring = new char[1];

	skipSpace();
	inchar = prevchar;
	if (inchar == '"')
	    inchar = super.read();
        else
	    throw new IOException();
    
	while (inchar != '"' && inchar != -1)
	{
	    charstring[0] = (char)inchar;
	    instring = instring.concat(new String(charstring));
	    inchar = super.read();
	}
	if (inchar == '"')
	    inchar = super.read();
	prevchar = inchar;
	if (inchar == -1)
	    throw new EOFException();
	return instring;	
    }

    /**
     * This method reads the next signed or unsigned integer from the
     * input file or stream.
     * It skips over leading transparent characters
     * (such as spaces, tabs, or newlines) till it finds a +, -, or digit,
     * reads a sequence of digits, and stops reading when
     * it reaches a character that is not a digit.
     * @return the integer value of a digit string.
     * @throws IOException if the next non-transparent character is not a
     * digit or + or -.
     * @throws EOFException if the end of file is reached before a digit can
     * be found.
     * @since 1.0
     */
    public int readInt() throws IOException, EOFException
    {
	int inchar;
	int polarity = 1;
	int value = 0;

	skipSpace();
	inchar = prevchar;
	if (inchar == '+')
	{
	    polarity = 1;
	    inchar = super.read();
	}
	else if (inchar == '-')
	{
	    polarity = -1;
	    inchar =  super.read();
	}
	else polarity = 1;
	if (!Character.isDigit((char) inchar))
	{
	    prevchar = inchar;
	    throw new IOException("Invalid character for integer");
	}
	while (Character.isDigit((char)inchar))
	{
	    value = value * 10 + Character.digit((char)inchar, 10);
	    inchar = super.read();
	}
	prevchar = inchar;
	return value * polarity;
    }

    /**
     * This method reads the next signed or unsigned long integer from the
     * input file or stream.
     * It skips over leading transparent characters
     * (such as spaces, tabs, or newlines) till it finds a +, -, or digit,
     * reads a sequence of digits, and stops reading when
     * it reaches a character that is not a digit.
     * @return the long integer value of a digit string.
     * @throws IOException if the next non-transparent character is not a
     * digit or + or -.
     * @throws EOFException if the end of file is reached before a digit can
     * be found.
     * @since 1.0
     */
    public long readLong() throws IOException, EOFException
    {
	int inchar;
	int polarity = 1;
	long value = 0;

	skipSpace();
	inchar = prevchar;
	if (inchar == '+')
	{
	    polarity = 1;
	    inchar = super.read();
	}
	else if (inchar == '-')
	{
	    polarity = -1;
	    inchar =  super.read();
	}
	else polarity = 1;
	if (!Character.isDigit((char) inchar))
	{
	    prevchar = inchar;
	    throw new IOException("Invalid character for integer");
	}
	while (Character.isDigit((char)inchar))
	{
	    value = value * 10 + Character.digit((char)inchar, 10);
	    inchar = super.read();
	}
	prevchar = inchar;
	return value * polarity;
    }

    /**
     * This method reads the next signed or unsigned fixed point number
     * from the input file or stream.
     * It skips over leading transparent characters
     * (such as spaces, tabs, or newlines) till it finds a +, -, or digit,
     * reads a sequence of digits optionally followed by a decimal point and
     * another string of digits, and stops reading when
     * it reaches a character that is not a digit.
     * @return the float value of a digit string.
     * @throws IOException if the next non-transparent character is not a
     * digit or + or -.
     * @throws EOFException if the end of file is reached before a digit can
     * be found.
     * @since 1.0
     */
    public float readFloat() throws IOException, EOFException
    {
	int inchar;
	int polarity = 1;
	float value = 0, place = (float) 1.0;

	skipSpace();
	inchar = prevchar;
	if (inchar == '+')
	{
	    polarity = 1;
	    inchar = super.read();
	}
	else if (inchar == '-')
	{
	    polarity = -1;
	    inchar = super.read();
	}
	else polarity = 1;
	if (!Character.isDigit((char) inchar))
	{
	    prevchar = inchar;
	    throw new IOException("Invalid character for integer");
	}
	while (Character.isDigit((char)inchar))
	{
	    value = value * 10 + Character.digit((char)inchar, 10);
	    inchar = super.read();
	}
	if (inchar == '.')
	{
	    inchar = super.read();
	    while (Character.isDigit((char)inchar))
	    {
		place = place * (float) 0.1;
		value = value + place * Character.digit((char)inchar, 10);
		inchar = super.read();
	    }
	}
	prevchar = inchar;
	return value * polarity;
    }

    /**
     * This method attempts to skip n characters in the input stream.
     * @see java.io.BufferedReader#skip
     * @return the number of characters actually skipped
     * @throws IOException if an I/O error occurs
     * @since 1.1
     */
    public long skip(long n) throws IOException
    {
	long actuallyskipped = super.skip(n-1);
	if (actuallyskipped < n-1)
	{
	    prevchar = -1;
	    return actuallyskipped;
	}
	else
	{
	    prevchar = super.read();
	    if (prevchar == -1)
		return n-1;
	    else
		return n;
	}
    }

    /**
     * This method reads skips over non-transparent characters
     * till it finds a transparent character, effectively skipping the current
     * data item in the input file.
     * @throws IOException if an I/O error occurs.
     * @since 1.0
     */
    public void skipItem() throws IOException
    {// skip to next white space
	int inchar = prevchar;
	while (!isTransparent(inchar))
	    inchar = super.read();
	prevchar = inchar;
    }

    /**
     * This method reads and discards characters until it finds a
     * new-line character.  It has no effect if the current character is
     * already a new-line character.  It effectively skips the remainder of 
     * the current line of input.
     * @throws IOException if an I/O error occurs.
     * @since 1.1
     */
    public void skipLine() throws IOException
    {
	int inchar = prevchar;
	while (inchar != '\n')
	    inchar = super.read();
	prevchar = inchar;
    }

    /**
     * This method reads over transparent characters
     * till it finds a non-transparent character, or until it reaches the end
     * of the file.
     * @throws IOException if an I/O error occurs.
     * @throws EOFException if the end of the file is encountered.
     * @since 1.0
     */
    public void skipSpace() throws IOException, EOFException
    {   // skip over white space
	int inchar = prevchar;
	while (isTransparent(inchar))
	    inchar = super.read();
	prevchar = inchar;
	if (inchar == -1)
	    throw new EOFException();
    }

    /**
     * This method determines whether its integer parameter represents a
     * transparent character.  The transparent characters are space, newline
     * (\n), tab (\t), carriage return (\r), and formfeed (\f).
     * @param c a character (passed in as type int).
     * @return true if the input parameter is a transparent character,
     * false otherwise.
     * @since 1.0
     */
    protected boolean isTransparent(int c)
    {
	return (c==' ' || c=='\n' || c=='\t' || c=='\r'|| c=='\f');
    }

    /**
     * This method tells whether the end of the file has been detected.
     * @return true if a previous read operation hit the end of the file.
     * @since 1.0
     */
    public boolean endOfFile()
    {
	return (prevchar == -1);
    }


    /**
     * This method indicates that mark() and reset() are not supported by
     * TextReader.
     * @return false unconditionally.
     * @since 1.1
     */
    public boolean markSupported()
    {
	return false;
    }

    /**
     * This method, inherited from BufferedReader, is not supported by
     * TextReader.  Use readChar() instead.
     * @throws IOException unconditionally.
     * @since 1.1
     */

    public int read() throws IOException
    {
	throw new IOException("Unsupported operation");
    }

    /**
     * This method, inherited from BufferedReader, is not supported by
     * TextReader.
     * @throws IOException unconditionally.
     * @since 1.1
     */

    public int read(char[] cbuf, int off, int len) throws IOException
    {
	throw new IOException("Unsupported operation");
    }

    /**
     * This method, inherited from BufferedReader, is not supported by
     * TextReader.
     * @throws IOException unconditionally.
     * @since 1.1
     */

    public int read(char[] cbuf) throws IOException
    {
	throw new IOException("Unsupported operation");
    }

    /**
     * This method, inherited from BufferedReader, is not supported by
     * TextReader.
     * @throws IOException unconditionally.
     * @since 1.1
     */

    public int read(java.nio.CharBuffer target) throws IOException
    {
	throw new IOException("Unsupported operation");
    }

    /**
     * This method, inherited from BufferedReader, is not supported by
     * TextReader.
     * @throws IOException unconditionally.
     * @since 1.1
     */

    public void mark (int readaheadlimit) throws IOException
    {
	throw new IOException("Unsupported operation");
    }

    /**
     * This method, inherited from BufferedReader, is not supported by
     * TextReader.
     * @throws IOException unconditionally.
     * @since 1.1
     */

    public void reset() throws IOException
    {
	throw new IOException("Unsupported operation");
    }
}

