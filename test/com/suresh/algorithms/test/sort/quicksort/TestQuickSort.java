package com.suresh.algorithms.test.sort.quicksort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.suresh.algorithms.sort.quicksort.QuickSort;

class TestQuickSort {

  @Test
  void test() {
    int[] actual = { 1, 2, 3, 4, 5, 6 };
    int[] expected = { 1, 2, 3, 4, 5, 6 };
    QuickSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testRandom() {
    int[] actual = { 3, 4, 5, 1, 2, 6 };
    int[] expected = { 1, 2, 3, 4, 5, 6 };
    QuickSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testReverseOrder() {
    int[] actual = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    QuickSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void equalValues() {
    int[] actual = { 0, 0, 0, 0, 0, 0 };
    int[] expected = { 0, 0, 0, 0, 0, 0 };
    QuickSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void negitiveNumbers() {
    int[] actual = { -3, -2, -10, -4, 4, 0, -1 };
    int[] expected = { -10, -4, -3, -2, -1, 0, 4 };
    QuickSort.sort(actual);
    assertArrayEquals(expected, actual);
  }
}
