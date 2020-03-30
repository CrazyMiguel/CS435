import java.util.*;

class Main
{
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
    for ( int j=0; j<n;j++)
    {
      int idx1=r.nextInt(n);
      int idx2=r.nextInt(n);
      if(idx1==idx2)
      {
        idx2=r.nextInt(n);
      }
      if(idx1!=idx2)
      {
        randG.addUndirectedEdge(randG.vertices.get(idx1), randG.vertices.get(idx2));
      }
    }
    return randG;
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
    Graph randG = createRandomUnweightedGraphIter(5);
    randG.print();
  }
}
