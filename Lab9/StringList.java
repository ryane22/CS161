import java.io.*;

class StringList
{
   ListNode head, tail;

   public StringList()
   {   // create a new empty list
      head = null;
      tail = null;
   }

   public void clear()
   {
      head = null;
      tail = null;
   }

   public void addToFront (String s)
   {   // add a new value at the head of the list
      ListNode newnode = new ListNode(s);
      newnode.next = head;
      head = newnode;
      if (tail == null)
      	tail = newnode;
   }

	public void addToBack (String s)
	{	// add new value to tail end of list
		ListNode newnode = new ListNode(s);
		if (tail != null)
		{
			tail.next = newnode;
			tail = newnode;
		}
		else
		{
			head = newnode;
			tail = newnode;
		}
	}

  public boolean delete (String s)
   {
	// This method deletes the string s from the list and returns true.
	// If s is not in the list, nothing is deleted and false is returned.

		ListNode current = head;
		ListNode previous = null;
		while (current != null && !current.data.equals(s))
		{
			previous = current;
			current = current.next;
		}
		if (current == null)
			return false;
		if (previous == null)
		{  // delete the head node
			head = head.next;
		}
		else
		{  // delete some node other than the head
			previous.next = current.next;
		}
		return true;
   }

   public boolean find (String target)
   {
		ListNode current = head;
		while( current != null)
		{
			if (current.data.equals(target))
				return true;
			current = current.next;
		}
      return false;
   }

	public void printList (PrintStream out)
	{
		ListNode current = head;
		out.println("Current strings:");
		while (current != null)
		{
			out.print(" "+ current.data);
			current = current.next;
		}
		out.println();
	}

   private class ListNode
   {
      private String data;
      private ListNode next;

      public ListNode (String s)
      {
         data = s;
         next = null;
      }
   }
}
