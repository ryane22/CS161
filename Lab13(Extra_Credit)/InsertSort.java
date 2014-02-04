class InsertSort extends DecisionAlgorithm
{
    int [] intset;
    long stepcount = 0;
    int numcount = 0;
    int maxdepth = 0;

    public InsertSort()
    {
      name = "Insertion Sort";
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
		//  *** Add  insertion sort code here.  
		//      Remember to increment the stepcount field
		//      for each comparison operation.
		int i, j, newValue;
		for (i = 1; i < intset.length; i++) 
		{
			stepcount++;
			newValue = intset[i];
			j = i;
			while (j > 0 && intset[j - 1] > newValue) 
			{
				stepcount++;
				intset[j] = intset[j - 1];
				j--;
			}
			intset[j] = newValue;
		}
    }
    
    private boolean orderCheck()
    {
      for (int i=0; i<numcount-1; i++)
         if (intset[i] > intset[i+1])
            return false;
      return true;
    }
}
