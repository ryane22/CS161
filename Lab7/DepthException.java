public class DepthException extends Exception
{
   public String getMessage()
   {
      return new String("Maximum depth exceeded");
   }
}