import java.util.*;

class DirectedGraph
{
  ArrayList<Node> vertices=new ArrayList<>();

  public void addNode(final int val)
  {
    Node node=new Node(val);
    vertices.add(node);
  }

  public void addDirectedEdge(final Node first, final Node second)
  {
    //Directional might have to check if the nodes actually exist
    if(!(first.neighbors.contains(second)))
    {
      first.neighbors.add(second);
    }
  }

  public void removeDirectedEdge(final Node first, final Node second)
  {
    //Directional remove might have to check if the nodes actually exist
    if(first.neighbors.contains(second))
    {
      first.neighbors.remove(second);
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
        System.out.println(" -> " + curr.neighbors.get(j).data);
      }
    }
  }
}
