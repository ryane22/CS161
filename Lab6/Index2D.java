public class Index2D
{
   public int row;
   public int column;
   
   public Index2D (int r, int c)
   {
      row = r;
      column = c;
   }
   
   public String toString()
   {
      return new String("(" + row + "," +column + ")");
   }
}