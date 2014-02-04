
public class MethodChain
{
   public void method1(int level) throws DepthException
   {
      System.out.println("Method 1 starting");
      if (level > 0)
         method2(level - 1);
      System.out.println("Method 1 returning");
   }

   public void method2(int level) throws DepthException
   {
      System.out.println("Method 2 starting");
      if (level > 0)
         method3(level - 1);
      System.out.println("Method 2 returning");
   }

   public void method3(int level) throws DepthException
   {
      System.out.println("Method 3 starting");
      if (level > 0)
         throw new DepthException();
      System.out.println("Method 3 returning");
   }
}
