import java.util.*;
class OrderedIntList
{
   int [] values;
   int capacity = 0;
   int intcount = 0;
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
   {  
		for (int x=0;x<values.length;x++)
		{
			if (target==values[x])
			{
				for (int y=x; y<(values.length-1);y++)
					values[y]=values[y+1];
				intcount = intcount-1;
				break;
			}
			else
			{
				System.out.println("Number not in list");
				break;
			}
		}
   }   
   
   public boolean find (int target)
   {
      for (int i=0; i<intcount; i++)
         if (values[i] == target)
            return true;
      return false;
   }
   
   public int size()
   {
      return intcount;
   }   
   
   public String toString()
   {
      String numberstring = "";
      for (int i=0; i<intcount; i++)
         if (i == 0)
            numberstring = numberstring + values[0];
         else
            numberstring = numberstring + " " + values[i];
      return numberstring;
   }

	public float findMean()
	{
		float total = 0;
		float average = 0;
		int x=0;
		for (x=0; x<intcount;x++)
		{
			total = total + values[x];
		}
		average = total/intcount;
		return average;
	}

	public float findMedian()
	{
		if ((intcount % 2) == 0)
		{
			float median = ((float)values[(intcount/2)-1]+values[(intcount/2)])/2;
			return median;
		}
		else
		{
			return (values[(intcount/2)]);
		}
	}
}
