import java.util.*;
class BST_rec
{
    static class Node //sets what a node is components
    {
      int data;
      Node l_child;
      Node r_child;
      Node(int data) //the creation of an actual node
      {
        this.data=data;
        l_child=null;
        r_child=null;
      }
    }

    public Node root;

	  public BST_rec()
    {
		    this.root = null; //Initialize a node root to null
	  }

    //check for the base case and take in inserts from driver
    public void insertrec(int data)
    {
      Node node=new Node(data);
      if(root==null) //Base case
      {
        root=node;
      }
      else
      {
        insertNode(root, node);
      }
    }
    //recursively insert the actual node
    public void insertNode(Node curr,Node node)
    {
      //curr equals your parent, node is your node being inserted
      //check if the node being inserted is less then parent node
      //if the left child doesnt exist insert this node as the parents left child
      //else call again to go more left
      if(curr.data>node.data)
      {
        if(curr.l_child==null)
        {
          curr.l_child=node;
        }
        else
        {
          insertNode(curr.l_child,node);
        }
      }
      //curr equals your parent, node is your node being inserted
      //check if the node being inserted is greater then parent node
      //if the right child doesnt exist insert this node as the parents right child
      //else call again to go more left
      else if(curr.data<node.data)
      {
          if(curr.r_child==null)
          {
            curr.r_child=node;
          }
          else
          {
            insertNode(curr.r_child,node);
          }
      }
    }
    //return max value
    public int findMaxRec(Node node)
    {
      //go right right right until there is no more right
      if(node.r_child != null)
      {
        return findMaxRec(node.r_child);
      }
      return(node.data);
    }
    //return min value
    public int findMinRec(Node node)
    {
      //go left left left until there is no more left
      if(node.l_child != null)
      {
        return findMinRec(node.l_child);
      }
      return(node.data);
    }

    public int findNextRec(int value)
    {
      ArrayList<Integer> arr=new ArrayList<Integer>();
      ArrayList<Integer> newA=SortArr(root, arr);
      for(int i=0;i<arr.size();i++)
      {
        try
        {
          if(arr.get(i)==value)
          {
            return arr.get(i+1);
          }
        }
        catch(Exception e)
        {
          System.out.println("There is no Next Value");
        }
      }
      return -1;
    }

    public int findPrevRec(int value)
    {
      ArrayList<Integer> arr=new ArrayList<Integer>();
      ArrayList<Integer> newA=SortArr(root, arr);
      for(int i=0;i<arr.size();i++)
      {
        try
        {
          if(arr.get(i)==value)
          {
            return arr.get(i-1);
          }
        }
        catch(Exception e)
        {
          System.out.println("There is no Prev Value");
        }
      }
      return -1;
    }
    //helper recursive function to findNext and findPrev
    public ArrayList<Integer> SortArr(Node root, ArrayList<Integer> arr)
    {
        if (root != null)
        {
            SortArr(root.l_child,arr);
            arr.add(root.data);
            SortArr(root.r_child,arr);
        }
        return arr;
    }

    void sort(Node root)
    {
        if (root != null)
        {
            sort(root.l_child);
            System.out.println(root.data);
            sort(root.r_child);
        }
    }

    public static void main(String[] args)
    {
      BST_rec BST = new BST_rec(); //intialize new Binary Search Tree
      BST.insertrec(43);
      BST.insertrec(27);
      BST.insertrec(31);
      BST.insertrec(65);
      BST.insertrec(46);
      BST.insertrec(11);
      BST.insertrec(96);
      BST.insertrec(1);
      //BST.sort(BST.root);
      System.out.println(BST.findNextRec(43));
      System.out.println(BST.findPrevRec(43));
      //System.out.println(BST.findPrevRec(1));
      //System.out.println(BST.findNextRec(96));
      //System.out.println(BST.findMaxRec(BST.root));
      //System.out.println(BST.findMinRec(BST.root));
    }
}
