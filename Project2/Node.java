import java.util.*;

class Node //sets what a node is components or vertex in this case
{
  int data;
  boolean visit;
  public ArrayList<Node> neighbors;
  Node(int data) //the creation of an actual node
  {
    this.data=data;
    this.neighbors = new ArrayList<>();
    this.visit=false;
  }
}
