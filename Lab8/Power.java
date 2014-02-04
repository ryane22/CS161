class Power
{
	public static long power (int x, int e)
	{	// raises x to the positive power e
		
		if (e == 0)
			return 1;
		else
			return x * power(x, e-1);

	}
	
	public static void main (String[] args)
	{
		System.out.println(args[0]+ "^" + args[1] + " = " +
				power(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
}