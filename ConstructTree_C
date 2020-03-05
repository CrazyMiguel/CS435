import java.util.*;
public class ConstructTree_C
{
  public static void main(String[] args)
  {
    BST_iter BST = new BST_iter();
    AVL_Iter AVL = new AVL_Iter();
    ArrayList<Integer> arr =getRandomA.getRandomArray(10000);
    long startTimeBSTr = System.currentTimeMillis();
    for(int i=0;i<arr.size();i++)
    {
      BST.insertIter(i);
    }
    long endTimeBSTr = System.currentTimeMillis();
    long timeBSTr =  ((endTimeBSTr-startTimeBSTr));
    System.out.println(timeBSTr + "ms");

    long startTimeAVL = System.currentTimeMillis();
    for(int i=0;i<arr.size();i++)
    {
      AVL.insertIter(i);
    }
    long endTimeAVL = System.currentTimeMillis();
    long timeAVL =  ((endTimeAVL- startTimeAVL));
    System.out.println(timeAVL + "ms");
  }
}
