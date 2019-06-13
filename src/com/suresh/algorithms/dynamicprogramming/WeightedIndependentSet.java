/**
 * 
 */
package com.suresh.algorithms.dynamicprogramming;

/**
 * @author syerrarapu
 *
 */
public class WeightedIndependentSet {

  /**
   * @param args
   *          command line arguments.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int[] pathGraph = { 1, 4, 5, 4 };
    int maxWeightedGraph = weightedIndependetSetUsingMemorization(pathGraph);
    System.out.println(maxWeightedGraph);
  }

  private static int recursiveGraph(int[] pathGraph, int index) {
    if (index >= pathGraph.length) {
      return 0;
    }
    return Math.max(recursiveGraph(pathGraph, index + 1),
        recursiveGraph(pathGraph, index + 2) + pathGraph[index]);
  }

  public static int weightedIndependetSetUsingMemorization(int[] array) {
    if (array.length < 1) {
      return 0;
    }
    if (array.length == 1) {
      return array[0];
    }
    if (array.length == 2) {
      return Math.max(array[0], array[1]);
    }
    int[] memoryTable = new int[array.length];
    memoryTable[0] = array[0];
    memoryTable[1] = array[1];
    for (int i = 2; i < array.length; i++) {
      memoryTable[i] = Math.max(array[i] + array[i - 2], array[i - 1]);
    }
    return Math.max(memoryTable[array.length - 1], memoryTable[array.length - 2]);
  }

}
