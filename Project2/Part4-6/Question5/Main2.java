import java.util.*;

class Main2
{
  public static WeightedGraph createRandomCompleteWeightedGraph(final int n)
  {
    WeightedGraph randG = new WeightedGraph();
    Random r=new Random();

    //Assigning nodes
    for (int i=0;i<n;i++)
    {
      randG.addNode(i);
    }

    //Assign random edges from low to high
    for (int j=0; j<randG.vertices.size();j++)
    {
      for(int k=0; k<randG.vertices.size();k++)
      {
        int weight=r.nextInt(10)+1;
        if (j!=k)
        {
        randG.addWeightedEdge(randG.vertices.get(j), randG.vertices.get(k), weight);
        }
      }
    }
    return randG;
  }
  public static void main(String[] args)
  {
    WeightedGraph graph=new WeightedGraph();
    WeightedGraph randG = createRandomCompleteWeightedGraph(5);
    randG.print();
    graph.addNode(0);
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addWeightedEdge(graph.vertices.get(0),graph.vertices.get(1),1);
    graph.addWeightedEdge(graph.vertices.get(1),graph.vertices.get(2),1);
    graph.removeWeightedEdge(graph.vertices.get(1),graph.vertices.get(2));
    //graph.print();
  }
}
