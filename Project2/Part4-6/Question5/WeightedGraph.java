import java.util.*;

class WeightedGraph
{
  ArrayList<Node> vertices=new ArrayList<>();

  public void addNode(final int val)
  {
    Node node=new Node(val);
    vertices.add(node);
  }

  public void addWeightedEdge(final Node first, final Node second, final int edgeWeight)
  {
    Edge cnx=new Edge(second,edgeWeight);
    if(!(first.neighbors.contains(cnx)))
    {
      first.neighbors.add(cnx);
    }
  }

  public void removeWeightedEdge(final Node first, final Node second)
  {
    if((first.neighbors.contains(second)))
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
      //System.out.println(curr.data);
    }
  }
}
