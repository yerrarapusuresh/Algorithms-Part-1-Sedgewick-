package com.suresh.algorithms.recursion;

public class PowerSetGenerator {

  public static void main(String[] args) {
    String s = "mohan";
    //subsetPrintUtilForString(s, 1, 1);
    powerSet(s);
  }

  public static void subsetPrintUtilForString(String s, int startIndex, int endIndex) {
    for (; startIndex <= endIndex; startIndex++) {
      System.out.print(s.charAt(startIndex));
    }
    System.out.println();
  }

  public static void powerSet(String s) {
    powerSet(s, 0);
  }

  private static void powerSet(String s, int currentIndex) {
    if (currentIndex >= s.length()) {
      return;
    }

    for (int i = currentIndex; i < s.length(); i++) {
      subsetPrintUtilForString(s, currentIndex, i);
    }
    powerSet(s, currentIndex + 1);
  }

}
