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

  public static void main(String[] args)
  {
    Graph ListG = createLinkedList(5);
    //ListG.print();
    Graph randG = createRandomUnweightedGraphIter(5);
    randG.print();
    //GraphSearch DFS=new GraphSearch();
    //ArrayList<Node> DFSR= DFS.DFSRec(randG.vertices.get(1),randG.vertices.get(3));
    //for(int j=0;j<DFSR.size();j++)
    //{
      //System.out.println(DFSR.get(j).data);
    //}
    //ArrayList<Node> DFSI= DFS.DFSIter(randG.vertices.get(1),randG.vertices.get(3));
    //for(int j=0;j<DFSI.size();j++)
    //{
    //  System.out.println(DFSI.get(j).data);
    //}
    GraphSearch BFT=new GraphSearch();
    //ArrayList<Node> BFTR= BFT.BFTRec(randG);
    //for(int j=0;j<BFTR.size();j++)
    //{
      //System.out.println(BFTR.get(j).data);
    //}
    ArrayList<Node> BFTI= BFT.BFTIter(randG);
    for(int k=0;k<BFTI.size();k++)
    {
      System.out.println(BFTI.get(k).data);
    }
  }
}
