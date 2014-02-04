class PalindromeTest
{
	public static  boolean isPalindrome(String str)
	{
		// a string is a palindrome if its length is less than 2
		// or if the first and last characters are the same and
		// everything in between is a palindrome
		if (str.length()==1)
			return true;
		else if (str.charAt(0) == str.charAt(str.length()-1))
			return isPalindrome(str.substring(1,str.length()-1));
		else
			return false;
	}
	
	public static void main (String[] args)
	{
		if (isPalindrome(args[0]))
			System.out.println(args[0] + " is a palindrome");
		else
			System.out.println(args[0] + " is not a palindrome");
	}
}
