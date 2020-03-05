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

    public int insertIter(int data)
    {
      Node node=new Node(data);
      if(root==null) //check if there even is a root edge case
      {
        root=node;
        update_bf(root);
        update_height(root);

        //System.out.println(root.bf);
        return 0;
      }

      Node parent = null;
      Node curr=root;
      int count=0;
      int levels_count=0;
      while(curr!=null) //until the end of the tree on that particular subtree
      {
        parent=curr;
        levels_count+=1;
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
          //System.out.println(findParent(data).data);
          data=findParent(data).data; //This is done mainly becuase of calling for the grandparent
          Node parents = find(data);
          update_bf(parents);
          update_height(parents);
          String cases=check_bf(parents);
          switch (cases)
          {
            case "LeftRight":
              //System.out.println("1");
              //rotate left then rotate right
              rotate_left(parents.l_child);
              rotate_right(parents);
              break;
            case "LeftLeft":
              //System.out.println("2");
              //rotate right
              rotate_right(parents);
              //update_bf(parents.r_child);
              //update_height(parents.r_child);
              //update_bf(parents);
              //update_height(parents);
              break;
            case "RightLeft":
              //System.out.println("3");
              //rotate right then rotate left
              rotate_right(parents.r_child);
              rotate_left(parents);
              break;
            case "RightRight":
              //System.out.println("4");
              //rotate left
              rotate_left(parents);
              break;
            default: break;

          }
          //System.out.println(parents.bf);
          //System.out.println(cases);
          count--;
          //break;
      }
      return levels_count;
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

    public void update_bf(Node node) //updates the balance factor of each node
    {
      //Sresht said maybe a good idea to not make balance factor a part of each node
      if (node.l_child == null && node.r_child == null) //no children
      {
        node.bf=0;
      }
      else
      {
        if(node.l_child == null) //no left children in subtree
        {
          int l_height=-1;
          int r_height=node.r_child.height;
          node.bf=l_height-r_height;
        }
        else if(node.r_child == null) // no right children in subtree
        {
          int l_height=node.l_child.height;
          int r_height=-1;
          node.bf=l_height-r_height;
        }
        else //has children in both so take the heights of both subtrees
        {
          int l_height=node.l_child.height;
          int r_height=node.r_child.height;
          node.bf=l_height-r_height;
        }
      }
    }
    public void update_height(Node node) //update the heights after each insert
    {
      if (node.l_child == null && node.r_child == null) //no children
      {
        node.height=0;
      }
      else
      {
        if(node.l_child == null) // no left child sub tree
        {
          int r_height=node.r_child.height;
          node.height=r_height+1;
        }
        else if(node.r_child == null) //no left child sub tree
        {
          int l_height=node.l_child.height;
          node.height=l_height+1;
        }
        else //if there are both sub trees then check which is greater
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

    public static String check_bf(Node node)
    {
      if(node.bf>1 && node.l_child.bf<0) //left right inbalance
      {
        return "LeftRight";
      }
      else if (node.bf>1) //left left inbalance
      {
        return "LeftLeft";
      }
      else if(node.bf<-1 && node.r_child.bf>0)//right left inbalance
      {
        return "RightLeft";
      }
      else if(node.bf<-1) //right right inbalance
      {
        return "RightRight";
      }
      return "None";
    }
    public void rotate_right(Node grandparent)
    {
      //parent goes into the position of grandparent
      //child goes into the position of parent
      //grandparent becomes right child of parent
      //keep a variable to know if there is more tree above it
      Node if_tree=findParent(grandparent.data);
      Node parent=grandparent.l_child;
      grandparent.l_child= parent.r_child; //disconnects grandparent from parent
      parent.r_child=grandparent; //makes parents right child now grandparent
      if(grandparent==if_tree)// basically means the original grandparent was the root
      {
        root=parent;
      }
      else if(grandparent==if_tree.r_child)
      {
        if_tree.r_child=parent;
      }
      else
      {
        if_tree.l_child=parent;
      }
      //System.out.println(parent.data);
      //System.out.println(parent.r_child.data);
      update_bf(grandparent);
      update_height(grandparent);
      update_bf(parent);
      update_height(parent);
      //System.out.println(parent.height);
    }
    public void rotate_left(Node grandparent)
    {
      //parent goes into the position of grandparent
      //child goes into the position of parent
      //grandparent becomes left child of parent
      Node if_tree=findParent(grandparent.data);
      Node parent=grandparent.r_child;
      grandparent.r_child= parent.l_child; //disconnects grandparent from parent
      parent.l_child=grandparent; //makes parents right child now grandparent
      if(grandparent==if_tree)// basically means the original grandparent was the root
      {
        root=parent;
      }
      else if(grandparent==if_tree.r_child)
      {
        if_tree.r_child=parent;
      }
      else
      {
        if_tree.l_child=parent;
      }
      //System.out.println(parent.data);
      //System.out.println(parent.r_child.data);
      update_bf(grandparent);
      update_height(grandparent);
      update_bf(parent);
      update_height(parent);

    }
    //level order traveral is not mine Sresht said to use this to check if the tree is RightLeft
    //Again level order is not mine!!
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.l_child);
            int rheight = height(root.r_child);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.l_child, level-1);
            printGivenLevel(root.r_child, level-1);
        }
    }
    public static void main(String[] args)
    {
      AVL_Iter AVL = new AVL_Iter(); //intialize new Binary Search Tree
      AVL.insertIter(43);
      AVL.insertIter(27);
      //AVL.printLevelOrder();
      //AVL.insertIter(24);
      //AVL.printLevelOrder();
      AVL.insertIter(31);
      //AVL.insertIter(46);
      //after insert 46 there should be a left rotation
      //AVL.insertIter(11);
      //AVL.insertIter(96);
      //AVL.insertIter(1);
      //AVL.printLevelOrder();
      //AVL.deleteIter(96);
      //System.out.println(AVL.deleteIter(65));
      //System.out.println(AVL.deleteIter(27));
      //AVL.sort(AVL.root);
      //System.out.println(AVL.findNextIter(43));
      //System.out.println(AVL.findPrevIter(43));
      //System.out.println(AVL.findPrevIter(1));
      //System.out.println(AVL.findNextIter(96));
      //System.out.println(AVL.findMaxIter(AVL.root));
      //System.out.println(AVL.findMinIter(AVL.root));
    }
}
