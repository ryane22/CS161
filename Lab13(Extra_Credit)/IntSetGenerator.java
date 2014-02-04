import java.util.*;

class IntSetGenerator implements InstanceGenerator
{
    public Object makeInstance(long seed, int p1, int p2)
    {
	return makeIntSet(seed, p1, p2);
    }

    public int[] makeIntSet(long seed, int size, int max)
    {
	int count = 0;
	int [] iset = new int[size];
	Random randgen = new Random(seed);
	while (count < size)
	{
	    iset[count] = randgen.nextInt(max)+1;
	    count++;
	}
	return iset;
    }
}
