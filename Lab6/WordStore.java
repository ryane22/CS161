import java.util.*;
class WordStore
{
	WordRecord [] words;
	int capacity = 10;
	int wordcount = 0;

	public WordStore()
	{
		words = new WordRecord [capacity];
	}

	public void addWord(String s)
	{	// if the word is already in the array, its frequency is incremented.
		// Otherwise, a new word record is added to the array.
		String newword = normalize(s);
		int index = findIndex(newword);
		if (index >= 0)
			words[index].incFrequency();
		else
		{
			if (wordcount == capacity)
				expand();
			int k = wordcount;
			while (k>0 && words[k-1].getWord().compareTo(newword) > 0)
			{
				words[k]=words[k-1];
				k = k-1;
			}
			words[k] = new WordRecord(newword);
			wordcount++;

		}
	}

	public int getCount (String s)
	{
		String target = normalize(s);
		int index = findIndex(target);
		if (index == -1)
			return 0;
		else
			return words[index].getFrequency();
	}

	public int getCount()
	{
		return wordcount;
	}

	public void showWordList()
	{
		for (int i=0; i<wordcount; i++)
			System.out.println(words[i].getWord()+": "+words[i].getFrequency());
	}
	
	private String normalize(String s)
	{
		StringBuilder normstring = new StringBuilder();
		int pos = 0;
		while (pos < s.length())
		{
			if (Character.isLetter(s.charAt(pos)))
				normstring.append(Character.toLowerCase(s.charAt(pos)));
			pos++;
		}
		return normstring.toString();
	}	
	
	private int findIndex(String target)
	{
		for (int i=0; i<wordcount; i++)
		{
			if (target.equals(words[i].getWord()))
				return i;
		}
		return -1;
	}	
	
	private void expand()
	{
		int newcap = capacity * 2;
		WordRecord [] tempwords = new WordRecord[newcap];
		for (int i=0; i<wordcount; i++)
			tempwords[i] = words[i];  // shallow copy is ok here
		capacity = newcap;
		words = tempwords;
	}	

	public void findHighest()
	{
		String highWord = "";
		int highWordFreq = 0;
		for (int i=0; i<wordcount; i++)
		{
			if (words[i].getFrequency() > highWordFreq)
			{
				highWordFreq = words[i].getFrequency();
				highWord = words[i].getWord();
			}
		}
		System.out.println(highWord);
	}
	
	private class WordRecord
	{
		String word;
		int frequency;
		public WordRecord (String s)
		{
			word = s;
			frequency = 1;
		}
		
		public String getWord()
		{
			return word;
		}
		
		public int getFrequency()
		{
			return frequency;
		}
		
		public void incFrequency()
		{
			frequency = frequency + 1;
		}
	}
}
