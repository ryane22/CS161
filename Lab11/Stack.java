
public class Stack <ItemType>
{
   ItemType [] values;
   int capacity;
   int top = -1;

   public Stack(int size)
   {
      capacity = size;
      values = (ItemType[]) new Object[capacity];
   }
   
   public void push(ItemType newval)
   {
      if (top == capacity - 1)
         expand();
      top = top + 1;
      values[top] = newval;
   }

   public ItemType pop()
   {
		// Add code here   	
		top = top - 1;
		return values[top + 1];
   }

	public boolean isEmpty()
   {
      return top == -1;
   }
   
   public int getCapacity()
   {
      return capacity;
   }

   public void showValues()
   {
      System.out.println("Current values:");
      for (int i=0; i<=top; i++)
         System.out.print(" " + values[i].toString());
      System.out.println();
   }
   
   private void expand()
   {
      // This method creates a new array with twice the capacity of the old one,
      // and copies the values from the old array to the new one.
      capacity = capacity * 2;
      ItemType [] newarray = (ItemType[]) new Object[capacity];
      System.arraycopy(values, 0, newarray, 0, capacity/2);
      values = newarray;
   }
}
