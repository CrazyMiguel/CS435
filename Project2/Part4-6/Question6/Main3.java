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

  public static ArrayList<Node> astar(final sourceNode, final destNode)
  {
    //Based on lecture 18 notes
    //I Know I need a heuristic function to help here which is h
    //Going to use manhattan distance easiest one.
    //will need to calculate g which is the distance so far
    //distance formula
    //g+h is where we decide which node to go to next

  }

  public static int gAndh(Node currNode,Node sourceNode,Node destNode)
  {
    //source is (0,0)
    //dest is (99,99)
    //distance from start
    g = Math.abs(currNode.x-start.x) + Math.abs(currNode.y-start.y);
    h = Math.abs(end.x-currNode.x) + Math.abs(end.y-currNode.y);
    total=g+h;
    return total;
  }
  
  public static void main(String[] args)
  {
    GridGraph randG = createRandomGridGraph(100);
    randG.print();
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
