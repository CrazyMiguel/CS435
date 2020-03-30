class Main
{
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
  }
}
