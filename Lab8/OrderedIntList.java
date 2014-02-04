import java.util.*;
class OrderedIntList
{
   int [] values;
   int capacity = 0;
   int intcount = 0;
	String numberstring = "";
   Random random;

   public OrderedIntList()
   {
      random = new Random();
      reset(0);
   }

   public void reset(int c)
   {
      capacity = c;
      values = new int[capacity];
      intcount = 0;
   }

   public void randomFill(int maxval)
   {
      for (int i=0; i<capacity; i++)
         add(random.nextInt(maxval));
   }

   public void add(int newval)
   {  // this add method keeps values in order as they are
      // inserted
      if (intcount == capacity)
      {
         System.err.println("The array is full");
         return;
      }
      int i = intcount;
      while (i > 0 && values[i-1] > newval)
      {
         values[i] = values[i-1];
         i = i - 1;
      }
      values[i] = newval;
      intcount++;
   }
   
   public void delete (int target)
   {  // this method deletes one occurrence of the target value from the list.  It has no
      // effect if the target value is not in the list.
      int index, tcount;
      index = tcount = 0;
      while (index < intcount)
      {
      	if (values[index] == target)
      		tcount++;
      	else
      		values[index-tcount] = values[index];
      	index++;
      }
      intcount = intcount - tcount;
   }   
   
   public boolean find (int target)
   {
		return find(target, 0);
   }
   
   private boolean find (int target, int start)
	{
		if (start <= capacity-1)
		{
			if (target == values[start])
				return true;
			else
				return find(target, start+1);
		}
		else
			return false;
	}   
   
   public int size()
   {
      return intcount;
   }   
   
   public String toString()
   {
		numberstring = "";
		return toString(0);
   }

	private String toString(int index)
	{
		if (index <= intcount-1)
		{
			if (index == 0)
            numberstring = numberstring + values[0];
			else
				numberstring = numberstring + " " + values[index];
			return toString(index+1);
		}
		else 
			return numberstring;
	}
}
