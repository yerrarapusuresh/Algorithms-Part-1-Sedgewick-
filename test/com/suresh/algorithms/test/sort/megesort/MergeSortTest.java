package com.suresh.algorithms.test.sort.megesort;

import static org.junit.Assert.assertArrayEquals;

import com.suresh.algorithms.sort.megesort.MergeSort;

import org.junit.jupiter.api.Test;

/**
 * This test is to test merge sort.
 * 
 * @author syerrarapu
 *
 */
class MergeSortTest {

  @Test
  void test() {
    int[] emptyArrayExpected = {};
    int[] emptyArrayAfterSorted = {};
    MergeSort.sort(emptyArrayAfterSorted);
    assertArrayEquals(emptyArrayExpected, emptyArrayAfterSorted);
  }

  @Test
  void testPositiveCaseSortedOrder() {
    int[] emptyArrayExpected = {1,2,3,4,5,6};
    int[] emptyArrayAfterSorted = {1,2,3,4,5,6};
    MergeSort.sort(emptyArrayAfterSorted);
    assertArrayEquals(emptyArrayExpected, emptyArrayAfterSorted);
  }
  
  @Test
  void testReverseOrder() {
    int[] emptyArrayExpected = {1,2,3,4,5,6};
    int[] emptyArrayAfterSorted = {6,5,4,3,2,1};
    MergeSort.sort(emptyArrayAfterSorted);
    assertArrayEquals(emptyArrayExpected, emptyArrayAfterSorted);
  }
  
  @Test
  void testWithDuplicates() {
    int[] emptyArrayExpected = {1,2,3,3,3,3,4,5,6};
    int[] emptyArrayAfterSorted = {6,3,3,5,4,3,2,1,3};
    MergeSort.sort(emptyArrayAfterSorted);
    assertArrayEquals(emptyArrayExpected, emptyArrayAfterSorted);
  }
  
  @Test
  void testWithNotPositiveIntegers() {
    int[] emptyArrayExpected = {-2,-1,0,1,2,3,3,3,3,4,5,6};
    int[] emptyArrayAfterSorted = {6,3,3,-1,-2,0,5,4,3,2,1,3};
    MergeSort.sort(emptyArrayAfterSorted);
    assertArrayEquals(emptyArrayExpected, emptyArrayAfterSorted);
  }


}
