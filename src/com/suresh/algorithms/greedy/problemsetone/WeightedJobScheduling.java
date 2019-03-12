package com.suresh.algorithms.greedy.problemsetone;

import java.io.*;
import java.util.Arrays;

public class WeightedJobScheduling {
  public static class Job2 implements Comparable<Job2> {
    private int length;
    private int weight;
    private double profit;

    public Job2(int weight, int length) {
      this.length = length;
      this.weight = weight;
      profit = ((double) (weight)) / length;
    }

    public int compareTo(Job2 that) {
      if (this.profit < that.profit)
        return 1;
      else if (this.profit > that.profit)
        return -1;

      else if (this.weight < that.weight)
        return 1;
      else if (this.weight > that.weight)
        return -1;
      return 0;

    }

    public String toString() {
      return "" + weight + " " + length + " " + profit;
    }
  }

  public static class Job implements Comparable<Job> {
    private int length;
    private int weight;
    private double profit;

    public Job(int weight, int length) {
      this.length = length;
      this.weight = weight;
      profit = weight - length;
    }

    public int compareTo(Job that) {
      if (this.profit < that.profit)
        return 1;
      else if (this.profit > that.profit)
        return -1;

      else if (this.weight < that.weight)
        return 1;
      else if (this.weight > that.weight)
        return -1;
      return 0;

    }

    public String toString() {
      return "" + weight + " " + length + " " + profit;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new FileReader(new File(
        "D:\\GitHubMyOwnRepos\\AlgorithmsBySedgewickPartOne\\Algorithms-Part-1-Sedgewick-\\src\\com\\suresh\\algorithms\\greedy\\problemsetone\\jobs.txt")));
    Job[] array = new Job[Integer.parseInt(br.readLine())];
    String temp = null;
    int count = 0;
    while ((temp = br.readLine()) != null) {
      String[] t = temp.split(" ");
      array[count++] = new Job(Integer.parseInt(t[0]), Integer.parseInt(t[1]));

    }

    Arrays.sort(array);
    count = 0;
    long sum = 0;
    for (Job j : array) {
      count += j.length;
      sum = sum + (count * j.weight);

    }

    System.out.println(sum);

  }
}