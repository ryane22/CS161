
class Queue<ItemType>
{
   ListNode head, tail;

   public Queue()
   {   // create a new empty list
      head = null;
      tail = null;
   }

   public void clear()
   {
      head = null;
      tail = null;
   }

	public void enqueue (ItemType s)
	{
		ListNode newnode = new ListNode(s);
		if (tail == null)
			head = tail = newnode;
		else
		{
      	tail.next = newnode;
      	tail = newnode;
		}
	}

  public ItemType dequeue()
   {
		ItemType val = head.data;
		head = head.next;
		if (head == null)
			tail = null;
		return val;
   }

	public boolean isEmpty()
	{
		return head == null;
	}

	private void showList()
	{
		ListNode current = head;
		while (current != null)
		{
			System.out.println(" " + current.data);
			current = current.next;
		}
	}
		

   private class ListNode
   {
      private ItemType data;
      private ListNode next;

      public ListNode (ItemType s)
      {
         data = s;
         next = null;
      }
   }
}
