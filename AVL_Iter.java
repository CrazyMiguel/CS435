class AVL_Iter
{
    static class Node //sets what a node is components
    {
      int data;
      int height;
      int bf;
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

	  public AVL_Iter()
    {
		    this.root = null; //Initialize a node root to null
	  }

    public void insertIter(int data)
    {
      Node node=new Node(data);
      if(root==null) //check if there even is a root edge case
      {
        root=node;
        update_bf(root);
        update_height(root);
        System.out.println(root.bf);
        return;
      }

      Node parent = null;
      Node curr=root;
      int count=0;
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
        count++;
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
      while(count>0)
      {
          System.out.println(findParent(data).data);
          data=findParent(data).data;
          Node parents = find(data);
          update_bf(parents);
          update_height(parents);
          System.out.println(parents.bf);
          count--;
          //break;
      }
      return;
    }
    //return max value
    public int findMaxIter(Node node)
    {
      //go right!!!
      while(node.r_child!=null) //until the end of the right subtree
      {
        node=node.r_child;
      }
      return(node.data);
    }

    //return min value
    public int findMinIter(Node node)
    {
      //go left left left until there is no more left
      while(node.l_child!=null) //until the end of the left subtree
      {
        node=node.l_child;
      }
      return(node.data);
    }

    public int findNextIter(int value)
    {
      //go right of current node then go as left as possible
      Node node = find(value);
      if(node.r_child!=null)
      {
        node=node.r_child;
        while(node.l_child!=null)
        {
          node=node.l_child;
        }
        return node.data;
      }
      else
      {
        return -1;
      }
    }

    public int findPrevIter(int value)
    {
      Node node = find(value);
      if(node.l_child!=null)
      {
        node=node.l_child;
        while(node.r_child!=null)
        {
          node=node.r_child;
        }
        return node.data;
      }
      else
      {
        return -1;
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
    public Node find(int value)
    {
		  Node parent = null;
      Node curr = root;
      if(curr.data==value)
      {
        return curr;
      }
      while(curr.data!=value)
      {
        parent=curr;
        if(value>curr.data)
        {
          curr=curr.r_child;
        }
        else if(value<curr.data)
        {
          curr=curr.l_child;
        }
      }
      return curr;
    }

    public Node findParent(int value)
    {
      Node prevParent=null;
		  Node parent = null;
      Node curr = root;
      if(curr.data==value)
      {
        return curr;
      }
      while(curr.data!=value)
      {
        parent=curr;
        if(value>curr.data)
        {

          curr=curr.r_child;
        }
        else if(value<curr.data)
        {
          curr=curr.l_child;
        }
      }
      return parent;
    }

    public int deleteIter(int value)
    {
      if(root==null)
      {
        return -1;
      }
      Node node=find(value);
      Node parent=findParent(value);
      if(node.l_child==null && node.r_child==null) //no children
      {
        if(parent.l_child.data==node.data)
        {
          parent.l_child=null;
        }
        else if (parent.r_child.data==node.data)
        {
          parent.r_child=null;
        }
      }
      else if(node.l_child==null)//right child of current node is now parents node
      {
        if(parent.l_child.data==node.data)
        {
          parent.l_child=node.r_child;
        }
        else if (parent.r_child.data==node.data)
        {
          parent.r_child=node.r_child;
        }
      }
      else if(node.r_child==null) // left child of current node is now parents node
      {
        if(parent.l_child.data==node.data)
        {
          parent.l_child=node.l_child;
        }
        else if (parent.r_child.data==node.data)
        {
          parent.r_child=node.l_child;
        }
      }
      else //has two children
      {
        if(parent.l_child.data==node.data)
        {
          int i=findNextIter(node.data);
          int temp=i;
          Node newplace=find(i);
          newplace.data=node.data;
          node.data=temp;
          Node parent_Ofdeleted=findParent(findPrevIter(node.data)); //trying to find parent of node to be deleted
          if(node.l_child==null)//right child of current node is now parents child node
          {
            if(parent_Ofdeleted.l_child.data==node.data)
            {
              parent_Ofdeleted.l_child=node.r_child;
            }
            else if (parent_Ofdeleted.r_child.data==node.data)
            {
              parent_Ofdeleted.r_child=node.r_child;
            }
          }
          else //no child after the swap
          {
            parent_Ofdeleted.r_child=null;
          }
          return newplace.data;
        }
        else if (parent.r_child.data==node.data)
        {
          int i=findNextIter(node.data);
          int temp=i;
          Node newplace=find(i);
          newplace.data=node.data;
          node.data=temp;
          Node parent_Ofdeleted=findParent(findPrevIter(node.data)); //trying to find parent of node to be deleted
          if(node.l_child==null)//right child of current node is now parents child node
          {
            if(parent_Ofdeleted.l_child.data==node.data)
            {
              parent_Ofdeleted.l_child=node.r_child;
            }
            else if (parent_Ofdeleted.r_child.data==node.data)
            {
              parent_Ofdeleted.r_child=node.r_child;
            }
          }
          else //no child after the swap
          {
            parent_Ofdeleted.r_child=null;
          }
          return newplace.data;
        }
      }
      return node.data;
    }

    public void update_bf(Node node)
    {
      if (node.l_child == null && node.r_child == null)
      {
        node.bf=0;
      }
      else
      {
        if(node.l_child == null)
        {
          int l_height=-1;
          int r_height=node.r_child.height;
          node.bf=l_height-r_height;
        }
        else if(node.r_child == null)
        {
          int l_height=node.l_child.height;
          int r_height=-1;
          node.bf=l_height-r_height;
        }
        else
        {
          int l_height=node.l_child.height;
          int r_height=node.r_child.height;
          node.bf=l_height-r_height;
        }
      }
    }
    public void update_height(Node node)
    {
      if (node.l_child == null && node.r_child == null)
      {
        node.height=0;
      }
      else
      {
        if(node.l_child == null)
        {
          int r_height=node.r_child.height;
          node.height=r_height+1;
        }
        else if(node.r_child == null)
        {
          int l_height=node.l_child.height;
          node.height=l_height+1;
        }
        else
        {
          int l_height=node.l_child.height;
          int r_height=node.r_child.height;
          if(l_height>r_height)
          {
            node.height=l_height+1;
          }
          else if(l_height<r_height)
          {
            node.height=r_height+1;
          }
        }
      }
    }

    public static void main(String[] args)
    {
      AVL_Iter BST = new AVL_Iter(); //intialize new Binary Search Tree
      BST.insertIter(43);
      BST.insertIter(27);
      BST.insertIter(31);
      //BST.insertIter(65);
      //BST.insertIter(46);
      //after insert 46 there should be a left rotation
      //BST.insertIter(11);
      //BST.insertIter(96);
      //BST.insertIter(1);
      //BST.deleteIter(96);
      //System.out.println(BST.deleteIter(65));
      //System.out.println(BST.deleteIter(27));
      //BST.sort(BST.root);
      //System.out.println(BST.findNextIter(43));
      //System.out.println(BST.findPrevIter(43));
      //System.out.println(BST.findPrevIter(1));
      //System.out.println(BST.findNextIter(96));
      //System.out.println(BST.findMaxIter(BST.root));
      //System.out.println(BST.findMinIter(BST.root));
    }
}
