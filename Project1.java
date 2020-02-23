class BST_iterative
{
    Node root; //The tree has to start somewhere

    BST_iterative() //constructing the root node
    {
      root=null
    }
    class Node //sets what a node is components
    {
      int data;
      Node l_child;
      Node r_child;

      public Node(int data) //the creation of an actual node
      {
        this.data=data;
        l_child=null;
        r_child=null;
      }
    }

    public static Node insert(int data)
    {
      Node new_node = new Node(data);
      if(root==null) //check if there even is a root edge case
      {
          return new_node;
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
        else if(curr.dat<data)
        {
          curr=curr.r_child; // go right
        }
      }
      //once it reached null means its time to insert
      if(parent.data>data)
      {
        parent.l_child=new_node; //set this new node to the left child of current parent
      }
      else if(parent.data<data)
      {
        parent.r_childe=new_node; // set this new node to the right child
      }
      return root;
    }

    public static void main(String[] args)
    {
      BST_iterative tree = new BST_iterative(); //new tree initialized

    }
}
