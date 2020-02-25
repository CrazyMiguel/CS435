class BST_recursive
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

	  public BST_recursive()
    {
		    this.root = null; //Initialize a node root to null
	  }

    public void insert(int data)
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
      BST_recursive BST = new BST_recursive(); //intialize new Binary Search Tree
      BST.insert(4);
      BST.insert(2);
      BST.insert(1);
      BST.insert(3);
      BST.insert(6);
      BST.insert(5);
      BST.sort(BST.root);
    }
}
