
package com.suresh.algorithms.sort.megesort;

/**
 * Bottom-up merge sort. using for loop.
 * 
 * @author syerrarapu
 *
 */
public class BottomUpMergeSort {

  /**
   * main method to run program.
   * 
   * @param args
   *          command line arguments.
   */
  public static void main(String[] args) {
    int[] array = { 7, 6, 5, 4, 3, 2, 1 };
    sort(array);
    for (int i : array) {
      System.out.println(i);
    }
  }

  /**
   * recursive method for calling merge sort.
   * @param array input array
   */
  private static void sort(int[] array) {
    int[] aux = new int[array.length];
    for (int size = 1; size < array.length; size += size) {
      for (int i = 0; i < (array.length - size); i += size + size) {
        merge(array, aux, i, i + size - 1, Math.min(array.length - 1, i + size + size - 1));
      }
    }
  }

  /**
   * this method is merge part for two sorted array into single sorted array.
   * 
   * @param array
   *          input array.
   * @param aux
   *          auxilary for input array.
   * @param low
   *          starting point of input array.
   * @param mid
   *          mid point of input array.
   * @param high
   *          end point of input array.
   */
  private static int merge(int[] array, int[] aux, int low, int mid, int high) {
    int inversionsCount = 0;

    for (int k = 0; k <= high; k++) {
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
        inversionsCount += ((mid - i) + 1);
        array[k] = aux[j++];
      } else {
        array[k] = aux[i++];
      }
    }
    return inversionsCount;

  }
}
