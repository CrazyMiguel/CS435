import java.util.*;

class TopSort
{
  ArrayList<Node> Kahns(final DirectedGraph graph)
  {
    HashMap<Node, Integer> inDegree = initializeInDegreeMap(graph);
    ArrayList<Node> topSort = new ArrayList<Node>();
    Queue<Node> queue = new LinkedList<>();
    //TODO Kahns
    return topSort;
  }

  ArrayList<Node> mDFS(final DirectedGraph graph)
  {
    ArrayList<Node> order=new ArrayList<Node>();
    Stack<Node> stack = new Stack<Node>();
    int numNodes = graph.vertices.size();
    for(int i=0;i<numNodes;i++)
    {
      if(!(graph.vertices.get(i).visit))//Actually means it is false
      {
        modifiedDfsHelper(graph.vertices.get(i),stack);
      }
    }
    //From stack to arraylist
    while(!stack.empty())
    {
      order.add(stack.pop());
    }
    return order;
  }

  void modifiedDfsHelper(final Node node, final Stack<Node> stack)
  {
    // Make nodevisited
    // Then go through all node's neighbors,
    // if the neighbor isn't visited call this method again
    // After all neighbors visited add the original node to the output stack.
    node.visit=true;
    for(int i=0;i<node.neighbors.size();i++)
    {
      if(!(node.neighbors.get(i).visit))//Actually means it is false/not visited
      {
        modifiedDfsHelper(node.neighbors.get(i),stack);
      }
    }
    stack.push(node);
  }
}
