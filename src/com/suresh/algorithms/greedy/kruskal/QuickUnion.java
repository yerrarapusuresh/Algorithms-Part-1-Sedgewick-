package com.suresh.algorithms.greedy.kruskal;

public class QuickUnion {

  private int[] points;
  private int numberOfComponents;

  /**
   * this contructor takes number points as a argument.
   * 
   * @param n
   *          number of points
   */
  public QuickUnion(int n) {
    this.numberOfComponents = n;
    points = new int[n];
    for (int i = 0; i < n; i++) {
      points[i] = i;
    }
  }

  /**
   * this method checks wheather two points are connected or not.
   * 
   * @param v
   *          input point.
   * @param u
   *          input point.
   * @return
   */
  public boolean find(int v, int u) {
    if (isInvalidArgument(v) || isInvalidArgument(u)) {
      throw new IllegalArgumentException("invalid aruguments: array index out bounds");
    }
    return parent(v) == parent(u);
  }

  /**
   * this method unions two points if those are not connected.
   * 
   * @param u
   *          input point.
   * @param v
   *          input point.
   */
  public void union(int u, int v) {
    if (isInvalidArgument(v) || isInvalidArgument(u)) {
      throw new IllegalArgumentException("invalid aruguments: array index out bounds");
    }
    if (find(u, v)) {
      return;
    }
    points[parent(v)] = parent(u);
    numberOfComponents--;
  }

  private boolean isInvalidArgument(int v) {
    if (v < 0 || v >= points.length) {
      return true;
    }
    return false;
  }

  private int parent(int v) {

    while (points[v] != v) {
      v = points[v];
    }
    return v;
  }

  public int getNumberOfComponents() {
    return numberOfComponents;
  }

  public static void main(String[] args) {
    QuickUnion qu = new QuickUnion(6);
    qu.union(0, 1);
    qu.union(1, 2);
    qu.union(3, 2);
    qu.union(0, 3);
    qu.union(4, 5);
    qu.union(0, 5);

    System.out.println(qu.find(0, 3));
    System.out.println(qu.find(0, 4));
    System.out.println(qu.getNumberOfComponents());

  }

}
