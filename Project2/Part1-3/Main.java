import java.util.*;

class Main
{
  //3b
  public static Graph createRandomUnweightedGraphIter(int n)
  {
    Graph graph = new Graph();
    Random r=new Random();

    //Assigning nodes
    for (int i=0;i<n;i++)
    {
      graph.addNode(i);
    }

    //Assigning random edges
    for (int j=0; j<graph.vertices.size();j++)
    {
      for(int k=j+1; k<graph.vertices.size();k++)
      {
        int chance=r.nextInt(2);
        if(chance==1)
        {
          graph.addUndirectedEdge(graph.vertices.get(j), graph.vertices.get(k));
        }
      }
    }
    return graph;
  }
  //3c
  public static Graph createLinkedList(int n)
  {
    Graph ListG = new Graph();
    //Assigning nodes and Edges
    ListG.addNode(0);
    for (int j=0;j<n-1;j++)
    {
      ListG.addNode(j+1);
      ListG.addUndirectedEdge(ListG.vertices.get(j), ListG.vertices.get(j+1));
    }
    return ListG;
  }

  public static ArrayList<Node> BFTRecLinkedList(final Graph graph)
  {
    GraphSearch BFTRec=new GraphSearch();
    return BFTRec.BFTRec(graph);
  }

  public static ArrayList<Node> BFTIterLinkedList(final Graph graph)
  {
    GraphSearch BFTIter=new GraphSearch();
    return BFTIter.BFTIter(graph);
  }

  public static void main(String[] args)
  {
    Graph ListG = createLinkedList(1000);
    ArrayList<Node> BFTRLinked= BFTRecLinkedList(ListG);
    for(int i=0;i<BFTRLinked.size();i++)
    {
      System.out.println(BFTRLinked.get(i).data);
    }
  }
}
