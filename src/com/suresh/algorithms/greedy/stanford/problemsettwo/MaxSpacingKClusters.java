package com.suresh.algorithms.greedy.stanford.problemsettwo;

import java.util.List;
import java.util.PriorityQueue;

import com.suresh.algorithms.greedy.kruskal.KruskalMST;
import com.suresh.algorithms.greedy.kruskal.WeightedUnionFindWithPathCompression;
import com.suresh.algorithms.greedy.stanford.problemsetone.Edge;
import com.suresh.algorithms.greedy.stanford.problemsetone.Graph;
import com.suresh.algorithms.greedy.stanford.problemsetone.GraphUtils;
import com.suresh.algorithms.greedy.stanford.problemsetone.PrimsMST;

public class MaxSpacingKClusters {

  public static void main(String[] args) throws Exception {
    String path = "D:\\GitHubMyOwnRepos\\AlgorithmsBySedgewickPartOne\\Algorithms-Part-1-Sedgewick-\\src\\com\\suresh\\algorithms\\greedy\\stanford\\problemsettwo\\clustering1.txt";
    Graph g = GraphUtils.readEdgeWeightGraphFromPath(path);
    KruskalMST kmst = new KruskalMST(g);
    PrimsMST pmst = new PrimsMST(g);
    System.out.println("kmst cost " + kmst.getMstCost() + " pmst cost " + pmst.getCostMst()
        + " size  " + kmst.getMst().size());

     System.out.println(computeMaxSpacing(kmst.getMst(), 4));

  }

  public static double computeMaxSpacing(List<Edge> e, int numberOfClusters) {
    int numberOfVertices = e.size() + 1;
    WeightedUnionFindWithPathCompression uf = new WeightedUnionFindWithPathCompression(
        numberOfVertices);
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    // int numberOfClusters = numberOfVertices - numberOfComponents;
    System.out.println("Edge size " + e.size());

    for (Edge edge : e) {
      pq.add(edge);
    }
    while (pq.size() > 3) {
      pq.poll();
    }
    System.out.println("PQ size " + pq.size());
    for (Edge edge : pq) {
      System.out.println(edge);
    }
    return pq.stream().mapToDouble(f -> f.cost()).sum();
  }

}
