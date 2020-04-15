import java.util.*;

class GridGraph
{
  ArrayList<Node> vertices=new ArrayList<>();

  public void addGridNode(final int val, final int x, final int y)
  {
    Node node=new Node(val,x,y);
    vertices.add(node);
  }

  public void addUndirectedEdge(final Node first, final Node second)
  {
    if(!(first.neighbors.contains(second)))
    {
      int fx=first.x;
      int fy=first.y;
      int sx=second.x;
      int sy=second.y;

      if(fx==sx && fy+1==sy) //move up one
      {
        first.neighbors.add(second);
        second.neighbors.add(first);
      }
      else if(fx==sx && fy-1==sy) //move down one
      {
        first.neighbors.add(second);
        second.neighbors.add(first);
      }
      else if(fx+1==sx && fy==sy) //move right one
      {
        first.neighbors.add(second);
        second.neighbors.add(first);
      }
      else if(fx-1==sx && fy==sy) //move left one
      {
        first.neighbors.add(second);
        second.neighbors.add(first);
      }
    }
  }

  public void removeUndirectedEdge(final Node first, final Node second)
  {
    for(int j=0;j<first.neighbors.size();j++)
    {
      if(first.neighbors.contains(second) && second.neighbors.contains(first))
      {
        first.neighbors.remove(second);
        second.neighbors.remove(first);
      }
    }
  }

  public HashSet<Node> getAllNodes()
  {
    HashSet<Node> set = new HashSet<Node>(vertices);
    return set;
  }

  public void print()
  {
    //checking if the neighbors and vertexes being added correctly depending on comment out
    for(int i=0;i<vertices.size();i++)
    {
      Node curr=vertices.get(i);
      for(int j=0;j<curr.neighbors.size();j++)
      {
        System.out.println("Vertex " + curr.data);
        System.out.println("-> " + curr.neighbors.get(j).data);
        System.out.println("start-loc: " + "(" + curr.x + "," + curr.y + ")");
        System.out.println("final-loc: " + "(" + curr.neighbors.get(j).x + "," + curr.neighbors.get(j).y + ")");
        System.out.print("\n");
      }
      //System.out.println(curr.data);
    }
  }
}
