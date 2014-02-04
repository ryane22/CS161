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

   public int getResult()
   {
      if (expstring == null)
      {
         System.err.println("There is no expression to evaluate.");
         System.err.println("Call setExpression() before calling getResult().");
         return 0;
      }
      int result = 0;
      cursor = 0;
      int op1 = getOperand();
      char operator = getOperator();
      int op2 = getOperand();
      switch(operator)
      {
         case '+':
            result = op1 + op2;
            break;
         case '-':
            result = op1 - op2;
            break;
         case '*':
            result = op1 * op2;
            break;
	 case '/':
	    if (op2 == 0)
		{
		System.err.println("Cannot Divide By Zero");
		break;
		}
	    else
		{
		result = op1 / op2;
		break;
		}
	 case '^':
	    result = (int) Math.pow(op1,op2);
	    break;

      }
      return result;
   }
	
   private int getOperand()
   {
      char nextchar = expstring.charAt(cursor);
      int value = 0;
      if (nextchar == '-')
	{
	 cursor++;
	 nextchar = expstring.charAt(cursor);
		while (cursor < expstring.length() && Character.isDigit(nextchar))
      		{
         	value = value * 10 + Character.digit(nextchar, 10);
         	cursor++;
         	if (cursor < expstring.length())
            		nextchar = expstring.charAt(cursor);
      		}
      	 return (value * -1);
	}
      else
	{
      		while (cursor < expstring.length() && Character.isDigit(nextchar))
      		{
         	value = value * 10 + Character.digit(nextchar, 10);
         	cursor++;
         	if (cursor < expstring.length())
            		nextchar = expstring.charAt(cursor);
      		}
      		return value;
   	}
   }

   private char getOperator()
   {
      char operator = expstring.charAt(cursor);
      cursor++;
      return operator;
   }	
}