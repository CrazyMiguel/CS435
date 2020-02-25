import java.util.*;
import java.lang.*;
class getSortedA
{
  public static int[] getSortedArray(int n)
  {
    int[] arr = new int[n];
    int j=arr.length;
    for(int i=0;i<n;i++)
    {
      arr[i]=j;
      j--;
    }
    return arr;
  }
  public static void main(String[] Args)
  {
    int[] arr=getSortedArray(100);
    for(int i=0;i<arr.length;i++)
    {
      System.out.println(arr[i]);
    }
  }
}
