class BST_iterative
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

	  public BST_iterative()
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

    public static void main(String[] args)
    {
      BST_iterative BST = new BST_iterative(); //intialize new Binary Search Tree
      BST.insert(4);
      BST.insert(2);
      BST.insert(1);
      BST.insert(3);
      BST.insert(6);
      BST.insert(5);
    }
}
