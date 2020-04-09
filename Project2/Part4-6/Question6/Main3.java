import java.util.*;

class Main3
{

  public static void main(String[] args)
  {
    GridGraph graph=new GridGraph();
    graph.addGridNode(0,0,0);
    graph.addGridNode(1,0,1);
    graph.addGridNode(2,1,0);
    graph.addGridNode(3,0,2);
    graph.addUndirectedEdge(graph.vertices.get(0),graph.vertices.get(1));
    graph.addUndirectedEdge(graph.vertices.get(0),graph.vertices.get(2));
    graph.addUndirectedEdge(graph.vertices.get(0),graph.vertices.get(3));
    graph.print();
    graph.removeUndirectedEdge(graph.vertices.get(0),graph.vertices.get(2));
    //graph.print();
  }
}
