public class Calculator
{
   String expstring;
   int cursor;
	
   public Calculator()
   {
      expstring = null;
   }
	
   public Calculator(String instring)
   {
   	expstring = instring;
   	cursor = 0;
   }

   public void setExpression(String estring)
   {
      expstring = estring;
      cursor = 0;
   }

   public float evalExp()
   {
      if (expstring == null)
      {
         System.err.println("There is no expression to evaluate.");
         System.err.println("Call setExpression() before calling getResult().");
         return 0;
      }
      cursor = 0;
      float result = evalTerm();
      while (nextOperator('+'))
      {
         char operator = getOperator();
         float term = evalTerm();
         if (operator == '+')
            result = result + term;
         else
            System.err.println("Invalid operator: " + operator);
      }
      while (nextOperator('-'))
      {
	 char operator = getOperator();
	 float term = evalTerm();
	 if (operator == '-')
	    result = result - term;
	 else
	    break;
      }
      return result;
   }
	
   private float evalTerm()
   {
      float result = getOperand();
      while (nextOperator('*'))
      {
         char operator = getOperator();
         float term = getOperand();
         if (operator == '*')
            result = result * term;
         else
            break;
      }
      while (nextOperator('/'))
      {
	 char operator = getOperator();
	 float term = getOperand();
	 if (operator == '/')
	    result = result / term;
	 else
	    break;
      }
      return result;
   }	
	
   private float getOperand()
   {
      if (cursor >= expstring.length())
         return 0;
      String opstring = "";
      char nextchar = expstring.charAt(cursor);
      if (nextchar == '-')
      {
         opstring = opstring + '-';
         cursor++;
         nextchar = expstring.charAt(cursor);
      }
      while (cursor < expstring.length() && !isOperator(nextchar))
      {
         opstring = opstring + nextchar;
         cursor++;
         if (cursor < expstring.length())
            nextchar = expstring.charAt(cursor);
      }

      return Float.parseFloat(opstring);
   }
	
   private char getOperator()
   {
      char operator = expstring.charAt(cursor);
      cursor++;
      return operator;
   }
   
   private boolean nextOperator(char op)
   {
      if (cursor < expstring.length() && expstring.charAt(cursor) == op)
         return true;
      else
         return false;
   }
   
   private boolean isOperator(char c)
   {
      String opset = "+-*/";
      return (opset.indexOf(c) >= 0);
   }
}