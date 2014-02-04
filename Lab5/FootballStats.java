import java.util.*;
import java.io.*;

class FootballStats
{
   String[] teams;
   double[] ppg;
   private final int NUMBER_OF_TEAMS = 32;

   public FootballStats()
   {
		teams = new String[32];
		ppg = new double[32];
		loadData();
   }

	private void loadData()
	{
		Scanner reader;
		try
		{
			reader = new Scanner(new File("teamdata.txt"));
		}
		catch (IOException e)
		{
			System.out.println("Error accessing \"teamdata.txt\": " + e.getMessage());
			return;
		}
		int index = 0;
		while (reader.hasNext())
		{
			String datastring = reader.nextLine();
			String [] datapair = datastring.split(",");
			teams[index] = datapair[0];
			ppg[index] = Double.parseDouble(datapair[1]);
			index++;
		}
	}

   private void showStats(){
   
		System.out.println("\n	TEAM	  	PPG");
		System.out.println("============================");
		
		for(int x=0;x<teams.length; x++){
			System.out.printf("%21s %5.1f\n", teams[x], ppg[x]); 
		}
   }
   
   private void highest(){
   	
		double highest = 0;
		String team = "none";
		for (int x=0; x<teams.length;x++)
		{
			if (ppg[x] > highest)
			{
				highest = ppg[x];
				team = teams[x];
			}
		}
		System.out.println();
		System.out.printf("Team %s has the highest ppg of %6.1f\n", team, highest); 
   }
   
   public static void main(String[] args)
   {
      FootballStats stats = new FootballStats();
      stats.showStats();
      stats.highest();
   }
}
