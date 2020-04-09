import java.util.*;

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

  public static void main(String[] args)
  {
    GridGraph randG = createRandomGridGraph(3);
    randG.print();
  }
}
