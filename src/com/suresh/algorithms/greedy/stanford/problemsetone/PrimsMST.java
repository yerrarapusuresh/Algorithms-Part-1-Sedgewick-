package com.suresh.algorithms.greedy.stanford.problemsetone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.suresh.algorithms.greedy.kruskal.KruskalMST;

public class PrimsMST {

  List<Edge> minSpanningEdges;
  Queue<Edge> minPq;
  Set<Integer> visited;
  Graph g;

  public PrimsMST(Graph g) {
    minSpanningEdges = new ArrayList<Edge>();
    minPq = new PriorityQueue<Edge>();
    visited = new HashSet<Integer>();
    this.g = g;
    prims(g);
  }

  private void prims(Graph g) {
    scan(g, 0);
    while ((!minPq.isEmpty()) && (minSpanningEdges.size() != (g.verticesSize() - 1))) {
      Edge e = minPq.poll();
      if (visited.contains(e.from()) && visited.contains(e.to(e.from()))) {
        continue;
      }
      if (!visited.contains(e.from())) {
        scan(g, e.from());
      } else if (!visited.contains(e.to(e.from()))) {
        scan(g, e.to(e.from()));
      }
      minSpanningEdges.add(e);
    }

  }

  public double getCostMst() {
    return minSpanningEdges.stream().mapToDouble(a -> a.cost()).sum();
  }

  public Iterable<Edge> Edges() {
    return minSpanningEdges;
  }

  private void scan(Graph g, int v) {
    for (Edge e : g.vertexAdj(v)) {
      minPq.add(e);
    }
    visited.add(v);

  }

  public static void main(String[] args) {
    String graphPath = "D:\\GitHubMyOwnRepos\\AlgorithmsBySedgewickPartOne\\Algorithms-Part-1-Sedgewick-\\src\\com\\suresh\\algorithms\\greedy\\problemsetone\\edges.txt";
    Graph g = null;
    try {
      g = GraphUtils.readEdgeWeightGraphFromPath(graphPath);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(g);
    PrimsMST pmst = new PrimsMST(g);
    System.out.println(pmst.getCostMst());
    
    KruskalMST kmst = new KruskalMST(g);
    System.out.println(kmst.getMstCost());
    
    for(Edge e: pmst.Edges()) {
      System.out.print(" "+e);
    }
    
    System.out.println();
    
    for(Edge e: kmst.getMst()) {
      System.out.print(" "+e);
    }

  }
}
