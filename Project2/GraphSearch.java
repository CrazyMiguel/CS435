import java.util.*;

class GraphSearch
{
  //3d)
  ArrayList<Node> DFSRec(final Node start, final Node end)
  {
    ArrayList<Node> DFS_order= new ArrayList<Node>;
    //The start always moves to the next node and becomes the new start
    //until the order actually hit the end
    //start deleting if you reached the end of the depth so you go up to the next node
    start.visit-true;
    if(!(DFS_order.contains(end)))
    {
      DFS_order.add(start);
    }
    for (neighbor : start.neighbors)
    {
      //check if the neighbor node was visited false if not
      if(!(neighbor.visit))
      {
        DFSRec(neighbor,end)//I need a helper function 
      }
    }




    //Base Case of nothing
    if(DFS_order.size()==0)
    {
      return null;
    }

  }
}
