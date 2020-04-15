import java.util.*;

class Main
{
  //3b
  public static Graph createRandomUnweightedGraphIter(int n)
  {
    Graph randG = new Graph();
    Random r=new Random();

    //Assigning nodes
    for (int i=0;i<n;i++)
    {
      randG.addNode(i);
    }

    //Assign random edges
    for (int j=0; j<randG.vertices.size();j++)
    {
      for(int k=j+1; k<randG.vertices.size();k++)
      {
        int chance=r.nextInt(2);
        if(chance==1)
        {
          randG.addUndirectedEdge(randG.vertices.get(j), randG.vertices.get(k));
        }
      }
    }
    return randG;
  }
  //3c
  public static Graph createLinkedList(int n)
  {
    Graph ListG = new Graph();
    //Assigning nodes
    for (int i=0;i<n;i++)
    {
      ListG.addNode(i);
    }
    for (int j=0;j<ListG.vertices.size()-1;j++)
    {
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
    Graph ListG = createLinkedList(10000);
    ArrayList<Node> BFTILinked= BFTIterLinkedList(ListG);
    for(int i=0;i<BFTILinked.size();i++)
    {
      System.out.println(BFTILinked.get(i).data);
    }
  }
}
