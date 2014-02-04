import java.util.*;

public class NumberMatrix
{
   int [][] matrix;
   int rowcount;
   int colcount;
	Index2D index;

   Scanner reader;

   public NumberMatrix()
   {
      rowcount = 0; 
      colcount = 0;
   }

   private void fillMatrix()
   {
      Random generator = new Random();
      int i, j;
      for (i=0; i<rowcount; i++)
         for (j=0; j<colcount; j++)
            matrix[i][j] = generator.nextInt(100);
   }

   public void initMatrix(int rows, int cols)
   {
      int i, j;
      rowcount = rows;
      colcount = cols;
      matrix = new int[rowcount][colcount];
      fillMatrix();
   }
   
   public Index2D find (int target)   
   {
		
      for (int i=0; i<rowcount; i++)
		{
			for (int j=0; j<colcount; j++)
			{
				if (target == matrix[i][j])
				{
					return index = new Index2D(i,j);
				}
			}
		}
      return null;
   }
   
   public void showMatrix()
   {
      int i, j;
      for (i=0; i<rowcount; i++)
      {
         System.out.println();
         for (j=0; j<colcount; j++)
            System.out.printf("%4d", matrix[i][j]);
      }
      System.out.println();
   }
}