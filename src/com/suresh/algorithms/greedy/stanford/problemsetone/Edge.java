package com.suresh.algorithms.greedy.stanford.problemsetone;

public class Edge implements Comparable<Edge> {

  private int from;
  private int to;
  private double cost;

  public Edge(int from, int to, double cost) {
    this.from = from;
    this.to = to;
    this.cost = cost;
  }

  public int from() {
    return this.from;
  }

  public int to(int u) {
    if (u == from) {
      return to;
    } else {
      return this.from;
    }

  }

  public double cost() {
    return this.cost;
  }

  public String toString() {

    return from + " " + to + " " + cost;
  }

  public int compareTo(Edge e) {
    if (this.cost < e.cost) {
      return -1;
    } else if (this.cost > e.cost) {
      return 1;
    }
    return 0;
  }

}
