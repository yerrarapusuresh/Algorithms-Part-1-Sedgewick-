package com.suresh.algorithms.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class Knapscak {

  public static void main(String[] args) {
    int[] weights = { 2, 2, 3 };
    int[] values = { 50, 10, 2 };
    int knapsackCapacity = 5;
   Set<Integer> set = new HashSet<>();
    // System.out.println(recursiveKnapsack(weights, values, knapsackCapacity, values.length - 1));
    recursiveKnapsackWithTracking(weights, values, knapsackCapacity, values.length - 1, set);
    set.stream().forEach(System.out::println);
  }

  public static int recursiveKnapsack(int[] weights, int[] values, int knapsackCapacity,
      int currentItem) {
    // the following condition will two constraints
    // 1.knapsack have capacity to hold
    // 2.there should be some items to put in knapsack
    if (knapsackCapacity <= 0 || currentItem < 0) {
      return 0;
    }

    // if current item weight grater than knapsack capacity
    // just ignoring the current item and pass next item.
    if (weights[currentItem] > knapsackCapacity) {
      return recursiveKnapsack(weights, values, knapsackCapacity, currentItem - 1);
    }

    // this is validates whether we should include current item or not.
    return Math.max(
        values[currentItem] + recursiveKnapsack(weights, values,
            knapsackCapacity - weights[currentItem], currentItem - 1),
        recursiveKnapsack(weights, values, knapsackCapacity, currentItem - 1));
  }

  public static int recursiveKnapsackWithTracking(int[] weights, int[] values, int knapsackCapacity,
      int currentItem, Set<Integer> set) {
    // the following condition will two constraints
    // 1.knapsack have capacity to hold
    // 2.there should be some items to put in knapsack
    if (knapsackCapacity <= 0 || currentItem < 0) {
      return 0;
    }

    // if current item weight grater than knapsack capacity
    // just ignoring the current item and pass next item.
    if (weights[currentItem] > knapsackCapacity) {
      return recursiveKnapsack(weights, values, knapsackCapacity, currentItem - 1);
    }

    // this is validates whether we should include current item or not.

    int includesCurrentItem = values[currentItem] + recursiveKnapsackWithTracking(weights, values,
        knapsackCapacity - weights[currentItem], currentItem - 1, set);
    int doesNotIncludeCurrentItem = recursiveKnapsackWithTracking(weights, values, knapsackCapacity,
        currentItem - 1, set);
    if (includesCurrentItem > doesNotIncludeCurrentItem) {
      set.add(currentItem);
      return includesCurrentItem;
    }
    return doesNotIncludeCurrentItem;
  }
}
