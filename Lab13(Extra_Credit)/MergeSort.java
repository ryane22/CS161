class MergeSort extends DecisionAlgorithm
{
    int [] intset;
    long stepcount = 0;
    int numcount = 0;
    int currentspace;
    int maxspace;

    public MergeSort()
    {
      name = "Merge Sort";
    }

    public void setInstance(Object instance)
    {
      int [] iset = (int[]) instance;
      numcount = iset.length;
      intset = new int [numcount];
      for (int pos=0; pos<numcount; pos++)
         intset[pos] = iset[pos];
    }

    public void setTarget(Long t)
    {
	// not needed
    }

    public long getStepCount()
    {
      return stepcount;
    }

    public long getSpace()
    {
      return maxspace;
    }

    public boolean getBooleanResult()
    {
      return orderCheck();
    }

    public void run()
    {
      stepcount = 0;
      maxspace = currentspace = numcount;
      intset = sortSet(intset);
    }

    public int[] sortSet(int [] iset)
    {
      if (iset.length <= 1)
         return iset;
      int mid = iset.length / 2;
      int leftsize = mid;
      int rightsize = iset.length - mid;
      int [] leftset = new int[leftsize];
      System.arraycopy(iset,0,leftset,0,mid);
      int [] rightset = new int[rightsize];
      System.arraycopy(iset,mid,rightset,0,mid);
      addSpace(leftsize + rightsize);
      leftset = sortSet(leftset);
      rightset = sortSet(rightset);
      iset = merge(leftset, rightset);
      deleteSpace(leftsize + rightsize);
      return iset;
    }

   private int [] merge(int [] set1, int [] set2)
   {
      int pos1 = 0, pos2 = 0;
      int outlength = set1.length + set2.length;
      int [] outset = new int[outlength];
      int value1 = set1[pos1];
      int value2 = set2[pos2];
      addSpace(outlength);
      for (int outpos=0; outpos<outlength; outpos++)
      {
			//  *** Add code here to copy the next element  
			//      from set1 or set2 to outset.  Remember
			//      to increment the stepcount field.
			if (pos1 < set1.length && pos2 < set2.length)
			{
				if (set1[pos1] <= set2[pos2])
				{
					stepcount++;
					outset[outpos] = set1[pos1];
					pos1++;
				}
				else
				{
					stepcount++;
					outset[outpos] = set2[pos2];
					pos2++;
				}
			}
			else if (pos1 < set1.length)
			{
				outset[outpos] = set1[pos1];
				pos1++;
			}
			else
			{
				outset[outpos] = set2[pos2];
				pos2++;
			}
      }
      deleteSpace(outlength);
      return outset;
   }

   private void addSpace(int newspace)
   {
      currentspace = currentspace + newspace;
      if (maxspace < currentspace)
         maxspace = currentspace;
   }
   
   private void deleteSpace(int space)
   {
      currentspace = currentspace - space;
   }

   private boolean orderCheck()
   {
      for (int i=0; i<numcount-1; i++)
         if (intset[i] > intset[i+1])
            return false;
      return true;
   }
}
