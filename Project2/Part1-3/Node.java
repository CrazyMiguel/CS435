import java.util.*;

class Node //sets a type Node which will be the vertex component to the graph
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
