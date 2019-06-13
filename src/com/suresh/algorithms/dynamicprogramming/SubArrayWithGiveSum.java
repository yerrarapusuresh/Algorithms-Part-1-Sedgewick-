/**
 * Sub-Array with given sum.
 */
package com.suresh.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author syerrarapu
 *
 */
public class SubArrayWithGiveSum {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    int[] array = {1,3,1};
    
    System.out.println(subArrayWithGivenSum(array, 4));
    

  }
  
  public static int subArrayWithGivenSum(int[] array, int sum) {
    return subArrayWithGivenSum(array, 0, 0, sum, new ArrayList<Integer>());
  }

  private static int subArrayWithGivenSum(int[] array, int currentIndex, int currentSum, int sum,
      List<Integer> positions) {
    if (currentIndex >= array.length) {
      return 0;
    }
    // without including current value
    int currentInclusion= 0;
   int sumWithOutIncluding =  subArrayWithGivenSum(array, currentIndex+1, currentSum, sum, positions);
    positions.add(currentIndex);
  int sumWithIncluding =  subArrayWithGivenSum(array, currentIndex + 1, currentSum + array[currentIndex], sum, positions);
    if ((currentSum + array[currentIndex]) == sum) {
      currentInclusion = 1;
    }
   
    return sumWithOutIncluding+sumWithIncluding+currentInclusion;

  }

}
