import java.util.*;
public class ConstructTree_A
{
  public static void main(String[] args)
  {
    BST_rec BSTr = new BST_rec();
    AVL_Iter AVL = new AVL_Iter();
    ArrayList<Integer> arr =getRandomA.getRandomArray(30000);
    long startTimeBSTr = System.currentTimeMillis();
    for(int i=0;i<arr.size();i++)
    {
      BSTr.insertrec(i);
    }
    long endTimeBSTr = System.currentTimeMillis();
    long timeBSTr =  ((endTimeBSTr-startTimeBSTr));
    System.out.println(timeBSTr + "ms");

    long startTimeAVL = System.currentTimeMillis();
    for(int j=0;j<arr.size();j++)
    {
      AVL.insertIter(j);
    }
    long endTimeAVL = System.currentTimeMillis();
    long timeAVL =  ((endTimeAVL- startTimeAVL));
    System.out.println(timeAVL + "ms");
  }
}
