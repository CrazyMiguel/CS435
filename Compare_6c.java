import java.util.*;
public class Compare_6c
{
  public static void main(String[] args)
  {
    BST_iter BST = new BST_iter();
    AVL_Iter AVL = new AVL_Iter();
    int[] arr =getSortedA.getSortedArray(10000);
    int countBST=0;
    for(int i=0;i<arr.length;i++)
    {
      countBST+=BST.insertIter(arr[i]);
    }
    int countAVL=0;
    for(int j=0;j<arr.length;j++)
    {
      countAVL+=AVL.insertIter(arr[j]);
    }
    System.out.println(countBST);
    System.out.println(countAVL);
  }
}
