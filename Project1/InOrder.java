import java.util.*;
class InOrder
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
    
    public InOrder()
    {
    	this.root = null; //Initialize a node root to null
    }

    public void insert(int data)
    {
      Node node=new Node(data);
      if(root==null) //check if there even is a root edge case
      {
        root=node;
        return;
      }

      Node parent = null;
      Node curr=root;
      while(curr!=null) //until the end of the tree on that particular subtree
      {
        parent=curr;
        if(curr.data>data)
        {
          curr=curr.l_child; //go left
        }
        else if(curr.data<data)
        {
          curr=curr.r_child; // go right
        }
      }
      //once it reached null means its time to insert
      if(parent.data>data)
      {
        parent.l_child=node; //set this new node to the left child of current parent
      }
      else if(parent.data<data)
      {
        parent.r_child=node; // set this new node to the right child
      }
      return;
    }

    void sort(Node root)
    {
        if (root != null)
        {
            sort(root.l_child); //recursive call to the left subtree to get smallest
            System.out.println(root.data);
            sort(root.r_child); //recursive call to the right subtree after
        }
    }

    public static void main(String[] args)
    {
      int[] nums = {10,05,20,06,12,07,11,16,19,18,17};
      ArrayList<Integer> unsorted= new ArrayList<>();
      for (int num: nums)
      {
        unsorted.add(num);
      }

      InOrder BST = new InOrder(); //intialize new Binary Search Tree
      System.out.println("Unsorted List:");
      for(int i=0;i<unsorted.size();i++)
      {
          System.out.println(unsorted.get(i));
          BST.insert(unsorted.get(i));
      }
      System.out.println("Sorted List:");
      BST.sort(BST.root);
    }
}
