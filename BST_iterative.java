import java.util.*;
class BST_iterative
{
    static class Node //sets what a node is components
    {
      int data;
      Node l_child;
      Node r_child;
    };
    static Node create(int data) //the creation of an actual node
    {
        Node new_node = new Node();
        new_node.data=data;
        Node l_child=null;
        Node r_child=null;
        return (new_node);
    }

    public static Node insert(Node node,int data)
    {
      if(node==null) //check if there even is a root edge case
      {
          return (create(data));
      }

      Node parent = null;
      Node curr=node;
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
        parent.l_child=(create(data)); //set this new node to the left child of current parent
      }
      else if(parent.data<data)
      {
        parent.r_child=(create(data)); // set this new node to the right child
      }
      return node;
    }

    public static void main(String[] args)
    {
      Node root = null;
      root = insert(root, 4);
      insert(root, 2);
      insert(root, 1);
      insert(root, 3);
      insert(root, 6);
      insert(root, 5);
    }
}
