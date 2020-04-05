import java.util.*;

class GraphSearch
{
  //3d)
  ArrayList<Node> DFSHelper(Node start, Node end, ArrayList<Node> arr)
  {
    //The start always moves to the next node and becomes the new start
    //until the order array actually hit the end
    //mark visited and add the start node to array if its not end
    //now go to neighbors if not visited recurse
    //start deleting if you reached the end of the depth so you go up to the next node
    start.visit=true;
    if(!(arr.contains(end)))
    {
      arr.add(start);
    }
    for (Node neighbor : start.neighbors)
    {
      //check if the neighbor node was visited false if not
      if(!(neighbor.visit))
      {
        DFSHelper(neighbor,end,arr);
      }
    }
    if(!(arr.contains(end)))
    {
      if(arr.size()>0)
      {
        arr.remove(arr.size()-1);
      }
    }
    return arr;
  }

  ArrayList<Node> DFSRec(final Node start, final Node end)
  {
    ArrayList<Node> DFS_order= new ArrayList<Node>();
    DFSHelper(start,end,DFS_order);

    //Base Case of nothing in the arraylist after dfs meaning no path
    if(DFS_order.size()==0)
    {
      return null;
    }
    else
    {
      return DFS_order;
    }
  }

  //3e
  ArrayList<Node> DFSIter(final Node start, final Node end)
  {
    //Stacks Stacks Stacks
    ArrayList<Node> order= new ArrayList<Node>();
    Stack<Node> stack=new Stack<Node>();
    stack.push(start);
    while(!(stack.empty()))
    {
      Node node=stack.pop();
      node.visit=true;
      order.add(node);
      if(node==end)
      {
        return order;
      }
      for(int i=0;i<node.neighbors.size();i++)
      {
        if(!(node.neighbors.get(i).visit))//Actually means it is false
        {
          stack.push(node.neighbors.get(i));
        }
      }
    }
    return null;
  }
}
