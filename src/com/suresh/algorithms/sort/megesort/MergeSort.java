
package com.suresh.algorithms.sort.megesort;

/**
 * .
 * 
 * @author Suresh Y.
 *
 */
public class MergeSort {

  /**
   * main method.
   * 
   * @param args
   *          command line arguments.
   */
  public static void main(String[] args) {

  }

  public static void sort(int[] array) {
    sort(array, new int[array.length], 0, array.length - 1);
  }

  private static void sort(int[] array, int[] aux, int low, int high) {
    if (high <= low) {
      return;
    }
    int mid = low + (high - low) / 2;
    sort(array, aux, low, mid);
    sort(array, aux, mid + 1, high);
    merge(array, aux, low, mid, high);
  }

  private static void merge(int[] array, int[] aux, int low, int mid, int high) {
    for (int k = low; k <= high; k++) {
      aux[k] = array[k];
    }
    int i = low;
    int j = mid + 1;
    for (int k = low; k <= high; k++) {
      if (i > mid) {
        array[k] = aux[j++];
      } else if (j > high) {
        array[k] = aux[i++];
      } else if (aux[j] < aux[i]) {
        array[k] = aux[j++];
      } else {
        array[k] = aux[i++];
      }
    }
  }

}
