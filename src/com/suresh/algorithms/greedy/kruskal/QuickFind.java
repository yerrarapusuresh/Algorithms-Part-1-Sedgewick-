/**
 * 
 */
package com.suresh.algorithms.greedy.kruskal;

/**
 * @author syerrarapu
 *
 */
public class QuickFind {

  private int[] points;
  private int numberOfComponents;

  public QuickFind(int n) {
    this.numberOfComponents = n;
    this.points = new int[n];
    for (int i = 0; i < n; i++) {
      points[i] = i;
    }
  }

  /**
   * two point to union.
   * 
   * @param u
   *          point one.
   * @param v
   *          point two.
   */
  public void union(int u, int v) {
    if (find(u, v)) {
      return;
    }
    int vparent = points[v];
    for (int i = 0; i < points.length; i++) {
      if (points[i] == vparent) {
        points[i] = points[u];
      }
    }
    numberOfComponents--;
  }

  /**
   * to check to points connected or not.
   * 
   * @param u
   *          point u
   * @param v
   *          point v
   * @return returns true or false, weather connected or not.
   */
  public boolean find(int u, int v) {
    return points[u] == points[v];
  }

  public int numberOfComponents() {
    return this.numberOfComponents;
  }

  /**
   * main method to test.
   * 
   * @param args
   *          main method.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    QuickFind qf = new QuickFind(6);
    qf.union(0, 1);
    qf.union(1, 2);
    qf.union(2, 3);
    qf.union(4, 5);
    qf.union(0, 5);

    System.out.println(qf.find(0, 3));
    System.out.println(qf.find(5, 4));
    System.out.println(qf.numberOfComponents());

  }

}
