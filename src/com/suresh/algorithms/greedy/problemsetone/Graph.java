package com.suresh.algorithms.greedy.problemsetone;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  private int vertices;
  private int edges;
  private List<List<Edge>> list;

  /**
   * .
   * 
   * @param vertices
   *          number of vertices graph contains
   */
  public Graph(int vertices) {
    this.vertices = vertices;
    list = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
      list.add(i, new ArrayList<Edge>());
    }
  }

  public int verticesSize() {
    return vertices;
  }

  /**
   * .
   * 
   * @param e
   *          Edge as input
   * @throws IndexOutOfBoundsException
   *           validity of vertices
   */
  public void addEdge(Edge e) throws IndexOutOfBoundsException {
    checkIndexOfEdge(e);
    list.get(e.from()).add(e);
    list.get(e.to(e.from())).add(e);
    edges++;
  }

  private void checkIndexOfEdge(Edge e) throws IndexOutOfBoundsException {
    checkIndexOfVertices(e.from());
    checkIndexOfVertices(e.to(e.from()));

  }

  /**
   * .
   * 
   * @param v
   *          vertex number
   * @return returns itarable implementation type
   */
  public Iterable<Edge> vertexAdj(int v) {
    checkIndexOfVertices(v);
    return list.get(v);

  }

  private void checkIndexOfVertices(int v) {
    if (v < 0 || v >= vertices) {
      throw new IndexOutOfBoundsException("Vertex out of bounds in Graph");
    }
  }

  /*
   * (non-Javadoc) .
   * 
   * @see java.lang.Object#toString()
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%d %d\n", vertices, edges));
    for (int i = 0; i < vertices; i++) {
      for (Edge e : vertexAdj(i)) {
        sb.append(String.format("%d %2.3f  ", e.to(i), e.cost()));
      }
      sb.append(String.format("\n"));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Graph g = new Graph(4);
    g.addEdge(new Edge(0, 1, 0.1));
    g.addEdge(new Edge(1, 2, 0.2));
    g.addEdge(new Edge(2, 3, 0.3));
    // g.addEdge(new Edge(0, 4, 0.5));

    System.out.println(g);
  }

}
