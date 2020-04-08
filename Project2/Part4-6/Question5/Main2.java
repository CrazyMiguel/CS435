import java.util.*;

class Main2
{
  public static void main(String[] args)
  {
    WeightedGraph graph=new WeightedGraph();
    graph.addNode(0);
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addWeightedEdge(graph.vertices.get(0),graph.vertices.get(1),1);
    graph.addWeightedEdge(graph.vertices.get(1),graph.vertices.get(2),1);
    graph.removeWeightedEdge(graph.vertices.get(1),graph.vertices.get(2));
    graph.print();
  }
}
