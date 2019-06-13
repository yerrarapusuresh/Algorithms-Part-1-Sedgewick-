package com.suresh.algorithms.greedy.kruskal;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.*;

import com.suresh.algorithms.greedy.stanford.problemsetone.Edge;
import com.suresh.algorithms.greedy.stanford.problemsetone.Graph;

public class KruskalMST {

  private Graph g;
  private Queue<Edge> pq;
  private WeightedUnionFindWithPathCompression uf;
  private List<Edge> result;

  public KruskalMST(Graph g) {
    this.g = g;
    pq = new PriorityQueue<Edge>();
    uf = new WeightedUnionFindWithPathCompression(g.verticesSize());
    result = new ArrayList<>();

    computeMST(g);

  }

  private void computeMST(Graph g) {
    for (int i = 0; i < g.verticesSize(); i++) {
      for (Edge e : g.vertexAdj(i)) {
        pq.add(e);
      }
    }

    while ((!pq.isEmpty()) && (result.size() < g.verticesSize() - 1)) {
      Edge e = pq.poll();
      if (!uf.find(e.from(), e.to(e.from()))) {
        uf.union(e.from(), e.to(e.from()));
        result.add(e);
      }
    }

  }

  public List<Edge> getMst() {
    return result;
  }

  public double getMstCost() {
    return result.stream().mapToDouble(e -> e.cost()).sum();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

  }

}
