import java.util.*;
public class Compare_6b
{
  public static void main(String[] args)
  {
    BST_iter BST = new BST_iter();
    AVL_Iter AVL = new AVL_Iter();
    ArrayList<Integer> arr =getRandomA.getRandomArray(10000);
    int countBST=0;
    for(int i=0;i<arr.size();i++)
    {
      countBST+=BST.insertIter(arr.get(i));
    }
    int countAVL=0;
    for(int j=0;j<arr.size();j++)
    {
      countAVL+=AVL.insertIter(arr.get(j));
    }
    System.out.println(countBST);
    System.out.println(countAVL);
  }
}
