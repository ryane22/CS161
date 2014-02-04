
class SearchTree
{
   TreeNode root;
   int size;

   public SearchTree()
   {   // create a new empty tree
      root = null;
      size = 0;
   }

   public void clear()
   {
      root = null;
      size = 0;
   }

   public int size()
   {
      return size;
   }

   private int size(TreeNode subroot)
   {
      if (subroot == null)
         return 0;
      else
         return 1 + size(subroot.left) + size(subroot.right);
   }

   public int height()
   {  // The height of a tree is the length of the longest path from root to leaf.
   	// A null tree has height -1.
      return height(root);
   }

   private int height(TreeNode subroot)
   {
 		//  ***  add code here
		if (subroot == null)
			return -1;
		else
		{
			if (1 + height(subroot.left) < 1 + height(subroot.right))
				return 1 + height(subroot.right);
			else
				return 1 + height(subroot.left);
		}
   }

   public void add (int value)
   {   // insert the new value the search tree
      TreeNode newnode = new TreeNode(value);
      if (root == null)
         root = newnode;
      else
         addNode(root, newnode);
      size++;
   }

   private void addNode(TreeNode subroot, TreeNode node)
   {
   	
   	// ***  replace this with search tree insertion code
		if (node.value <= subroot.value)
		{
			if (subroot.left == null)
			{
				node.parent = subroot;
				subroot.left = node;
			}
			else
				addNode(subroot.left, node);
		}
		else
		{
			if (subroot.right == null)
			{
				node.parent = subroot;
				subroot.right = node;
			}
			else
				addNode(subroot.right, node);
		}
      //node.left = subroot.left;                     /*what does this do?*/
      //node.parent = subroot;
      //subroot.left = node;
   }   
   
   public boolean delete(int target)
   {
      TreeNode targnode = findNode(root, target);
      if (targnode == null)
         return false;
      if (targnode.childCount() < 2)
         simpleDelete(targnode);
      else  // node to be deleted has two non-empty subtrees
      {
         // ***  add code here
			TreeNode replacenode = getFirst(targnode.right);
			targnode.value = replacenode.value;
			simpleDelete(replacenode);
      }
      size--;
      return true;
   }

   private void simpleDelete(TreeNode node)
   {   // delete a node that has at least one null child
      TreeNode parent = node.parent;
      TreeNode subroot = null;
      if (node.left!= null)
         subroot = node.left;
      else
         subroot = node.right;
      if (subroot != null)
         subroot.parent = parent;
      if (parent == null)
         root = subroot;
      else if (parent.left == node)
         parent.left = subroot;
      else parent.right = subroot;
    }

   private TreeNode getFirst(TreeNode subroot)
   {  // this method returns a pointer to the first (lowest value) node in the specified subtree
		if (subroot == null)
         return null;
      while (subroot.left != null)
         subroot = subroot.left;
      return subroot;
   }
   
   public String toString()
   {
      return treeString(root);
   }

   private String treeString(TreeNode node)
   {
      String tstring;
      if (node == null)
         tstring = "~";
      else
      {
         tstring = ""+node.value;
         if (node.left != null || node.right != null)
         tstring += "(" + treeString(node.left) + ","
		            + treeString(node.right) + ")";
      }
      return tstring;
   }

   public boolean find(int target)
   {
      return findNode(root, target) != null;
   }

   private TreeNode findNode (TreeNode subroot, int target)
   {
      //  ***  replace code here to search for the target
      //       following one path from the root
		if (subroot == null)
			return null;
		else
		{
			if (target == subroot.value)
				return subroot;
			else if (target < subroot.value)
				return findNode(subroot.left, target);
			else if (target > subroot.value)
				return findNode(subroot.right, target);
			else
				return null;
		}
   }

   private class TreeNode
   {
      private int value;
      private TreeNode left;
      private TreeNode right;
      private TreeNode parent;

      public TreeNode (int val)
      {
         value = val;
         left = right = null;
      }
      
      public int childCount()
      {
         int count = 0;
         if (left != null) count++;
         if (right != null) count++;
         return count;
      }
   }
}
