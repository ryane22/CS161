import java.util.*;
import java.io.*;

class ExpressionDialog
{
   Scanner keyreader;
   Calculator calc;
   PrintStream logfile;

   public ExpressionDialog()
   {
      keyreader = new Scanner(System.in);
      calc = new Calculator();
   }
    
   public void run()
   {
      String expression;
      float result = 0;
      showMenu();
      expression = getNextExpression();
      while(!expression.equals("quit"))
      {
			if (expression.contains("log"))
			{
				if (expression.contains("off"))
				{
					logfile.close();
					expression = getNextExpression();
				}
				else
				{
					String fileName = expression.replaceFirst("log ", "");
					setLogFile(fileName);
					expression = getNextExpression();
				}
			}
			else
			{
         	calc.setExpression(expression);
				try
				{
         	result = calc.evalExp();
				}
				catch (NumberFormatException s)
				{
					System.out.println("Cannot Parse");
					System.out.println("Please Try Again");
					result = 0;
				}

         	System.out.println("=> " + result);
         	if (logfile != null)
         	{
            	logfile.println(expression);
            	logfile.println("=> " + result);
         	}
         	expression = getNextExpression();
			}
      }
      if (logfile != null)
         logfile.close();
   }

   private String getNextExpression()
   {
      System.out.print("? ");
      return keyreader.nextLine();
   }

   private void showMenu()
   {
		System.out.println();
      System.out.println("Enter a simple arithmetic expression");
		System.out.println("log <filename>");
		System.out.println("log off");
      System.out.println("Or enter \"quit\" to terminate the program");
   }
   
   private void setLogFile(String filename)
   {
      try
      {
         logfile = new PrintStream(filename);
      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }  
   }

   public static void main(String[] args)
   {
      ExpressionDialog dialog = new ExpressionDialog();
      if (args.length > 0)
         dialog.setLogFile(args[0]);
      dialog.run();
   }
}















