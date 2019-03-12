package com.suresh.algorithms.greedy.problemsetone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class JobSchedulingMethodOne {

  public static void main(String[] args) {
    Jobs[] jobs = null;
    try (BufferedReader br = new BufferedReader(new FileReader(
        "D:\\GitHubMyOwnRepos\\AlgorithmsBySedgewickPartOne\\Algorithms-Part-1-Sedgewick-\\src\\com\\suresh\\algorithms\\greedy\\problemsetone\\jobs.txt"));) {
      jobs = new Jobs[Integer.parseInt(br.readLine())];
      int i = 0;
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(" ");
        jobs[i++] = new Jobs(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    int completionTime = 0;
    long weightedSum = 0;
    Arrays.sort(jobs);
    
    for (Jobs b : jobs) {
      // System.out.println(" " + b);
      completionTime += b.length;
      weightedSum += (completionTime * b.weight);
      System.out.println("" + (b.weight / b.length));
    }

    System.out.println(" " + weightedSum);

  }

  static class Jobs implements Comparable<Jobs> {
    private int weight;
    private int length;

    public Jobs(int weight, int length) {
      this.weight = weight;
      this.length = length;
    }

    public String toString() {
      return weight + " " + length;
    }

    @Override
    public int compareTo(Jobs that) {
      if (((double)this.weight / this.length) > ((double)that.weight / that.length)) {
        return -1;
      } else if (((double)this.weight /(double) this.length) < ((double)that.weight / (double)that.length)) {
        return 1;
      } else if (this.weight > that.weight) {
        return -1;
      } else if (this.weight < that.weight) {
        return 1;
      }
      return 0;
    }
  }

}
