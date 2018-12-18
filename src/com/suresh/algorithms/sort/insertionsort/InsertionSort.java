
package com.suresh.algorithms.sort.insertionsort;

/**
 * Insertion sort implementation.
 * 
 * @author syerrarapu
 *
 */
public class InsertionSort {

  /**
   * main method.
   * 
   * @param args
   *          command line arguments.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  /**
   * sorting using insertion sort technique.
   * 
   * @param arr
   *          input array.
   * @return number of swaps.
   */
  public static int insertionSort(int[] arr) {
    int counter = 0;
    int i = 1;
    while (i < arr.length) {
      int pivot = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > pivot) {
        arr[j + 1] = arr[j];
        j--;
        counter++;
      }
      arr[j + 1] = pivot;
      i++;
    }
    return counter;
  }
}
