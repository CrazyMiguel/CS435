import java.util.*;
public class ConstructTree_C
{
  public static void main(String[] args)
  {
    BST_iter BST = new BST_iter();
    AVL_Iter AVL = new AVL_Iter();
    ArrayList<Integer> arr =getRandomA.getRandomArray(10000);
    long startTimeBST = System.currentTimeMillis();
    for(int i=0;i<arr.size();i++)
    {
      BST.insertIter(arr.get(i));
    }
    long endTimeBST = System.currentTimeMillis();
    long timeBST =  ((endTimeBST-startTimeBST));
    System.out.println("BST "+ timeBST + "ms");

    long startTimeAVL = System.currentTimeMillis();
    for(int j=0;j<arr.size();j++)
    {
      AVL.insertIter(arr.get(j));
    }
    long endTimeAVL = System.currentTimeMillis();
    long timeAVL =  ((endTimeAVL- startTimeAVL));
    System.out.println("AVL " + timeAVL + "ms");
  }
}
