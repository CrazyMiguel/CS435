import java.util.*;
import java.lang.*;
class getRandomA
{
  public static ArrayList<Integer> getRandomArray(int n)
  {
    Random rand = new Random();
    ArrayList<Integer> arr = new ArrayList<Integer>();
    int arraysize=0;
    while(arraysize<n)
    {
      int r=rand.nextInt(n)+1;
      if(!arr.contains(r))
      {
        arr.add(r);
        arraysize++;
      }
    }
    return arr;
  }
  public static void main(String[] Args)
  {
    ArrayList<Integer> arr=getRandomArray(100);
    for(int i=0;i<arr.size();i++)
    {
      System.out.println(arr.get(i));
    }
  }
}
