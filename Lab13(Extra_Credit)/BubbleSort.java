class BubbleSort extends DecisionAlgorithm
{
    int [] intset;
    long stepcount = 0;
    int numcount = 0;
    int maxdepth = 0;

    public BubbleSort()
    {
      name = "Bubble Sort";
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
      return numcount;
    }

    public boolean getBooleanResult()
    {
      return orderCheck();
    }

    public void run()
    {
      stepcount = 0;
      sortSet();
    }

   public void sortSet()
   {
      boolean orderchanged = false;
      int highindex = numcount;
      do
      {
         for (int pos=1; pos<highindex; pos++)
         {
            if (intset[pos-1] > intset[pos])
            {
               swap(pos-1, pos);
               orderchanged = true;
            }
            stepcount = stepcount + 1;
         }
         highindex = highindex - 1;
      }  while (orderchanged && highindex > 0);
   }

   private void swap(int index1, int index2)
   {
      int temp = intset[index1];
      intset[index1] = intset[index2];
      intset[index2] = temp;
   }

   private boolean orderCheck()
   {
      for (int i=0; i<numcount-1; i++)
         if (intset[i] > intset[i+1])
            return false;
      return true;
   }
}
