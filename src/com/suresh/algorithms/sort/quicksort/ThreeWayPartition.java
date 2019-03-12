/**
 * Dutch Nation Flag Problem
 */

package com.suresh.algorithms.sort.quicksort;

import java.util.Arrays;

/**
 * .
 * 
 * @author syerrarapu
 *
 */
public class ThreeWayPartition {

  /**
   * .
   * 
   * @param args
   *          command line arguments
   */
  public static void main(String[] args) {
    int[] array = { 1, 100, -6, 100, 3, 2, 4, -0, 34 };
    sort(array);
    System.out.println(Arrays.toString(array));
  }

  private static void sort(int[] array, int low, int high) {
    if (high <= low) {
      return;
    }

    int gt = high;
    int lt = low;
    int i = low;
    int pivot = array[low];
    while (i <= gt) {
      if (array[i] < pivot) {
        swap(array, i++, lt++);
      } else if (array[i] > pivot) {
        swap(array, i, gt--);
      } else {
        i++;
      }
    }

    sort(array, low, lt - 1);
    sort(array, gt + 1, high);

  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;

  }

  public static void sort(int[] array) {
    sort(array, 0, array.length - 1);
  }

}
