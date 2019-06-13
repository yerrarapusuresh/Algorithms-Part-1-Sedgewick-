package com.suresh.algorithms.greedy.kruskal;

public class WeightedUnionFindWithPathCompression {

  private int[] points;
  private int[] weights;
  private int numberOfComponents;

  /**
   * this constructor takes number points as a input.
   * 
   * @param n
   *          number of input points;
   */
  public WeightedUnionFindWithPathCompression(int n) {
    this.numberOfComponents = n;
    points = new int[n];
    weights = new int[n];
    for (int i = 0; i < n; i++) {
      points[i] = i;
      weights[i] = 1;
    }
  }

  /**
   * this method checks whether two points connected or not.
   * 
   * @param u
   *          input method u.
   * @param v
   *          input method v.
   * @return if both connected return true else return false.
   */
  public boolean find(int u, int v) {
    if (isInvalidArgument(v) || isInvalidArgument(u)) {
      throw new IllegalArgumentException("invalid aruguments: array index out bounds");
    }
    return parent(u) == parent(v);
  }

  private boolean isInvalidArgument(int v) {
    if (v < 0 || v >= points.length) {
      return true;
    }
    return false;
  }

  private int parent(int u) {
    while (points[u] != u) {
      points[u] = points[points[u]];
      u = points[u];
    }
    return u;
  }

  /**
   * this method unions two points if not connected.
   * 
   * @param u
   *          input point u.
   * @param v
   *          input point v.
   */
  public void union(int u, int v) {
    if (isInvalidArgument(v) || isInvalidArgument(u)) {
      throw new IllegalArgumentException("invalid aruguments: array index out bounds");
    }

    if (find(u, v)) {
      return;
    }
    int i = parent(u);
    int j = parent(v);
    if (weights[i] > weights[j]) {
      points[j] = i;
      weights[i] += weights[j];
    } else {
      points[i] = j;
      weights[j] += weights[i];
    }
    numberOfComponents--;
  }

  /**
   * this method will return number of components.
   * 
   * @return integer as number of components in graph/maze
   */
  public int getNumberOfComponents() {
    return numberOfComponents;
  }

  /**
   * this method takes command line arguments as a input.
   * 
   * @param args
   *          command line arguments
   */
  public static void main(String[] args) {
    WeightedUnionFindWithPathCompression wufpc = new WeightedUnionFindWithPathCompression(6);
    wufpc.union(0, 1);
    wufpc.union(2, 3);
    wufpc.union(3, 4);
    wufpc.union(1, 4);

    System.out.println(wufpc.getNumberOfComponents());

  }

}
