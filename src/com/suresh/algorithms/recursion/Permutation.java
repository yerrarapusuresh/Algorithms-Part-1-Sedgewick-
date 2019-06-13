package com.suresh.algorithms.recursion;

public class Permutation {

  public static void main(String[] args) {
    permutateArray(new int[] { 1, 2, 3 }, 0);
  }

  public static void permutateArray(int[] array, int currentIndex) {
    if (currentIndex >= array.length) {
      printArray(array);
      return;
    }
   // printArray(array);
    for (int i = currentIndex ; i < array.length; i++) {
      swap(array, currentIndex, i);
      permutateArray(array, currentIndex + 1);
      swap(array, currentIndex, i);
    }
  }

  private static void swap(int[] array, int currentIndex, int i) {
    int temp = array[i];
    array[i] = array[currentIndex];
    array[currentIndex] = temp;
  }

  private static void printArray(int[] array) {
    for (int i : array) {
      System.out.print("" + i);
    }
    System.out.println();
  }

}
