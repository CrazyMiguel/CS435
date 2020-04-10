import java.util.*;
import java.lang.*;

class Main3
{
  public static GridGraph createRandomGridGraph(int n)
  {
    GridGraph randG = new GridGraph();
    Random r=new Random();

    //Assigning nodes
    int count=0;
    for (int y=0;y<n;y++)
    {
      for (int x=0;x<n;x++)
      {
        randG.addGridNode(count,x,y);
        count+=1;
      }
    }

    //Assign random edges from low to high
    for (int j=0; j<randG.vertices.size();j++)
    {
      for(int k=0; k<randG.vertices.size();k++)
      {
        int chance=r.nextInt(2);//50% chance of getting an edge
        if(chance==0)
        {
          randG.addUndirectedEdge(randG.vertices.get(j), randG.vertices.get(k));
        }
      }
    }
    return randG;
  }

  public static ArrayList<Node> astar(final Node sourceNode, final Node destNode)
  {
    //Based on lecture 18 notes
    //I Know I need a heuristic function to help here which is h
    //Going to use manhattan distance easiest one.
    //will need to calculate g which is the distance so far
    //distance formula
    //g+h is where we decide which node to go to next
    //need to Map actual node to its costs
    HashMap<Node, Integer> map = new HashMap<>();
    ArrayList<Node> order=new ArrayList<Node>();
    Node currNode=sourceNode;
    int total=gAndh(currNode,sourceNode,destNode);
    map.put(sourceNode,total);
    while(currNode!=destNode)
    {
      //mark the Node vistied
      //take it out of the map and add the node to ArrayList
      currNode.visit=true;
      map.remove(currNode);
      order.add(currNode);
      //go through all of currNode neighbors
      //if neighbor was visited do nothing
      //calculate neighbor gandh value
      //if neighbor not in the map add it to the Map
      //if g distance is less than the last inputted replace its value in the Map
      for (int i=0; i<currNode.neighbors.size();i++)
      {
        if (!(currNode.neighbors.get(i).visit))//not visited
        {
          total=gAndh(currNode.neighbors.get(i),sourceNode,destNode);
          if((!map.containsKey(currNode.neighbors.get(i))))//does not contain key/Node
          {
            map.put(currNode.neighbors.get(i),total);
          }
          if(total<map.get(currNode.neighbors.get(i)))//new g value is less than old
          {
            map.replace(currNode.neighbors.get(i),total);
          }
        }
      }
      int min= Collections.min(map.values());
      for (Node n : map.keySet())
      {
        if(min==map.get(n))
        {
          currNode=n;
          break;
        }
      }
    }
    order.add(currNode);
    return order;
  }

  public static int gAndh(Node currNode,Node sourceNode,Node destNode)
  {
    //source is (0,0)
    //dest is (99,99)
    //distance from sourceNode
    //g can change based on min distance
    int g = Math.abs(currNode.x-sourceNode.x) + Math.abs(currNode.y-sourceNode.y);
    //Manhattan distance which this heurisic doesnt change
    int h = Math.abs(destNode.x-currNode.x) + Math.abs(destNode.y-currNode.y);
    int total=g+h;
    return total;
  }

  public static void main(String[] args)
  {
    GridGraph randG = createRandomGridGraph(3);
    ArrayList<Node> order = astar(randG.vertices.get(0), randG.vertices.get((randG.vertices.size()-1)));
    randG.print();
    for(int j=0;j<order.size();j++)
    {
      System.out.println(order.get(j).data);
    }
    /*
    GridGraph graph=new GridGraph();
    graph.addGridNode(0,0,0);
    graph.addGridNode(1,0,1);
    graph.addGridNode(2,1,0);
    graph.addGridNode(3,2,2);
    graph.addGridNode(4,1,1);
    graph.addGridNode(5,2,1);
    graph.addUndirectedEdge(graph.vertices.get(0),graph.vertices.get(1));
    graph.addUndirectedEdge(graph.vertices.get(0),graph.vertices.get(2));
    graph.addUndirectedEdge(graph.vertices.get(0),graph.vertices.get(3));
    graph.addUndirectedEdge(graph.vertices.get(4),graph.vertices.get(1));
    graph.addUndirectedEdge(graph.vertices.get(4),graph.vertices.get(2));
    graph.addUndirectedEdge(graph.vertices.get(4),graph.vertices.get(5));
    graph.addUndirectedEdge(graph.vertices.get(4),graph.vertices.get(3));
    graph.print();
    graph.removeUndirectedEdge(graph.vertices.get(0),graph.vertices.get(2));
    //graph.print();
    */
  }
}
