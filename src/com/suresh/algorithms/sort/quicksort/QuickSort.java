package com.suresh.algorithms.sort.quicksort;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] array = { 3, 2, 1, 7, 9, -1, 6 };
    sort(array);
    System.out.println(Arrays.toString(array));

  }

  public static int partition(int[] array, int low, int high) {
    int pivot = array[high];
    int j = low;
    for (int i = low; i < high; i++) {
      if (array[i] < pivot) {
        swap(array, j++, i);
      }
    }
    swap(array, high, j);
    return j;
  }

  public static void sort(int[] array) {
    sort(array, 0, array.length - 1);
  }

  private static void sort(int[] array, int low, int high) {
    if (high <= low) {
      return;
    }
    int pivot = partition(array, low, high);
    sort(array, low, pivot - 1);
    sort(array, pivot + 1, high);
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
