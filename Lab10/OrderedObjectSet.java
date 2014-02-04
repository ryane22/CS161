import java.util.*;

class OrderedObjectSet <ElementType extends Comparable<ElementType>>
         implements Iterable<ElementType>
{
   protected ListNode head;
   protected ListNode tail;
   protected int size;

   public OrderedObjectSet()
   {
      head = null;
      tail = null;
      size = 0;
   }

   public int size()
   {
      return size;
   }

   public boolean add(ElementType newobject)
   {
   	// adds a new node with the specified data object to the list

   	ListNode successor = findGreaterOrEqual(newobject);
   	if (successor == null)
   	{
   		addToBack(newobject);
			size ++;
   		return true;
   	}
      if (successor.value.equals(newobject))
         return false;   // can't add duplicates
      else
      {
       // add code here that creates a new node and inserts it before successor
			ListNode newnode = new ListNode(newobject);
			if (true)
			{
				newnode.next = successor;
				newnode.prev = successor.prev;
				successor.prev.next = newnode;
				successor.prev = newnode;
			}
      }
		size ++;
      return true;
   }

   public boolean delete (ElementType target)
   {  // deletes the first occurrence of target in the list, if it's there,
      // and returns true.  If the target is not there, it returns false.

      ListNode targnode = findGreaterOrEqual(target);
      if (targnode == null || !targnode.value.equals(target))
         return false;
      ListNode previous = targnode.prev;
      if (targnode == head) // delete the head node
      {
         head = targnode.next;
         if (head != null)
            head.prev = null;
         else
            tail = null;
      }
      else if (targnode == tail)  // delete the tail node
      {
         previous.next = null;
         tail = previous;
      }
      else  // delete a node from the middle
      {
         previous.next = targnode.next;
         targnode.next.prev = previous;
      }
      size--;
      return true;
   }

   public void clear()
   {
      head = null;
      tail = null;
      size = 0;
   }

   public boolean contains(ElementType target)
   {
      // add code here to determine if the target object is in the set
		ListNode currentnode = head;
		while (currentnode != null)
		{
			if (currentnode.value.compareTo(target) != 0)
				currentnode = currentnode.next;
			else
				return true;
		}
      return false;
   }

   private ListNode findGreaterOrEqual(ElementType target)
   {  // this method returns a reference to the first node in the list with a value
      // greater than or equal to the target

      ListNode currentnode = head;
      while (currentnode != null && currentnode.value.compareTo(target) < 0)
         currentnode = currentnode.next;
      return currentnode;
   }

   private void addToBack(ElementType v)
   {
      // adds a new node with the specified value to the
      // tail of the list
		ListNode newnode = new ListNode(v);
		if (tail != null)
		{
			tail.next = newnode;
			tail.next.prev = tail;
			tail = newnode;
		}
		else
		{
			head = newnode;
			tail = newnode;
		}
   }

   public Iterator<ElementType>  iterator()
   {
      return new Cursor();
   }

   protected class Cursor implements Iterator<ElementType>
   {
      ListNode cursor = head;

      public boolean hasNext()
      {
         return cursor != null;
      }

      public ElementType next()
      {
         if (hasNext())
         {
            ElementType nextobject = cursor.value;
            cursor = cursor.next;
            return nextobject;
         }
         else
            return null;
      }

      public void remove()
      {   // iterator-based node removal is not implemented
         System.out.println("Iterator-based node removal is not supported");
      }
   }

   protected class ListNode
   {
      ElementType value;
      ListNode next;
      ListNode prev;

      public ListNode(ElementType o)
      {
         value = o;
         next = null;
         prev = null;
      }
   }
}
