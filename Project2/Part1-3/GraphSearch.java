import java.util.*;

class GraphSearch
{
  ArrayList<Node> DFSHelper(Node start, Node end, ArrayList<Node> arr)
  {
    //The start always moves to the next node and becomes the new start
    //mark visited and add the start node to array if its not end
    //now go to neighbors if not visited
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

  //Breadth First Traversal
  ArrayList<Node> BFTRec(final Graph graph)
  {
    ArrayList<Node> BFT_order= new ArrayList<Node>();
    Queue<Node> queue = new LinkedList<>();
    //Set a start node
    queue.add(graph.vertices.get(0));
    BFTHelper(queue, BFT_order, queue.peek());

    //Base Case of nothing in the arraylist after dfs meaning no path
    if(BFT_order.size()==0)
    {
      return null;
    }
    else if(BFT_order.size()!=graph.vertices.size())
    {
      for(int i=0;i<graph.vertices.size();i++)
      {
        if(!(BFT_order.contains(graph.vertices.get(i))))
        {
          BFT_order.add(graph.vertices.get(i));
        }
      }
      return BFT_order;
    }
    else
    {
      return BFT_order;
    }
  }

  ArrayList<Node> BFTHelper(Queue<Node> queue, ArrayList<Node> arr, Node start)
  {
    //The start always moves to the next node and becomes the new start
    //until the order array actually hit the end
    //mark visited and add the start node to array if its not end
    //now go to ***ALL*** the neighbors if not visited then recurse
    //start deleting if you reached the end of the depth so you go up to the next node
    if(!(queue.isEmpty()))
    {
      arr.add(start);
      start.visit = true;
      for (Node neighbor : start.neighbors)
      {
        //check if the neighbor node was visited false if not
        if(!(neighbor.visit))
        {
          neighbor.visit = true;
          queue.add(neighbor);
        }
      }
      queue.poll();
      if(!(queue.isEmpty()))
      {
        BFTHelper(queue,arr,queue.peek());
      }
    }
    return arr;
  }

  ArrayList<Node> BFTIter(final Graph graph)
  {
    ArrayList<Node> BFT_order= new ArrayList<Node>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(graph.vertices.get(0));
    while(!(queue.isEmpty()))
    {
      Node head = queue.poll();
      head.visit = true;
      for (Node neighbor : head.neighbors)
      {
        //check if the neighbor node was visited false if not
        if(!(neighbor.visit))
        {
          neighbor.visit = true;
          queue.add(neighbor);
        }
      }
      BFT_order.add(head);
    }
    return BFT_order;
  }
}
