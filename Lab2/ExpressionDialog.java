import java.util.*;

class ExpressionDialog
{
   Scanner keyreader;
   Calculator calc;

   public ExpressionDialog()
   {
      keyreader = new Scanner(System.in);
      calc = new Calculator();
   }
    
   public void run()
   {
      String expression;
      showMenu();
      expression = getNextExpression();
      while(!expression.equals("quit"))
      {
         calc.setExpression(expression);
         System.out.print(expression + " = ");
         System.out.println(calc.getResult());
         expression = getNextExpression();
      }
   }

   private String getNextExpression()
   {
      System.out.print("? ");
      return keyreader.next();
   }

   private void showMenu()
   {
      System.out.println("Enter a simple arithmetic expression");
      System.out.println("Or enter \"quit\" to terminate the program");
   }

   public static void main(String[] args)
   {
      ExpressionDialog dialog = new ExpressionDialog();
      dialog.run();
   }
}















