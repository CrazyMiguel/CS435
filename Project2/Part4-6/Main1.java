import java.util.*;

class Main1
{
  public static DirectedGraph createRandomDAGIter(final int n)
  {
    DirectedGraph randG = new DirectedGraph();
    Random r=new Random();

    //Assigning nodes
    for (int i=0;i<n;i++)
    {
      randG.addNode(i);
    }

    //Assign random edges from low to high
    for (int j=0; j<randG.vertices.size();j++)
    {
      for(int k=j+1; k<randG.vertices.size();k++)
      {
        int chance=r.nextInt(4);//25% chance of getting directed edge
        if(chance==1)
        {
          randG.addDirectedEdge(randG.vertices.get(j), randG.vertices.get(k));
        }
        else if(chance==2)
        {
          randG.addDirectedEdge(randG.vertices.get(k), randG.vertices.get(j));
        }
        else if(chance==3)
        {
          randG.addDirectedEdge(randG.vertices.get(j), randG.vertices.get(k));
          randG.addDirectedEdge(randG.vertices.get(k), randG.vertices.get(j));
        }
      }
    }
    return randG;
  }
  public static void main(String[] args)
  {
    DirectedGraph randG = createRandomDAGIter(5);
    randG.print();
  }
}
