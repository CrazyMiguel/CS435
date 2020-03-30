import java.util.*;

class Graph
{
  static class Node //sets what a node is components
  {
    int data;
    public ArrayList<Node> neighbors;
    Node(int data) //the creation of an actual node
    {
      this.data=data;
      this.neighbors = new ArrayList<>();
    }
  }

  ArrayList<Node> vertices=new ArrayList<>();

  public void addNode(final int val)
  {
    Node node=new Node(val);
    vertices.add(node);
  }

  public void addUndirectedEdge(final Node first, final Node second)
  {
    //Bi-directional might have to check if the nodes actually exist
    if(!(first.neighbors.contains(second)))
    {
      first.neighbors.add(second);
      second.neighbors.add(first);
    }
  }

  public void removeUndirectedEdge(final Node first, final Node second)
  {
    //Bi-directional remove might have to check if the nodes actually exist
    if(first.neighbors.contains(second))
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
        System.out.println(curr.neighbors.get(j).data);
      }
      //System.out.println(curr.data);
    }
  }

  public static void main(String[] args)
  {
    Graph G = new Graph(); //intialize new Binary Search Tree
    G.addNode(0);
    G.addNode(1);
    G.addNode(2);
    G.addNode(3);
    G.addNode(4);
    G.addUndirectedEdge(G.vertices.get(0), G.vertices.get(1));
    G.addUndirectedEdge(G.vertices.get(0), G.vertices.get(2));
    G.addUndirectedEdge(G.vertices.get(1), G.vertices.get(2));
    G.removeUndirectedEdge(G.vertices.get(0), G.vertices.get(1));
    //G.print();
    //for (Node i : G.getAllNodes())
    //{
    //    	System.out.println(i);
    //}
    G.getAllNodes();
  }
}
