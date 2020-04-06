import java.util.*;

class Graph
{
  ArrayList<Node> vertices=new ArrayList<>();

  public void addNode(final int val)
  {
    Node node=new Node(val);
    vertices.add(node);
  }

  public void addUndirectedEdge(final Node first, final Node second)
  {
    //Bi-directional might have to check if the nodes actually exist
    if(!(first.neighbors.contains(second) || second.neighbors.contains(first)))
    {
      first.neighbors.add(second);
      second.neighbors.add(first);
    }
  }

  public void removeUndirectedEdge(final Node first, final Node second)
  {
    //Bi-directional remove might have to check if the nodes actually exist
    if(first.neighbors.contains(second) ||  second.neighbors.contains(first))
    {
      first.neighbors.remove(second);
      second.neighbors.remove(first);
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
        System.out.println("Edge to " + curr.neighbors.get(j).data);
      }
      //System.out.println(curr.data);
    }
  }
}
